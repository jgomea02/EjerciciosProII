package pack;

public class Profesor extends Persona{
	private int NAlumnos;
	
	public Profesor(String Nombre, String NIF, int nAlumnos) {
		super(Nombre, NIF); 
		this.NAlumnos = nAlumnos;
	}

	public int getNAlumnos() {
		return NAlumnos;
	}

	public void setNAlumnos(int nAlumnos) {
		NAlumnos = nAlumnos;
	}
	
}
