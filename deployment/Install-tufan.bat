@ECHO OFF

@REM echo Installing Java 17. Please wait...
@REM
@REM echo Java 17 Installation was successfully.

@REM echo Installing MySQL Server. Please wait...
@REM msiexec /i "C:\Workspace\tufan\deployment\install-files\mysql-installer-web-community-8.0.34.0.msi" /qn
@REM echo Configurating MySQL Server...
@REM "C:\Program Files\MySQL\MySQL Server 5.6\bin\mysqlinstanceconfig.exe"
@REM -i -q ServiceName=MySQL RootPassword= ServerType=DEVELOPER
@REM DatabaseType=MYISAM Port=3306 Charset=utf8
@REM echo MySQL Installation was successfully.



echo Create and Config Database Started. Please wait...
SET MYSQL="C:\Workspace\tufan\deployment\install-files\mysql-8.0.33-winx64\bin"
SET INPUTCreateDB="C:\Workspace\tufan\database\createDB.sql"
SET INPUTCreateT="C:\Workspace\tufan\database\createTables.sql"
SET INPUTInsert="C:\Workspace\tufan\database\insertData.sql"
SET OUTPUT="C:\Workspace\tufan\deployment\OutputLog.txt"
cd %MYSQL%
@REM cd C:\xampp3\mysql\bin
echo Config User Database Started...
mysql -uroot < %INPUTCreateDB%
echo Create Tables Started...
mysql -uadminMG -pmaghsoud71 -v -D tufan-g11 < %INPUTCreateT% > %OUTPUT%
echo Insert data Started...
mysql -uadminMG -pmaghsoud71 -v -D tufan-g11 < %INPUTInsert% > %OUTPUT%
echo Create and Config Database finished.



@REM echo Running jar file. Please wait...
@REM
@REM echo Application Started successfully.


PAUSE