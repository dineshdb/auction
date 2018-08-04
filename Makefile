all: run-proxy

update:
	git submodule update --init --recursive
	cd frontend && git checkout master
	cd recommendation && git checkout master

setup: update setup-front setup-rec setup-proxy setup-train

setup-front:
	cd frontend && npm i

setup-train:
	cd recommendation && pip install -r requirements.txt --user

setup-rec:
	cd recommendation && pip install -r requirements-pro.txt --user

setup-proxy:
	cd reverse-proxy/ && npm i

train:
	cd recommendation && python3 recommend.py

build-api:
	./gradlew build

build-front:
	cd frontend && npm run build

run-api: build-api
	source ./setenv.sh && java -jar build/libs/auction-0.0.1-SNAPSHOT.jar

run-rec:
	cd recommendation && python3 app.py

build-proxy: build-front
	rm -rf reverse-proxy/public
	mkdir reverse-proxy/public
	cp -rf frontend/build/* reverse-proxy/public/
	
run-proxy: build-proxy
	cd reverse-proxy && npm run start

proxy: build-proxy
