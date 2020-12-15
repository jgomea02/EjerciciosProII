package pack;

public class Asignatura{
	private String NombreAsigantura;
	private double nota;
	
	public Asignatura(String NombreAsignatura, double nota) {
		this.NombreAsigantura = NombreAsignatura;
		this.nota = nota;
	}

	public String getNombreAsigantura() {
		return NombreAsigantura;
	}

	public void setNombreAsigantura(String nombreAsigantura) {
		NombreAsigantura = nombreAsigantura;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
