import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    private int numSam;
    private int numDiff;
    
    private Scanner in;

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        int length = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < tests; i++) {
            runOneTest(length);
            String result = in.nextLine();
            if (!result.equals("Y")) {
                break;
            }
        }
    }

    private void runOneTest(int length) {
        System.out.println(1);
        System.out.flush();
        in.nextLine();

        List<Integer> records = new ArrayList<>(Collections.nCopies(length, 0));

        Integer posSam = null;
        Integer posDiff = null;
        numSam = -1;
        numDiff = -1;
        int round = 2;
        int pointer = 0;

        while (round <= 150) {
            printRecords(records);

            if (round % 10 == 2) {
                int currentS = findC(posSam);
                int currentD = findC(posDiff);
                round += 2;
                records = repairRecords(records, posSam, posDiff, currentS, currentD);
                continue;
            }

            if (pointer == length / 2) {
                round++;
                System.out.println(1);
                System.out.flush();
                in.nextLine();
                continue;
            }

            System.out.println(pointer + 1);
            System.out.flush();
            int first = in.nextInt();
            in.nextLine();
            records.set(pointer, first);

            System.out.println(length - pointer);
            System.out.flush();
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

    private int findC(Integer pos) {
        if (pos == null) {
            System.out.println(1);
            System.out.flush();
            in.nextLine();
            return -1;
        } else {
            System.out.println(pos + 1);
            System.out.flush();
            int currentD = in.nextInt();
            in.nextLine();
            return currentD;
        }
    }

    private List<Integer> complement(List<Integer> records) {
        for (int i = 0; i < records.size(); i++) {
            records.set(i, (records.get(i) + 1) % 2);
        }
        return records;
    }

    private void printRecords(List<Integer> records) {
        for (int record : records) {
            System.out.print(record);
        }
        System.out.println();
        System.out.flush();
    }

    private List<Integer> repairRecords(List<Integer> records, Integer posSam, Integer posDiff, int currentS, int currentD) {
        boolean nothingHappened = (posSam == null && posDiff == null) ||
                                  (posSam == null && numDiff == currentD) ||
                                  (posDiff == null && numSam == currentS) ||
                                  (numSam == currentS && numDiff == currentD);

        boolean swapHappened = (posSam == null && numDiff != currentD) ||
                               (numSam == currentS && numDiff != currentD);

        boolean complementHappened = (posDiff == null && numSam != currentS) ||
                                     (numSam != currentS && numDiff != currentD);

        boolean complementAndSwapHappened = (numSam != currentS && numDiff == currentD);

        if (nothingHappened) {
            return records;
        } else if (swapHappened) {
            Collections.reverse(records);
            numDiff = currentD;
        } else if (complementHappened) {
            records = complement(records);
            numSam = currentS;
            numDiff = currentD;
        } else if (complementAndSwapHappened) {
            Collections.reverse(records);
            records = complement(records);
            numSam = currentS;
        }

        return records;
    }
}