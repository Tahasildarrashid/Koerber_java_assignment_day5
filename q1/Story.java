package src_assignment_day5.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class Story {
    public static void main(String[] args) {
        HashMap<String, Integer> mp =new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rashid.tahasildar\\Desktop\\day5\\src_assignment_day5\\q1\\data.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    token = token.toLowerCase();
                    int count = mp.getOrDefault(token, 0);
                    mp.put(token, count + 1);
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        for(Map.Entry<String, Integer> entry : mp.entrySet())
        {
            System.out.println(entry.getKey() + " appear " +  entry.getValue() + " times");
        }
    }
}
