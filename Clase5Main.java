package tareita5;

import java.util.Scanner;

public class Clase5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Introduce el nombre del primer jugador: ");
        String primerNombreUsu = sc.nextLine();
        boolean usuEntrada = true;
        while (usuEntrada) {
            if (primerNombreUsu.equals(" ") || primerNombreUsu.equals("  ") || primerNombreUsu.equals("   ") || primerNombreUsu.length() <= 2)
                System.out.println("ERROR. tu usuario no puede ser un nombre vacio y no puede tener menos de  3 letras");

            else
                usuEntrada = false;
        }
        Usuarios usu1 = new Usuarios(primerNombreUsu);


        System.out.println("\nAhora el segundo:");
        String segundoNombreUsu = sc.nextLine();
        boolean usuEntrada2 = true;
        while (usuEntrada2) {
            if (segundoNombreUsu.equals(" ") || segundoNombreUsu.equals("  ") || segundoNombreUsu.equals("   ") || segundoNombreUsu.length() <= 2)
                System.out.println("ERROR. tu usuario no puede ser un nombre vacio y no puede tener menos de  3 letras");

            else
                usuEntrada2 = false;
        }
        Usuarios usu2 = new Usuarios(segundoNombreUsu);

        while (usu1.getPuntos() < 5 && usu2.getPuntos() < 5) {

            System.out.println("\n turno de " + usu1.getNombre() + ". introduce la palabra:");
            boolean entradaPalabra = true;
            String palabraUsuario = "";
            while (entradaPalabra) {
                //hay que repetir la palabra dos veces porque hay que limpiar el sc al repetir el bucle
                sc.nextLine();
                palabraUsuario = sc.nextLine();
                if (palabraUsuario == " " || palabraUsuario.length() <= 2 || palabraUsuario == "  " || palabraUsuario == "   ")
                    System.out.println("Error. La palabra no puede ser vacia ni tener menos de 3 letras");

                else
                    entradaPalabra = false;

            }
            usu1.introducirPalabra(palabraUsuario);

            System.out.println("El tamaño de la palabra es: " + usu1.saber());

            boolean entrada1 = true;

            while (entrada1 == true) {
                if (usu1.juego().equals("partida")) {
                    if (usu2.getVidas() > 0) {
                        System.out.println("\nturno de " + usu2.getNombre() + ". adivina la letra:");

                        char letraUsuario = sc.next().charAt(0);

                        System.out.println(usu2.adivinarPalabra(letraUsuario));
                    }
                } else if (usu2.juego().equals("victoria")) {
                    System.out.println("Palabra adivinada. Jugador " + usu2.getNombre() + " gana un punto");
                    usu2.setPuntos(usu2.getPuntos() + 1);
                    entrada1 = false;
                } else if (usu2.juego().equals("derrota")) {
                    System.out.println("Palabra no adivinada. Jugador " + usu1.getNombre() + " gana un punto");
                    usu1.setPuntos(usu1.getPuntos() + 1);
                    entrada1 = false;
                }

            }
        }


        System.out.println("\n turno de jugador " + usu2.getNombre() + ". introduce la palabra:");
        boolean entradaPalabra2 = true;
        String palabraUsuario2 = "";
        while (entradaPalabra2) {
            sc.nextLine();
            palabraUsuario2 = sc.nextLine();
            if (palabraUsuario2 == " " || palabraUsuario2.length() <= 2 || palabraUsuario2 == "  " || palabraUsuario2 == "   ")
                System.out.println("Error. La palabra no puede ser vacia ni tener menos de 3 letras");

            else
                entradaPalabra2 = false;
        }
        usu2.introducirPalabra(palabraUsuario2);

        System.out.println("El tamaño de la palabra es: " + usu2.saber());

        boolean entrada2 = true;

        while (entrada2 == true) {
            if (usu2.juego().equals("partida")) {
                if (usu1.getVidas() > 0) {
                    System.out.println("\nturno de " + usu1.getNombre() + ". adivina la letra:");

                    char letraUsuario = sc.next().charAt(0);

                    System.out.println(usu1.adivinarPalabra(letraUsuario));
                }
            } else if (usu1.juego().equals("victoria")) {
                System.out.println("Palabra adivinada. Jugador " + usu1.getNombre() + " gana un punto");
                usu1.setPuntos(usu1.getPuntos() + 1);
                entrada2 = false;
            } else if (usu1.juego().equals("derrota")) {
                System.out.println("Palabra no adivinada. Jugador " + usu2.getNombre() + " gana un punto");
                usu2.setPuntos(usu2.getPuntos() + 1);
                entrada2 = false;
            }

        }


        if (usu1.ganador(usu1, usu2) == 1)
            System.out.println("Juego terminado... " + "GANADOR: " + usu1.getNombre());

        else
            System.out.println("Juego terminado... " + "GANADOR: " + usu2.getNombre());

    }
}
