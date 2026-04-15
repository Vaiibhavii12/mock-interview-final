@REM Licensed to the Apache Software Foundation (ASF)
@REM Maven Wrapper script for Windows
@echo off

@setlocal

set MAVEN_PROJECTBASEDIR=%~dp0

@REM Find java.exe
set JAVA_EXE=java.exe

set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"

%JAVA_EXE% ^
  -jar %WRAPPER_JAR% ^
  %*
if ERRORLEVEL 1 goto error
goto end

:error
set ERROR_CODE=1

:end
@endlocal & set ERROR_CODE=%ERROR_CODE%

exit /B %ERROR_CODE%
