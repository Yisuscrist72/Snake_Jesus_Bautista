# Snake Game

Este proyecto es una implementación del clásico juego "Snake" utilizando Java Swing. El juego consiste en controlar una serpiente que se mueve automáticamente por la pantalla, comiendo comida para crecer y evitando colisiones con las paredes y consigo misma.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de archivos:

```
SnakeGame
├── src
│   ├── Main.java        # Punto de entrada de la aplicación.
│   ├── GamePanel.java   # Lógica del juego y renderizado.
│   ├── Snake.java       # Clase que representa la serpiente.
│   └── Food.java        # Clase que representa la comida.
├── .gitignore           # Archivos y carpetas a ignorar por Git.
└── README.md            # Documentación del proyecto.
```

## Instrucciones para Ejecutar el Juego

1. Asegúrate de tener Java instalado en tu máquina.
2. Clona este repositorio o descarga los archivos.
3. Navega al directorio `src`.
4. Compila el proyecto utilizando el siguiente comando:
   ```
   javac Main.java GamePanel.java Snake.java Food.java
   ```
5. Ejecuta el juego con el siguiente comando:
   ```
   java Main
   ```

## Controles

- Usa las teclas de flecha para cambiar la dirección de la serpiente.
- La serpiente crecerá al comer la comida que aparece en posiciones aleatorias.

## Características

- Movimiento automático de la serpiente.
- Detección de colisiones con paredes y consigo misma.
- Incremento de longitud y puntuación al comer comida.
- Interfaz gráfica simple y funcional.

¡Disfruta jugando!