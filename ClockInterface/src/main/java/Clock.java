public class Clock implements TimeInterface {
    protected int hour;
    protected int minute;
    protected String name;
    protected int cost;

    public Clock(String _name, int _cost){
        this.name = _name;
        this.cost = _cost;
        this.hour = 0;
        this.minute = 0;
    }

    public Clock(String _name, int _cost, int _hour, int _minute) {
        this.name = _name;
        this.cost = _cost;
        this.hour = _hour % 24;
        this.minute = _minute % 60;
    }

    public String GetBrand() { return this.name; }
    public int GetPrice() { return this.cost; }

    public void SetTime(Hand hand, int  value) throws ThrowOutputException{
        if (value < 0)
            throw new ThrowOutputException(value, "Hours/Minutes/Seconds must be positive only\n");
        if (hand == Hand.HOUR) {
            this.hour = value % 24;
            return;
        }
        if (hand == Hand.MINUTE ){
            this.minute = value % 60;
            return;
        }
        if (hand == hand.SECOND){
            throw new ThrowOutputException(hand, "Class Clock does not have second hand\n");
        }
    }

    public void IncTime(Hand hand, int  value) throws ThrowOutputException{
        if (value < 0)
            throw new ThrowOutputException(value, "You can increase Hours/Minutes/Seconds only on positive values\n");
        if (hand == Hand.MINUTE )
            this.minute += value;
        if (this.minute > 59) {
            this.hour += this.minute / 60;
            this.minute %= 60;
        }
        if (hand == Hand.HOUR ) this.hour += value;
        if (this.hour > 23) {
            this.hour %= 24;
        }
    }

    @Override
    public String toString() {
        return "Clock{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
