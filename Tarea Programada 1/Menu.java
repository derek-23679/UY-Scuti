import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Entrenador jugador;
    private Pokemon[] pokemones;
    private Pokemon[] pokemonesJugador;
    private Gimnasio[] gimnasios;

    public Menu() {
        scanner = new Scanner(System.in);
        pokemones = new Pokemon[1];
        gimnasios = new Gimnasio[3];
        pokemonesJugador = new Pokemon[3];
    }

    public void iniciar() {
        boolean signal = false;

        while (!signal) {
            System.out.println("=========== POKEMON ===========\nPresione ENTER para continuar...");
            if (scanner.nextLine() != null) {
                signal = true;
            }
        }

        generarDatos();
        String nombre = pedirNombre();
        System.out.printf("Bienvenido %s, elige tus pokemones!\n", nombre);
        elegirPokemones();
        jugador = new Entrenador(nombre, true, pokemones);
        System.out.println("Elige el gimnasio que quieres desafiar!");
        elegirGimnasio();
    }

    private String pedirNombre() {
        System.out.println("Tu nombre es...");
        String nombreTemp = scanner.nextLine();
        return nombreTemp;
    }

    private void generarDatos() {
        // Elementos
        Elemento fuego = new Elemento("Fuego", new String[] {"Planta", "Volador"}, new String[] {"Agua"});
        Elemento agua = new Elemento("Agua", new String[] {"Fuego"}, new String[] {"Planta", "Eléctrico"});
        Elemento planta = new Elemento("Planta", new String[] {"Agua"}, new String[] {"Fuego", "Volador"});
        Elemento electrico = new Elemento("Eléctrico", new String[] {"Agua"}, new String[] {"Planta"});
        Elemento volador = new Elemento("Volador", new String[] {"Planta"}, new String[] {"Fuego"});
        Elemento normal = new Elemento("Normal", new String[] {}, new String[] {});

        // Stats
        Stats statsCharmander = new Stats(39, 52, 43, 65);
        Stats statsCharmeleon = new Stats(58, 64, 58, 80);
        Stats statsCharizard = new Stats(78, 84, 78, 100);
        Stats statsVulpix = new Stats(38, 41, 40, 65);
        Stats statsGrowlithe = new Stats(55, 70, 45, 60);
        Stats statsSquirtle = new Stats(44, 48, 65, 43);
        Stats statsWartortle = new Stats(59, 63, 80, 58);
        Stats statsBlastoise = new Stats(79, 83, 100, 78);
        Stats statsPsyduck = new Stats(50, 52, 48, 55);
        Stats statsLapras = new Stats(130, 85, 80, 60);
        Stats statsBulbasaur = new Stats(45, 49, 49, 45);
        Stats statsIvysaur = new Stats(60, 62, 63, 60);
        Stats statsVenusaur = new Stats(80, 82, 83, 80);
        Stats statsOddish = new Stats(45, 50, 55, 30);
        Stats statsBellsprout = new Stats(50, 75, 35, 40);
        Stats statsPikachu = new Stats(35, 55, 40, 90);
        Stats statsRaichu = new Stats(60, 90, 55, 110);
        Stats statsMagnemite = new Stats(25, 35, 70, 45);
        Stats statsVoltorb = new Stats(40, 30, 50, 100);
        Stats statsElectabuzz = new Stats(65, 83, 57, 105);
        Stats statsPidgey = new Stats(40, 45, 40, 56);
        Stats statsPidgeotto = new Stats(63, 60, 55, 71);
        Stats statsPidgeot = new Stats(83, 80, 75, 101);
        Stats statsZubat = new Stats(40, 45, 35, 55);
        Stats statsFearow = new Stats(65, 90, 65, 100);
        Stats statsSnorlax = new Stats(160, 110, 65, 30);
        Stats statsRattata = new Stats(30, 56, 35, 72);
        Stats statsJigglypuff = new Stats(115, 45, 20, 20);
        Stats statsMeowth = new Stats(40, 45, 35, 90);
        Stats statsEevee = new Stats(55, 55, 50, 55);

        // Ataques
        Ataque placaje = new Ataque("Placaje", normal, 40, 35, 95);
        Ataque golpeCuerpo = new Ataque("Golpe Cuerpo", normal, 50, 35, 95);
        Ataque latigo = new Ataque("Látigo", normal, 35, 30, 95);
        Ataque ascuas = new Ataque("Ascuas", fuego, 40, 25, 100);
        Ataque giroFuego = new Ataque("Giro Fuego", fuego, 60, 25, 100);
        Ataque llamarada = new Ataque("Llamarada", fuego, 90, 15, 85);
        Ataque pistolaAgua = new Ataque("Pistola Agua", agua, 40, 25, 100);
        Ataque surf = new Ataque("Surf", agua, 90, 15, 100);
        Ataque hidrobomba = new Ataque("Hidrobomba", agua, 110, 5, 80);
        Ataque latigoCepa = new Ataque("Latigazo Cepa", planta, 45, 25, 100);
        Ataque hojaAfilada = new Ataque("Hoja Afilada", planta, 55, 25, 95);
        Ataque rayoSolar = new Ataque("Rayo Solar", planta, 120, 10, 100);
        Ataque impactrueno = new Ataque("Impactrueno", electrico, 40, 25, 100);
        Ataque rayo = new Ataque("Rayo", electrico, 90, 15, 100);
        Ataque chispazo = new Ataque("Chispazo", electrico, 40, 30, 100);
        Ataque ataqueAla = new Ataque("Ataque Ala", volador, 60, 35, 95);
        Ataque picado = new Ataque("Picado", volador, 80, 30, 100);
        Ataque tornado = new Ataque("Tornado", volador, 80, 20, 95);

        // Pokemones
        Pokemon charmander = new Pokemon("Charmander", 1, statsCharmander, new Elemento[]{fuego}, new Ataque[]{placaje, golpeCuerpo, ascuas});
        Pokemon charmeleon = new Pokemon("Charmeleon", 1, statsCharmeleon, new Elemento[]{fuego}, new Ataque[]{placaje, latigo, giroFuego});
        Pokemon charizard = new Pokemon("Charizard", 1, statsCharizard, new Elemento[]{fuego, volador}, new Ataque[]{golpeCuerpo, latigo, llamarada});
        Pokemon vulpix = new Pokemon("Vulpix", 1, statsVulpix, new Elemento[]{fuego}, new Ataque[]{placaje, golpeCuerpo, ascuas});
        Pokemon growlithe = new Pokemon("Growlithe", 1, statsGrowlithe, new Elemento[]{fuego}, new Ataque[]{golpeCuerpo, placaje, giroFuego});
        Pokemon squirtle = new Pokemon("Squirtle", 1, statsSquirtle, new Elemento[]{agua}, new Ataque[]{placaje, golpeCuerpo, pistolaAgua});
        Pokemon wartortle = new Pokemon("Wartortle", 1, statsWartortle, new Elemento[]{agua}, new Ataque[]{latigo, placaje, surf});
        Pokemon blastoise = new Pokemon("Blastoise", 1, statsBlastoise, new Elemento[]{agua}, new Ataque[]{golpeCuerpo, placaje, hidrobomba});
        Pokemon psyduck = new Pokemon("Psyduck", 1, statsPsyduck, new Elemento[]{agua}, new Ataque[]{placaje, latigo, pistolaAgua});
        Pokemon lapras = new Pokemon("Lapras", 1, statsLapras, new Elemento[]{agua}, new Ataque[]{golpeCuerpo, latigo, surf});
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, statsBulbasaur, new Elemento[]{planta}, new Ataque[]{placaje, golpeCuerpo, latigoCepa});
        Pokemon ivysaur = new Pokemon("Ivysaur", 1, statsIvysaur, new Elemento[]{planta}, new Ataque[]{latigo, placaje, hojaAfilada});
        Pokemon venusaur = new Pokemon("Venusaur", 1, statsVenusaur, new Elemento[]{planta}, new Ataque[]{golpeCuerpo, latigo, rayoSolar});
        Pokemon oddish = new Pokemon("Oddish", 1, statsOddish, new Elemento[]{planta}, new Ataque[]{placaje, golpeCuerpo, latigoCepa});
        Pokemon bellsprout = new Pokemon("Bellsprout", 1, statsBellsprout, new Elemento[]{planta}, new Ataque[]{golpeCuerpo, placaje, hojaAfilada});
        Pokemon pikachu = new Pokemon("Pikachu", 1, statsPikachu, new Elemento[]{electrico}, new Ataque[]{placaje, golpeCuerpo, impactrueno});
        Pokemon raichu = new Pokemon("Raichu", 1, statsRaichu, new Elemento[]{electrico}, new Ataque[]{latigo, placaje, rayo});
        Pokemon magnemite = new Pokemon("Magnemite", 1, statsMagnemite, new Elemento[]{electrico}, new Ataque[]{golpeCuerpo, placaje, chispazo});
        Pokemon voltorb = new Pokemon("Voltorb", 1, statsVoltorb, new Elemento[]{electrico}, new Ataque[]{placaje, golpeCuerpo, impactrueno});
        Pokemon electabuzz = new Pokemon("Electabuzz", 1, statsElectabuzz, new Elemento[]{electrico}, new Ataque[]{golpeCuerpo, latigo, rayo});
        Pokemon pidgey = new Pokemon("Pidgey", 1, statsPidgey, new Elemento[]{volador, normal}, new Ataque[]{placaje, golpeCuerpo, ataqueAla});
        Pokemon pidgeotto = new Pokemon("Pidgeotto", 1, statsPidgeotto, new Elemento[]{volador, normal}, new Ataque[]{latigo, placaje, picado});
        Pokemon pidgeot = new Pokemon("Pidgeot", 1, statsPidgeot, new Elemento[]{volador, normal}, new Ataque[]{golpeCuerpo, latigo, tornado});
        Pokemon zubat = new Pokemon("Zubat", 1, statsZubat, new Elemento[]{volador, normal}, new Ataque[]{placaje, golpeCuerpo, ataqueAla});
        Pokemon fearow = new Pokemon("Fearow", 1, statsFearow, new Elemento[]{volador, normal}, new Ataque[]{golpeCuerpo, placaje, picado});
        Pokemon snorlax = new Pokemon("Snorlax", 1, statsSnorlax, new Elemento[]{normal}, new Ataque[]{placaje, golpeCuerpo, latigo});
        Pokemon rattata = new Pokemon("Rattata", 1, statsRattata, new Elemento[]{normal}, new Ataque[]{latigo, placaje, placaje});
        Pokemon jigglypuff = new Pokemon("Jigglypuff", 1, statsJigglypuff, new Elemento[]{normal}, new Ataque[]{golpeCuerpo, latigo, placaje});
        Pokemon meowth = new Pokemon("Meowth", 1, statsMeowth, new Elemento[]{normal}, new Ataque[]{placaje, golpeCuerpo, latigo});
        Pokemon eevee = new Pokemon("Eevee", 1, statsEevee, new Elemento[]{normal}, new Ataque[]{golpeCuerpo, placaje, latigo});

        Pokemon[] pokemonesTemp = new Pokemon[] {
            charmander, charmeleon, charizard, vulpix, growlithe,
            squirtle, wartortle, blastoise, psyduck, lapras,
            bulbasaur, ivysaur, venusaur, oddish, bellsprout,
            pikachu, raichu, magnemite, voltorb, electabuzz,
            pidgey, pidgeotto, pidgeot, zubat, fearow,
            snorlax, rattata, jigglypuff, meowth, eevee
        };

        pokemones = pokemonesTemp;

        // Gimnasios
        Entrenador[] entrenadoresFacil = new Entrenador[] {
            new Entrenador("Ana", false, new Pokemon[] {pokemones[26], pokemones[20], pokemones[13]}),
            new Entrenador("Brock", false, new Pokemon[] {pokemones[23], pokemones[24], pokemones[25]})
        };
        Entrenador[] entrenadoresMedio = new Entrenador[] {
            new Entrenador("Luis", false, new Pokemon[] {pokemones[15], pokemones[16], pokemones[17]}),
            new Entrenador("Misty", false, new Pokemon[] {pokemones[18], pokemones[19], pokemones[22]})
        };
        Entrenador[] entrenadoresDificil = new Entrenador[] {
            new Entrenador("Carlos", false, new Pokemon[] {pokemones[3], pokemones[9], pokemones[29]}),
            new Entrenador("Giovanni", false, new Pokemon[] {pokemones[12], pokemones[7], pokemones[2]})
        };
        Gimnasio[] gimnasiosTemp = new Gimnasio[] {
            new Gimnasio("Gimnasio Normal", "Fácil", entrenadoresFacil),
            new Gimnasio("Gimnasio Eléctrico", "Medio", entrenadoresMedio), 
            new Gimnasio("Gimnasio del Team Rocket", "Difícil", entrenadoresDificil)
        };

        gimnasios = gimnasiosTemp;
    }

    private void mostrarPokemones() {
        System.out.println("-------- POKEMONES --------");
        for (Pokemon p : pokemones) {
            if (p == null) {
                continue; // Manejo de errores.
            }
            String elementos = null;
            for (Elemento e : p.getElementos()) {
                if (elementos == null) {
                    elementos = e.getNombre();
                } else {
                    elementos += " y " + e.getNombre();
                }
            }
            Stats s = p.getStats();
            System.out.printf("%s | Elementos: %s| HP:%d ATK:%d DEF:%d SPD:%d\n",
            p.getNombre(), elementos.trim(), s.getHp(), s.getAtk(), s.getDef(), s.getSpd());
        }
        System.out.println();
    }

    private void mostrarGimnasios() {
        System.out.println("-------- GIMNASIOS --------");
        for (int i = 0; i < gimnasios.length; i++) {
            Gimnasio g = gimnasios[i];
            System.out.printf("%d. %s - %s\n", i + 1, g.getNombre(), g.getDificultad());
            Entrenador[] entrenadores = g.getEntrenadores();
            for (int j = 0; j < entrenadores.length; j++) {
                if (j == entrenadores.length - 1) {
                    System.out.printf("Líder: %s\n", entrenadores[j].getNombre());
                    entrenadores[j].setLider();
                } else {
                    System.out.printf("Entrenador %d: %s\n", j + 1, entrenadores[j].getNombre());
                }
            }
            System.out.println();
        }
    }

    private void elegirPokemones() {
        mostrarPokemones();
        int contador = 0;
        while (contador != 3) {
            System.out.printf("Ingresa el nombre del pokémon que quieres en tu equipo (%d/3): ", contador + 1);
            String input = scanner.nextLine().trim();
            boolean encontrado = false;
            for (int i = 0; i < pokemones.length; i++) {
                if (pokemones[i].getNombre().equalsIgnoreCase(input)) {
                    pokemonesJugador[contador] = pokemones[i];
                    System.out.println(pokemones[i].getNombre() + " ha sido seleccionado.\n");

                    // Borra al pokemon seleccionado de la lista de pokemones disponibles.
                    Pokemon[] pokemonesTemp = new Pokemon[pokemones.length - 1];
                    int contador2 = 0;
                    for (int j = 0; j < pokemones.length; j++) {
                        if (j != i) {
                            pokemonesTemp[contador2++] = pokemones[j];
                        }
                    }
                    pokemones = pokemonesTemp;
                    encontrado = true;
                    contador++;
                    break;
                }
            }
            if (!encontrado) {
                    System.out.println("Pokémon no encontrado. Intenta de nuevo!\n");
                }
        }
    }

    private void elegirGimnasio() {
        mostrarGimnasios();
        int opcion = -1;
        while (opcion > 3 || opcion < 1) {
            try {
                opcion = Integer.parseInt(scanner.nextLine()) - 1;
                Gimnasio gimnasioTemp = gimnasios[opcion];
                Entrenador[] entrenadoresTemp = gimnasioTemp.getEntrenadores();
                for (int i = 0; i < entrenadoresTemp.length; i++) {
                    if (!entrenadoresTemp[i].isLider()) {
                        System.out.printf("Te enfrentas a %s!", entrenadoresTemp[i].getNombre());
                        iniciarCombate(jugador, entrenadoresTemp[i]);
                    } else if (i == entrenadoresTemp.length && entrenadoresTemp[i].isLider()) {
                        System.out.printf("Ahora te enfrentas al líder %s!", entrenadoresTemp[i].getNombre());
                        iniciarCombate(jugador, entrenadoresTemp[i]);
                    }
                }
            } catch (Exception error) {
                System.out.println("Opción no encontrada. Intenta de nuevo!\n");
            }
        }

    }

    // Combate WIP
    private void iniciarCombate(Entrenador jugador, Entrenador npc) {
        
    }
}
