import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private String nombre;
    private Pokemon[] pokemones;
    private Pokemon[] pokemonesJugador;
    private Entrenador jugador;

    public Menu() {
        scanner = new Scanner(System.in);
        nombre = null;
        pokemones = new Pokemon[1];
        pokemonesJugador = new Pokemon[3];
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

        // Elegir 3 pokemones
        for (int i = 0; i < 2; i++) {
            elegirPokemones();
        }

        jugador = new Entrenador(nombre, true, pokemonesJugador);
    }

    private void pedirNombre() {
        System.out.println("¿Cómo te llamas?");
        nombre = scanner.nextLine();
    }

    private void datosPokemones() {
        // No se como crear esas instancias de pokemon, se pueden hacer con ChatGPT, no sé si se necesite correr el juego varias veces en una misma sesión.
        // En ese caso, hay que hacer reset de los datos que tomamos ej. La lista de pokemones.
    }

    private void elegirPokemones() {
        System.out.println("--------- Elección de pokemones ---------");

        // Print de pokemones para elegir
        for (int i = 0; i < pokemones.length - 1; i++) {
            System.out.print(i + 1 + ") ");
            pokemonToString(pokemones[i]);
        }

        System.out.println("¿Qué pokemon desea?");
        int opcion = -1;
        int contador = -1;

        // No hay pokemon 0, empieza en 1
        while (opcion >= 0) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                opcion--;
                contador++;
            } catch (Exception error) {
                System.out.println(error);
                opcion = -1;
            }
        
        pokemonesJugador[contador] = pokemones[opcion];

        // Modificar la lista original de pokemones para quitar el pokemon seleccionado
        Pokemon[] pokemonesTemp = new Pokemon[pokemones.length - 1];
        int contador2 = 0;

        for (int i = 0; i < pokemones.length; i++) {
            if (i != opcion) {
                pokemonesTemp[contador2] = pokemones[contador2];
                contador++;
            }
        }

        pokemones = pokemonesTemp;
        }
    }

    private void pokemonToString(Pokemon pokemon) {
        // Para hacer print para la elección del pokemon
        System.out.printf("%s Lv%d\n", pokemon.getNombre(), pokemon.getNivel());
    }
}