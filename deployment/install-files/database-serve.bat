@ECHO OFF

if _%1_==_payload_  goto :payload

:getadmin
    echo %~nx0: elevating self
    set vbs=%temp%\getadmin.vbs
    echo Set UAC = CreateObject^("Shell.Application"^)                >> "%vbs%"
    echo UAC.ShellExecute "%~s0", "payload %~sdp0 %*", "", "runas", 1 >> "%vbs%"
    "%temp%\getadmin.vbs"
    del "%temp%\getadmin.vbs"
goto :eof

:payload


set InstallationPath=C:\Tufan-Application
set MySQLPath=C:\xampp


echo Start MySQL Server. Please wait...
@REM e:
cd "%MySQLPath%"
@REM net stop MySQL
@REM mysqld --remove
@REM mysqld --install
@REM mysqld --initialize
@REM net start MySQL
@REM call mysql_start.bat



echo Create and Config Database Started. Please wait...
set MYSQL="%MySQLPath%\mysql\bin"
set INPUTCreateDB="%InstallationPath%\database-config\createDB.sql"
set INPUTCreateT="%InstallationPath%\database-config\createTables.sql"
set INPUTInsert="%InstallationPath%\database-config\insertData.sql"
set OUTPUT="%InstallationPath%\install-files\OutputLog.txt"
set USER=adminMG
set PASSWORD=maghsoud71
cd %MYSQL%
echo %MYSQL%
echo Config User Database Started...
mysql -uroot < %INPUTCreateDB%
echo Create Tables Started...
mysql -u%USER% -p%PASSWORD% -v -D tufan-g11 < %INPUTCreateT% > %OUTPUT%
echo Insert data Started...
mysql -u%USER% -p%PASSWORD% -v -D tufan-g11 < %INPUTInsert% > %OUTPUT%
echo Create and Config Database finished.




@REM @echo off
@REM cd /D %~dp0
@REM echo Diese Eingabeforderung nicht waehrend des Running beenden
@REM echo Please dont close Window while MySQL is running
@REM echo MySQL is trying to start
@REM echo Please wait  ...
@REM echo MySQL is starting with mysql\bin\my.ini (console)
@REM 
@REM mysql\bin\mysqld --defaults-file=mysql\bin\my.ini --standalone
@REM 
@REM @REM if errorlevel 1 goto error
@REM @REM goto finish
@REM 
@REM :error
@REM echo.
@REM echo MySQL konnte nicht gestartet werden
@REM echo MySQL could not be started
@REM @REM pause
@REM 
@REM @REM :finish



echo MySQL Started successfully.

PAUSE