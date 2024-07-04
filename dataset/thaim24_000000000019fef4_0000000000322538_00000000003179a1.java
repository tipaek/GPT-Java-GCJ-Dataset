import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int U = sc.nextInt();
            int[] Q = new int[10000];
            String[] R = new String[10000];
            for (int i=0; i<10000; i++) {
                Q[i] = sc.nextInt();
                R[i] = sc.next();
            }

            System.out.println("Case #" + (t+1) + ": " + solve(U, Q, R));
        }
    }

    private static String solve(int U, int[] Q, String[] R) {
        HashSet<Character>[] set = new HashSet[10];
        for (int i=0; i<10; i++) {
            set[i] = new HashSet();
        }

        for (int i=0; i<10000; i++) {
            if (Q[i] < 10) {
                set[Q[i]].add(R[i].charAt(0));
            } else {
                if (R[i].length() == 1) {
                    set[9].add(R[i].charAt(0));
                } else {
                    set[Q[i]/10].add(R[i].charAt(0));

                    if (Q[i]/10 == 1) {
                        // set[Q[i]%10].add(R[i].charAt(1));
                    } else {
                        set[0].add(R[i].charAt(1));
                    }
                }
            }
        }

        String D = "";

        /*
        for (int i=0; i<10; i++) {
            System.err.println("size of set[" + i + "]=" + set[i].size());
        }
        */

        set[0].removeAll(set[9]);
        // System.err.println("size of set[0]=" + set[0].size());
        D += String.valueOf((char)set[0].toArray()[0]);

        HashSet<Character> hit = new HashSet();
        for (int i=1; i<=9; i++) {
            set[i].removeAll(hit);
            D += String.valueOf((char)set[i].toArray()[0]);

            hit.add(D.charAt(i));
        }

        return D;
    }
}
