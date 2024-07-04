import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    private void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        int length = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < tests; i++) {
            executeTest(length);
            String result = in.nextLine();
            if (!"Y".equals(result)) {
                break;
            }
        }
    }

    private void executeTest(int length) {
        System.out.println(1); // Initial move
        in.nextLine();

        List<Integer> records = new ArrayList<>(Collections.nCopies(length, 0));

        Integer posSam = null;
        Integer posDiff = null;
        int numSam = -1;
        int numDiff = -1;
        int round = 2;
        int pointer = 0;

        while (round <= 150) {
            if (round % 10 == 2) {
                int currentS = findControlBit(posSam);
                int currentD = findControlBit(posDiff);
                round += 2;
                records = updateRecords(records, posSam, posDiff, numSam, numDiff, currentS, currentD);
                continue;
            }

            if (pointer == length / 2) {
                round++;
                System.out.println(1);
                in.nextLine();
                continue;
            }

            System.out.println(pointer + 1);
            int first = in.nextInt();
            in.nextLine();
            records.set(pointer, first);

            System.out.println(length - pointer);
            int second = in.nextInt();
            in.nextLine();
            records.set(length - pointer - 1, second);

            if (posSam == null && first == second) {
                posSam = pointer;
                numSam = first;
            }
            if (posDiff == null && first != second) {
                posDiff = pointer;
                numDiff = first;
            }

            pointer++;
            round += 2;
        }

        printRecords(records);
    }

    private int findControlBit(Integer pos) {
        if (pos == null) {
            System.out.println(1);
            in.nextLine();
            return -1;
        } else {
            System.out.println(pos + 1);
            int value = in.nextInt();
            in.nextLine();
            return value;
        }
    }

    private List<Integer> complement(List<Integer> records) {
        for (int i = 0; i < records.size(); i++) {
            records.set(i, (records.get(i) + 1) % 2);
        }
        return records;
    }

    private void printRecords(List<Integer> records) {
        for (int value : records) {
            System.out.print(value);
        }
        System.out.println();
    }

    private List<Integer> updateRecords(List<Integer> records, Integer posSam, Integer posDiff, int numSam, int numDiff, int currentS, int currentD) {
        if (posSam == null && posDiff == null) {
            return records;
        } else if (posSam == null && numDiff != currentD) {
            Collections.reverse(records);
        } else if (posDiff == null && numSam != currentS) {
            return complement(records);
        } else if (numSam != currentS && numDiff != currentD) {
            return complement(records);
        } else if (numSam != currentS) {
            Collections.reverse(records);
            return complement(records);
        } else if (numDiff != currentD) {
            Collections.reverse(records);
        }
        return records;
    }
}