
public class NumberReadListenerImpl implements NumberReadListenerInterface {
   
    Double totalhastaAhora = 0.0;

    @Override
    public void numberRead(NumberReadEvent numberReadEvent) {
        totalhastaAhora += numberReadEvent.getNumber();
    }

    @Override
    public void numberStreamTerminated(NumberReadEvent numberReadEvent) {
        System.out.println("La suma de todos estos numeros es: " + totalhastaAhora);
    }
}



