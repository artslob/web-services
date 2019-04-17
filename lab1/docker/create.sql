CREATE SCHEMA "ifmo-ws";

CREATE TABLE "ifmo-ws.cities"
(
    id         SERIAL PRIMARY KEY NOT NULL,
    name       VARCHAR(200)       NOT NULL, -- название города
    country    VARCHAR(200)       NOT NULL, -- название страны
    founded    INTEGER            NOT NULL, -- год основания
    population INTEGER            NOT NULL, -- население (тысяч человек)
    area       INTEGER            NOT NULL  -- площадь города (км^2)
);

INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Paris', 'France', -52, 2190, 105);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('London', 'Great Britain', 43, 8538, 1706);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Moscow', 'Russia', 1147, 12506, 2511);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Beijing', 'PRC', -1045, 21705, 16801);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Tokyo', 'Japan', 1457, 13742, 2188);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Delhi', 'India', 1200, 16787, 1483);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Cairo', 'Egypt', 969, 9717, 3085);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Berlin', 'Germany', 1237, 3611, 891);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Rome', 'Italy', -753, 3900, 1287);
INSERT INTO "ifmo-ws.cities"(name, country, founded, population, area)
values ('Seoul', 'South Korea', 1394, 10063, 605);
