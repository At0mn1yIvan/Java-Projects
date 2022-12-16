package Serialize;

import ClockClasses.Clock;
import ClockClasses.ShopClock;
import ClockClasses.SubClock;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class DBShopDeserializer {

    private SessionFactory sessionFactory;

    public DBShopDeserializer() {
        registerSessionFactory();
    }

    public ShopClock Load(){
        try(var session = sessionFactory.openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ShopClock> criteriaQuery = criteriaBuilder.createQuery(ShopClock.class);
            criteriaQuery.from(ShopClock.class);
            return session.createQuery(criteriaQuery).list().stream().findAny().orElseThrow();
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
