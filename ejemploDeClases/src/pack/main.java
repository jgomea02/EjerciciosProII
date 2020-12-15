package pack;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		pedirNotas();
	}
	
	public static void pedirNotas() {
		System.out.println("****************************");
		System.out.println("\tBienvenido");
		System.out.println("****************************");
		
		System.out.println("¿Cuál es su nombre?");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		
		System.out.println("Dime tu NIF");
		String nif = sc.nextLine();
		System.out.println("Eres alumno? Y/N");
		char respuesta = sc.nextLine().toUpperCase().charAt(0);//para que se quede solo con el primer caracter
		if(respuesta == 'Y') {
			System.out.println("Cuál es tu ID?");
			String IDAlumno = sc.nextLine();
			Alumno alumno1 = new Alumno(nombre,nif, IDAlumno);
			System.out.println("He creado un alumno que se llama " + alumno1.getNombre());
			System.out.println("Dime una asignatura");
			String asignatura = sc.nextLine();
			System.out.println("Dime la nota");
			Double nota = sc.nextDouble();
			Asignatura asign1 = new Asignatura(asignatura, nota);
			System.out.println("El alumno " + alumno1.getNombre() + "con IDAlumno " + alumno1.getIDAlumno() + " ha obtenido " + asign1.getNota() + " en " + asign1.getNombreAsigantura());
			
		}else {
			System.out.println("¿Cuántos alumnos tiene?");
			int nAlumnos = sc.nextInt();
			Profesor profesor1 = new Profesor(nombre, nif, nAlumnos);
			System.out.println("He creado un profesor que se llama " + profesor1.getNombre() + " y tiene " + profesor1.getNAlumnos() + " alumnos");
		}
		sc.close();
	}

}


/*
 * Profesores - ponerNotas Nombre Asignatura nº Alumnos nif
 * 
 * alumnos - entregarTrabajos Nombre Asignatura Id Alumno nif
 */