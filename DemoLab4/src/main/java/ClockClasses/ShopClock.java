package ClockClasses;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class ShopClock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    //@ElementCollection(targetClass = Clock.class)
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public List<Clock> Watches;


    public ShopClock(){
        Watches = new ArrayList<>();
//        Watches.add(new Clock("Gucci", 9000));
//        Watches.add(new SubClock("Garmin", 2000));
//        Watches.add(new Clock("Casio", 1000));
//        Watches.add(new SubClock("Rolex", 10000));
//        Watches.add(new Clock("Samsung", 400));
//        Watches.add(new Clock("Apple", 700));
//        Watches.add(new Clock("Casio", 150));
    }

    
    public void PrintAllBrands(){
        TreeSet<String> br = new TreeSet<>();
        for (Time c: Watches){
            br.add(c.GetBrand());
        }
        System.out.println(br);
    }

    public String PopularBrand() {
        HashMap<String, Integer> hm = new HashMap<>();
        for (Time c:Watches) {
            if (hm.get(c.GetBrand()) != null)
                hm.put(c.GetBrand(), hm.get(c.GetBrand()) + 1);
            else
                hm.put(c.GetBrand(), 1);
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
        for (Time c: Watches){
            try {
                c.SetTime(hand, value);
            }
            catch (ThrowOutputException ex){
                System.out.println(ex);
            }
        }
    }


    public Time MostExpWatch(){
        Comparator<Time> comp = Comparator.comparingInt(Time::GetPrice);
        return Collections.max(Watches, comp);
    }
    
    public void Add(Clock c){
        Watches.add(c);
    }
}
