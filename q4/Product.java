package src_assignment_day5.q4;

import java.util.Collections;
import java.util.*;
import java.util.Comparator;

public class Product {
    private int productID;
    private String productName;
    private double productPrice;

    public Product(){};

    public Product(int productID, String productName, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public double getProductPrice()
    {
        return productPrice;
    }

    PriorityQueue<Product> pq = new PriorityQueue<>(new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return Double.compare(o2.getProductPrice(), o1.getProductPrice());
        }
    });


    public void init()
    {
        pq.offer(new Product(1, "rashid", 1000));
        pq.offer(new Product(2, "ram", 2000));
        pq.offer(new Product(3, "rahul", 20000));
        pq.offer(new Product(4, "rajeev kalose", 3000));
        pq.offer(new Product(5, "shivam", 4000));
    }

    public void display()
    {
        while(!pq.isEmpty())
        {
            Product temp = pq.poll();
            System.out.println(temp);
            System.out.println("Id is: " + temp.productID);
            System.out.println("Name is: " + temp.productName);
            System.out.println("Price is: " + temp.productPrice);
        }
    }
}
