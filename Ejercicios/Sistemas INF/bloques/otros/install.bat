@echo off

echo Bienvenido al instalador

pause

MD %1 %2

XCOPY E:\*.exe %1/%2 

XCOPY E:\*.dat %1/%2 /H

cd %1/%2

md ejemplos

XCOPY E:\EJ*.exe %1/%2/ejemplos 

md %2

XCOPY E:\DOC*.exe %1/%2/ejemplos 

rd /s E:

tree 

pause
