import java.io.*;
import java.util.*;

public class Solution {

    static int depth = 0;
    static int[] diag = new int[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCases = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        boolean errorOccurred = false;

        for (int i = 0; i < numCases; i++) {
            int[] array = new int[size];
            Arrays.fill(array, -1);

            int currentQuery = 0;
            int counter = 0;
            int sameIndex = -1; // Index of bits that are the same
            int diffIndex = -1; // Index of bits that are different

            while (counter < array.length) {
                if (currentQuery % 10 == 0 && currentQuery != 0) {
                    if (sameIndex != -1) {
                        if (processQuery(br, array, sameIndex)) {
                            errorOccurred = true;
                            break;
                        }
                        currentQuery++;
                    }
                    if (diffIndex != -1) {
                        if (processQuery(br, array, diffIndex)) {
                            errorOccurred = true;
                            break;
                        }
                        currentQuery++;
                    }
                }

                if (counter % 2 == 0) {
                    System.out.println(counter / 2 + 1);
                } else {
                    System.out.println(array.length - counter / 2);
                }

                if (processResponse(br, array, counter)) {
                    errorOccurred = true;
                    break;
                }

                if (counter % 2 != 0) {
                    updateIndices(array, counter, sameIndex, diffIndex);
                }

                currentQuery++;
                counter++;
            }

            if (errorOccurred) {
                break;
            }

            printArray(array);

            if (br.readLine().charAt(0) == 'N') {
                System.out.println("Darn it");
                errorOccurred = true;
                break;
            }
        }
    }

    private static boolean processQuery(BufferedReader br, int[] array, int index) throws IOException {
        System.out.println(index + 1);
        String response = br.readLine();
        if (response.charAt(0) == 'N') {
            System.out.println("Darn it");
            return true;
        }
        int value = Integer.parseInt(response);
        if (array[index] != value) {
            invertArray(array);
        }
        return false;
    }

    private static boolean processResponse(BufferedReader br, int[] array, int counter) throws IOException {
        String response = br.readLine();
        if (response.charAt(0) == 'N') {
            System.out.println("Darn it");
            return true;
        }
        int value = Integer.parseInt(response);
        if (counter % 2 == 0) {
            array[counter / 2] = value;
        } else {
            array[array.length - counter / 2 - 1] = value;
        }
        return false;
    }

    private static void updateIndices(int[] array, int counter, int sameIndex, int diffIndex) {
        int leftIndex = counter / 2;
        int rightIndex = array.length - counter / 2 - 1;
        if (sameIndex == -1 && array[leftIndex] == array[rightIndex]) {
            sameIndex = leftIndex;
        }
        if (diffIndex == -1 && array[leftIndex] != array[rightIndex]) {
            diffIndex = leftIndex;
        }
    }

    private static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    private static void reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - i - 1] = array[i];
        }
        System.arraycopy(reversed, 0, array, 0, array.length);
    }

    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value);
        }
        System.out.println(sb.toString());
    }
}