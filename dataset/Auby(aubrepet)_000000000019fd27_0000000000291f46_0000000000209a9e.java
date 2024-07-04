import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {
    
    int numSam;
    int numDiff;
    
    Scanner in;

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        int lenght = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            runOneTest(lenght);
            String result = in.nextLine();
            if (!result.equals("Y")) { // wrong answer
                break;
            }
        }

    }

    private void runOneTest(int lenght) {
        System.out.println(1); // get rid of unuseful first move
        System.out.flush();
        in.nextLine();

        List<Integer> records = new ArrayList<>(Collections.nCopies(lenght, 0));

        Integer posSam = null;
        Integer posDiff = null;
        numSam = -1;
        numDiff = -1;
        int round = 2;
        int pointer = 0;
        while (round <= 150) {
            printRecords(records);
            //fixing after alter
            if (round % 10 == 2) {
                // read two control bites
                int currentS = findC(posSam);
                int currentD = findC(posDiff);
                round += 2;
                //repair array
                records = repairRecords(records, posSam, posDiff, currentS, currentD);
                continue;
            }
            //already know whole array
            if (pointer == lenght / 2) {
                round++;
                System.out.println(1);
                System.out.flush();
                in.nextLine();
                continue;
            }
            //read pair
            System.out.println(pointer + 1);
            System.out.flush();
            int first = in.nextInt();
            in.nextLine();
            records.set(pointer, first);
            System.out.println(lenght - pointer);
            System.out.flush();
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
    }

    private int findC(Integer pos) {
        int currentD = -1;
        if (pos == null) {
            System.out.println(1);
            System.out.flush();
            in.nextLine();
        } else {
            System.out.println(pos + 1);
            System.out.flush();
            currentD = in.nextInt();
            in.nextLine();
        }
        return currentD;
    }

    private List<Integer> complement(List<Integer> records) {
        for (int i = 0; i < records.size(); i++) {
            records.set(i, (records.get(i) + 1) % 2);
        }
        return records;
    }

    private void printRecords(List<Integer> records) {
        for (int i = 0; i < records.size(); i++) {
            System.out.print(records.get(i));
        }
        System.out.println("");
        System.out.flush();
    }

    private List<Integer> repairRecords(List<Integer> records, Integer posSam, Integer posDiff, int currentS, int currentD) {
        if (posSam == null && posDiff == null) {// nothing happend
        } else if (posSam == null && numDiff == currentD) { // nothing happend
        } else if (posDiff == null && numSam == currentS) { // nothing happend
        } else if (posSam == null && numDiff != currentD) { // swap happend
            Collections.reverse(records);
            numDiff = currentD;
        } else if (posDiff == null && numSam != currentS) { // complment happend
            records = complement(records);
            numSam = currentS;
        } else if (numSam == currentS && numDiff == currentD) { // nothing happend
        } else if (numSam != currentS && numDiff == currentD) { // complment and swap happend
            Collections.reverse(records);
            records = complement(records);
            numSam = currentS;
        } else if (numSam == currentS && numDiff != currentD) { // swap happend
            Collections.reverse(records);
            numDiff = currentD;
        } else if (numSam != currentS && numDiff != currentD) { // complment happend
            records = complement(records);
            numSam = currentS;
            numDiff = currentD;
        }
        return records;
    }
}
