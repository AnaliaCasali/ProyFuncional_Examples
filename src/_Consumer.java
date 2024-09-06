import java.util.function.Consumer;

public class _Consumer {


    public static void main(String[] args) {
            // usar
        mostrarMensaje.accept("esto es un Consumer");
        mostrarEdad.accept(5);

        //mostrarEdad.andThen(mostrarMensaje("err")).accept(5);

    }

    //  recibe un argumento y no devuelve nada
    // solo hace algo
    static Consumer<String> mostrarMensaje=
            (str)-> System.out.println("El mensaje es " + str);

    static Consumer<Integer> mostrarEdad=
            (nro)-> System.out.println("La edad es " + nro);


}