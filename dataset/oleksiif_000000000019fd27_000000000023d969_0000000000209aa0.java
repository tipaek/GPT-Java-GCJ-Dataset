import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            int K = in.nextInt();
            if (K % N != 0) {
                System.out.println(String.format("Case #%s: IMPOSSIBLE", caseIndex));
            } else {
                System.out.println(String.format("Case #%s: POSSIBLE", caseIndex));
                int center = K / N;
                int[] array = new int[N];
                for (int i = 0; i < N; i++) {
                    array[i] = i + 1;
                }
                array[center - 1] = array[0];
                array[0] = center;
                StringBuilder square = new StringBuilder();
                int counter = 0;
                for(int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        square.append(array[counter % N]).append(" ");
                        counter++;
                    }
                    square.deleteCharAt(square.length() -1).append("\n");
                    counter--;
                }
                square.deleteCharAt(square.length() -1);
                System.out.println(square);
            }
        }
    }
}