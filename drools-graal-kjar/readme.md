This is a POC to demonstrate how a Drools kjar can be loaded and executed on GraalVM.

To check that graal is correctly working in your environment try to compile the HelloWorld class with

`native-image -Dfile.encoding=UTF-8 -classpath target/classes org.mf.HelloWorld`

Conversely to compile the Drools example use this (replacing `/home/mfusco/.m2/repository` with your maven repository home)

`./gen-native.sh`

Check performance with `/usr/bin/time -v`

`./run-java.sh Mario 18`

