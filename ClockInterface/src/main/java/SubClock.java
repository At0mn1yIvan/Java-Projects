

public class SubClock extends Clock{
    protected int second;

    public SubClock(String _name, int _cost){
        super(_name, _cost);
        this.second = 0;
    }
    public SubClock(String _name, int _cost, int _hour, int _minute, int _second){
        super(_name, _cost, _hour, _minute);
        this.second = _second % 60;
    }

    @Override
    public void SetTime(Hand hand, int  value) throws ThrowOutputException{
        if (hand == Hand.HOUR || hand == Hand.MINUTE)
            super.SetTime(hand, value);
        if (hand == Hand.SECOND)
        {
            this.second = value % 60;
            return;
        }
    }

    @Override
    public void IncTime(Hand hand, int  value) throws ThrowOutputException{
        if (hand == Hand.SECOND)
            this.second += value;
        if (this.second > 59){
            this.minute += this.second / 60;
            this.second %= 60;
        }
        super.IncTime(hand, value);
    }

    @Override
    public String toString() {
        return "SubClock{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
