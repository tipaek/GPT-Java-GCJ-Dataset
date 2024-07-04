import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String line = in.nextLine();  // Scanner has functions to read ints, longs, strings, chars, etc.
        String[] split = line.split(" ");
        int t = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        ESAbATAd esAbATAd = new ESAbATAd(in, t, b);
        esAbATAd.query();
    }
    private static class ESAbATAd {

        private static final String PASS = "Y";
        private static final int MAX = 150;

        private int count;
        private int testCases;
        private int[] array;
        private int next;

        private boolean toContinue;

        private Scanner input;

        ESAbATAd(Scanner input, int t, int b) {
            this.input = input;
            this.count = 0;
            this.next = 0;
            this.testCases = t;
            this.array = new int[b];
            this.toContinue = true;
            Arrays.fill(this.array, -1);
        }

        void query() {
            if (count == MAX || isArrayFilled()){
                printAnswer();
            } else {
                // random quantum fluctuation may occurs
                printPosition();
                count++;
            }
            if (toContinue) {
                query();
            }
        }

        private void printPosition() {
            System.out.println(next + 1);
            int value = Integer.parseInt(input.nextLine());
            array[next] = value;
            next++;
            next %= array.length;
        }

        private void printAnswer() {
            testCases--;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : array) {
                stringBuilder.append(i);
            }
            System.out.println(stringBuilder.toString());
            String result = input.nextLine();
            if (result.equals(PASS) && testCases > 0) {
                reset();
            } else {
                toContinue = false;
            }
        }

        private void reset() {
            count = 0;
            next = 0;
            Arrays.fill(array, -1);
        }

        private boolean isArrayFilled() {
            for (int i : array) {
                if (i == -1) {
                    return false;
                }
            }
            return true;
        }
    }
}