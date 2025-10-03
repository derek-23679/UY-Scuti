import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Entrenador jugador;

    public Menu() {
        scanner = new Scanner(System.in);
        jugador = new Entrenador();
    }

    public void iniciar() {
        boolean signal = false;

        while (!signal) {
            System.out.println("=========== POKÉMON ===========\n Presione ENTER para continuar...");
            if (scanner.nextLine() != null) {
                signal = true;
            }
        }

        System.out.println("Bienvenido!");

        // pedirNombre()
    }

    private String pedirNombre() {
        System.out.println("Tu nombre es...");
        String nombreTemp = scanner.nextLine();
        return nombreTemp;
    }

    private Pokemon[] elegirPokemones() {
        System.out.println("Y tus pokemones son...");

    }

    private void generarDatos() {
        Elemento fuego = new Elemento("Fuego", String[] {"Planta", "Volador"}, String[] {"Agua"});
        Elemento agua = new Elemento("Agua", String[] {"Fuego"}, String[] {"Planta", "Eléctrico"});
        Elemento planta = new Elemento("Planta", String[] {"Agua"}, String[] {"Fuego", "Volador"});
        Elemento electrico = new Elemento("Eléctrico", String[] {"Agua"}), String[] {"Planta"});
        Elemento volador = new Elemento("Volador", String[] {"Planta"}), String[] {"Fuego"});
        Elemento normal = new Elemento("Normal", String[] {}, String[] {};
    }
}
