-- Tabla ROL que complementa la tabla PERSONAJE
CREATE TABLE ROL (
	ROL_ID NUMBER(10) NOT NULL,
  ROL_NOMBRE VARCHAR2(100 CHAR)NOT NULL,
  ROL_ESTADO varchar2(50 CHAR) NOT NULL
);
-- Secuencia para el campo ROL_ID de la tabla ROL
CREATE SEQUENCE "SEC_ROL" minvalue 1 start with 1 increment by 1;
-- Columna unica para nombre del ROL para evitar la duplicidad de nombre
CREATE UNIQUE INDEX UNQ_ROL_NOMBRE ON ROL(ROL_NOMBRE);
-- Columna unica para nombre del PERSONAJE para evitar la duplicidad de nombre
CREATE UNIQUE INDEX UNQ_PERS_NOMBRE ON PERSONAJE(PERS_NOMBRE);