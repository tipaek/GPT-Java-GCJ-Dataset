import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int S[] = new int[N];
            int F[] = new int[N];
//            HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

            ArrayList<Integer> start = new ArrayList<Integer>();
            ArrayList<Integer> finish = new ArrayList<Integer>();
            char c[] = new char[N];
            Arrays.fill(c, '0');

            boolean check[] = new boolean[N];
            for (int j = 0; j < N; j++) {
                S[j] = sc.nextInt();
                start.add(S[j]);
                F[j] = sc.nextInt();
                finish.add(F[j]);
//                h.put(F[j], S[j]);
            }

            int S_copy[] = new int[N];
            int F_copy[] = new int[N];
            for (int j = 0; j < N; j++) {
                F_copy[j] = F[j];
                S_copy[j] = S[j];
            }

//            System.out.println();
//            System.out.println(h);
            Arrays.sort(F);


            boolean aval[] = new boolean[N];
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
//                    System.out.println(aval[k] + " " + F[k]);
                    if(F_copy[j] == F[k] && aval[k] == false){
                        aval[k] = true;
                        S[k] = S_copy[j];
                        break;
                    }
                }
            }

//            for (int j = 0; j < N; j++)
//                S[j] = h.get(F[j]);

//            System.out.println();
//            for (int k = 0; k < F.length; k++) {
//                System.out.print(S[k] + " " + F[k]);
//                System.out.println();
//            }
//            System.out.println();

//            c = printMaxActivities(S, F, c);
            int p = 0;
            c[p] = 'C';
            for (int k = 1; k < F.length; k++) {
                if (S[k] >= F[p]) {
                    c[k] = 'C';
                    p = k;
                }
            }
//            System.out.println();
//            for (int k = 0; k < c.length; k++)
//                System.out.print(c[k] + " ");
//            System.out.println();

            if ((String.valueOf(c)).indexOf('0') != -1) {
//                c = activities(S, F, c);
                int q = 0;
                while (c[q] != '0')
                    q++;
                c[q] = 'J';
                for (int j = q + 1; j < F.length; j++) {
                    if (S[j] >= F[q] && c[j] == '0') {
                        c[j] = 'J';
                        q = j;
                    }
                }
            }
//                System.out.println();
//                for (int k = 0; k < c.length; k++)
//                    System.out.print(c[k] + " ");
//                System.out.println();

            if ((String.valueOf(c)).indexOf('0') != -1) {
                System.out.print("Case #" + i + ": " + "IMPOSSIBLE");
                System.out.println();
            } else {
                char ch[] = new char[N];
//                Arrays.fill(ch, '#');
                boolean available[] = new boolean[N];
                Arrays.fill(available, false);
                for (int j = 0; j < N; j++) {
                    int index = 0;
                    for (int k = 0; k < N; k++) {
                        if (start.get(k) == S[j] && finish.get(k) == F[j] && available[k] == false) {
                            index = k;
                            available[k] = true;
                            break;
                        }
                    }
                    ch[index] = c[j];
                }
                System.out.print("Case #" + i + ": " + String.valueOf(ch));
                System.out.println();
            }
        }
    }
}

