import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] names;
        for (int q = 1; q <= cases; q++) {
            int times = Integer.parseInt(s.nextLine());
            names = new String[times];
            for (int x = 0; x < times; x++) {
                /*String in = s.nextLine();
                String n = "";
                for (int i = in.length()-1; i >= 0; i--) {
                    n += in.charAt(i);
                }
                names[x] = n;*/
                names[x] = s.nextLine();
            }
            String ans = reduce(names);
            System.out.println("Case #" + q + ": " + ans);
        }
    }
    public static String reduce(String[] words) {
        String end = "";
        String start = "";
        int min;
        int at;
        int ait;
        for (int x = 0; x < words.length; x++) {
            at = words[x].indexOf('*');
            min = Math.min(start.length(),at);
            if (!words[x].substring(0,min).equals(start.substring(0,min))) {
                return "*";
            }
            if (at > start.length()) {
                start = words[x].substring(0,at);
            }
            
            ait = words[x].length() - at - 1;
            min = Math.min(end.length(),ait);
            if (!words[x].substring(words[x].length()-min,words[x].length()).equals(end.substring(end.length()-min,end.length()))) {
                return "*";
            }
            if (ait > end.length()) {
                end = words[x].substring(at+1,words[x].length());
            }
        }
        return start + end;
    }
}