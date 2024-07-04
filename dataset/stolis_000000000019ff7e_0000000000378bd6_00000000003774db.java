import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            String C = in.next();
            String J = in.next();
            Set<String> set1 = new HashSet<>();
            set1.add(C);
            Set<String> set2 = new HashSet<>();
            set2.add(J);
            
            Set<Character> set3 = new HashSet<>();
            for (char c : C.toCharArray()) {
                set3.add(c);
            }
            for (char c : J.toCharArray()) {
                set3.add(c);
            }
            char[] chars = new char[set3.size()];
            int idx = 0;
            for (char c : set3) {
                chars[idx++] = c;
            }
            
            String answer = null;
            main: while (true) {
                for (String name : set1) {
                    if (set2.contains(name)) {
                        answer = name;
                        break main;
                    }
                }
                set1 = generate(set1, chars);
                set2 = generate(set2, chars);
            }
            System.out.printf("Case #%d: %s\n", t, answer);
        }
    }

    private static Set<String> generate(Set<String> set, char[] chars) {
        Set<String> result = new HashSet<>();
        for (String s : set) {
            generate(s, result, chars);
        }
        return result;
    }

    private static void generate(String s, Set<String> set, char[] chars) {
        // delete
        if (s.length() > 1) {
            for (int i=0; i<s.length(); i++) {
                String x = s.substring(0, i) + s.substring(i+1);
                add(x, set);
            }
        }
        // insert
        if (s.length() < 6) {
            for (char c : chars) {
                for (int i=0; i<=s.length(); i++) {
                    String x = s.substring(0,i) + c + s.substring(i);
                    add(x, set);
                }
            }
        }
        // replace
        for (char c : chars) {
            for (int i=0; i<=s.length(); i++) {
                String x = s.substring(0, i) + c + ((i == s.length()) ? "" : s.substring(i+1));
                add(x, set);
            }
        }
    }

    private static void add(String s, Set<String> set) {
        set.add(s);
    }

}
