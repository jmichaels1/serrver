


--modificacions a fer a les taules, quan fem el volcat massiu des de CSV


--taula SESION-------------------------:


ALTER TABLE `sesion` CHANGE `id_master1` `id_master1` INT NULL;
ALTER TABLE `sesion` CHANGE `id_master2` `id_master2` INT NULL;
ALTER TABLE `sesion` CHANGE `asignatura` `asignatura` VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;
ALTER TABLE `sesion` CHANGE `asignatura_desc_extra` `asignatura_desc_extra` VARCHAR(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;

--...

ALTER TABLE `sesion` CHANGE `id_docente1` `id_docente1` INT NULL;
ALTER TABLE `sesion` CHANGE `id_docente2` `id_docente2` INT NULL;

--tipo_aula
--aula

ALTER TABLE `SESION` CHANGE `notaSesion` `notaSesion` VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;

ALTER TABLE `SESION` CHANGE `confirmAsignatura` `confirmAsignatura` BOOLEAN NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `confirmContenidos` `confirmContenidos` BOOLEAN NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `confirmDocente1` `confirmDocente1` BOOLEAN NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `confirmDocente2` `confirmDocente2` BOOLEAN NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `confirmAula` `confirmAula` BOOLEAN NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `notaConfirms` `notaConfirms` VARCHAR(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `warningConfirms` `warningConfirms` BOOLEAN NULL DEFAULT NULL;

ALTER TABLE `SESION` CHANGE `version` `version` INT NULL DEFAULT NULL;
ALTER TABLE `SESION` CHANGE `activa` `activa` BOOLEAN NULL DEFAULT NULL;