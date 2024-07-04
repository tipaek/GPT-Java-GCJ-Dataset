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
            for (int j = 0; j < nums.length; j++) {
                String target = nums[j];
                while (j < nums.length - 1 && nums[j].equals(nums[j + 1])) {
                    j++;
                    target += nums[j]; 
                }
                result += createNest(target);
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        input.close();
        
    }
    
    public static String createNest(String n) {
        if (n.length() < 1)
            return "";
        int number = Integer.valueOf(n.substring(0,1));
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