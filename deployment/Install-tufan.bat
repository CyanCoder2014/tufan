@ECHO OFF


set SourcePath=%cd%
set InstallationPath=C:\Tufan-Application
echo "SourcePath: %SourcePath%\install-files\"
echo "InstallationPath: %InstallationPath%\install-files\"
if not exist "%InstallationPath%" xcopy /s "%SourcePath%\install-files\*.*" "%InstallationPath%\install-files\*"
if not exist "%InstallationPath%" xcopy /s "%SourcePath%\database-config\*.*" "%InstallationPath%\database-config\*"
if not exist "%InstallationPath%" xcopy /s "%SourcePath%\install-files\Tufan.bat" "%InstallationPath%\*"


echo Installing Java 17. Please wait...
%InstallationPath%\install-files\JDK.v17.0.8.x64.Win.exe /s
@REM echo Java 17 Installation was successfully.


echo Installing MySQL Server. Please wait...
cd "%InstallationPath%\install-files\mysql-8.0.33-winx64\bin"
@REM mysqld.exe --console --initialize"
@REM mysqld.exe --console
@REM mysqld --install MySQL --defaults-file=%SourcePath%\database-config\admin.cnf

@REM %InstallationPath%\install-files\xaamp.exe /s

echo MySQL Installation was successfully.

@REM echo start mysql service.
@REM net start MySQL


echo Create and Config Database Started. Please wait...
set MYSQL="%InstallationPath%\install-files\mysql-8.0.33-winx64\bin"
set INPUTCreateDB="%SourcePath%\database-config\createDB.sql"
set INPUTCreateT="%SourcePath%\database-config\createTables.sql"
set INPUTInsert="%SourcePath%\database-config\insertData.sql"
set OUTPUT="%SourcePath%\install-files\OutputLog.txt"
set USER=adminMG
set PASSWORD=maghsoud71
cd %MYSQL%
echo Config User Database Started...
mysql -uroot < %INPUTCreateDB%
echo Create Tables Started...
@REM mysql_config_editor set --login-path=local --host=localhost --user=username  --password
@REM mysql --login-path=local -v -D tufan-g11 < %INPUTCreateT% > %OUTPUT%
mysql -u%USER% -p%PASSWORD% -v -D tufan-g11 < %INPUTCreateT% > %OUTPUT%
echo Insert data Started...
mysql -u%USER% -p%PASSWORD% -v -D tufan-g11 < %INPUTInsert% > %OUTPUT%
echo Create and Config Database finished.



@REM echo Running jar file. Please wait...
@REM
@REM echo Application Started successfully.


PAUSE