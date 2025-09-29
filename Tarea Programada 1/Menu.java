import java.util.Scanner;
import java.util.List;

public class Menu {
    private Scanner scanner;
    private String nombre;
    private List<Pokemon> pokemones;

    public Menu() {
        scanner = new Scanner(System.in);
        nombre = null;
    }

    public void iniciar() {
        boolean hold = true;

        while (hold) {
            System.out.println("========= POKEMON =========\nPresione ENTER para continuar");
            
            if (scanner.nextLine() != null) {
                hold = false;
            }
        }

        pedirNombre();
        elegirPokemon();
    }

    private void pedirNombre() {
        System.out.println("¿Cómo te llamas?");
        nombre = scanner.nextLine();
    }

    private void pokemones() {
        Pokemon pokemon = new Pokemon("nombre", 0, null, null, null);
    }

    private void elegirPokemon() {
        for (int i = 0; i < List<Pokemon>)
    }
}