DEBUG_MODE_IN_5005_PORT=-Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

docker-compose-up:
	docker-compose up -d --force-recreate

run: docker-compose-up
	mvn spring-boot:run -Dspring-boot.run.profiles=local $(DEBUG_MODE_IN_5005_PORT)