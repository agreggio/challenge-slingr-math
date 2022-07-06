#!/bin/bash

function trap_ctrlc() {
	echo "Shutting down docker."
	docker-compose down
	echo "Stopped bash opeation."
	exit 2
}

trap "trap_ctrlc" 2

cd challenge-slingr-math-common &&
mvn clean install &&
cd ../ &&
cd challenge-slingr-math-security &&
mvn clean package -DskipTests &&
cd ../ &&
cd challenge-slingr-math-web &&
mvn clean package -DskipTests &&
cd ../ &&
docker-compose -f docker-compose.yml up -d