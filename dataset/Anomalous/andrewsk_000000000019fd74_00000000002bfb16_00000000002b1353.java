import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ":");
            process(n);
        }
    }

    private static void process(int n) {
        List<Long> splitList = calculateSplits(n);
        int steps = 0;
        int currentRow = 0;
        int currentColumn = 0;
        System.out.println((currentRow + 1) + " " + (currentColumn + 1));
        steps++;

        boolean moveLeft = true;
        int direction = 1;

        for (long row : splitList) {
            while (currentRow < row) {
                currentRow++;
                currentColumn = moveLeft ? 0 : currentRow;
                System.out.println((currentRow + 1) + " " + (currentColumn + 1));
                steps++;
            }
            for (int i = 0; i < row; i++) {
                currentColumn += direction;
                System.out.println((currentRow + 1) + " " + (currentColumn + 1));
                steps++;
            }
            direction *= -1;
            moveLeft = !moveLeft;
        }

        long sum = 0;
        for (int i = 0; i < splitList.size() - 1; i++) {
            sum += (1L << splitList.get(i)) - 1;
        }
        long last = splitList.get(splitList.size() - 1);
        sum += (1L << last) + last;

        while (sum < n) {
            currentRow++;
            currentColumn = moveLeft ? 0 : currentRow;
            System.out.println((currentRow + 1) + " " + (currentColumn + 1));
            steps++;
            sum += 1;
        }
    }

    private static List<Long> calculateSplits(int n) {
        long i = 0;
        long cumulativeSum = i + (1L << i);
        while (cumulativeSum <= n) {
            i++;
            cumulativeSum = i + (1L << i);
        }
        i--;
        cumulativeSum = i + (1L << i);

        List<Long> splitList = new ArrayList<>();
        splitList.add(i);

        while (i > 2) {
            i--;
            long additionalSum = (1L << i) - 1;
            if (cumulativeSum + additionalSum <= n) {
                splitList.add(i);
                cumulativeSum += additionalSum;
            }
        }
        Collections.reverse(splitList);
        return splitList;
    }
}