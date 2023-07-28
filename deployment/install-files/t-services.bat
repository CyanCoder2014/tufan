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







set SourcePath=%cd%
set InstallationPath=C:\Tufan-Application

cd "%InstallationPath%\install-files\mysql-8.0.33-winx64\bin"

@REM mysqlinstanceconfig.exe -i -q ServiceName=MySQL RootPassword= ServerType=DEVELOPER DatabaseType=INODB Port=3306 Charset=utf8
@REM mysqld.exe --host=127.0.0.1 --port=3306 -u root
@REM mysqld --install-manual "service_name" --local-service --defaults-file="%InstallationPath%\mysql\my.ini"



@REM mysqladmin −uroot shutdown

@REM mysqld --host=127.0.0.1 --port=3306 -u root --install
@REM mysqld --install
@REM net start MySQL

@REM mysqld -uroot
@REM mysqladmin −u root shutdown



mysqld --remove



mysqld --install MySQL
@REM mysqld --install MySQL --defaults-file=%InstallationPath%\database-config\admin.cnf
net start MySQL


echo.
echo...Script Complete....
echo.

PAUSE