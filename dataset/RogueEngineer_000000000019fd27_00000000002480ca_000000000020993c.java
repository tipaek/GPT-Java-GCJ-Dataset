import java.util.*;

public class Solution {
    public static void p(String s) {System.out.print(s);}
    public static void pn(String s) {System.out.println(s);}
    public static void ep(String s) {System.err.print(s);}
    public static void epn(String s) {System.err.println(s);}


    public static void caseN(Scanner s, int t) {
        p("Case #" + t + ": ");

        int n = s.nextInt();
        int k = 0;
        List<Set<Integer>> rs = new ArrayList<>();
        List<Set<Integer>> cs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rs.add(new HashSet<>());
            cs.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int elm = s.nextInt();
                rs.get(i).add(elm);
                cs.get(j).add(elm);
                if (i == j) {
                    k += elm;
                }
            }
        }
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (rs.get(i).size() != n) r++;
            if (cs.get(i).size() != n) c++;
        }

        pn(k + " " + r + " " + c);
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tNum = s.nextInt();
        for (int t = 1; t <= tNum; t++) {
            caseN(s, t);
        }
    }
}
