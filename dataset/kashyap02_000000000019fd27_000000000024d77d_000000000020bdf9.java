import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static char[] printMaxActivities(int s[], int f[], char c[]) {
        int i = 0;
        c[i] = 'C';

        for (int j = 1; j < f.length; j++) {
            if (s[j] >= f[i]) {
                c[j] = 'C';
                i = j;
            }
        }

        return c;
    }

    public static char[] activities(int s[], int f[], char c[]) {
        int i = 0;
        while (c[i] != '0')
            i++;
        c[i] = 'J';
        for (int j = i + 1; j < f.length; j++) {
            if (s[j] >= f[i] && c[j] == '0') {
                c[j] = 'J';
                i = j;
            }
        }
        return c;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int S[] = new int[N];
            int F[] = new int[N];
            HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

            ArrayList<Integer> start = new ArrayList<>();
            ArrayList<Integer> finish = new ArrayList<>();
            char c[] = new char[N];
            Arrays.fill(c, '0');

            for (int j = 0; j < N; j++) {
                S[j] = sc.nextInt();
                start.add(S[j]);
                F[j] = sc.nextInt();
                finish.add(F[j]);
                h.put(F[j], S[j]);
            }

            Arrays.sort(F);
            for (int j = 0; j < N; j++)
                S[j] = h.get(F[j]);

//            System.out.println();
//            for (int k = 0; k < F.length; k++) {
//                System.out.print(S[k] + " " + F[k]);
//                System.out.println();
//            }
//            System.out.println();

            c = printMaxActivities(S, F, c);
//            System.out.println();
//            for (int k = 0; k < c.length; k++)
//                System.out.print(c[k] + " ");
//            System.out.println();

            if ((String.valueOf(c)).indexOf('0') != -1)
                c = activities(S, F, c);
//                System.out.println();
//                for (int k = 0; k < c.length; k++)
//                    System.out.print(c[k] + " ");
//                System.out.println();
//            }

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

