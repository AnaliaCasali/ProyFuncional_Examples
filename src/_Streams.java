import entities.Persona;
import enums.Genero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class _Streams {

    /* FUNCTION <T, R> recibe un parametro y devuelve un parametro R
                // para usar:.apply
    * BIFUNCTION<T,V,R> recibe 2 parametros y devuelve un parametro R
                // para usar:.apply
    * PREDICATE<T> recibe un parametro solo devuelve Verdadero o Falso
                // para usar:.test
    * CONSUMER<T>  recibe un parametro NO devuelve nada (void) .accept
    * SUPPLIER<R> solo devuelve
                // para usar: .get
     * */

    public static void main(String[] args) {

        List<Persona> personas= new ArrayList<>();
       personas.add(new Persona("Juan", "Martinez", 20, Genero.Masculino));
       personas.add(new Persona("Maria", "Gonzalez", 20, Genero.Femenino) );
       personas.add(new Persona("Rosa", "Perez", 24, Genero.Femenino));
       personas.add(new Persona("Azul", "Cierlo", 25, Genero.Femenino));
       personas.add(new Persona("Pedro", "Gutierrez", 23,Genero.Masculino ));
               // forma imperativa
        for(Persona p : personas ){
            System.out.println( p.toString());
        }

        // forma declarativa
        Consumer<Persona> imprimirPersona  = (p)-> System.out.println(p.toString());
        personas.stream().forEach( imprimirPersona); // foreach espera un consumer
                //(p)-> System.out.println(p.toString())

        System.out.println("Personas mayores de 20");

        Predicate<Persona> sonMayoresa20=(p)-> p.getEdad()>20;
        Predicate<Persona> sonMenoresa20=(p)-> p.getEdad()<20;

        List<Persona> mayores20= personas.stream()
                 .filter(sonMayoresa20)
                 .collect(Collectors.toList()); // guarda en una lista nueva

        personas.stream()
                .filter(sonMayoresa20)  // filter espera un predicate
                .forEach(imprimirPersona); // imprime

        //mayores20.stream().forEach( imprimirPersona);


        //lista de solo los nombres y apellidos de las personas
        System.out.println("lista de solo los nombres y apellidos de las personas\n");

        Function<Persona, String> getNombreCompleto=
                (persona)-> persona.getNombre() + " " + persona.getApellido();

        List<String> nombresCompletos=
        personas.stream()
                .map(getNombreCompleto)
                .collect(Collectors.toList());

        nombresCompletos.stream().forEach(System.out::println);


    // hace transformaciones espera un FUNCTION
        System.out.println("Lista de solo mujeres");

        Predicate<Persona> esMujer=(p)-> p.getGenero().equals(Genero.Femenino);
        personas.stream()
                .filter(esMujer)
                .forEach(System.out::println);

        // ordenar uso sorted(Comparator.comparing(FUNCTION))
        // Reversed agrego  para ordenar descendente

        System.out.println("Ordenando por edad:");
        personas.stream()
                .sorted(Comparator.comparing(ordenarPorGenero).reversed()
                        .thenComparing(Comparator.comparing(ordenarPorEdad)))
                .forEach(imprimirPersona);


        // allmatch
        System.out.println("Son todos mayores a veinte: "+  personas.stream()
                .allMatch(sonMayoresa20));
        System.out.println("Son todos menores a veinte: "+  personas.stream()
                .allMatch(sonMenoresa20));
        // anyMatch

        System.out.println("hay algun mayor a veinte: "+  personas.stream()
                .anyMatch(sonMayoresa20));

        System.out.println("hay algun menor a veinte: "+  personas.stream()
                .anyMatch(sonMenoresa20));

        // noneMatch ninguno
        System.out.println("ninguno menor a veinte: "+  personas.stream()
                .noneMatch(sonMenoresa20));

        System.out.println("Algun nombre comienza con Az: "+
        personas.stream()
                .anyMatch((p)-> p.getNombre().contains("Az")));


        // MAPS  <Persona, Genero>
        Map<Genero, List<Persona>> agrupacionPorGenero=
                personas.stream()
                        .collect(Collectors.groupingBy(ordenarPorGenero));

        BiConsumer <Genero, List<Persona>> mostrarMapa=
                (genero,listapersonas) ->
                   {System.out.println(genero);
                    listapersonas.stream().forEach(System.out::println); };

        agrupacionPorGenero.forEach(mostrarMapa);


        // MAX
        System.out.println("La persona de mayor edad");
        System.out.println(personas.stream()
                .max(Comparator.comparing(ordenarPorEdad)));

        // MIN
        System.out.println("La persona de menor edad");
        personas.stream()
                .min(Comparator.comparing(ordenarPorEdad))
                .ifPresent(imprimirPersona);


    }

    static Function<Persona, Integer> ordenarPorEdad= (p)-> p.getEdad();
    static Function<Persona, Genero> ordenarPorGenero= (p)-> p.getGenero();


}
