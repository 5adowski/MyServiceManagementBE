CREATE TABLE TECHNICIAN
(
    ID           BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME         TEXT NOT NULL,
    PHONE_NUMBER TEXT NOT NULL,
    EMAIL        TEXT NOT NULL
);

CREATE TABLE COMPANY
(
    TIN      BIGINT PRIMARY KEY NOT NULL,
    NAME     TEXT               NOT NULL,
    ZIP_CODE TEXT               NOT NULL,
    CITY     TEXT               NOT NULL,
    STREET   TEXT               NOT NULL
);

CREATE TABLE CUSTOMER
(
    ID           BIGINT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME   TEXT         NOT NULL,
    LAST_NAME    TEXT         NOT NULL,
    PHONE_NUMBER TEXT,
    EMAIL        TEXT,
    TIN          BIGINT REFERENCES COMPANY (TIN),
    ID_ADDRESSES BIGINT ARRAY NOT NULL
);

CREATE TABLE ADDRESS
(
    ID       BIGINT AUTO_INCREMENT PRIMARY KEY,
    ZIP_CODE TEXT NOT NULL,
    CITY     TEXT NOT NULL,
    STREET   TEXT NOT NULL
);

CREATE TABLE DEVICE
(
    ID             BIGINT                         NOT NULL PRIMARY KEY,
    ID_FACTORY     TEXT,
    ID_FD          TEXT,
    SERIAL_NUMBER  TEXT                           NOT NULL,
    CATALOG_NUMBER TEXT                           NOT NULL,
    ID_ADDRESS     BIGINT REFERENCES ADDRESS (ID) NOT NULL
);

CREATE TABLE TASK
(
    ID            BIGINT AUTO_INCREMENT PRIMARY KEY,
    DESCRIPTION   TEXT                                NOT NULL,
    DATE          DATE                                NOT NULL,
    START_TIME    TIME                                NOT NULL,
    END_TIME      TIME                                NOT NULL,
    MIN_PRICE     DECIMAL                             NOT NULL,
    MAX_PRICE     DECIMAL,
    STATUS        ENUM ('CREATED', 'PASSED', 'ENDED') NOT NULL,
    NOTES         TEXT,
    ID_TECHNICIAN BIGINT REFERENCES TECHNICIAN (ID)   NOT NULL,
    ID_COMPANY    BIGINT REFERENCES COMPANY (TIN),
    ID_CUSTOMER   BIGINT REFERENCES CUSTOMER (ID)     NOT NULL,
    ID_ADDRESS    BIGINT REFERENCES ADDRESS (ID)      NOT NULL,
    ID_DEVICE     BIGINT REFERENCES DEVICE (ID)       NOT NULL
);