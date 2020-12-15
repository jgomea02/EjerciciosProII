
import java.util.EventListener;

public interface NumberReadListenerInterface extends EventListener {
    public void numberRead(NumberReadEvent numberReadEvent);
    public void numberStreamTerminated(NumberReadEvent numberReadEvent);
}


