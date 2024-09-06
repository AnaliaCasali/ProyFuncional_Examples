import entities.Persona;

import java.util.function.Function;

public interface PersonaValidator extends Function<Persona, Resultado> {

    static PersonaValidator EsNombreValido(){
        return  (p) -> p.getNombre().isEmpty()? Resultado.NOMBRE_VACIO : Resultado.OK;
    }

    static PersonaValidator EsApellidoValido (){
         return (p)-> p.getApellido().isEmpty()? Resultado.APELLIDO_VACIO : Resultado.OK;
    }

    static PersonaValidator EsMayorEdad(){
        return (p)-> p.getEdad()>18 ? Resultado.OK : Resultado.ES_MENOR_EDAD;
    }

    default  PersonaValidator and(PersonaValidator otro){
        return  persona -> {
                Resultado resultado= this.apply(persona);
                return  resultado.equals(Resultado.OK) ?
                            otro.apply(persona)
                             : resultado;   };
    }

}


enum Resultado{
    OK,NOMBRE_VACIO, APELLIDO_VACIO, ES_MENOR_EDAD;
}