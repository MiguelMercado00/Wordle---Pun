import java.util.Scanner;

public class JuegoDePalabras {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] palabrasAdivinar = {"CARRO", "COMER", "NADAR", "LUCES", "CASAS", "CERDO", "CRUDO", "ERROR", "FINCA", "HIELO", "PERRO", "RELOJ", "REMAR", "ZORRO", "RELOJ"};
        int random = (int) (Math.random() * palabrasAdivinar.length);
        String correcta = palabrasAdivinar[random];
        int n = correcta.length();
        char[] intento = new char[n];
        int intentosRestantes = 6;
        System.out.print("¿Quieres jugar el juego? (si/no): ");
        String respuesta = input.nextLine();

        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("¡Adiós!");
            return;
        } else if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("¡Bienvenido a Wordle!");

        } else if (!respuesta.equalsIgnoreCase("si")) {
            System.out.println("Respuesta no válida. ¡Adiós!");
            return;
        }

            for (intentosRestantes = 6; intentosRestantes > 0; intentosRestantes--) {
                System.out.println("Intentos restantes: " + intentosRestantes);
                System.out.print("Ingresa tu intento de " + n + " letras: ");
                String intentoStr = input.nextLine();

                // Si el intento excede el número de caracteres de la palabra, no se cuenta como intento
                if (intentoStr.length() > n) {
                    System.out.println("Tu intento excede el número de caracteres de la palabra a adivinar.");
                    intentosRestantes++;
                    continue;
                }
                // Si el intento no tiene el número de caracteres suficientes, no se cuenta como intento
                if (intentoStr.length() < n) {
                    System.out.println("Tu intento no tiene el número de caracteres suficientes de la palabra a adivinar.");
                    intentosRestantes++;
                    continue;
                }

                intento = intentoStr.toCharArray();
                int letrasCorrectas = 0;
                boolean[] letrasAdivinadas = new boolean[n];
                boolean[] letrasMedioCorrectas = new boolean[n];

                for (int i = 0; i < n; i++) {
                    if (intento[i] == correcta.charAt(i)) {
                        letrasCorrectas++;
                        letrasAdivinadas[i] = true;
                    }
                }

                System.out.print("Tu intento: ");
                for (int i = 0; i < n; i++) {
                    if (letrasAdivinadas[i]) {
                        // Si la letra está en la posición correcta, se marca con color verde
                        System.out.print("\033[32m" + intento[i] + " " + "\033[0m");
                    } else if (correcta.indexOf(intento[i]) != -1 && !letrasAdivinadas[correcta.indexOf(intento[i])]) {
                        // Si la letra está en la palabra, pero no en la posición correcta y no ha sido adivinada aún, se marca con color amarillo
                        System.out.print("\033[33m" + intento[i] + " " + "\033[0m");
                        letrasMedioCorrectas[i] = true;
                    } else {
                        System.out.print(intento[i] + " ");
                    }
                }
                System.out.println();

                if (letrasCorrectas == n) {
                    System.out.println("¡Felicidades, has adivinado la palabra!");
                    return;
                }
                if (letrasCorrectas != n && intentosRestantes == 1) {
                    System.out.println("No pudiste encontrar la palabra que era: " + correcta);
                }
            }
        }
    }


//Creado por Miguel Mercado, Juan Jose Botero y Thomas Osorio




