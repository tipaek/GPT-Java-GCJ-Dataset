import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner scanner;

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int length = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < testCases; i++) {
            executeTest(length);
            String result = scanner.nextLine();
            if (!result.equals("Y")) {
                break;
            }
        }
    }

    private void executeTest(int length) {
        System.out.println(1);
        System.out.flush();
        scanner.nextLine();

        List<Integer> records = new ArrayList<>(Collections.nCopies(length, 0));
        Integer samePosition = null;
        Integer diffPosition = null;
        int sameValue = -1;
        int diffValue = -1;
        int round = 2;
        int pointer = 0;

        while (round <= 150) {
            if (round % 10 == 2) {
                int currentSame = readControlBit(samePosition);
                int currentDiff = readControlBit(diffPosition);
                round += 2;
                records = adjustRecords(records, samePosition, diffPosition, sameValue, diffValue, currentSame, currentDiff);
                continue;
            }

            if (pointer == length / 2) {
                round++;
                System.out.println(1);
                System.out.flush();
                scanner.nextLine();
                continue;
            }

            System.out.println(pointer + 1);
            System.out.flush();
            int first = scanner.nextInt();
            scanner.nextLine();
            records.set(pointer, first);

            System.out.println(length - pointer);
            System.out.flush();
            int second = scanner.nextInt();
            scanner.nextLine();
            records.set(length - pointer - 1, second);

            if (samePosition == null && first == second) {
                samePosition = pointer;
                sameValue = first;
            }

            if (diffPosition == null && first != second) {
                diffPosition = pointer;
                diffValue = first;
            }

            pointer++;
            round += 2;
        }

        printRecords(records);
    }

    private int readControlBit(Integer position) {
        if (position == null) {
            System.out.println(1);
            System.out.flush();
            scanner.nextLine();
            return -1;
        } else {
            System.out.println(position + 1);
            System.out.flush();
            int value = scanner.nextInt();
            scanner.nextLine();
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
        System.out.flush();
    }

    private List<Integer> adjustRecords(List<Integer> records, Integer samePosition, Integer diffPosition, int sameValue, int diffValue, int currentSame, int currentDiff) {
        if (samePosition == null && diffPosition == null) {
            return records;
        } else if (samePosition == null && diffValue == currentDiff) {
            return records;
        } else if (diffPosition == null && sameValue == currentSame) {
            return records;
        } else if (samePosition == null && diffValue != currentDiff) {
            Collections.reverse(records);
        } else if (diffPosition == null && sameValue != currentSame) {
            records = complement(records);
        } else if (sameValue == currentSame && diffValue == currentDiff) {
            return records;
        } else if (sameValue != currentSame && diffValue == currentDiff) {
            Collections.reverse(records);
            records = complement(records);
        } else if (sameValue == currentSame && diffValue != currentDiff) {
            Collections.reverse(records);
        } else if (sameValue != currentSame && diffValue != currentDiff) {
            records = complement(records);
        }
        return records;
    }
}