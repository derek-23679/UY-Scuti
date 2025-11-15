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
     * Método recursivo para insertar un color manteniendo el balance del árbol
     * @param nodo Nodo actual de la recursión
     * @param color El color a insertar
     * @return El nodo actualizado después de la inserción
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
    
    /**
     * Obtiene la altura de un nodo
     * @param nodo El nodo a consultar
     * @return La altura del nodo, 0 si es nulo
     */
    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }
    
    /**
     * Calcula el factor de balance de un nodo
     * @param nodo El nodo a evaluar
     * @return Diferencia entre altura izquierda y derecha
     */
    private int obtenerBalance(Nodo nodo) {
        if (nodo == null) return 0;
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }
    
    /**
     * Realiza una rotación simple a la derecha
     * @param y El nodo desbalanceado
     * @return El nuevo nodo raíz después de la rotación
     */
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo B = x.derecho;
        
        x.derecho = y;
        y.izquierdo = B;
        
        y.altura = 1 + Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho));
        x.altura = 1 + Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho));
        
        return x;
    }
    
    /**
     * Realiza una rotación simple a la izquierda
     * @param x El nodo desbalanceado
     * @return El nuevo nodo raíz después de la rotación
     */
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo B = y.izquierdo;
        
        y.izquierdo = x;
        x.derecho = B;
        
        x.altura = 1 + Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho));
        y.altura = 1 + Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho));
        
        return y;
    }
    
    /**
     * Obtiene la frecuencia de un color en el árbol
     * @param color El color a buscar
     * @return La frecuencia del color, 0 si no existe
     */
    public int obtenerFrecuencia(String color) {
        return buscarFrecuencia(raiz, color);
    }
    
    /**
     * Búsqueda recursiva de la frecuencia de un color
     * @param nodo Nodo actual de la búsqueda
     * @param color Color a buscar
     * @return Frecuencia del color encontrado
     */
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
    
    /**
     * Vacía el árbol completamente
     */
    public void limpiar() {
        raiz = null;
    }
}