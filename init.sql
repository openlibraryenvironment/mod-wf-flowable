select 1;

CREATE EXTENSION IF NOT EXISTS pg_trgm;

CREATE USER folio_admin WITH PASSWORD 'folio_admin';
DROP DATABASE if exists okapi_modules;
CREATE DATABASE okapi_modules;
GRANT ALL PRIVILEGES ON DATABASE okapi_modules to folio_admin;

CREATE SCHEMA mod_wf_default AUTHORIZATION okapi_modules;
