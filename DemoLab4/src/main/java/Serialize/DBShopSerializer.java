package Serialize;

import ClockClasses.Clock;
import ClockClasses.ShopClock;
import ClockClasses.SubClock;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBShopSerializer {

    private final ShopClock shop;
    private SessionFactory sessionFactory;

    public DBShopSerializer(ShopClock shop) {
        this.shop = shop;
        registerSessionFactory();
    }

    public void Save(){
        try (var session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(shop);
            transaction.commit();
        }
    }

    private void registerSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Clock.class);
        configuration.addAnnotatedClass(SubClock.class);
        configuration.addAnnotatedClass(ShopClock.class);
        configuration.configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }
}
