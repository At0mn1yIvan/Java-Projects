package ClockClasses;


import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public interface Time extends Serializable {

    String GetBrand();
    int GetPrice();
    void SetTime(Hand hand, int  value) throws ThrowOutputException;
    void IncTime(Hand hand, int  value) throws ThrowOutputException;

}
