package entities;
import enums.Genero;
import java.util.Optional;

public class Persona {

	String nombre;
	Optional <String> apellido;
	int edad;
	Genero genero;

	public Persona(String nombre, String apellido, int edad, Genero genero) {
		super();
		this.nombre = nombre;
		this.apellido = Optional.ofNullable(apellido);
		this.edad = edad;
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido.orElse("Apellido No Especificado");
	}
	public void setApellido(String apellido) {
		this.apellido = Optional.ofNullable(apellido);
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + "]";
	}
	
	
}
 