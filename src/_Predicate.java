import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    // devuelven V o F
    // solo reciben 1 dato de entrada
    public static void main(String[] args) {
        //usar
        System.out.println("-1 es mayor?" +  esMayoracero.test(-1));

          System.out.println("10 es mayor?" +  esMayoracero.test(10) );

        System.out.println("tiene nombre y es mayor?" +
                esmayorEdadyIngresoNombre.test("ana",10) );

    }

    static Predicate<Integer> esMayoracero=
                (nro)-> nro>0;

    static BiPredicate<String, Integer> esmayorEdadyIngresoNombre
        =(nombre,edad)-> nombre.isEmpty() || edad>18;

}
