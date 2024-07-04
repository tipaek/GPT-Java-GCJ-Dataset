import java.util.*;

public  class Solution {
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
                // Q[i]ãŒ1æ¡ãªã‚‰R[i]ã¯å¿…ãš1æ¡ã§, Mi ã¯Qiä»¥ä¸‹
                set[Q[i]].add(R[i].charAt(0));
            } else {
                if (R[i].length() == 1) {
                    // Q[i]ãŒ2æ¡ã§R[i]ãŒ1æ¡ãªã‚‰, Miã¯9ä»¥ä¸‹
                    set[9].add(R[i].charAt(0));
                } else {
                    // Q[i]ãŒ2æ¡ã§R[i]ãŒ2æ¡ãªã‚‰ï¼Œ10ã®ä½ã¨1ã®ä½ã§ãã‚Œãã‚Œè€ƒãˆã‚‰ã‚Œã‚‹
                    // å°‘ãªãã¨ã‚‚Miã®10ã®ä½ã¯Qiã®10ã®ä½ä»¥ä¸‹
                    set[Q[i]/10].add(R[i].charAt(0));

                    if (Q[i]/10 == 1) {
                        // QiãŒ10-19ã§R[i]ãŒ2æ¡ãªã‚‰, Miã®10ã®ä½ã¯1ã§å›ºå®šã§ Miã®1ã®ä½ã¯ä»¥ä¸‹Q[i]ã®1ã®ä½ä»¥ä¸‹
                        // set[Q[i]%10].add(R[i].charAt(1));
                    } else {
                        // MiãŒ20ä»¥ä¸Šãªã‚‰, Miã®10ã®ä½ã‹ã‚‰ç¹°ã‚Šä¸‹ã’ã«ãªã‚Šã†ã‚‹ã®ã§Qiã®1ã®ä½ã¯0ä»¥ä¸‹ (ä»»æ„)
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
