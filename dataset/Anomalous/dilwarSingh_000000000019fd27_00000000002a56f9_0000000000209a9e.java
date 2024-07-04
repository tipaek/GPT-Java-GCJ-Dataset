import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[] mid10 = new int[10];
    private static int[] next5 = new int[5];

    public static void main(String[] args) {
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            if (b == 10) {
                processB10();
            } else if (b == 20) {
                processB20();
            }
            if (!"Y".equals(scanner.next().trim())) {
                break;
            }
        }
    }

    private static void processB10() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = readCharAt(i);
        }
        System.out.println(arrayToString(arr));
        System.out.flush();
    }

    private static void processB20() {
        int[] arr = new int[20];
        for (int i = 0; i < 10; i++) {
            arr[i + 5] = readCharAt(i + 5);
            mid10[i] = arr[i + 5];
        }

        int state = computeChangeState(10);
        adjustArray(arr, state);

        for (int i = 0; i < 5; i++) {
            arr[i] = readCharAt(i);
        }

        state = computeChangeState(10);
        adjustArray(arr, state);

        for (int i = 15; i < 20; i++) {
            arr[i] = readCharAt(i);
        }

        System.out.println(arrayToString(arr));
        System.out.flush();
    }

    private static int computeChangeState(int mid) {
        for (int i = 0; i < 5; i++) {
            next5[i] = readCharAt(i + 5);
        }

        int[] comp = complementArray(next5.clone());
        int[] rev = reverseArray(next5.clone());
        int[] revComp = complementAndReverse(next5.clone());

        if (Arrays.equals(next5, Arrays.copyOfRange(mid10, 0, 5))) return 4;
        if (Arrays.equals(revComp, Arrays.copyOfRange(mid10, 5, 10))) return 3;
        if (Arrays.equals(rev, Arrays.copyOfRange(mid10, 5, 10))) return 2;
        if (Arrays.equals(comp, Arrays.copyOfRange(mid10, 0, 5))) return 1;
        return 4;
    }

    private static void adjustArray(int[] arr, int state) {
        switch (state) {
            case 1:
                complementArray(arr);
                complementArray(mid10);
                break;
            case 2:
                reverseArray(arr);
                reverseArray(mid10);
                break;
            case 3:
                complementAndReverse(arr);
                complementAndReverse(mid10);
                break;
        }
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
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    private static int[] complementAndReverse(int[] array) {
        return complementArray(reverseArray(array));
    }

    private static int readCharAt(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return scanner.nextInt();
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int x : array) {
            sb.append(x);
        }
        return sb.toString();
    }
}