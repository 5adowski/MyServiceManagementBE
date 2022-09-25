INSERT INTO TECHNICIAN(NAME, PHONE_NUMBER, EMAIL) VALUES('Karol', '123123123', 'karol@service.com'),
                                                        ('wojtek', '111222333', 'wojtek@service.com'),
                                                        ('andrzej', '987654321', 'andrzej@service.com');

INSERT INTO COMPANY(TIN, NAME, ZIP_CODE, CITY, STREET) VALUES(5223130908, 'PROMEDIO Sp. z o.o.', '02-495', 'Warszawa', 'Ryżowa 49'),
                                                             (9181733595, 'F.U.H. Progress EXPORT-IMPORT', '23-400', 'Biłgoraj', 'Cegielniana 25/24');

INSERT INTO CUSTOMER(FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL, TIN, ID_ADDRESSES) VALUES('Andrzej', 'Ananas', '501372154', null, null, 1),
                                                                                        ('Tomasz', 'Kowalski', '665328166', 'tkowalski@gmail.com', 5223130908, 2),
                                                                                        ('Karol', 'Kaktus', '501324583', null, 9181733595, 3);

INSERT INTO ADDRESS(ZIP_CODE, CITY, STREET, ID_DEVICES) VALUES('05-500', 'Piaseczno', 'Nad Perełką 19/33', 1),
                                                              ('02-777', 'Warszawa', 'Komisji Edukacji Narodowej 61', 2),
                                                              ('02-677', 'Warszawa', 'Wynalazek 3', 3);

INSERT INTO DEVICE(ID_FACTORY, ID_FD, SERIAL_NUMBER, CATALOG_NUMBER) VALUES('8290', '434', '000001', '7713230830'),
                                                                           ('8370', '664', '052433', '7716010244'),
                                                                           ('8290', '444', '563487', '7713230795');

INSERT INTO TASK(DESCRIPTION, DATE, START_TIME, END_TIME, MIN_PRICE, MAX_PRICE, STATUS, NOTES, ID_TECHNICIAN, ID_COMPANY, ID_CUSTOMER, ID_ADDRESS, ID_DEVICE) VALUES('Konserwacja', '2022-12-29', '09:00:00', '10:30:00', 420, null, 'CREATED', null, 1, null, 1, 1, 1),
                                                                                                                                                     ('Konserwacja, piec hałasuje podczas grzania wody', '2023-11-16', '12:00:00', '13:30:00', 450, null, 'CREATED', null, 1, 9181733595, 3, 3, 3),
                                                                                                                                                     ('Nie włącza się', '2022-12-29', '10:30:00', '12:00:00', 200, 450, 'PASSED', null, 1, 5223130908, 2, 2, 2);