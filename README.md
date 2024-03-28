You will need to run Redis and MySQL DB from Docker container:
-----------------------------------------------------------------------------------------------------------------------------
docker run --name mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --restart unless-stopped -v mysql:/var/lib/mysql mysql:8 
docker run -d --name redis -p 6379:6379 redis:latest
-----------------------------------------------------------------------------------------------------------------------------

After that fill the DB with dump.sql
The project is ready to run.

My results:
Redis:	106 ms
MySQL:	285 ms
