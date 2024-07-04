import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 1; i <= cases; i++) {
            String ans = findInputs(input);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
    
    public static String findInputs(Scanner input) {
        String error = "";
        List<String> inputs = new ArrayList<>();
        int times = input.nextInt();
        for(int i = 0; i < times; i++) {
            String val = input.next();
            int index = val.indexOf("*");
            inputs.add("");
            int count = 0;
            while(index > -1) {
                 String look = val.substring(0, index);
                 while (inputs.size() <= count + 2) {
                        inputs.add("");
                 }
                 if(index == 0) {
                    count++;
                    val = val.substring(1);
                    index = val.indexOf("*");
                 } else { // index was greater than 0
                     String inList = inputs.get(count);
                     if(inList.equals("")) {
                        inputs.set(count, look);
                     } else { // something is in there
                        if(!(look.contains(inList) || inList.contains(val))) error = "*";
                        if(look.length() > inList.length()) inputs.set(count, look);
                        // else list remains the same
                     }
                     // updates
                     val = val.substring(index + 1);
                     index = val.indexOf("*");
                     count+=2;
                 }
            }
            String end = inputs.get(count);
            if(!(val.contains(end) || end.contains(val))) error = "*";
            if(val.length() > end.length()) inputs.set(count, val);
        }
        String ans = "";
        for(String line : inputs) {
            ans += line;
        }
        if(error.length() == 1) return error;
        return ans;
    }
}