import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {
        String mensaje= "Hola Mundo";

        Optional<String> msg= Optional.ofNullable(mensaje);

        Optional<String> msgNull= Optional.ofNullable(null);


        System.out.println( msg.isEmpty());

        System.out.println( msgNull.isEmpty());


        msg.ifPresentOrElse(
                (p)-> System.out.println(p),
                ()-> System.out.println("no especificado")
        );

        msgNull.ifPresentOrElse(
                (p)-> System.out.println(p),
                ()-> System.out.println("no especificado")
        );

    }

}
