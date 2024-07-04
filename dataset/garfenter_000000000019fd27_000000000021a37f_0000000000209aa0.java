
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int N = in.nextInt();
            int K = in.nextInt();
            int expectedKCase1 = 0;
            boolean solved = false;
            for (int i = 1; i <= N; i++) {
                expectedKCase1 += i;
            }
            if (expectedKCase1 == K && K != 3) {
                System.out.println("Case #" + c + ": POSSIBLE");
                for (int i = 0; i < N; i++) {
                    String line = "";
                    for (int j = 0; j < N; j++) {
                        int number = i + j + 1;
                        number = number > N ? number - N : number;
                        line += number + " ";
                    }
                    System.out.println(line.trim());
                }
                continue;
            }
            for (int i = 1; i <= N; i++) {
                if (i * N == K) {
                    System.out.println("Case #" + c + ": POSSIBLE");
                    solveFor(i, N);
                    solved = true;
                }
            }
            if (!solved) {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }
        }
    }

    public static void solveFor(int startValue, int N) {
        int number = startValue;
        for (int i = 0; i < N; i++) {
            String line = "";
            for (int j = 0; j < N; j++) {
                line += number + " ";
                number++;
                number = number > N ? 1 : number;
            }
            number--;
            number = number == 0 ? N : number;
            System.out.println(line.trim());
        }
    }
}
