package ClockClasses;


public class Main {

    public static void main(String[] args) {
        //shop.PrintAllBrands();

        SubClock two = new SubClock("Rolex", 5000);


        try {
            two.SetTime(Hand.HOUR, 105);
            two.SetTime(Hand.MINUTE, 75);
            two.SetTime(Hand.SECOND, 65);
            two.IncTime(Hand.SECOND, 1200);

        }
        catch (ThrowOutputException ex){
            System.out.println(ex);
            System.exit(1);
        }

    }
}
