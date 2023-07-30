



echo Create and Config Database Started. Please wait...
MYSQLRoot=
INPUTCreateDB="./database-config/createDB.sql"
INPUTCreateT="./database-config/createTables.sql"
INPUTInsert="./database-config/insertData.sql"
OUTPUT="./install-files/OutputLog.txt"
USER=adminMG
PASSWORD=maghsoud71

echo Config User Database Started...
mysql -uroot -proot < $INPUTCreateDB
echo Create Tables Started...
mysql -u$USER -p$PASSWORD -v -D tufan-g11 < $INPUTCreateT > $OUTPUT
echo Insert data Started...
mysql -u$USER -p$PASSWORD -v -D tufan-g11 < $INPUTInsert > $OUTPUT
echo Create and Config Database finished.

