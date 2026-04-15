package com.interviewforge.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("railway")
public class RailwayDataSourceConfig {

    @Bean
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");

        if (databaseUrl == null || databaseUrl.isEmpty()) {
            throw new RuntimeException("DATABASE_URL environment variable is not set!");
        }

        // Railway provides: postgresql://user:pass@host:port/db
        // JDBC needs:       jdbc:postgresql://host:port/db (with user/pass separate)
        String jdbcUrl;
        String username = "";
        String password = "";

        if (databaseUrl.startsWith("jdbc:")) {
            jdbcUrl = databaseUrl;
        } else {
            // Parse the Railway URL: postgresql://user:pass@host:port/db
            String withoutProtocol;
            if (databaseUrl.startsWith("postgresql://")) {
                withoutProtocol = databaseUrl.substring("postgresql://".length());
            } else if (databaseUrl.startsWith("postgres://")) {
                withoutProtocol = databaseUrl.substring("postgres://".length());
            } else {
                withoutProtocol = databaseUrl;
            }

            // Split at @ to get credentials and host
            int atIndex = withoutProtocol.indexOf('@');
            if (atIndex > 0) {
                String credentials = withoutProtocol.substring(0, atIndex);
                String hostAndDb = withoutProtocol.substring(atIndex + 1);

                // Parse user:password
                int colonIndex = credentials.indexOf(':');
                if (colonIndex > 0) {
                    username = credentials.substring(0, colonIndex);
                    password = credentials.substring(colonIndex + 1);
                } else {
                    username = credentials;
                }

                jdbcUrl = "jdbc:postgresql://" + hostAndDb;
            } else {
                jdbcUrl = "jdbc:postgresql://" + withoutProtocol;
            }
        }

        System.out.println("=== Railway DataSource ===");
        System.out.println("JDBC URL: " + jdbcUrl.replaceAll(":[^@/]+@", ":***@"));
        System.out.println("Username: " + username);
        System.out.println("==========================");

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setMaximumPoolSize(5);

        return dataSource;
    }
}
