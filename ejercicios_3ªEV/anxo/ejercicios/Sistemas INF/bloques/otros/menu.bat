@echo off

rem menu de opciones 
rem sobre un archivo 
rem pasado como parametro

:menu

echo 1. Mostrar
echo 2. Atributos
echo 3. Borrar
echo 4. Salir

set /p opcion=Introduzca  la opcion:

if %opcion%==1 goto mostrar
if %opcion%==2 goto atributo
if %opcion%==3 goto borrar
if %opcion%==4 goto salir

:mostrar
type %1

choice /c sn /m "¿Quieres seguir en el menu?"

if errorlevel 2 goto salir
if errorlevel 1 goto menu

:atributo
attrib %1

choice /c sn /m "¿Quieres seguir en el menu?"

if errorlevel 2 goto salir
if errorlevel 1 goto menu

:borrar
echo Se esta borrando el archivo %1
del %1

:salir
echo Gracias por usar nuestro menu


