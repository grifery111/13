USE pol_bel_db;
CREATE TABLE Dictionary (
                            word_polish VARCHAR(100) PRIMARY KEY,
                            word_belarusian VARCHAR(100) NOT NULL
);
USE bel_pol_db;
CREATE TABLE Dictionary (
                            word_belarusian VARCHAR(100) PRIMARY KEY,
                            word_polish VARCHAR(100) NOT NULL
);
USE pol_bel_db;
INSERT INTO Dictionary (word_polish, word_belarusian) VALUES
                                                          ('kot', 'кот'),
                                                          ('pies', 'сабака'),
                                                          ('dom', 'дом'),
                                                          ('książka', 'кніга');

USE bel_pol_db;
INSERT INTO Dictionary (word_belarusian, word_polish) VALUES
                                                          ('кот', 'kot'),
                                                          ('сабака', 'pies'),
                                                          ('дом', 'dom'),
                                                          ('кніга', 'książka');