public class ThrowOutputException extends Exception {
    private int i = 0;
    private Hand hand;
    public ThrowOutputException(int _i, String message){
        super (message);
        this.i = _i;

    }
    public ThrowOutputException(Hand _hand, String message){
        super (message);
        this.hand = _hand;

    }
    @Override
    public String toString() {
        return "ThrowOutputException{" +
                "i=" + i +
                "}:" + this.getMessage();
    }
}
