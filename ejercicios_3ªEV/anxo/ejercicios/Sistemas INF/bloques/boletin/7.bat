@echo off

set /a contador1=0
set /a contador2=0
for %%x in (*.txt) do (echo %%x
	set /a contador1=contador1+1
)
for %%n in (*.bat) do (echo %%n
	set /a contador2=contador2+1
)

echo el numero de archivos con extension .txt es %contador1% y con extension .bat es %contador2%