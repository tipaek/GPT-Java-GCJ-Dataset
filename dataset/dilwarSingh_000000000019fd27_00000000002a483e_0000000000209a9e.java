import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int t = s.nextInt();
        int b = s.nextInt();

        String rep = "Y";
        for (int i = 0; i < t && rep.equals("Y"); i++) {
            if (b == 10) {
                System.out.println(getB10());
                System.out.flush();
                s.nextLine();
                rep = s.nextLine().trim();
            } else if (b == 20) {
                System.out.println(getB20());
                System.out.flush();
                s.nextLine();
                rep = s.nextLine().trim();
            }
        }
    }

    private static String getB10() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = readCharAt(i);

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x);
        return sb.toString();
    }

    static int[] mid10 = new int[10];
    static int[] next5 = new int[5];

    private static String getB20() {
        int[] arr = new int[20];
        mid10 = new int[10];
        next5 = new int[5];

        for (int i = 0; i < 10; i++) {
            arr[i + 5] = readCharAt(i + 5);
            mid10[i] = arr[i + 5];
        }
        int state = computeChange(10);

        if (state == 1) {
            arr = complementArray(arr);
            mid10 = complementArray(mid10);
        } else if (state == 2) {
            arr = reverseArray(arr);
            mid10 = reverseArray(mid10);
        } else if (state == 3) {
            arr = complementAndReverse(arr);
            mid10 = complementAndReverse(mid10);
        }
        for (int i = 0; i < 5; i++) arr[i] = readCharAt(i);

        state = computeChange(10);

        if (state == 1) {
            arr = complementArray(arr);
            mid10 = complementArray(mid10);
            for (int i = 15; i < 20; i++) arr[i] = readCharAt(i);
        } else if (state == 2) {
            arr = reverseArray(arr);
            mid10 = reverseArray(mid10);
            for (int i = 0; i < 5; i++) arr[i] = readCharAt(i);
        } else if (state == 3) {
            arr = complementAndReverse(arr);
            mid10 = complementAndReverse(mid10);
            for (int i = 0; i < 5; i++) arr[i] = readCharAt(i);
        } else {
            for (int i = 15; i < 20; i++) arr[i] = readCharAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x);
        return sb.toString();
    }

    private static int computeChange(int mid) {
        int ii = 0;
        for (int i = mid - 5; i < mid; i++) next5[ii++] = readCharAt(i);

        int[] comp = complementArray(Arrays.copyOf(next5, next5.length));
        int[] rev = reverseArray(Arrays.copyOf(next5, next5.length));
        int[] revComp = complementAndReverse(Arrays.copyOf(next5, next5.length));

        if (Arrays.equals(comp, Arrays.copyOfRange(mid10, 0, 5))) return 1;
        else if (Arrays.equals(rev, Arrays.copyOfRange(mid10, 5, 10))) return 2;
        else if (Arrays.equals(revComp, Arrays.copyOfRange(mid10, 5, 10))) return 3;
        return 4;
    }

    private static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    private static int[] complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (temp == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

   private static int[] complementAndReverse(int[] array) {
        return complementArray(reverseArray(array));
    }

    private static int readCharAt(int x) {
        System.out.println(x + 1);
        System.out.flush();
        return s.nextInt();
    }
}