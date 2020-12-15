package pack;

import java.util.ArrayList;

public class Alumno extends Persona {
	private String IDAlumno;
	private ArrayList<Asignatura> Asignaturas;
	
	public ArrayList<Asignatura> getAsignaturas() {
		return Asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		Asignaturas = asignaturas;
	}

	public String getIDAlumno() {
		return IDAlumno;
	}

	public void setIDAlumno(String iDAlumno) {
		IDAlumno = iDAlumno;
	}

	public Alumno(String nombre, String NIF, String IDAlumno) {
		super(nombre, NIF);
		this.IDAlumno = IDAlumno;
		this.Asignaturas = new ArrayList<Asignatura>();
	}
	
	public void addAsigantura(Asignatura asignatura1) {
		getAsignaturas().add(asignatura1);
	}
	
}
