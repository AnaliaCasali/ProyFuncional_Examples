import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {



    public static void main(String[] args) {
      // para usar los function
        System.out.println( calcular.apply(8));
        System.out.println( calcularBifunction.apply(8,8));

    }

    // function (recibe y devuelve)
    //T - tipo entrada function
    //R - tipo salida function
    static Function<Integer, String> calcular
                 = (nro1)-> "El nro ingresado es" + nro1;
 // 3 tipos genericos , dos primeros de entrada el ult de resultado
    static BiFunction<Integer, Integer, String>
                calcularBifunction = (nro1,nro2)->
                "La suma de los numeros es" +  (nro1+nro2);



}




