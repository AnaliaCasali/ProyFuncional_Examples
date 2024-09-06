public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");

            // forma imperativa (normal)
        //    calcular(5,7 );

          MostrarCalculos m =new MostrarCalculos() ;
//          m.Calcular(1,5);

          // forma declarativa
        Calculadora c;

        c= ( nro1 , nro2) -> {
            int resultado=nro1+nro2;
            System.out.println("suma funcional " + resultado);
        };

        c.Calcular(6,6);

        c= ( nro1 , nro2) -> {
            int resultado=nro1*nro2;
            System.out.println("mulpiplicar funcional " + resultado);
        };

        c.Calcular(6,6);

        Mensajes mensaje;
        mensaje= ()->"Esto es interfaz funcional mensaje";

        mensaje.MostrarMensaje();


    }



    public static void calcular(int a, int b){
        int resultado= a+b;
        System.out.println( "La suma es"+resultado );
    }
    public static void multiplicar(int a, int b){
        int resultado= a*b;
        System.out.println( "La multiplicacion es"+resultado );
    }

}