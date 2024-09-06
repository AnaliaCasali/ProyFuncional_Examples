import entities.Persona;
import enums.Genero;

public class _CombinatorPattern {


    public static void main(String[] args) {


        Persona  p =  new Persona("Juan", "Jose", 17, Genero.Masculino);


        Resultado resultado=  PersonaValidator.EsNombreValido()
                                .and(PersonaValidator.EsApellidoValido())
                                .and(PersonaValidator.EsMayorEdad())
                                .apply(p);

        System.out.println(resultado);
    }
}
