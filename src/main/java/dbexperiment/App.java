package dbexperiment;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class App {

    static private EntityManagerFactory emf;

    public static void main(String[] args) {
        emf= EntityManagerFactoryProvider.getEntityManagerFactory();
        UserJpaController ujpa=new UserJpaController(emf);
        ProductJpaController pujpa=new ProductJpaController(emf);
        List<User> userList=ujpa.findUtilizadorEntities(true,-1,-1);
        System.out.println( userList.toString());

        List<Product> productList = pujpa.findProductEntities(true,-1,-1);
        System.out.println( productList.toString());
    }
}
