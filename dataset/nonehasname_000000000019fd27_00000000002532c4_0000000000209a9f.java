import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String... args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = input.nextInt();
        input.nextLine();
        for (int i = 1; i <= cases; i++) {
            String[] nums = input.nextLine().split("");
            String result = "";
            for (String n : nums) {
                result += createNest(n.trim());
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        input.close();
        
    }
    
    public static String createNest(String n) {
        int number = Integer.valueOf(n);
        String result = "";
        for (int i = 0; i < number; i++) {
            result += "(";
        }
        result += n;
        for (int i = 0; i < number; i++) {
            result += ")";
        }
        return result;
    }
}