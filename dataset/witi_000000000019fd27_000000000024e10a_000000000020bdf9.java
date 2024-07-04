import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        casesloop:
        for (int t = 1; t<=T; t++) {

            int N = in.nextInt();

            int[] start = new int[N];
            int[] end = new int[N];

            int[] overl = new int[24*60];

            for (int i=0; i<N; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }

            for (int i=0; i<N; i++) {
                int endn = end[i];
                if (start[i] > end[i])
                    endn += 24*60;

                for (int time=start[i]; time<endn; time++) {
                    overl[time % (24 * 60)] += 1;

                    if (overl[time % (24 * 60)] > 2) {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        continue casesloop;
                    }
                }
            }

            boolean[] assign = new boolean[N];
            boolean[] overlB = new boolean[24*60];

            assignloop:
            for (int i=0; i<N; i++) {
                int endn = end[i];
                if (start[i] > end[i])
                    endn += 24*60;

                for (int time=start[i]; time<endn; time++) {
                    if (overlB[time % (24 * 60)])
                        continue assignloop;
                }
                assign[i] = true;
                for (int time=start[i]; time<endn; time++) {
                    overlB[time % (24 * 60)] = true;
                }
            }


            String out = new String("Case #" + t + ": ");
            
            for (int i=0; i<N; i++) {
                if (assign[i])
                    out += "C";
                else
                    out += "J";
            }

            System.out.println(out);
        }

    }
}
