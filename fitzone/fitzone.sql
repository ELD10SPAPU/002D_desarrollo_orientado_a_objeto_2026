-- ============================================================================
-- EP3 FORMA A — Gimnasio FitZone (Gestión de Planes de Membresía)
-- Ejecutar conectado como: usuario_desarrollador
--   * Laboratorio Duoc: SID = ORCL (localhost:1521)
--   * Docker en casa  : Service Name = FREEPDB1 (localhost:1521)
-- ============================================================================
DROP TABLE planes_membresia;
CREATE TABLE planes_membresia (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo VARCHAR2(20) NOT NULL,                 -- 'ESTANDAR' o 'PERSONALIZADO'
    nombre_cliente VARCHAR2(100) NOT NULL,
    precio_base NUMBER(10) NOT NULL,
    duracion_meses NUMBER(3) NOT NULL,
    -- Columnas exclusivas de ESTANDAR (NULL si es PERSONALIZADO)
    clases_semanales NUMBER(3),
    acceso_piscina CHAR(1),                     -- 'S' = Sí, 'N' = No
    -- Columnas exclusivas de PERSONALIZADO (NULL si es ESTANDAR)
    sesiones_entrenador NUMBER(3),
    recargo_entrenador NUMBER(10)
);

INSERT INTO planes_membresia (tipo, nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina)
VALUES ('ESTANDAR', 'Camila Rojas', 32000, 6, 4, 'S');

INSERT INTO planes_membresia (tipo, nombre_cliente, precio_base, duracion_meses, sesiones_entrenador, recargo_entrenador)
VALUES ('PERSONALIZADO', 'Matías Fuentes', 45000, 12, 8, 25000);

INSERT INTO planes_membresia (tipo, nombre_cliente, precio_base, duracion_meses, clases_semanales, acceso_piscina)
VALUES ('ESTANDAR', 'Valentina Soto', 29000, 3, 2, 'N');

COMMIT;


-- Verificación rápida
SELECT * FROM planes_membresia ORDER BY id ASC;
SELECT id, tipo, nombre_cliente, precio_base, duracion_meses FROM planes_membresia ORDER BY id ASC;