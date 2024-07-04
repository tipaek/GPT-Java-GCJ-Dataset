import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // javac Solution.java
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            int n = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            for(int i=0; i<n; i++) {
                String p = scanner.next();
                patterns.add(p);
            }
            System.out.println("Case #" + testCase + ": " + calc(patterns));
        }
    }

    public static String calc(List<String> patterns) {
        String begin = "";
        String end = "";
        for(String pattern : patterns) {
            String a = pattern.substring(0, pattern.indexOf("*"));
            String b = pattern.substring(pattern.lastIndexOf("*")+1);
            b = reverse(b);
            if(begin.length() >= a.length()) {
                if(!begin.startsWith(a)) return "*";
            } else {
                if(!a.startsWith(begin)) return "*";
                begin = a;
            }
            if(end.length() >= b.length()) {
                if(!end.startsWith(b)) return "*";
            } else {
                if(!b.startsWith(end)) return "*";
                end = b;
            }
        }
        return begin + reverse(end);
    }

    static String reverse(String b) {
        char[] bchar = b.toCharArray();
        for(int i=0; i<bchar.length/2; i++) {
            char temp = bchar[i];
            bchar[i] = bchar[bchar.length-i-1];
            bchar[bchar.length-i-1] = temp;
        }
        return new String(bchar);
    }
}
