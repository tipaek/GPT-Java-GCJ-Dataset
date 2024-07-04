import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            int n = in.nextInt();
            List<String> list = new ArrayList<>();
            List<Character> prefix = new ArrayList<>();
            List<Character> suffix = new ArrayList<>();
            boolean stop = false;
            for (int j = 1; j <= n; j++) {
                final String s = in.next();
                if (stop) {
                    continue;
                }
                if (!s.startsWith("*")) {
                    int k = 0;
                    for (; k < Math.min(prefix.size(), s.indexOf("*")); k++) {
                        if (prefix.get(k) != s.charAt(k)) {
                            stop = true;
                            break;
                        }
                    }
                    k=prefix.size();
                    while(k<s.indexOf("*")){
                        prefix.add(s.charAt(k));
                        k++;
                    }
                }
                if (!s.endsWith("*")) {
                    int k = 0;
                    for (; k < Math.min(suffix.size(), s.length()-1-s.lastIndexOf("*")); k++) {
                        int pos = s.length()-1 - k;
                        if (suffix.get(k) != s.charAt(pos)) {
                            stop = true;
                            break;
                        }
                    }
                    k=s.length()-suffix.size()-1;
                    while(k>s.lastIndexOf("*")){
                        suffix.add(s.charAt(k));
                        k--;
                    }
                }
                list.add(s);
            }
            if (!stop){
                for (Character character : prefix) {
                    sb.append(character);
                }
                for (String s : list) {
                    int start = s.indexOf("*");
                    int end = s.lastIndexOf("*");
                    for (int k = start+1; k<end; k++) {
                        if (s.charAt(k)!='*'){
                            sb.append(s.charAt(k));
                        }
                    }
                }
                for (int k = suffix.size() - 1; k >= 0; k--) {
                    sb.append(suffix.get(k));
                }
            } else {
                sb = new StringBuilder();
                sb.append("*");
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}