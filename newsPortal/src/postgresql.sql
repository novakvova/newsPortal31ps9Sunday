CREATE USER bob with PASSWORD 'Qwerty1-'; 
\du 
CREATE DATABASE newsportal_db; 
\l 
GRANT ALL PRIVILEGES ON DATABASE "newsportal_db" to bob; 
\q