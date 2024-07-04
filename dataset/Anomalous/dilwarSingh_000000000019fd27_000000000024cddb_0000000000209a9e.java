import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int[] mid10 = new int[10];
    private static final int[] next5 = new int[5];

    public static void main(String[] args) {
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        String response = "Y";
        for (int i = 0; i < t && response.equals("Y"); i++) {
            if (b == 10) {
                System.out.println(processB10());
                System.out.flush();
                scanner.nextLine();
                response = scanner.nextLine().trim();
            } else if (b == 20) {
                System.out.println(processB20());
                System.out.flush();
                scanner.nextLine();
                response = scanner.nextLine().trim();
            }
        }
    }

    private static String processB10() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = readCharAt(i);
        }
        return arrayToString(array);
    }

    private static String processB20() {
        int[] array = new int[20];

        for (int i = 0; i < 10; i++) {
            array[i + 5] = readCharAt(i + 5);
            mid10[i] = array[i + 5];
        }

        int state = determineState(10);

        if (state == 1) {
            array = complementArray(array);
            mid10 = complementArray(mid10);
        } else if (state == 2) {
            array = reverseArray(array);
            mid10 = reverseArray(mid10);
        } else if (state == 3) {
            array = complementAndReverse(array);
            mid10 = complementAndReverse(mid10);
        }

        for (int i = 0; i < 5; i++) {
            array[i] = readCharAt(i);
        }

        state = determineState(10);

        if (state == 1) {
            array = complementArray(array);
            mid10 = complementArray(mid10);
            for (int i = 15; i < 20; i++) {
                array[i] = readCharAt(i);
            }
        } else if (state == 2) {
            array = reverseArray(array);
            mid10 = reverseArray(mid10);
            for (int i = 0; i < 5; i++) {
                array[i] = readCharAt(i);
            }
        } else if (state == 3) {
            array = complementAndReverse(array);
            mid10 = complementAndReverse(mid10);
            for (int i = 0; i < 5; i++) {
                array[i] = readCharAt(i);
            }
        }

        return arrayToString(array);
    }

    private static int determineState(int mid) {
        for (int i = 0; i < 5; i++) {
            next5[i] = readCharAt(mid - 5 + i);
        }

        int[] comp = complementArray(Arrays.copyOf(next5, next5.length));
        int[] rev = reverseArray(Arrays.copyOf(next5, next5.length));
        int[] revComp = complementAndReverse(Arrays.copyOf(next5, next5.length));

        if (Arrays.equals(comp, Arrays.copyOfRange(mid10, 0, 5))) {
            return 1;
        } else if (Arrays.equals(rev, Arrays.copyOfRange(mid10, 5, 10))) {
            return 2;
        } else if (Arrays.equals(revComp, Arrays.copyOfRange(mid10, 5, 10))) {
            return 3;
        }
        return 4;
    }

    private static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    private static int[] complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
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
        for (int value : array) {
            sb.append(value);
        }
        return sb.toString();
    }
}