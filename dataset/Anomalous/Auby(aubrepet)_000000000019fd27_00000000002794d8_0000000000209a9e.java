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
            System.out.println("0"); // Skip the first move
            in.nextLine();

            List<Integer> records = new ArrayList<>(Collections.nCopies(length, 0));

            Integer posSame = null;
            Integer posDiff = null;
            int numSame = -1;
            int numDiff = -1;
            int round = 2;
            int pointer = 0;

            while (round < 150) {
                if (round % 10 == 2) {
                    int currentSame = -1;
                    int currentDiff = -1;

                    if (posSame == null) {
                        System.out.println("0");
                        in.nextLine();
                    } else {
                        System.out.println(posSame);
                        currentSame = in.nextInt();
                        in.nextLine();
                    }

                    if (posDiff == null) {
                        System.out.println("0");
                        in.nextLine();
                    } else {
                        System.out.println(posDiff);
                        currentDiff = in.nextInt();
                        in.nextLine();
                    }

                    round += 2;

                    if (posSame == null && posDiff == null) {
                        continue;
                    } else if (posSame == null && numDiff == currentDiff) {
                        continue;
                    } else if (posDiff == null && numSame == currentSame) {
                        continue;
                    } else if (posSame == null && numDiff != currentDiff) {
                        Collections.reverse(records);
                    } else if (posDiff == null && numSame != currentSame) {
                        records = complement(records);
                    } else if (numSame == currentSame && numDiff == currentDiff) {
                        continue;
                    } else if (numSame != currentSame && numDiff == currentDiff) {
                        Collections.reverse(records);
                        records = complement(records);
                    } else if (numSame == currentSame && numDiff != currentDiff) {
                        Collections.reverse(records);
                    } else if (numSame != currentSame && numDiff != currentDiff) {
                        records = complement(records);
                    }

                    continue;
                }

                if (pointer == length / 2) {
                    round++;
                    System.out.println("0");
                    in.nextLine();
                    continue;
                }

                System.out.println(pointer);
                int first = in.nextInt();
                in.nextLine();
                records.set(pointer, first);

                System.out.println(length - pointer - 1);
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
            String result = in.nextLine();
            if (result.equals("N")) {
                break;
            }
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
}