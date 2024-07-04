
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(br.readLine());
            for (int i = 1; i < numberOfCases + 1; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                if (k % n == 0) {
                    int[] array = new int[n];
                    for (int j = 0; j < n; j++) {
                        array[j] = (k / n + j) % n == 0 ? n : (k / n + j) % n;
                    }
                    System.out.println("Case #" + i + ": POSSIBLE");
                    for (int j = 0; j < n; j++) {
                        for (int q = 0; q < n; q++) {
                            System.out.print(array[(n + q - j) % n] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
