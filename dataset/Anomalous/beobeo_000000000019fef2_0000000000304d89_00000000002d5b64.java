import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void getResult(int R, int S) {
        List<int[]> ways = new ArrayList<>();
        int count = 0;
        int initial = R - 1;
        int endIndex = R * (S - 1);
        int startIndex = endIndex - (R - 1) * (S - 1) + 1;

        for (int i = endIndex; i >= startIndex; i--) {
            if (count == S - 1) {
                count = 0;
                initial--;
            }
            ways.add(new int[]{i, initial});
            count++;
        }

        System.out.println(ways.size());
        for (int[] element : ways) {
            System.out.println(element[0] + " " + element[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");
            getResult(R, S);
        }
        scanner.close();
    }
}