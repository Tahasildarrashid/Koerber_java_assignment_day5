package src_assignment_day5;

import java.util.*;
import java.io.*;

public class q3 {
    public static void main(String[] args) {
        List<Double> arr = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rashid.tahasildar\\Desktop\\day5\\src_assignment_day5\\data.txt")))
        {
            String line ;
            while((line = br.readLine()) != null)
            {
                String tokens[] = line.split(" ");
                if(tokens.length == 1)
                {
                    double it = Double.parseDouble(tokens[0]);
                    arr.add(it);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("exiting from the code");
        }

        Collections.sort(arr);
        System.out.println(arr);
        double ans = arr.get(arr.size()-1);
        System.out.println(ans);
    }
}
