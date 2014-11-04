rem echo off
set SPRINTDIR=%~dp0
set ASCIIDOCDIR=.\tools\asciidoc-8.6.9\
set PLANTUMLDIR=.\tools\
set SRCDIR=./src/
set SRCDOC=./doc/
set SRCDOCDIR=./srcdoc/

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des documentations
@echo ///////////////////////////////////////////////////////

java -jar %PLANTUMLDIR%plantuml.jar -Tpng -o images %SRCDOCDIR%diagClass.puml

javadoc -d %SRCDOC%javadoc %SRCDIR%Controler/Controller.java %SRCDIR%Model/Etudiants.java %SRCDIR%Model/Groupes.java %SRCDIR%Model/Voeux.java %SRCDIR%Model/Intervenants.java %SRCDIR%Model/Projets.java %SRCDIR%Model/Sujets.java %SRCDIR%View/ActionListenerAS.java %SRCDIR%View/ActionListenerBouton.java %SRCDIR%View/AfficherCsv.java %SRCDIR%View/JTableObjet.java %SRCDIR%View/OPTI.java %SRCDIR%View/OPTIlib.java

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOC%Bilan Fonctionnel.html %SRCDOCDIR%Bilan Fonctionnel.txt
python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOC%Bilan globale.html %SRCDOCDIR%Bilan globale.txt
python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOC%Bilan Humain.html %SRCDOCDIR%Bilan Humain.txt
python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOC%Bilan_Financier.html %SRCDOCDIR%Bilan_Financier.txt
python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOC%Bilan_Technique.html %SRCDOCDIR%Bilan_Technique.txt
python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOC%BilanFonctionnel.html %SRCDOCDIR%BilanFonctionnel.txt
