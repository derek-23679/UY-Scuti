/**
 * Árbol autobalanceado para contar frecuencias de colores
 */
public class Arbol {

    /**
     * Nodo del árbol
     */
    private class Nodo {
        String color;
        int frecuencia;
        int altura;
        Nodo izquierdo;
        Nodo derecho;

        /**
         * Constructor de Nodo
         * @param color El color que contiene el nodo
         */
        public Nodo(String color) {
            this.color = color;
            this.frecuencia = 1;
            this.altura = 1;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    private Nodo raiz;
    
    /**
     * Constructor de Arbol
     */
    public Arbol() {
        this.raiz = null;
    }
    
    /**
     * Inserta un color en el árbol o incrementa su frecuencia si ya existe
     * @param color El color a insertar
     */
    public void insertar(String color) {
        raiz = insertarRecursivo(raiz, color);
    }
    
    /**
     * Método recursivo para insertar un color
     * @param nodo Nodo actual de la recursión
     * @param color El color a insertar
     */
    private Nodo insertarRecursivo(Nodo nodo, String color) {
        if (nodo == null) {
            return new Nodo(color);
        }
        
        int comparacion = color.compareTo(nodo.color);
        
        if (comparacion < 0) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, color);
        } else if (comparacion > 0) {
            nodo.derecho = insertarRecursivo(nodo.derecho, color);
        } else {
            nodo.frecuencia++;
            return nodo;
        }
        
        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo), 
                                    obtenerAltura(nodo.derecho));
        
        int balance = obtenerBalance(nodo);
        
        // Casos de rotación
        if (balance > 1 && color.compareTo(nodo.izquierdo.color) < 0) {
            return rotarDerecha(nodo);
        }
        
        if (balance < -1 && color.compareTo(nodo.derecho.color) > 0) {
            return rotarIzquierda(nodo);
        }
        
        if (balance > 1 && color.compareTo(nodo.izquierdo.color) > 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }
        
        if (balance < -1 && color.compareTo(nodo.derecho.color) < 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }
        
        return nodo;
    }
    
    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }
    
    private int obtenerBalance(Nodo nodo) {
        if (nodo == null) return 0;
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }
    
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo B = x.derecho;
        
        x.derecho = y;
        y.izquierdo = B;
        
        y.altura = 1 + Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho));
        x.altura = 1 + Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho));
        
        return x;
    }
    
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo B = y.izquierdo;
        
        y.izquierdo = x;
        x.derecho = B;
        
        x.altura = 1 + Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho));
        y.altura = 1 + Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho));
        
        return y;
    }
    
    public int obtenerFrecuencia(String color) {
        return buscarFrecuencia(raiz, color);
    }
    
    private int buscarFrecuencia(Nodo nodo, String color) {
        if (nodo == null) return 0;
        
        int comparacion = color.compareTo(nodo.color);
        
        if (comparacion < 0) {
            return buscarFrecuencia(nodo.izquierdo, color);
        } else if (comparacion > 0) {
            return buscarFrecuencia(nodo.derecho, color);
        } else {
            return nodo.frecuencia;
        }
    }
    
    public void limpiar() {
        raiz = null;
    }
}