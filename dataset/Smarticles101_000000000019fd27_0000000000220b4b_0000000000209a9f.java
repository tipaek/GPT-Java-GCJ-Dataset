import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        in.nextLine();
        
        for (int cs = 1; cs <= cases; cs++) {
            String s = in.nextLine();
            
            System.out.println("Case #" + cs + ": " + recurse(s, 0));
        }
    }

    static String recurse(String s, int lmin) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int x = Character.getNumericValue(s.charAt(i));
            if (x < min) min = x;
        }

        if (min == Integer.MAX_VALUE) return "";

        // pad
        String front = "";
        String back = "";

        System.out.println(min);
        for (int i = 0; i < min - lmin; i++) {
            front+="(";
            back+=")";
        }
        
        String res = "";
        String[] split = s.split(min+"");
        
        for(int i = 0; i < split.length; i++) {
            split[i] = recurse(split[i], min);
        }

        res = String.join(min+"", split);

        if (res.equals("")) res = s;
        return front + res + back;
    }
}