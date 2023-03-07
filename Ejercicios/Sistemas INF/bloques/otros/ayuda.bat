@echo off

rem programa: 4.bat

cd %1 

help %2 >> ayuda.rlt
help %3 >> ayuda.rlt
help %4 >> ayuda.rlt

echo Fichero ade ayuda creado: ayida.rlt en %1
