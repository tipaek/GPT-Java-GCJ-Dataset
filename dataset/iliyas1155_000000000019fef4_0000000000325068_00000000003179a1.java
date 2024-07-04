import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            String res = calc(scanner);
            System.out.println("Case #" + testCase + ": " + res);
        }
    }

    public static String calc(Scanner scanner) {
        int u = scanner.nextInt();
        Map<Character, Long>[] dict = new HashMap[10];
        for(int i=0; i<10; i++) {
            dict[i] = new HashMap<>();
        }
        Set<Character> set = new HashSet<>();
        for(int i=0; i<10000; i++) {
            int m = scanner.nextInt();
            String str = scanner.next();
            if(m==-1) continue;
            // n = random(1, m)
            String mStr = ""+m;
            if(mStr.length()==str.length()) {
                int upLimit = mStr.charAt(0)-'0';
                for(int j=1; j<=upLimit; j++) {
                    dict[j].put(str.charAt(0), dict[j].getOrDefault(str.charAt(0), 0L) + 1);
                }
            } else {
                for(int j=1; j<10; j++) {
                    dict[j].put(str.charAt(0), dict[j].getOrDefault(str.charAt(0), 0L) + 1);
                }
            }
            for(char c : str.toCharArray()) {
                set.add(c);
            }
        }
        String res = "";

        for(int i=1; i<10; i++) {
            char bestChar = 0;
            long bestCount = 0;
            for(char c : dict[i].keySet()) {
                if(dict[i].get(c) > bestCount) {
                    bestCount = dict[i].get(c);
                    bestChar = c;
                }
            }
            set.remove(bestChar);
            for(Map<Character, Long> d : dict) {
                d.remove(bestChar);
            }
            res += bestChar;
        }
        for(char c : set) {
            res = c + res;
            break;
        }
        return res;
    }

}
