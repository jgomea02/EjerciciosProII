import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

//Clase fuente de eventos.
public class LectorNumeros {
    private Set<NumberReadListenerInterface> listeners;
   
    //En el constructor inicializamos el set de listeners.
	//Set es un interface, hay que crear una de sus clases hijas 
	//HashSet, TreeSet o LinkedHashSet

    public LectorNumeros() {
        listeners = new HashSet<NumberReadListenerInterface>();
    }
   
    public static void main(String[] args) {
    	LectorNumeros lector = new LectorNumeros();
        NumberReadListenerInterface listener = new NumberReadListenerImpl();
        lector.addNumberReadListener(listener);
        lector.leerNumeros();
    }
      
    public void leerNumeros() {

    	//Vamos metiendo numeros hasta introducir uno en blanco (null)
    	//que es el momento generador de evento
        Scanner sc=new Scanner(System.in);
            Double d = null;
            do {
            	System.out.print("Introduzca un numero: ");
                String readLine = sc.nextLine();
                		//console.readLine("Enter a number: ", (Object[])null);
                d = getDoubleValue(readLine);
                if (d != null) {
                    notifyListenersOfNewNumber(d); //<-- aqui generamos un evento
                }
            } while (d != null);
            
            //Aqui se genera el evento:
            notifyListenersOfEndOfStream(); //<-- aqui generamos otro evento final.
    }
   
    public void addNumberReadListener(NumberReadListenerInterface listener) {
        this.listeners.add(listener);
    }
   
    public void removeNumberReadListener(NumberReadListenerInterface listener) {
        this.listeners.remove(listener);
    }
   
    private void notifyListenersOfEndOfStream() {
       for (NumberReadListenerInterface numberReadListener: listeners) {
    	   //Exactamente el evento se genera aqui:
            numberReadListener.numberStreamTerminated(new NumberReadEvent(this, 0.0));
        }
    }

    private void notifyListenersOfNewNumber(Double d) {
        for (NumberReadListenerInterface numberReadListener: listeners) {
            numberReadListener.numberRead(new NumberReadEvent(this, d));
        }
    }

    private Double getDoubleValue(String readLine) {
        Double result;
        try {
            result = Double.valueOf(readLine);
        } catch (Exception e) {
            result = null;
        }
        return result;  }  }