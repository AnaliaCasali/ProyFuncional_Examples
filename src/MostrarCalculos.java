public class MostrarCalculos implements Calculadora {
    @Override
    public void Calcular(int nro1, int nro2) {
        int resultado=nro1+nro2;
        System.out.println("suma "+ resultado);
    }
}
