import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfTestCases = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberOfTestCases; i++) {
                int M = Integer.parseInt(br.readLine());
                if (M <= 500) {
                    printSequence(M, 1);
                } else if (M == 501) {
                    System.out.println("1 1");
                    System.out.println("2 1");
                    System.out.println("2 2");
                    printSequence(M - 2, 3);
                }
            }
        }
    }

    private static void printSequence(int end, int start) {
        for (int j = start; j <= end; j++) {
            System.out.println(j + " 1");
        }
    }
}