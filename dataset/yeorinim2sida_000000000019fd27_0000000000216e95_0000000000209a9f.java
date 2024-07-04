import java.util.Scanner;

public class Solution {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.next());
        for(int tc = 1 ; tc <= T ; tc++) {
            StringBuilder sequence = new StringBuilder();
            Num prev = new Num("", 0); // init as dummy
            String s = sc.next();
            for(int i = 0 ; i < s.length(); i++) {
                Num cur = Num.init(s.charAt(i));
                int skip = Math.min(prev.size, cur.size);
                flush(sequence, ')', prev.size - skip);
                flush(sequence, '(', cur.size - skip);
                sequence.append(cur.v);
                prev = cur;
            }
            flush(sequence, ')', prev.size);
            System.out.printf("Case #%d: %s\n", tc, sequence.toString());
        }
    }
    
    static void flush(StringBuilder seq, char c, int cnt) {
        for (int i = 0; i < cnt; i++) {
            seq.append(c);
        }
    }

    static class Num {
        /**
         * digits like "0", "3", ..
         */
        String v;
        /**
         * # of parenthesis
         */
        int size;
        
        Num(String c, int l) {
            v = c;
            size = l;
        }
        
        static Num init(char d) {
            int size = d - '0';
            return new Num(String.valueOf(d), size);
        }
    }
}