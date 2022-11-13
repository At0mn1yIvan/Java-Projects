package ClockClasses;

public interface TimeInterface {

    String GetBrand();
    int GetPrice();
    void SetTime(Hand hand, int  value) throws ThrowOutputException;
    void IncTime(Hand hand, int  value) throws ThrowOutputException;


}
