import java.util.Random;
import java.util.Scanner;

/**
 * La interfaz que ve el usuario
 * @author UY Scuti
 * @version 1.0
 */
public class Menu {
    private Scanner scanner;
    private Entrenador jugador;
    private Pokemon[] pokemones;
    private Pokemon[] pokemonesJugador;
    private Gimnasio[] gimnasios;

    /**
     * Constructor del menu
     */
    public Menu() {
        scanner = new Scanner(System.in);
        pokemones = new Pokemon[1];
        gimnasios = new Gimnasio[3];
        pokemonesJugador = new Pokemon[3];
    }

    /**
     * Da inicio al menu
     */
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
        jugador = new Entrenador(nombre, true, pokemonesJugador);
        System.out.println("Elige el gimnasio que quieres desafiar!");
        elegirGimnasio();
    }

    /**
     * Pide el nombre del usuario
     * @return Nombre que ingresó el usuario
     */
    private String pedirNombre() {
        System.out.println("Tu nombre es...");
        String nombreTemp = scanner.nextLine();
        return nombreTemp;
    }

    /**
     * Genera los datos: elementos, stats, ataques, pokemones, entrenadores y gimnasios
     */
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
        Pokemon charmander = new Pokemon("Charmander", 1, statsCharmander, new Elemento[]{fuego}, new Ataque[]{placaje, ascuas, giroFuego});
        Pokemon charmeleon = new Pokemon("Charmeleon", 1, statsCharmeleon, new Elemento[]{fuego}, new Ataque[]{golpeCuerpo, giroFuego, llamarada});
        Pokemon charizard = new Pokemon("Charizard", 1, statsCharizard, new Elemento[]{fuego, volador}, new Ataque[]{placaje, ascuas, llamarada});
        Pokemon vulpix = new Pokemon("Vulpix", 1, statsVulpix, new Elemento[]{fuego}, new Ataque[]{golpeCuerpo, ascuas, giroFuego});
        Pokemon growlithe = new Pokemon("Growlithe", 1, statsGrowlithe, new Elemento[]{fuego}, new Ataque[]{latigo, giroFuego, llamarada});

        Pokemon squirtle = new Pokemon("Squirtle", 1, statsSquirtle, new Elemento[]{agua}, new Ataque[]{placaje, pistolaAgua, surf});
        Pokemon wartortle = new Pokemon("Wartortle", 1, statsWartortle, new Elemento[]{agua}, new Ataque[]{golpeCuerpo, pistolaAgua, hidrobomba});
        Pokemon blastoise = new Pokemon("Blastoise", 1, statsBlastoise, new Elemento[]{agua}, new Ataque[]{latigo, surf, hidrobomba});
        Pokemon psyduck = new Pokemon("Psyduck", 1, statsPsyduck, new Elemento[]{agua}, new Ataque[]{placaje, pistolaAgua, surf});
        Pokemon lapras = new Pokemon("Lapras", 1, statsLapras, new Elemento[]{agua}, new Ataque[]{golpeCuerpo, surf, hidrobomba});

        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, statsBulbasaur, new Elemento[]{planta}, new Ataque[]{placaje, latigoCepa, hojaAfilada});
        Pokemon ivysaur = new Pokemon("Ivysaur", 1, statsIvysaur, new Elemento[]{planta}, new Ataque[]{golpeCuerpo, hojaAfilada, rayoSolar});
        Pokemon venusaur = new Pokemon("Venusaur", 1, statsVenusaur, new Elemento[]{planta}, new Ataque[]{latigo, hojaAfilada, rayoSolar});
        Pokemon oddish = new Pokemon("Oddish", 1, statsOddish, new Elemento[]{planta}, new Ataque[]{placaje, latigoCepa, hojaAfilada});
        Pokemon bellsprout = new Pokemon("Bellsprout", 1, statsBellsprout, new Elemento[]{planta}, new Ataque[]{golpeCuerpo, latigoCepa, rayoSolar});

        Pokemon pikachu = new Pokemon("Pikachu", 1, statsPikachu, new Elemento[]{electrico}, new Ataque[]{placaje, impactrueno, rayo});
        Pokemon raichu = new Pokemon("Raichu", 1, statsRaichu, new Elemento[]{electrico}, new Ataque[]{golpeCuerpo, chispazo, rayo});
        Pokemon magnemite = new Pokemon("Magnemite", 1, statsMagnemite, new Elemento[]{electrico}, new Ataque[]{latigo, chispazo, rayo});
        Pokemon voltorb = new Pokemon("Voltorb", 1, statsVoltorb, new Elemento[]{electrico}, new Ataque[]{placaje, impactrueno, chispazo});
        Pokemon electabuzz = new Pokemon("Electabuzz", 1, statsElectabuzz, new Elemento[]{electrico}, new Ataque[]{golpeCuerpo, impactrueno, rayo});

        Pokemon pidgey = new Pokemon("Pidgey", 1, statsPidgey, new Elemento[]{volador, normal}, new Ataque[]{placaje, ataqueAla, tornado});
        Pokemon pidgeotto = new Pokemon("Pidgeotto", 1, statsPidgeotto, new Elemento[]{volador, normal}, new Ataque[]{golpeCuerpo, ataqueAla, picado});
        Pokemon pidgeot = new Pokemon("Pidgeot", 1, statsPidgeot, new Elemento[]{volador, normal}, new Ataque[]{latigo, picado, tornado});
        Pokemon zubat = new Pokemon("Zubat", 1, statsZubat, new Elemento[]{volador, normal}, new Ataque[]{placaje, ataqueAla, picado});
        Pokemon fearow = new Pokemon("Fearow", 1, statsFearow, new Elemento[]{volador, normal}, new Ataque[]{golpeCuerpo, ataqueAla, tornado});

        Pokemon snorlax = new Pokemon("Snorlax", 1, statsSnorlax, new Elemento[]{normal}, new Ataque[]{golpeCuerpo, placaje, latigo});
        Pokemon rattata = new Pokemon("Rattata", 1, statsRattata, new Elemento[]{normal}, new Ataque[]{placaje, golpeCuerpo, latigo});
        Pokemon jigglypuff = new Pokemon("Jigglypuff", 1, statsJigglypuff, new Elemento[]{normal}, new Ataque[]{placaje, golpeCuerpo, latigo});
        Pokemon meowth = new Pokemon("Meowth", 1, statsMeowth, new Elemento[]{normal}, new Ataque[]{golpeCuerpo, placaje, latigo});
        Pokemon eevee = new Pokemon("Eevee", 1, statsEevee, new Elemento[]{normal}, new Ataque[]{placaje, golpeCuerpo, latigo});

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

    /**
     * Hace display de los datos de los pokemones que puede elegir el jugador
     */
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
            p.getNombre(), elementos, s.getHp(), s.getAtk(), s.getDef(), s.getSpd());
        }
        System.out.println();
    }

    /**
     * Hace display de los datos de los gimnasios que puede elegir el jugador
     */
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

    /**
     * Le pide al usuario que elija 3 pokemones iniciales
     */
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
    
    /**
     * Permite al jugador elegir un gimnasio y combate contra todos sus entrenadores
     * 
     */
    private void elegirGimnasio() {
        boolean continuar = true;
    
        while (continuar) {
            mostrarGimnasios();
            System.out.println("Selecciona un gimnasio para desafiar (1-3), o 0 para salir:");
            int opcion = -1;
    
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un número valido");
                continue;
            }
    
            if (opcion == 0) {
                System.out.println("¡Gracias por jugar!");
                continuar = false;
                break;
            }
    
            if (opcion < 1 || opcion > gimnasios.length) {
                System.out.println("Opcion invalida. Intenta nuevamente");
                continue;
            }
    
            Gimnasio gimnasioTemp = gimnasios[opcion - 1];
            System.out.printf("\nDesafias al %s (%s)\n", gimnasioTemp.getNombre(), gimnasioTemp.getDificultad());
    
            Entrenador[] entrenadoresTemp = gimnasioTemp.getEntrenadores();
    
            boolean victoriaGimnasio = true;
    
            for (int i = 0; i < entrenadoresTemp.length; i++) {
                Entrenador rival = entrenadoresTemp[i];
                String tipo = rival.isLider() ? "Lider" : "Entrenador";
                System.out.printf("\nTe enfrentas al %s %s\n", tipo, rival.getNombre());
    
                // Reinicia HP y estado de todos los pokemones de ambos antes del combate
                restaurarEquipo(jugador);
                restaurarEquipo(rival);
    
                Combate combate = new Combate(jugador, rival, scanner);
                combate.iniciarCombate();
    
                // Si el jugador perdió, termina el gimnasio
                if (!tienePokemonesVivos(jugador)) {
                    System.out.println("\nHas perdido el desafio del gimnasio :c");
                    victoriaGimnasio = false;
                    break;
                }
    
                // Si ganó y aún hay entrenadores por vencer
                if (i < entrenadoresTemp.length - 1) {
                    System.out.println("\n¡Has vencido! Preparate para el siguiente combate c:");
                } else {
                    System.out.printf("\n¡Has vencido al lider %s y ganado el %s!\n",
                            rival.getNombre(), gimnasioTemp.getNombre());
                }
            }
    
            // Si el jugador ganó todo el gimnasio
            if (victoriaGimnasio) {
                System.out.println("\n¡Felicidades! Has conquistado este gimnasio.\n");
            }
    
            // Preguntar si desea continuar con otro gimnasio
            System.out.println("¿Deseas desafiar otro gimnasio? (s/n)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
                System.out.println("\n¡Gracias por jugar Pokemon Java Edition! (como el minecraft pero con Pokemon)");
            }
        }
    }
    
    /**
     * Restaura el HP y el estado de todos los pokemones de un entrenador
     * Se usa entre combates dentro del mismo gimnasio
     */
    private void restaurarEquipo(Entrenador entrenador) {
        for (Pokemon p : entrenador.getPokemones()) {
            if (p != null) {
                Stats s = p.getStats();
                // restaurar HP base
                s.setHp(100);
                p.setDebilitado(false);
                for (Ataque a : p.getAtaques()) {
                a.restaurarPP(); //restaura PP
                }
            }
        }
    }
    
    /**
     * Verifica si el entrenador tiene al menos un pokemon vivo
     */
    private boolean tienePokemonesVivos(Entrenador e) {
        for (Pokemon p : e.getPokemones()) {
            if (!p.isDebilitado()) return true;
        }
        return false;
    }

    /**
     * Hace que el NPC (rival) elija un pokemon aleatorio entre los que tiene
     * Este pokemon no puede estar debilitado
     * Es el parametro de pokemonActivo() del NPC
     * @param npc El entrenador NPC
     */
    private void pokemonActivoNpc(Entrenador npc) {
        Random random = new Random();
        Pokemon[] equipo = npc.getPokemones();
    
        // Verificar si tiene alguno disponible
        boolean tieneVivo = false;
        for (Pokemon p : equipo) {
            if (!p.isDebilitado()) {
                tieneVivo = true;
                break;
            }
        }
    
        if (!tieneVivo) {
            System.out.println(npc.getNombre() + " no tiene mas Pokemones disponibles.");
            return;
        }
    
        // Elegir un Pokémon no debilitado al azar
        Pokemon pokemonNpc;
        do {
            int indice = random.nextInt(equipo.length);
            pokemonNpc = equipo[indice];
        } while (pokemonNpc.isDebilitado());
    
        npc.setPokemonActivo(pokemonNpc);
        System.out.println("\n" + npc.getNombre() + " elije " + npc.getPokemonActivo().getNombre() + "!");
    }


    /**
     * Asigna el pokemon activo del jugador
     * Permite al jugador elegir entre sus 3 pokemones
     * El pokemon elegido no puede estar debilitado
     * @param jugador El entrenador jugador
     */
    private void pokemonActivoJugador(Entrenador jugador) {
        System.out.println("\nElije tu siguiente pokemon (1, 2, 3)");
        Pokemon[] equipo = jugador.getPokemones();
        for (int i = 0; i < equipo.length; i++) {
            System.out.printf("%d. %s\n", i + 1, equipo[i].getNombre());
        }
        int opcion = -1;
        while (opcion < 1 || opcion > 3) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                Pokemon elegido = equipo[opcion - 1];
                if (elegido.isDebilitado()) { // verifica si esta debilitado
                    System.out.printf("%s esta debilitado.\n", elegido.getNombre());
                    opcion = -1; // volver a pedir
                } else {
                    jugador.setPokemonActivo(elegido);
                    System.out.printf("%s: %s yo te elijo!\n", jugador.getNombre(), elegido.getNombre());
                }
            } catch (Exception e) {
                System.out.println("Ingrese un numero (1, 2, 3)");
            }
        }
    }

    /**
     * Muestra las estadisticas del pokemon activo de un entrenador
     * @param entrenador El entrenador del que queremos ver el pokemon
     */
    private void mostrarStats(Entrenador entrenador) {
        Pokemon activo = entrenador.getPokemonActivo();
        if (activo != null) {
            Stats s = activo.getStats();
            System.out.printf("\n%s | HP:%d ATK:%d DEF:%d SPD:%d\n",
            activo.getNombre(), s.getHp(), s.getAtk(), s.getDef(), s.getSpd());
        } else {
            System.out.println(entrenador.getNombre() + " no tiene un pokemon activo.");
        }
    }

    /**
     * Asigna el ataque a usar del pokemon del jugador
     * El usuario puede elegir el ataque que quiere usar
     * Valida que el ataque tenga PP disponibles
     * @param pokemon
     * @param npc
     */
    private void elegirAtaque(Pokemon pokemon, Entrenador npc) {
        System.out.println("Ataques disponibles: ");
        Ataque[] ataques = pokemon.getAtaques();

        for (int i = 0; i < ataques.length; i++) {
            Ataque a = ataques[i];
            System.out.printf("%d. %s | Elemento: %s | Potencia: %d | PPMax: %d | Precisión: %d\n",
                    i + 1, a.getNombre(), a.getElemento().getNombre(), a.getPotencia(), a.getPPMax(), a.getPrecision());
        }

        System.out.println("Elije un ataque para usar contra " + npc.getPokemonActivo().getNombre() + "! (1, 2, 3): ");
        int opcion = -1;

        while (opcion < 1 || opcion > ataques.length) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                Ataque ataqueElegido = ataques[opcion - 1];

                if (ataqueElegido.getPPMax() > 0) {
                    pokemon.setAtaqueActivo(ataqueElegido);
                    System.out.println("Has elegido " + ataqueElegido.getNombre() + "!");
                } else {
                    System.out.println(pokemon.getNombre()+" no tiene PP sufientes para usar " + ataqueElegido.getNombre()+".");
                    opcion = -1; // volver a pedir
                }
            } catch (Exception e) {
                System.out.println("Escribe el número que corresponda al ataque (1, 2, 3): ");
            }
        }
    }

    /**
     * Inicia el combate entre el jugador y el NPC
     * Integra la logica completa del sistema de combate
     * @param jugador Entrenador jugador
     * @param npc Entrenador NPC
     */
    private void iniciarCombate(Entrenador jugador, Entrenador npc) {
        pokemonActivoJugador(jugador);
        pokemonActivoNpc(npc);
        mostrarStats(jugador);
    
        //Aqui inicia Combate para eleigr ataques, etc
        Combate combate = new Combate(jugador, npc, scanner);
        combate.iniciarCombate();
    }

}
