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
cd "%MySQLPath%"
@REM net stop MySQL
@REM mysqld --remove
@REM mysqld --install
@REM mysqld --initialize
@REM net start MySQL
call mysql_start.bat
echo MySQL Started successfully.



@REM echo Running jar file. Please wait...
@REM
@REM echo Application Started successfully.
