@ECHO OFF

@REM if _%1_==_payload_  goto :payload
@REM
@REM :getadmin
@REM     echo %~nx0: elevating self
@REM     set vbs=%temp%\getadmin.vbs
@REM     echo Set UAC = CreateObject^("Shell.Application"^)                >> "%vbs%"
@REM     echo UAC.ShellExecute "%~s0", "payload %~sdp0 %*", "", "runas", 1 >> "%vbs%"
@REM     "%temp%\getadmin.vbs"
@REM     del "%temp%\getadmin.vbs"
@REM goto :eof
@REM
@REM :payload


set InstallationPath=C:\Tufan-Application
set MySQLPath=C:\xampp


echo Start MySQL Server. Please wait...
cd "%MySQLPath%"
call mysql_start.bat
echo MySQL Started.




echo Running jar file. Please wait...
cd "C:\Program Files\Java\jdk-17\bin"
start javaw -jar %InstallationPath%\tufan.jar
echo Application Started successfully.

exit
@REM PAUSE