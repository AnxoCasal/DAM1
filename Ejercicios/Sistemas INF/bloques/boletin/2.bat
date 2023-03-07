@echo off 

set /p num1=Introduzca el numerador
:denominador
set /p num2=Introduzca el denominador
if %num2%==0 (
	goto mensaje
) else (
	goto operar
)

:mensaje
echo denominador es cero
pause
goto denominador

:operar 
set /a div=%num1% / %num2%
echo La solucion es %div%

pause