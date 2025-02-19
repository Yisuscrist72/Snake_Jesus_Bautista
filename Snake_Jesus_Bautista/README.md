# Snake Game

Este proyecto es una implementación del clásico juego "Snake" utilizando Java Swing. El juego consiste en controlar una serpiente que se mueve automáticamente por la pantalla, comiendo comida para crecer y evitando colisiones con las paredes y consigo misma.

## Estructura del Proyecto

El proyecto tiene la siguiente estructura de archivos:

```
EXPLORADOR
├── SNAKE_JESUS_BAUTISTA
 └── SnakeGame
    ├── bin
    │   └── game
    │       ├── Food.class
    │       ├── GamePanel.class
    │       ├── GamePanel$1.class
    │       ├── GamePanel$2.class
    │       └── Snake.class
    ├── main
    │   ├── Main.class
    │   ├── SnakeGame.class
    │   ├── Food.class
    │   ├── GamePanel.class
    │   ├── GamePanel$1.class
    │   ├── Main.class
    │   └── Snake.class
    └── src
        ├── game
        │   ├── Food.java
        │   ├── GamePanel.java
        │   └── Snake.java
        └── main
            └── SnakeGame.java

```

## Instrucciones para Ejecutar el Juego

1. Asegúrate de tener Java instalado en tu máquina.
2. Clona este repositorio o descarga los archivos.
   ```
   git clone https://github.com/Yisuscrist72/Snake_Jesus_Bautista.git
   ```
3. Navega al directorio `SnakeGame`.
   ```
   cd Snake_Jesus_Bautista/SnakeGame
   ```
4. Compila el proyecto utilizando el siguiente comando:
   ```
   javac -d bin src/game/Food.java src/game/GamePanel.java src/game/Snake.java src/main/SnakeGame.java
   ```
5. Ejecuta el juego con el siguiente comando:
   ```
   java -cp bin main.SnakeGame   
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
