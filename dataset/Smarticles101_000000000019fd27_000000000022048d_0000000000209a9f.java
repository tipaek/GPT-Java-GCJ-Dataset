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

        //System.out.println(s);

        for (int i = 0; i < s.length(); i++) {
            int x = Character.getNumericValue(s.charAt(i));
            if (x < min) min = x;
        }

        // pad
        String front = "";
        String back = "";

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