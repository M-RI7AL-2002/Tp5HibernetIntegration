package presentation;

import dao.IDao;
import entities.Categorie;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

import java.util.Locale;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = (IDao<Product>) context.getBean("productDaoImpl");
        IDao<Categorie> categoryDao = (IDao<Categorie>) context.getBean("categorieDaoImpl");

        Categorie categorie = new Categorie("Sport");

        Product product = new Product();
        product.setName("Boxing Gloves");
        product.setPrice(300.0);
        product.setCategorie(categorie);
        categoryDao.create(categorie);

        productDao.create(product);

        System.out.println("Categorie sauvegardé : " + categorie.getRef());

        System.out.println("Produit sauvegardé : " + product.getName());
    }
}