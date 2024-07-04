import java.io.*;
import java.util.*;

public class Quantum {

    static int depth = 0;
    static int[] diag = new int[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCases = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        boolean darnIt = false;

        for (int i = 0; i < numCases; i++) {
            int[] array = new int[size];
            Arrays.fill(array, -1);

            int currentQuery = 0;
            int counter = 0;
            int invIndex = -1; // find bits that are the same
            int revIndex = -1; // find bits that are different

            while (counter < array.length) {
                if (currentQuery % 10 == 0 && currentQuery != 0) {
                    if (invIndex != -1) {
                        queryAndUpdateArray(br, array, invIndex, true);
                        currentQuery++;
                    }
                    if (revIndex != -1) {
                        queryAndUpdateArray(br, array, revIndex, false);
                        currentQuery++;
                    }
                }

                if (counter % 2 == 0) {
                    System.out.println(counter / 2 + 1);
                } else {
                    System.out.println(array.length - counter / 2);
                }

                String line = br.readLine();
                if (line.charAt(0) == 'N') {
                    System.out.println("Darn it");
                    darnIt = true;
                    break;
                }

                int value = Integer.parseInt(line);
                updateArray(array, counter, value);

                if (counter % 2 != 0) {
                    updateIndexes(array, counter, invIndex, revIndex);
                }

                currentQuery++;
                counter++;
            }

            if (darnIt) {
                break;
            }

            printArray(array);
            String line = br.readLine();
            if (line.charAt(0) == 'N') {
                System.out.println("Darn it");
                darnIt = true;
                break;
            }
        }
    }

    private static void queryAndUpdateArray(BufferedReader br, int[] array, int index, boolean invertCheck) throws IOException {
        System.out.println(index + 1);
        String line = br.readLine();
        if (line.charAt(0) == 'N') {
            System.out.println("Darn it");
            return;
        }
        int value = Integer.parseInt(line);
        if (invertCheck && array[index] != value) {
            invertArray(array);
        } else if (!invertCheck && array[index] != value) {
            reverseArray(array);
        }
    }

    private static void updateArray(int[] array, int counter, int value) {
        if (counter % 2 == 0) {
            array[counter / 2] = value;
        } else {
            array[array.length - counter / 2 - 1] = value;
        }
    }

    private static void updateIndexes(int[] array, int counter, int invIndex, int revIndex) {
        if (invIndex == -1 && array[array.length - counter / 2 - 1] == array[counter / 2]) {
            invIndex = counter / 2;
        }
        if (revIndex == -1 && array[array.length - counter / 2 - 1] != array[counter / 2]) {
            revIndex = counter / 2;
        }
    }

    private static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    private static void reverseArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }

    private static void printArray(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }
        System.out.println(result);
    }
}