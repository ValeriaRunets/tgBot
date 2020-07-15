CREATE DATABASE travel;
use travel;
create table city
(
  id          bigint auto_increment primary key unique,
  name        varchar(20) null,
  description text        null
);
INSERT INTO `city` (`name`,`description`)
VALUES
  ("Berlin", "Brandenburg Gate is one of Germany’s best-known landmarks that you’ll no doubt want to see. Historically, an old city gate, Brandenburg Gate was rebuilt around 250 years ago and still stands proudly today."),
  ("Moscow", "The heart of Russia’s capital, Red Square is arguably Moscow’s most visited attraction. The cobblestone square is surrounded by beautiful architecture, and is the place where most of the city’s (and country’s) history unfolded."),
  ("Minsk", "The Red Church is a symbol of Minsk. The official name of the church is quite rare and, probably, can’t be found elsewhere in the world: Sts. Simon and Helena Church."),
  ("Rome", "As the Eiffel Tower is to Paris, the silhouette of the Flavian Amphitheatre is to Rome. The largest structure left to us by Roman antiquity, the Colosseum still provides the model for sports arenas - present day football stadium design is clearly based on this oval Roman plan.")
  
  