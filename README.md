# ecommerce
Online web based ecommerce system.

[![CircleCI](https://circleci.com/gh/dineshdb/auction.svg?style=svg&circle-token=71fcd4229acc7677621a9c5eed5df401a87d022c)](https://circleci.com/gh/dineshdb/auction)

..
## Getting started.
* Clone this repo using ``` git clone git@github.com:dineshdb/ecommerce.git```
* Update all submodules using ``` git submodule update --init --recursive```
* Build the project using ``` ./gradlew build ```. It will build the backend components.
* Create database from [here](#create_database)
* Update environment variables using ```source setenv.sh```
* Run the project using ``` ./gradlew bootRun```. Go to http://localhost:8080 to see the output.
* To sync new updates ``git pull --recurse-submodules``.

## Running the app.
Following steps automagically build required files
* Setup all dependencies using ``make setup``
* Run api-server using ``make run-api``.
* Run recommendation server using ``make run-rec``.
* Run reverse proxy using ``make run-proxy``.

## Create Database
Install mysql or mariadb and get into its root shell. Then execute:
```mysql
mysql> create database auction_db; -- Create the new database
mysql> create user 'auction_user'@'localhost' identified by 'ThePassword'; -- Creates the user
mysql> grant all on auction_db.* to 'auction_user'@'localhost'; -- Gives all the privileges to the new user on the newly created database
```

**Note**: Don't forget to change password in production.

## Authors
* **[Aashutosh Poudel](https://github.com/atosh502)** <aashutoshpoudyal@gmail.com>
* **[Dinesh Bhattarai](https://dbhattarai.info.np)** <dbhattarai252@gmail.com> 
* **[Jeevan Thapa](https://github.com/jeevan9111)** <jeevanthapa9111@gmail.com>
* **[Rupesh Shrestha](https://github.com/rupesh1439)** <rupesh.shrestha96742@gmail.com>
