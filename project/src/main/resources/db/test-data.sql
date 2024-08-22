DROP TABLE adventure;
DROP TABLE author;

CREATE TABLE author (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  description VARCHAR(64) NOT NULL,
  images VARCHAR(64),
  version INTEGER DEFAULT '1',
  creation_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE adventure (
  id INTEGER NOT NULL AUTO_INCREMENT,
  title VARCHAR(64) NOT NULL,
  description VARCHAR(64) NOT NULL,
  images VARCHAR(64),
  type VARCHAR(20) DEFAULT NULL,
  stock INTEGER NOT NULL,
  version INTEGER DEFAULT '1',
  creation_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  author_id INTEGER DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES author(id)
);


INSERT INTO author (name, description, images)
VALUES ('Gary Gygax', 'Gary Gygax was an American', 'gygax_image.jpg');


-- Insert an adventure into the adventure table
INSERT INTO adventure (title, description, images, type, stock, author_id)
VALUES ('The Temple of Elemental Evil', 'The Temple of Elemental Evil is a', 'temple_of_elemental_evil.jpg', 'Adventure Module', 100, (SELECT id FROM author WHERE name = 'Gary Gygax'));