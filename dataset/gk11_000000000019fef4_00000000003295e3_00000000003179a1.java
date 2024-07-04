import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        int U = scanner.nextInt();
        Map<Character,BitSet> tallies = new HashMap<>();
        for (int i=0;i<10000;i++) {
            Integer M_ = scanner.nextInt(); scanner.skip(" ");
            String R = scanner.nextLine();
            String M = M_.toString();
            if (R.length() != M.length()) {
                continue;
            }
            for (int k=0;k<M.length();k++) {
                BitSet bt = tallies.computeIfAbsent(R.charAt(k), x -> {
                    BitSet b = new BitSet();
                    b.set(0,10);
                    return b;
                });
            }
            BitSet bt = tallies.get(R.charAt(0));
            for (int x=M.charAt(0)-'0'+1;x<=9;x++) {
                bt.clear(x);
            }
        }
        char sol[] = new char[10];
        for (Map.Entry<Character,BitSet> e : tallies.entrySet()) {
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
            sol[e.getValue().cardinality()-1] = e.getKey();
        }
        System.out.println("Case #"+t+": "+new String(sol));
    }
}
