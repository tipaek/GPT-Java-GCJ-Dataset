import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = sc.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int N = sc.nextInt();
            int trace = 0;
            int row = 0;
            int col = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int d = sc.nextInt();

                    if (j == k) {
                        trace += d;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
        }

        sc.close();
    }
}