package proii.es.unileon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> gruposPalillos = new ArrayList<ArrayList<Integer>>();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while (num != 0) {
			ArrayList<Integer> palillos = new ArrayList<Integer>();
			lectura(num, sc, palillos);
			gruposPalillos.add(palillos);
			num = sc.nextInt();
		}
		sc.close();

		for (int i = 0; i < gruposPalillos.size(); i++) {
			int suma = sumaRec(gruposPalillos.get(i), 0, 0);
			// int suma = hallarSuma(gruposPalillos.get(i));
			int mayor = gruposPalillos.get(i).get(0);
			int mayorPalilloCortados = buscoMayor(gruposPalillos.get(i), mayor);
			int menorLongitudPosible = buscoMenorLongitudPosible(suma, mayorPalilloCortados + 1, gruposPalillos.get(i));
			System.out.println(menorLongitudPosible);
		}
	}
	
	private static void lectura(int num, Scanner sc, ArrayList<Integer> palillos){
		for (int i = 0; i < num; i++) {
			int aux = sc.nextInt();
			palillos.add(aux);
		}
	}

	private static int buscoMenorLongitudPosible(int suma, int numBuscado, ArrayList<Integer> palillos) {
		if (suma % numBuscado == 0) {
			if (esPosibleDivision(numBuscado, palillos, 1)) {
				return numBuscado;
			} else {
				return buscoMenorLongitudPosible(suma, ++numBuscado, palillos);
			}

		}
		return buscoMenorLongitudPosible(suma, ++numBuscado, palillos);
	}

	private static boolean esPosibleDivision(int numBuscado, ArrayList<Integer> palillos, int indice) {
		// TODO Auto-generated method stub
		if (sumaRec(palillos, 0, 0) == numBuscado) {
			return true;
		} else {
			comparar(palillos);
			ArrayList<Integer> sumaNumeroBuscado = new ArrayList<Integer>();
			int aux = palillos.get(indice);
			sumaNumeroBuscado.add(aux);
			for(int i = indice; i < palillos.size(); i++) {
				if(aux + palillos.get(i) == numBuscado) {
					sumaNumeroBuscado.add(palillos.get(i));
					int k = 0;
					boolean sigue = true;
					while(k < sumaNumeroBuscado.size() && sigue) {
						palillos.remove(Integer.valueOf(sumaNumeroBuscado.get(k)));
						k++;
					}
					return esPosibleDivision(numBuscado, palillos, 0);
				}else if(aux + palillos.get(i) < numBuscado) {
					aux += palillos.get(i);
					sumaNumeroBuscado.add(palillos.get(i));
				}else if(i == palillos.size()-1) {
					sumaNumeroBuscado = new ArrayList<Integer>();
				}
				
			}
		}

		return false;
	}
	
	private static void comparar( ArrayList<Integer> palillos) {
		Comparator<Integer> comparador = Collections.reverseOrder();
		Collections.sort(palillos, comparador);
	}

	// metodo que hace la suma de los elementos de forma recursiva
	private static int sumaRec(ArrayList<Integer> palillos, int i, int suma) {
		// TODO Auto-generated method stub
		if (i == palillos.size()) {
			return suma;
		} else {
			suma += palillos.get(i);
			return sumaRec(palillos, ++i, suma);
		}
	}

	// metodo que bsuca el mayor de los elementos
	private static int buscoMayor(ArrayList<Integer> palillos, int mayor) {
		// TODO Auto-generated method stub
		for (int i = 0; i < palillos.size(); i++) {
			if (palillos.get(i) > mayor) {
				mayor = palillos.get(i);
			}
		}
		return mayor;
	}

}

/*
9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
 */
 