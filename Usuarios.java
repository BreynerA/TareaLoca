package tareita5;

import java.util.Arrays;

public class Usuarios {
    private String nombre;
    private int puntos;
    private static int vidas;
    private static char[] palabraAdivina;
    private static String mandar;
    private static char[] mandarPasos;

    public Usuarios(String nombre) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.vidas = 5;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void introducirPalabra(String palabra) {
        vidas = 5;
        int tamanio = palabra.length();
        palabraAdivina = new char[tamanio];
        mandarPasos = new char[tamanio];
        int posicion = 0;

        for (char p : palabra.toCharArray()) {
            palabraAdivina[posicion] = p;
            mandarPasos[posicion] = '■';
            posicion++;
        }


    }

    public String adivinarPalabra(char letra) {

        for (int i = 0; i < palabraAdivina.length; i++) {
            if (palabraAdivina[i] == letra) {
                mandarPasos[i] = letra;
            }
        }

        if (saberSiEsta(letra) == false) {
            this.vidas--;
            dibujo();
            return "Fallaste. Este es tu progreso :" + Arrays.toString(mandarPasos);
        } else {
            dibujo();
            return "Adivinaste. Este es tu progreso: " + Arrays.toString(mandarPasos);
        }
    }

    public String saber() {
        this.mandar = "";
        int posicion = 0;
        while (posicion < palabraAdivina.length) {
            this.mandar += "■";
            posicion++;
        }
        return mandar;
    }

    public String juego() {
        if (compararArrays() == true) {
            return "victoria";
        } else if (palabraAdivina != mandarPasos && vidas != 0) {
            return "partida";
        } else if (palabraAdivina != mandarPasos && vidas == 0)
            return "derrota";
        else
            return "";
    }

    public boolean compararArrays() {
        int posicion = 0;
        int total = 0;
        while (posicion < palabraAdivina.length) {
            if (palabraAdivina[posicion] == mandarPasos[posicion]) {
                total++;
            }
            posicion++;
        }

        if (total == palabraAdivina.length)
            return true;

        else
            return false;
    }

    public boolean saberSiEsta(char letra) {
        for (int i = 0; i < palabraAdivina.length; i++) {
            if (palabraAdivina[i] == letra)
                return true;
        }
        return false;
    }

    public int ganador(Usuarios usu1, Usuarios usu2) {
        if (usu1.getPuntos() > usu2.getPuntos())
            return 1;
        else
            return 2;
    }

    public void dibujo() {
        if (this.vidas == 5) {
            System.out.println("""
                                   ___
                                  |   |
                                  O   |
                                      |
                                      |
                                ______|
                    """);
        } else if (this.vidas == 4) {
            System.out.println("""
                                   ___
                                  |   |
                                  O/  |
                                      |
                                      |
                                ______|
                    """);
        } else if (this.vidas == 3) {
            System.out.println("""
                                   ___
                                  |   |
                                 _O/  |
                                      |
                                      |
                                ______|
                    """);
        } else if (this.vidas == 2) {
            System.out.println("""
                                   ___
                                  |   |
                                 _O/  |
                                  |   |
                                      |
                                ______|
                    """);
        } else if (this.vidas == 1) {
            System.out.println("""
                                   ___
                                  |   |
                                 _O/  |
                                  |   |
                                   \\  |
                                ______|
                    """);
        } else if (this.vidas == 0) {
            System.out.println("""
                                   ___
                                  |   |
                                 _O/  |
                                  |   |
                                  /\\  |
                                ______|
                    """);
        }

    }

}
