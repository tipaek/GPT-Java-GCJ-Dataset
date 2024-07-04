import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        int lenght = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            System.out.println("0"); // get rid of unuseful first move
            in.nextLine();

            List<Integer> records = new ArrayList<>(Collections.nCopies(lenght, 0));

            Integer posSam = null;
            Integer posDiff = null;
            int numSam = -1;
            int numDiff = -1;
            int round = 2;
            int pointer = 0;
            while (round < 150) {
                //fixing after alter
                if (round % 10 == 2) {
                    // read two control bites
                    int currentS = -1;
                    int currentD = -1;
                    if (posSam == null) {
                        System.out.println("0");
                        in.nextLine();
                    } else {
                        System.out.println(posSam);
                        currentS = in.nextInt();
                        in.nextLine();
                    }
                    if (posDiff == null) {
                        System.out.println("0");
                        in.nextLine();
                    } else {
                        System.out.println(posDiff);
                        currentD = in.nextInt();
                        in.nextLine();
                    }
                    round += 2;

                    //repair array
                    if (posSam == null && posDiff == null) {// nothing happend
                        continue;
                    } else if (posSam == null && numDiff == currentD) { // nothing happend
                        continue;
                    } else if (posDiff == null && numSam == currentS) { // nothing happend
                        continue;
                    } else if (posSam == null && numDiff != currentD) { // swap happend
                        Collections.reverse(records);
                    } else if (posDiff == null && numSam != currentS) { // complment happend
                        records = complement(records);
                    } else if (numSam == currentS && numDiff == currentD) { // nothing happend
                        continue;
                    } else if (numSam != currentS && numDiff == currentD) { // complment and swap happend
                        Collections.reverse(records);
                        records = complement(records);
                    } else if (numSam == currentS && numDiff != currentD) { // swap happend
                        Collections.reverse(records);
                    } else if (numSam != currentS && numDiff != currentD) { // complment happend
                        records = complement(records);
                    }
                    continue;
                }
                //already know whole array
                if (pointer == lenght / 2) {
                    round++;
                    System.out.println("0");
                    in.nextLine();
                    continue;
                }
                //read pair
                System.out.println(pointer);
                int first = in.nextInt();
                in.nextLine();
                records.set(pointer, first);
                System.out.println(lenght - pointer - 1);
                int second = in.nextInt();
                in.nextLine();
                records.set(lenght - pointer - 1, second);

                //mark usefull
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
            String result = in.nextLine();
            if (result.equals("N")) { // wrong answer
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
        for (int i = 0; i < records.size(); i++) {
            System.out.print(records.get(i));;
        }
        System.out.println("");
    }
}
