package com.interviewforge.repository;

import com.interviewforge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.bestScore > 0 ORDER BY u.bestScore DESC")
    List<User> findTopPerformers();

    @Query("SELECT u FROM User u ORDER BY u.bestScore DESC LIMIT 10")
    List<User> findTop10ByOrderByBestScoreDesc();
}
