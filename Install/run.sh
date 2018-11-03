#!/bin/bash
#for Ubuntu

CURRENT=`pwd`
cd ..

mvn compile
mvn install

java -jar target/application-0.0.1-SNAPSHOT.jar 

