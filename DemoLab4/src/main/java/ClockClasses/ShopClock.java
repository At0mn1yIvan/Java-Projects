package ClockClasses;

import java.util.*;

public class ShopClock {
    public ArrayList<Clock> Watches;


    public ShopClock(){
        Watches = new ArrayList<>();
        Watches.add(new Clock("Gucci", 9000));
        Watches.add(new SubClock("Garmin", 2000));
        Watches.add(new Clock("Casio", 1000));
        Watches.add(new SubClock("Rolex", 10000));
        Watches.add(new Clock("Samsung", 400));
        Watches.add(new Clock("Apple", 700));
        Watches.add(new Clock("Casio", 150));
    }

    
    public void PrintAllBrands(){
        TreeSet<String> br = new TreeSet<>();
        for (Clock c: Watches){
            br.add(c.name);
        }
        System.out.println(br);
    }

    public String PopularBrand() {
        HashMap<String, Integer> hm = new HashMap<>();
        for (Clock c:Watches) {
            if (hm.get(c.name) != null)
                hm.put(c.name, hm.get(c.name) + 1);
            else
                hm.put(c.name, 1);
        }
        int max = 0;
        String sp_st = "";
        for (String ind: hm.keySet()){
            if (hm.get(ind) > max) {
                max = hm.get(ind);
                sp_st = ind;
            }
        }
        return sp_st;

    }

    public void SetTimeAll(Hand hand, int value) throws ThrowOutputException {
        for (Clock c: Watches){
            try {
                c.SetTime(hand, value);
            }
            catch (ThrowOutputException ex){
                System.out.println(ex);
            }
        }
    }


    public Clock MostExpWatch(){
        Comparator<Clock> comp = new Comparator<>() {
            @Override
            public int compare(Clock o1, Clock o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        };
        return Collections.max(Watches,comp);
    }

}
