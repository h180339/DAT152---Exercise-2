package no.hvl.DAT152.Oppgave2;

import no.hvl.DAT152.Oppgave1.Product;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NewDAO {


    public ArrayList<Product> getAllProducts(ServletContext context) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String filename = context.getRealPath("/WEB-INF/database.txt");
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split(";");
                products.add(new Product(a[0], a[1], a[2], a[3], a[4]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
