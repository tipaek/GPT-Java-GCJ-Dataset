import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] words = new String[n];
            for (int j = 0; j < n; j++) { 
                String word = scanner.nextLine();
                words[j] = word.replace("*",".*");
            }
            String p = matches(words);
            System.out.println("Case #" + i + ": " + p);
        }
    }
    
    public static String matches(String[] words) {
        String result = findLongest(words);
        result = result.replace(".*","");
        boolean patt = true;
        for (int i = 0; i < words.length; i++) {
            if(!Pattern.matches(words[i], result)) patt = false;
        }
        
        if (patt) {
            return result;
        } else {
            return "*";
        }
    }
    
    public static String findLongest(String[] words) {
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            if (result.length() < words[i].length()) result = words[i];
        }
        return result;
    }
}