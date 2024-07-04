import java.util.Scanner;

public class Tim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t, n;
        n = in.nextInt();
        t = in.nextInt();
        int[] S = new int[n];
        int[] E = new int[n];

        for (int i = 1; i <= t; i++) {
            n = in.nextInt();
            for (int j = 0; j < n; j++) {
                S[j] = in.nextInt() / 60;
                E[j] = in.nextInt() / 60;
            }
            for (int k = 0; k < n; k++) {
                int c = 0;
                if (S[k] <= 12 && E[k] <= 12) {
                    if (S[k] >= S[c] && E[k] <= E[c]) {
                        System.out.print("Case #" + i + ": " + "C");
                    } else {
                        System.out.print("J");
                    }
                    c++;
                } else {
                    System.out.print("IMpossible");
                }
            }
            System.out.println(); // To move to the next line for the next case
        }
        in.close();
    }
}