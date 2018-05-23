#!/bin/bash
#for Ubuntu

cd 
cd Documents/workspace-sts-3.9.4.RELEASE/aplication/

mvn compile

mvn install

java -jar target/application-0.0.1-SNAPSHOT.jar 
