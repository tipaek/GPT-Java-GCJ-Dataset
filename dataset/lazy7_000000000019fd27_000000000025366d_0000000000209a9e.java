import java.io.*;
import java.util.*;

public class Solution {
    public static BufferedReader br;
    public static int B;
    public static int[] arr;
    public static int step = 4;

    public static boolean flagFound = false;
    public static int flag_leftStart;
    public static int flag_leftEnd;
    public static int flag_rightStart;
    public static int flag_rightEnd;

    public static List<Integer> indexes;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().trim().split(" ");
        int T = Integer.parseInt(inp[0]);
        B = Integer.parseInt(inp[1]);
        for (int t = 0; t < T; t++) {
            if (B == 10) {
                solveFor10();
            } else {
                solveGeneric();
            }
            System.out.flush();
        }
    }

    public static void solveGeneric() throws IOException {
        indexes = new ArrayList<>();
        for (int i = 1; i <= B; i++) {
            indexes.add(i);
        }
        int leftStart = 1;
        int leftEnd = step;
        int rightStart = B - step + 1;
        int rightEnd = B;

        while (true) {
            arr = new int[B + 1];
            for (int i = leftStart; i <= leftEnd; i++) // query Left
                arr[i] = query(i);
            for (int i = rightStart; i <= rightEnd; i++) // query Right
                arr[i] = query(i);

            // Throwaway query
            for (int i = 1; i <= (10 - (2 * step)); i++) {
                query(i);
            }

            if (leftRigthSame(leftStart, rightStart)) {
                leftStart++;
                leftEnd++;
                rightStart++;
                rightEnd++;
                if (leftStart > rightStart)
                    break;
            } else if (leftRightCompliment(leftStart, rightStart)) {
                leftStart++;
                leftEnd++;
                rightStart++;
                rightEnd++;
                if (leftStart > rightStart)
                    break;
            } else {
                flag_leftStart = leftStart;
                flag_leftEnd = leftEnd;
                flag_rightStart = rightStart;
                flag_rightEnd = rightEnd;
                flagFound = true;
                // remove indexes for these
                for (int i = leftStart; i <= leftEnd; i++) {
                    indexes.remove(Integer.valueOf(i));
                }
                for (int i = rightStart; i <= rightEnd; i++) {
                    indexes.remove(Integer.valueOf(i));
                }
                break;
            }
        }
        // System.out.println("Flag found: " + flagFound);
        if (flagFound) {
            while (indexes.size() > 0) {
                // System.out.println("--------------------------------");
                // System.out.println("Indexes size: " + indexes.size());
                // printArray(arr);
                arr = checkChange();
                // printArray(arr);
                // System.out.println("--------------------------------");

                for (int i = 1; i <= (10 - (2 * step)); i++) { // fill values
                    if (indexes.size() > 0) {
                        int x = indexes.remove(indexes.size() - 1);
                        arr[x] = query(x);
                    }
                }
            }
            printArray(arr);
            printAndCheckAnswer();
        } else {
            System.exit(1);
        }

    }

    public static int[] checkChange() throws IOException {
        // System.out.println("CHECKING CHANGE ...");
        int[] leftValues = new int[step];
        int index = 0;
        for (int i = flag_leftStart; i <= flag_leftEnd; i++) {
            leftValues[index] = query(i);
            index++;
        }

        int[] rightValues = new int[step];
        index = 0;
        for (int i = flag_rightStart; i <= flag_rightEnd; i++) {
            rightValues[index] = query(i);
            index++;
        }

        int[] originalLeft = fetchArray("left");
        int[] originalRight = fetchArray("right");

        // check if no change
        if (arrayEqual(leftValues, originalLeft) && arrayEqual(rightValues, originalRight)) {
            // System.out.println("No change");
            return arr;
        }

        // check if complimented;
        if (arrayEqual(compliment(leftValues), originalLeft) && arrayEqual(compliment(rightValues), originalRight)) {
            // System.out.println("COMPLIMENT");
            return compliment(arr);
        }

        reverseIndexes();
        // check if is reversed
        if (arrayEqual(reverse(rightValues), originalLeft) && arrayEqual(reverse(leftValues), originalRight)) {
            // System.out.println("REVERSED");
            return reverseOriginal(arr);
        }

        // System.out.println("BOTH");
        return reverseOriginal(compliment(arr)); // reverse + compliment
    }

    // left 5, and right 5 same?
    public static boolean leftRigthSame(int leftIndex, int rightIndex) {
        // left and right are same
        boolean same = true;
        for (int i = 0; i < step; i++) {
            if (arr[leftIndex + i] != arr[rightIndex + i]) {
                same = false;
                break;
            }
        }
        return same;
    }

    public static boolean leftRightCompliment(int leftIndex, int rightIndex) {
        boolean compliment = true;
        for (int i = 0; i < step; i++) {
            if (arr[leftIndex + i] != ((arr[rightIndex + step - (1 + i)] + 1) % 2)) {
                compliment = false;
                break;
            }
        }
        return compliment;
    }

    public static void solveFor10() throws IOException {
        arr = new int[11];
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        printAndCheckAnswer();
    }

    public static int query(int query) throws IOException {
        System.out.println(query);
        return Integer.parseInt(br.readLine().trim());
    }

    public static int[] reverseOriginal(int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr = reverse(tempArr);
        for (int i = arr.length - 1; i > 0; i--) {
            tempArr[i] = tempArr[i - 1];
        }
        tempArr[0] = 0;
        return tempArr;
    }

    public static int[] reverse(int[] array) {
        int length = array.length;
        int[] tempArr = new int[length];
        for (int i = 0; i < length; i++) {
            tempArr[i] = array[i];
        }
        for (int i = 0; i < length / 2; i++) {
            int temp = tempArr[i];
            tempArr[i] = tempArr[length - 1 - i];
            tempArr[length - 1 - i] = temp;
        }
        return tempArr;
    }

    public static int[] compliment(int[] array) {
        int length = array.length;
        int[] tempArr = new int[length];
        for (int i = 0; i < length; i++) {
            tempArr[i] = (array[i] + 1) % 2;
        }
        return tempArr;
    }

    public static int[] fetchArray(String which) {
        int[] tempArr = new int[step];
        int index = 0;

        if (which.compareTo("left") == 0) {
            for (int i = flag_leftStart; i <= flag_leftEnd; i++) {
                tempArr[index] = arr[i];
                index++;
            }
        } else {
            for (int i = flag_rightStart; i <= flag_rightEnd; i++) {
                tempArr[index] = arr[i];
                index++;
            }
        }
        return tempArr;
    }

    public static boolean arrayEqual(int[] a1, int[] a2) {
        int length = a1.length;
        for (int i = 0; i < length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }

    public static void printArray(int[] arr) {
        int i = 0;
        if (arr.length > B - 3)
            i = 1;
        // for (i = i; i < arr.length; i++) {
        // System.out.print(i + "\t");
        // }
        // if (arr.length > B - 3)
        // i = 1;
        // System.out.println();
        for (i = i; i < arr.length; i++) {
            // System.out.print(arr[i] + "\t");
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void printAndCheckAnswer() throws IOException {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        String verdict = br.readLine().trim();
        if (verdict.compareTo("Y") == 0) {
            // System.out.println("WOOHOO");
        } else {
            System.exit(1);
        }
    }

    public static void reverseIndexes() {
        List<Integer> newList = new ArrayList<>();
        for (int i : indexes) {
            newList.add(B - i + 1);
        }
        indexes = newList;
    }
}
