
-- sessions + info (nom) masters + info (inicials) docents:

SELECT
	id_sesion,
    -- id_master1,
    m1.code master1,
    -- id_master2,
    m2.code master2,
    asignatura,
    asignatura_desc_extra,
    color_fondo,
	color_texto,
    sesion_contenidos,
    -- id_docente1,
    d1.code docente1,
    -- id_docente2,
    d2.code docente2,
    tipo_aula,
    aula,
    notaSesion,
    confirmAsignatura,
    confirmContenidos,
    confirmDocente1,
    confirmDocente2,
    confirmAula,
    notaConfirms,
    warningConfirms,
    version,
    activa
    
FROM asico_db.sesion s LEFT JOIN asico_db.master m1
		ON s.id_master1 = m1.id_Master
    LEFT JOIN asico_db.master m2
    	ON s.id_master2 = m2.id_Master
        
    LEFT JOIN asico_db.docente d1
    	ON s.id_docente1 = d1.id_docente
    LEFT JOIN asico_db.docente d2
    	ON s.id_docente2 = d2.id_docente
        
ORDER BY id_sesion
;