import java.util.List;
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

    // Todos los datos son de la primera generación (Pokémon Rojo/Azul/Amarillo)
    private void datosPokemones() {
        /* Elementos seleccionados:
         * - Fuego (fuerte vs Planta, Volador; débil vs Agua), 
           - Agua (fuerte vs Fuego; débil vs Planta, Eléctrico), 
           - Planta (fuerte vs Agua; débil vs Fuego, Volador), 
           - Eléctrico (fuerte vs Agua; débil vs Planta), 
           - Volador (fuerte vs Planta; débil vs Fuego), 
           - Normal (neutro)
        */
        Elemento fuego = new Elemento("Fuego", List.of("Planta", "Volador"), List.of("Agua"));
        Elemento agua = new Elemento("Agua", List.of("Fuego"), List.of("Planta", "Eléctrico"));
        Elemento planta = new Elemento("Planta", List.of("Agua"), List.of("Fuego", "Volador"));
        Elemento electrico = new Elemento("Eléctrico", List.of("Agua"), List.of("Planta"));
        Elemento volador = new Elemento("Volador", List.of("Planta"), List.of("Fuego"));
        Elemento normal = new Elemento("Normal", List.of(), List.of());
        /* Stats base de cada pokémon, divididos por elemento
         * (Obtenidas de https://pokemondb.net/pokedex/game/red-blue-yellow):
        */
        // Fuego:
        Stats statsCharmander = new Stats(39, 52, 43, 65);
        Stats statsCharmeleon = new Stats(58, 64, 58, 80);
        Stats statsCharizard = new Stats(78, 84, 78, 100);
        Stats statsVulpix = new Stats(38, 41, 40, 65);
        Stats statsGrowlithe = new Stats(55, 70, 45, 60);
        // Agua:
        Stats statsSquirtle = new Stats(44, 48, 65, 43);
        Stats statsWartortle = new Stats(59, 63, 80, 58);
        Stats statsBlastoise = new Stats(79, 83, 100, 78);
        Stats statsPsyduck = new Stats(50, 52, 48, 55);
        Stats statsLapras = new Stats(130, 85, 80, 60);
        // Planta:
        Stats statsBulbasaur = new Stats(45, 49, 49, 45);
        Stats statsIvysaur = new Stats(60, 62, 63, 60);
        Stats statsVenusaur = new Stats(80, 82, 83, 80);
        Stats statsOddish = new Stats(45, 50, 55, 30);
        Stats statsBellsprout = new Stats(50, 75, 35, 40);
        // Eléctrico:
        Stats statsPikachu = new Stats(35, 55, 40, 90);
        Stats statsRaichu = new Stats(60, 90, 55, 110);
        Stats statsMagnemite = new Stats(25, 35, 70, 45);
        Stats statsVoltorb = new Stats(40, 30, 50, 100);
        Stats statsElectabuzz = new Stats(65, 83, 57, 105);
        // Volador:
        Stats statsPidgey = new Stats(40, 45, 40, 56);
        Stats statsPidgeotto = new Stats(63, 60, 55, 71);
        Stats statsPidgeot = new Stats(83, 80, 75, 101);
        Stats statsZubat = new Stats(40, 45, 35, 55);
        Stats statsFearow = new Stats(65, 90, 65, 100);
        // Normal:
        Stats statsSnorlax = new Stats(160, 110, 65, 30);
        Stats statsRattata = new Stats(30, 56, 35, 72);
        Stats statsJigglypuff = new Stats(115, 45, 20, 20);
        Stats statsMeowth = new Stats(40, 45, 35, 90);
        Stats statsEevee = new Stats(55, 55, 50, 55);
        /* Ataques disponibles, divididos por elemento
         * (Obtenidos de https://pokemon.fandom.com/es/wiki/Lista_de_Pok%C3%A9mon_de_la_primera_generaci%C3%B3n):
        */
        // Ataques tipo Normal:
        Ataque placaje = new Ataque("Placaje", normal, 40, 35, 95);
        Ataque golpeCuerpo = new Ataque("Golpe Cuerpo", normal, 50, 35, 95);
        Ataque latigo = new Ataque("Látigo", normal, 35, 30, 95);
        // Ataques tipo Fuego:
        Ataque ascuas = new Ataque("Ascuas", fuego, 40, 25, 100);
        Ataque giroFuego = new Ataque("Giro Fuego", fuego, 60, 25, 100);
        Ataque llamarada = new Ataque("Llamarada", fuego, 90, 15, 85);
        // Ataques tipo Agua:
        Ataque pistolaAgua = new Ataque("Pistola Agua", agua, 40, 25, 100);
        Ataque surf = new Ataque("Surf", agua, 90, 15, 100);
        Ataque hidrobomba = new Ataque("Hidrobomba", agua, 110, 5, 80);
        // Ataques tipo Planta:
        Ataque latigoCepa = new Ataque("Latigazo Cepa", planta, 45, 25, 100);
        Ataque hojaAfilada = new Ataque("Hoja Afilada", planta, 55, 25, 95);
        Ataque rayoSolar = new Ataque("Rayo Solar", planta, 120, 10, 100);
        // Ataques tipo Eléctrico:
        Ataque impactrueno = new Ataque("Impactrueno", electrico, 40, 25, 100);
        Ataque rayo = new Ataque("Rayo", electrico, 90, 15, 100);
        Ataque chispazo = new Ataque("Chispazo", electrico, 40, 30, 100);
        // Ataques tipo Volador:
        Ataque ataqueAla = new Ataque("Ataque Ala", volador, 60, 35, 95);
        Ataque picado = new Ataque("Picado", volador, 80, 30, 100);
        Ataque tornado = new Ataque("Tornado", volador, 80, 20, 95);
        /* Pokemones que se tomarán en cuenta, divididos por elemento
         * Se seleccionaron 5 pokémon por cada uno de los 6 elementos, para un total de 30
         * Cada pokémon tiene 3 ataques; 1 ataque básico y 2 ataques relativo a su elemento
        */
        // Fuego
        Pokemon charmander = new Pokemon("Charmander", 1, statsCharmander, List.of(fuego), List.of(placaje, golpeCuerpo, ascuas));
        Pokemon charmeleon = new Pokemon("Charmeleon", 1, statsCharmeleon, List.of(fuego), List.of(placaje, latigo, giroFuego));
        Pokemon charizard = new Pokemon("Charizard", 1, statsCharizard, List.of(fuego, volador), List.of(golpeCuerpo, latigo, llamarada));
        Pokemon vulpix = new Pokemon("Vulpix", 1, statsVulpix, List.of(fuego), List.of(placaje, golpeCuerpo, ascuas));
        Pokemon growlithe = new Pokemon("Growlithe", 1, statsGrowlithe, List.of(fuego), List.of(golpeCuerpo, placaje, giroFuego));
        // Agua
        Pokemon squirtle = new Pokemon("Squirtle", 1, statsSquirtle, List.of(agua), List.of(placaje, golpeCuerpo, pistolaAgua));
        Pokemon wartortle = new Pokemon("Wartortle", 1, statsWartortle, List.of(agua), List.of(latigo, placaje, surf));
        Pokemon blastoise = new Pokemon("Blastoise", 1, statsBlastoise, List.of(agua), List.of(golpeCuerpo, placaje, hidrobomba));
        Pokemon psyduck = new Pokemon("Psyduck", 1, statsPsyduck, List.of(agua), List.of(placaje, latigo, pistolaAgua));
        Pokemon lapras = new Pokemon("Lapras", 1, statsLapras, List.of(agua), List.of(golpeCuerpo, latigo, surf));
        // Planta
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, statsBulbasaur, List.of(planta), List.of(placaje, golpeCuerpo, latigoCepa));
        Pokemon ivysaur = new Pokemon("Ivysaur", 1, statsIvysaur, List.of(planta), List.of(latigo, placaje, hojaAfilada));
        Pokemon venusaur = new Pokemon("Venusaur", 1, statsVenusaur, List.of(planta), List.of(golpeCuerpo, latigo, rayoSolar));
        Pokemon oddish = new Pokemon("Oddish", 1, statsOddish, List.of(planta), List.of(placaje, golpeCuerpo, latigoCepa));
        Pokemon bellsprout = new Pokemon("Bellsprout", 1, statsBellsprout, List.of(planta), List.of(golpeCuerpo, placaje, hojaAfilada));
        // Eléctrico
        Pokemon pikachu = new Pokemon("Pikachu", 1, statsPikachu, List.of(electrico), List.of(placaje, golpeCuerpo, impactrueno));
        Pokemon raichu = new Pokemon("Raichu", 1, statsRaichu, List.of(electrico), List.of(latigo, placaje, rayo));
        Pokemon magnemite = new Pokemon("Magnemite", 1, statsMagnemite, List.of(electrico), List.of(golpeCuerpo, placaje, chispazo));
        Pokemon voltorb = new Pokemon("Voltorb", 1, statsVoltorb, List.of(electrico), List.of(placaje, golpeCuerpo, impactrueno));
        Pokemon electabuzz = new Pokemon("Electabuzz", 1, statsElectabuzz, List.of(electrico), List.of(golpeCuerpo, latigo, rayo));
        // Volador
        Pokemon pidgey = new Pokemon("Pidgey", 1, statsPidgey, List.of(volador, normal), List.of(placaje, golpeCuerpo, ataqueAla));
        Pokemon pidgeotto = new Pokemon("Pidgeotto", 1, statsPidgeotto, List.of(volador, normal), List.of(latigo, placaje, picado));
        Pokemon pidgeot = new Pokemon("Pidgeot", 1, statsPidgeot, List.of(volador, normal), List.of(golpeCuerpo, latigo, tornado));
        Pokemon zubat = new Pokemon("Zubat", 1, statsZubat, List.of(volador, normal), List.of(placaje, golpeCuerpo, ataqueAla));
        Pokemon fearow = new Pokemon("Fearow", 1, statsFearow, List.of(volador, normal), List.of(golpeCuerpo, placaje, picado));
        // Normal
        Pokemon snorlax = new Pokemon("Snorlax", 1, statsSnorlax, List.of(normal), List.of(placaje, golpeCuerpo, latigo));
        Pokemon rattata = new Pokemon("Rattata", 1, statsRattata, List.of(normal), List.of(latigo, placaje, placaje));
        Pokemon jigglypuff = new Pokemon("Jigglypuff", 1, statsJigglypuff, List.of(normal), List.of(golpeCuerpo, latigo, placaje));
        Pokemon meowth = new Pokemon("Meowth", 1, statsMeowth, List.of(normal), List.of(placaje, golpeCuerpo, latigo));
        Pokemon eevee = new Pokemon("Eevee", 1, statsEevee, List.of(normal), List.of(golpeCuerpo, placaje, latigo));
        /*
         * Se asignan todos los objetos pokémon al arreglo pokemones:
        */
        pokemones = new Pokemon[] {
        charmander, charmeleon, charizard, vulpix, growlithe,
        squirtle, wartortle, blastoise, psyduck, lapras,
        bulbasaur, ivysaur, venusaur, oddish, bellsprout,
        pikachu, raichu, magnemite, voltorb, electabuzz,
        pidgey, pidgeotto, pidgeot, zubat, fearow,
        snorlax, rattata, jigglypuff, meowth, eevee
        };
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