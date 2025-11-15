/**
 * Clase para colores de consola usando códigos ANSI
 * Proporciona constantes para colores de texto, fondo y estilos
 */
public class Color {
    /** Código para resetear formato y color */
    public static final String RESET = "\u001B[0m";
   
    /** Colores de texto */
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    /** Colores de fondo */
    public static final String BLACKBG = "\u001B[40m";
    public static final String REDBG = "\u001B[41m";
    public static final String GREENBG = "\u001B[42m";
    public static final String YELLOWBG = "\u001B[43m";
    public static final String BLUEBG = "\u001B[44m";
    public static final String PURPLEBG = "\u001B[45m";
    public static final String CYANBG = "\u001B[46m";
    public static final String WHITEBG = "\u001B[47m";

    /** Estilos de texto */
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

}