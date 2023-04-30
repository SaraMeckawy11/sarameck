@echo off

REM Compile the Java file
javac -d . LAB6.java

REM Normal case
echo Testing normal case...
java Assi6.LAB6 assignment6.arxml
echo ----------------------------------------------------------------------------------
REM Not valid Autosar file case
echo Testing not valid Autosar file case...
java Assi6.LAB6 laab6.docs
echo ----------------------------------------------------------------------------------
REM Empty file case
echo Testing empty file case...
java Assi6.LAB6 emptyfile.arxml
echo ----------------------------------------------------------------------------------

REM Clean up compiled Java files
del Assi6\*.class

pause
