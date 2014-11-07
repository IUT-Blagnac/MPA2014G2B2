rem echo off
set SPRINTDIR=%~dp0
set SRCDIR=./src/
set BINDIR=./bin/

set RUNTEST=1

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION
@echo ///////////////////////////////////////////////////////
javac -encoding UTF-8 -d %BINDIR% %SRCDIR%Controler/*.java %SRCDIR%Model/*.java %SRCDIR%View/*.java
javac -cp ./bin/;./tools/junit.jar -d %BINDIR% %SRCDIR%Tests/OPTIlibTest.java

@echo ///////////////////////////////////////////////////////
@echo // CREATION de l'executable
@echo ///////////////////////////////////////////////////////
cd %BINDIR%
jar cvfm ../OPTI.jar ../META-INF/MANIFEST.MF *
jar cvfm ../OPTICastHTML.jar ../META-INF/MANIFEST2.MF *
cd %SPRINTDIR%

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION des tests
@echo ///////////////////////////////////////////////////////
if "%RUNTEST%"=="1" (
 cd %BINDIR%
 java -cp .;../tools/junit.jar Tests/OPTIlibTest
 pause
 cd %SPRINTDIR%
 cd OPTIweb/test
 casperjs.bat test casperAccueil.js
pause
 casperjs.bat test casperCredits.js
pause
 casperjs.bat test casperdemo1.js
pause
 casperjs.bat test casperEtudiants.js
pause
 casperjs.bat test casperAccueil.js
pause
 casperjs.bat test casperProjets.js
pause
 casperjs.bat test casperSujets.js
)

