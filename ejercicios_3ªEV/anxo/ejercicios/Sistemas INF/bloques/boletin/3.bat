@echo off 

set /p edad=Cual es tu edad?

if %edad% GEQ 18 (
	echo Eres ya mayor de edad
) else ( 
	echo Aun no eres mayor de edad
)
pause