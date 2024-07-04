import java.util.*;
class Solution{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int x = 1; x <= T; x++) {
            int N = sc.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = sc.nextInt();
                E[i] = sc.nextInt();
            }
 System.out.println("Case #" + x +": "+ calc(S, E, N) );
        }
    }

    public static String calc(int[] S, int[] E, int N) {
        int Ccompl = 0, Jcompl = 0;
        Jcompl = E[0];
        String s = "J";
        for (int i = 1; i < N; i++) {
            if (s.charAt(s.length() - 1) == 'J') {
                if (S[i] >= Jcompl) {
                    s += "J";
                    Jcompl = E[i];
                }
                if (S[i] < Jcompl) {
                    s += "C";
                    Ccompl = E[i];
                    continue;
                }
                if (s.charAt(s.length() - 1) == 'C') {
                    if (S[i] >= Ccompl) {
                        s += "C";
                        Ccompl = E[i];
                    }
                    if (S[i] < Ccompl) {
                        s += "J";
                        Jcompl = E[i];
                        continue;
                    }
                } else {
                    s = "IMPOSSIBLE";
                    break;
                }
            }
        }
        return s;
    }
}
