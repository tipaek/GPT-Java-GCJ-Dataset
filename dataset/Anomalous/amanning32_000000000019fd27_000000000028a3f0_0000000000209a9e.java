import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    private static boolean finished;
    private static int numQueries;
    private static int[] array;
    private static boolean explore;
    private static int increment;
    private static int search;
    private static int[] lastChange;
    private static int lastRec;
    private static int numBits;
    private static Scanner scan;

    static {
        finished = false;
        numQueries = 0;
        explore = true;
        increment = 0;
        search = 1;
        lastChange = new int[]{0, 0, 0, 0};
        lastRec = 1;
    }

    private static void explore() {
        System.out.println(search);
        int input = scan.nextInt();
        array[search] = input;
        numQueries++;

        if (search == array.length / 2 + 1) {
            finished = true;
        }

        lastRec = search > numBits / 2 ? numBits + 1 - search : search - 1;

        search = numBits + 1 - search + increment;
        increment = (increment + 1) % 2;

        if (numQueries % 10 == 0) {
            explore = false;
            Arrays.fill(lastChange, 1);
        }
    }

    private static void investigate() {
        int iter = 0;
        int lookAt = 1;

        while (iter < 10 && Arrays.stream(lastChange).sum() > 1) {
            System.out.println(lookAt);
            int input = scan.nextInt();
            numQueries++;

            if (array[lookAt] == input) {
                lastChange[0] = 0;
            } else {
                lastChange[3] = 0;
            }

            if (array[numBits + 1 - lookAt] == input) {
                lastChange[2] = 0;
            } else {
                lastChange[1] = 0;
            }

            lookAt++;
            iter++;
        }

        if (iter == 10 || Arrays.stream(lastChange).sum() != 1) {
            System.err.println("Error: could not determine change");

            array = new int[numBits + 1];
            numQueries = 0;
            finished = false;
            explore = true;
            increment = 0;
            search = 1;
            lastRec = 1;
        } else {
            if (lastChange[0] == 1) {
                complement();
            } else if (lastChange[1] == 1) {
                reverse();
            } else if (lastChange[2] == 1) {
                complement();
                reverse();
            }

            explore = true;
        }
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        numBits = scan.nextInt();

        for (int j = 0; j < numTests; j++) {
            array = new int[numBits + 1];

            System.out.println(search);
            int input = scan.nextInt();
            array[search] = input;
            numQueries++;
            search = numBits + 1 - search + increment;
            increment = (increment + 1) % 2;

            while (!finished) {
                if (!explore) {
                    investigate();
                } else {
                    explore();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= numBits; i++) {
                result.append(array[i] == 0 ? '0' : '1');
            }

            System.out.println(result.toString());
            scan.nextLine();

            String confirmation = scan.nextLine();
            if (confirmation.charAt(0) == 'N') {
                System.err.println("Error in output.");
                return;
            } else {
                resetState();
            }
        }
    }

    private static void reverse() {
        for (int i = 1; i <= numBits / 2; i++) {
            int temp = array[i];
            array[i] = array[numBits + 1 - i];
            array[numBits + 1 - i] = temp;
        }
    }

    private static void complement() {
        for (int i = 1; i <= numBits; i++) {
            array[i] = (array[i] + 1) % 2;
        }
    }

    private static void resetState() {
        numQueries = 0;
        finished = false;
        explore = true;
        increment = 0;
        search = 1;
        lastRec = 1;
    }
}