/**
 * Nodo para el árbol autobalanceado
 */
public class Nodo {
    String color;
    int frecuencia;
    int altura;
    Nodo izquierdo;
    Nodo derecho;
    
    public Nodo(String color) {
        this.color = color;
        this.frecuencia = 1;
        this.altura = 1;
        this.izquierdo = null;
        this.derecho = null;
    }
}