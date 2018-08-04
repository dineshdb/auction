all: run-proxy

api:
	./gradlew build

front:
	cd frontend && npm run build

run-api: api
	source ./setenv.sh && java -jar build/libs/auction-0.0.1-SNAPSHOT.jar

run-rec:
	cd recommendation && python3 app.py

proxy-build: front
	rm -rf reverse-proxy/public
	mkdir reverse-proxy/public
	cp -rf frontend/build/* reverse-proxy/public/
	
run-proxy:
	cd reverse-proxy && npm run start

proxy: proxy-build
