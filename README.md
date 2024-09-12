# Compunet Taller UDP

Este proyecto es un taller práctico sobre el protocolo UDP (User Datagram Protocol) desarrollado en el curso de Computación en Internet de la Universidad ICESI.

## Integrantes
- Oscar Stiven Muñoz
- Sebastian Erazo
- Luis Manuel Rojas

## Descripción del Proyecto
El taller aborda la implementación de comunicación en red utilizando UDP en Java. Incluye ejercicios de captura y análisis de paquetes con Wireshark, así como una discusión sobre patrones de diseño y posibles mejoras de seguridad y migración a TCP.

## Contenido del Taller
1. **Análisis con Wireshark:**
   - Verificación del contenido del mensaje en las capturas.
   - Cálculo y explicación del checksum de los paquetes.

2. **Patrones de Diseño Aplicados:**
   - **Reactor:** Manejo eficiente de múltiples conexiones usando multiplexación.
   - **Observer:** Notificación de eventos a diferentes módulos de forma desacoplada.
   - **Singleton:** Asegura una única instancia de cliente o servidor.
   - **Adapter:** Permite adaptar la comunicación UDP a TCP sin modificar la lógica principal.
   - **Strategy:** Define algoritmos intercambiables para la gestión de mensajes.

3. **Migración de UDP a TCP:**
   - Sustitución de clases y métodos clave.
   - Establecimiento de conexiones y manejo de flujos de entrada/salida.
   - Modificación de métodos de envío y recepción de datos.

4. **Mejoras de Seguridad:**
   - **Cifrado de Datos:** Implementación de cifrado utilizando bibliotecas como `javax.crypto` y algoritmos como AES.
   - **Autenticación:** Uso de tokens o certificados para autenticar usuarios y dispositivos.
   - **Integridad de Datos:** Uso de hashing como SHA-256 para asegurar que los datos no sean alterados.
   - **Uso de TLS/SSL:** Implementación de SSL/TLS sobre TCP para asegurar la comunicación.

## Requerimientos
- Java JDK 8 o superior
- Wireshark para la captura y análisis de paquetes
