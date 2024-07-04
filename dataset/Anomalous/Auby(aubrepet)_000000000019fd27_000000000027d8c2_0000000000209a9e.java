import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        int length = in.nextInt();
        in.nextLine();
        
        for (int i = 0; i < tests; i++) {
            runOneTest(length);
            if (!in.nextLine().equals("Y")) {
                break;
            }
        }
    }

    private void runOneTest(int length) {
        System.out.println("1");
        in.nextLine();

        List<Integer> records = new ArrayList<>(Collections.nCopies(length, 0));

        Integer posSame = null;
        Integer posDiff = null;
        int numSame = -1;
        int numDiff = -1;
        int round = 2;
        int pointer = 0;

        while (round <= 150) {
            if (round % 10 == 2) {
                int currentSame = findControl(posSame);
                int currentDiff = findControl(posDiff);
                round += 2;
                records = repairRecords(records, posSame, posDiff, numSame, numDiff, currentSame, currentDiff);
                continue;
            }

            if (pointer == length / 2) {
                round++;
                System.out.println("1");
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

            if (posSame == null && first == second) {
                posSame = pointer;
                numSame = first;
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

    private int findControl(Integer pos) {
        if (pos == null) {
            System.out.println("1");
            in.nextLine();
            return -1;
        } else {
            System.out.println(pos + 1);
            int control = in.nextInt();
            in.nextLine();
            return control;
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
    }

    private List<Integer> repairRecords(List<Integer> records, Integer posSame, Integer posDiff, int numSame, int numDiff, int currentSame, int currentDiff) {
        if (posSame == null && posDiff == null) {
            // Nothing happened
        } else if (posSame == null && numDiff == currentDiff) {
            // Nothing happened
        } else if (posDiff == null && numSame == currentSame) {
            // Nothing happened
        } else if (posSame == null && numDiff != currentDiff) {
            // Swap happened
            Collections.reverse(records);
        } else if (posDiff == null && numSame != currentSame) {
            // Complement happened
            records = complement(records);
        } else if (numSame == currentSame && numDiff == currentDiff) {
            // Nothing happened
        } else if (numSame != currentSame && numDiff == currentDiff) {
            // Complement and swap happened
            Collections.reverse(records);
            records = complement(records);
        } else if (numSame == currentSame && numDiff != currentDiff) {
            // Swap happened
            Collections.reverse(records);
        } else if (numSame != currentSame && numDiff != currentDiff) {
            // Complement happened
            records = complement(records);
        }
        return records;
    }
}