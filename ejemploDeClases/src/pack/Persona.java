package pack;

import java.util.ArrayList;

public class Persona {
	
	private String nombre;
	private ArrayList<Asignatura> asignaturas;
	private String NIF;
	
	public Persona(String nombre, String NIF) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.NIF = NIF;
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Asignatura> getAsignatura() {
		return asignaturas;
	}

	public void setAsignatura(ArrayList<Asignatura> asignatura) {
		this.asignaturas = asignatura;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

}
