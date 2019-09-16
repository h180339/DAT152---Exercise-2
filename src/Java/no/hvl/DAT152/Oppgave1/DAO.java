package no.hvl.DAT152.Oppgave1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * A class representing a database handler
 *
 * @author Gruppe 5
 * @version 1.0.0
 */
public class DAO {

    private static final String FILENAME = "web/WEB-INF/database.txt";


    /**
     * @return list of all products in database
     */
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split(";");
                products.add(new Product(a[0], a[1], a[2], a[3], a[4]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
