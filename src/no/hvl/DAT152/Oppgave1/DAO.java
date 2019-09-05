package no.hvl.DAT152.Oppgave1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {

	ArrayList<Product> products = new ArrayList<>();
	private static final String FILENAME = "database.txt";


	public Product getProduct() {
        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String [] a = line.split(";");
                products.add(new Product(a[0], a[1], a[2], a[3], a[4]));
                for (Product product : products) {
                    System.out.println(product);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
