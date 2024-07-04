import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        for (int i = 0; i < testCases; i++) {
            for (int j = 0; j < arraySize; j++) {
                System.out.println(j + 1);
                array[j] = scanner.nextInt();
            }

            for (int j = 0; j < arraySize; j++) {
                System.out.print(array[j]);
            }
            System.out.println(); // To move to the next line after printing the array
        }
    }

    private static void solve() {
        // This method is currently not utilized.
    }
}