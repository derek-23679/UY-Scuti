import java.util.Random;
import java.util.Scanner;

/**
 * Controla la loogica del combate entre dos entrenadores
 * Gestiona turnos, danio, ataques, debilitaciones y ganador final
 * @author UY Scuti
 * @version 1.1
 */
public class Combate {
    private Entrenador jugador;
    private Entrenador enemigo;
    private Random random;
    private Scanner scanner;

    /**
     * Constructor del combate
     * @param jugador Entrenador jugador
     * @param enemigo Entrenador enemigo (NPC)
     * @param scanner Para leer las opciones del usuario
     */
    public Combate(Entrenador jugador, Entrenador enemigo, Scanner scanner) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.random = new Random();
        this.scanner = scanner;
    }

    /**
     * inicia el combate entre el jugador y el enemigo
     */
    public void iniciarCombate() {
        System.out.printf("\n¡Comienza el combate entre %s y %s!\n",
                jugador.getNombre(), enemigo.getNombre());

        while (tienePokemonesVivos(jugador) && tienePokemonesVivos(enemigo)) {
            if (jugador.getPokemonActivo() == null || jugador.getPokemonActivo().isDebilitado()) {
                cambiarPokemon(jugador);
            }
            if (enemigo.getPokemonActivo() == null || enemigo.getPokemonActivo().isDebilitado()) {
                cambiarPokemon(enemigo);
            }

            realizarTurno();
        }

        if (tienePokemonesVivos(jugador)) {
            System.out.printf("\n¡%s ha ganado el combate! c:\n", jugador.getNombre());
        } else {
            System.out.printf("\n%s ha perdido el combate :c\n", jugador.getNombre());
        }
    }

    /**
     * Ejecuta un turno de combate donde ambos atacan segun su velocidad
     */
    private void realizarTurno() {
        Pokemon p1 = jugador.getPokemonActivo();
        Pokemon p2 = enemigo.getPokemonActivo();

        if (p1 == null || p2 == null) return;

        Ataque a1 = elegirAtaqueJugador(p1, p2);
        Ataque a2 = enemigoEligeAtaque(p2);

        System.out.printf("\n%s usa %s!\n", p1.getNombre(), a1.getNombre());

        boolean p1Primero = p1.getStats().getSpd() >= p2.getStats().getSpd();

        if (p1Primero) {
            atacar(p1, p2, a1);
            if (!p2.isDebilitado()) {
                atacar(p2, p1, a2);
            }
        } else {
            atacar(p2, p1, a2);
            if (!p1.isDebilitado()) {
                atacar(p1, p2, a1);
            }
        }
    }

    /**
     * Permite al jugador elegir un ataque
     */
    private Ataque elegirAtaqueJugador(Pokemon atacante, Pokemon objetivo) {
        Ataque[] ataques = atacante.getAtaques();
        System.out.println("\nElige un ataque para " + atacante.getNombre() + ":");
        for (int i = 0; i < ataques.length; i++) {
            Ataque a = ataques[i];
            System.out.printf("%d. %s | Potencia: %d | Precision: %d\n", i + 1, a.getNombre(), a.getPotencia(), a.getPrecision());
        }

        int opcion = -1;
        while (opcion < 1 || opcion > ataques.length) {
            try {
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Por favor, ingresa un numero valido.");
            }
        }

        Ataque elegido = ataques[opcion - 1];
        atacante.setAtaqueActivo(elegido);
        return elegido;
    }

    /**
     * Realiza el ataque de un Pokemon a otro y calcula el danio
     */
    private void atacar(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        if (random.nextInt(100) >= ataque.getPrecision()) {
            System.out.println("El ataque falló!");
            return;
        }

        int nivel = atacante.getNivel();
        int atk = atacante.getStats().getAtk();
        int def = defensor.getStats().getDef();
        int base = ataque.getPotencia();

        double daño = (((2 * nivel / 5.0 + 2) * base * atk / def) / 50) + 2;

        for (Elemento e : atacante.getElementos()) {
            if (e.getNombre().equalsIgnoreCase(ataque.getElemento().getNombre())) {
                daño *= 1.5;
            }
        }

        daño *= (0.85 + (random.nextDouble() * 0.15));

        int hpRestante = defensor.getStats().getHp() - (int) daño;
        defensor.getStats().setHp(Math.max(0, hpRestante));

        System.out.printf("%s recibe %.0f de daño. (HP restante: %d)\n",
                defensor.getNombre(), daño, defensor.getStats().getHp());

        if (defensor.getStats().getHp() <= 0) {
            System.out.printf("%s se ha debilitado!\n", defensor.getNombre());
            defensor.setDebilitado(true);
        }
    }

    private boolean tienePokemonesVivos(Entrenador e) {
        for (Pokemon p : e.getPokemones()) {
            if (!p.isDebilitado()) return true;
        }
        return false;
    }

    private void cambiarPokemon(Entrenador e) {
        for (Pokemon p : e.getPokemones()) {
            if (!p.isDebilitado()) {
                e.setPokemonActivo(p);
                System.out.printf("%s envía a %s al combate!\n", e.getNombre(), p.getNombre());
                return;
            }
        }
    }

    private Ataque enemigoEligeAtaque(Pokemon enemigo) {
        Ataque[] ataques = enemigo.getAtaques();
        return ataques[random.nextInt(ataques.length)];
    }
}
