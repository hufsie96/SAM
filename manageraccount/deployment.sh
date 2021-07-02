#!/bin/bash

##build java application jar"
mvn clean install

#docker build ..
sudo docker build -t manageraccount:1.0 .

#change docker tag 
sudo docker tag manageraccount:1.0 hufsie96/manageraccount:latest

#push docker images to private repository 
sudo docker push hufsie96/manageraccount:latest

