#!/usr/bin/env bash
app_name='jenkins-docker-demo'
docker stop ${app_name}

echo'----stop container----'
docker rm ${app_name}

echo'----rm container----'

docker run -p 8990:8990 --name ${app_name} \
-v /etc/localtime:/etc/localtime \
-v /home/developer/app/logs/:/home/developer/app/logs/ \
-d docker-demo/${app_name}:1.0.0

echo'----start container success----'
