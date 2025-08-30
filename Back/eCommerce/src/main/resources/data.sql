-- ========================
-- USUARIOS
-- ========================
INSERT INTO usuarios
(id_usuario, nombre_Completo, email, contrasenia, rol, dni, Pais, provincia, direccion, numero, fecha_Registro)
VALUES
    (1, 'Admin Principal', 'admin@ecommerce.com', 'admin123', 'Admin', '00000000', 'Argentina', 'Córdoba', 'Calle Falsa', 1, '2025-08-24'),
    (2, 'Usuario Uno', 'user1@ecommerce.com', 'user123', 'Cliente', '12345678', 'Argentina', 'Córdoba', 'Av. Siempre Viva', 123, '2025-08-24'),
    (3, 'Usuario Dos', 'user2@ecommerce.com', 'user456', 'Cliente', '87654321', 'Argentina', 'Córdoba', 'Calle Luna', 45, '2025-08-24');
-- ========================
-- PRODUCTOS
-- ========================
INSERT INTO producto
(id_producto, nombre, descripcion, marca, categoria, talle, stock, precio, imagen)
VALUES
    (1, 'Remera Roja', 'Remera de algodón', 'MarcaA', 'Ropa', 'M', 50, 1500.00, 'remera_roja.png'),
    (2, 'Pantalón Azul', 'Jean clásico', 'MarcaB', 'Ropa', 'L', 30, 3500.00, 'pantalon_azul.png');

-- ========================
-- FACTURAS
-- ========================
INSERT INTO facturas
(id_factura, id_usuario, fecha, total, estado)
VALUES
    (1, 2, '2025-08-24', 5000.00, 'Pagado'),
    (2, 3, '2025-08-24', 3500.00, 'Pagado');

-- ========================
-- DETALLE_FACTURA
-- ========================
INSERT INTO DETALLE_FACTURA
(ID_DETALLE_FACTURA, ID_FACTURA, ID_PRODUCTO, CANTIDAD, PRECIO_UNITARIO, SUBTOTAL)
VALUES
    (1, 1, 1, 2, 1500.00, 3000.00),
    (2, 1, 2, 1, 2000.00, 2000.00),
    (3, 2, 2, 1, 3500.00, 3500.00);
-- ========================
-- PAGOS
-- ========================
INSERT INTO pago
(id_pago, id_factura, metodo, estado, fecha)
VALUES
    (1, 1, 'Aprobado', 'Aprobado', '2025-08-24'),
    (2, 2, 'Aprobado', 'Aprobado', '2025-08-24');

-- ========================
-- TICKETS
-- ========================
INSERT INTO tickets
(id_ticket, id_factura, url_ticket, fecha_ticket)
VALUES
    (1, 1, 'http://localhost:8080/tickets/1', '2025-08-24'),
    (2, 2, 'http://localhost:8080/tickets/2', '2025-08-24');