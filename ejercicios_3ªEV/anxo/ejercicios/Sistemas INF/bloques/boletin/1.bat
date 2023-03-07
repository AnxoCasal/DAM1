@echo off 

set /p num1=Introduzca el primer numero
set /p num2=Introduzca el segundo numero
set /a media=(%num1%+%num2%)/2

echo La media es %media%