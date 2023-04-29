CREATE TABLE publicaciones_cientificas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    fecha_publicacion DATE,
    revista_conferencia VARCHAR(255),
    resumen TEXT,
    numero_citas INT
);
