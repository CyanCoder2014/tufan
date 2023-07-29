@ECHO OFF

set SourcePath=%cd%
set InstallationPath=C:\Tufan-Application
set MySQLPath=C:\xampp
echo "SourcePath: %SourcePath%\install-files\"
echo "InstallationPath: %InstallationPath%"
if not exist "%InstallationPath%\install-files" xcopy /s "%SourcePath%\install-files\*.*" "%InstallationPath%\install-files\*"
if not exist "%InstallationPath%\database-config" xcopy /s "%SourcePath%\database-config\*.*" "%InstallationPath%\database-config\*"
if not exist "%InstallationPath%\Tufan.bat" xcopy /s "%SourcePath%\install-files\Tufan.bat" "%InstallationPath%\*"

if not exist "%MySQLPath%\mysql" xcopy /s "%SourcePath%\install-files\xampp\*.*" "%MySQLPath%\*"


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


echo Installing Java 17. Please wait...
@REM %InstallationPath%\install-files\JDK.v17.0.8.x64.Win.exe /s
@REM path="C:\Program Files\Java\jdk-17\bin";%path%
echo Java 17 Installation was successfully.


echo Installing MySQL Server. Please wait...
cd "%MySQLPath%"
@REM net stop MySQL
@REM mysqld --remove
@REM mysqld --install
@REM mysqld --initialize
@REM net start MySQL
call mysql_start.bat
echo MySQL Started successfully.


echo Create and Config Database Started. Please wait...
set MYSQL="%MySQLPath%\mysql\bin"
set INPUTCreateDB="%InstallationPath%\database-config\createDB.sql"
set INPUTCreateT="%InstallationPath%\database-config\createTables.sql"
set INPUTInsert="%InstallationPath%\database-config\insertData.sql"
set OUTPUT="%InstallationPath%\install-files\OutputLog.txt"
set USER=adminMG
set PASSWORD=maghsoud71
cd %MYSQL%
echo Config User Database Started...
mysql -uroot < %INPUTCreateDB%
echo Create Tables Started...
mysql -u%USER% -p%PASSWORD% -v -D tufan-g11 < %INPUTCreateT% > %OUTPUT%
echo Insert data Started...
mysql -u%USER% -p%PASSWORD% -v -D tufan-g11 < %INPUTInsert% > %OUTPUT%
echo Create and Config Database finished.



@REM echo Running jar file. Please wait...
@REM
@REM echo Application Started successfully.


PAUSE