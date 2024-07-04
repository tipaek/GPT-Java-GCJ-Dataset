import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner scanner;

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int length = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            executeTest(length);
            String response = scanner.nextLine();
            if (!response.equals("Y")) {
                break;
            }
        }
    }

    private void executeTest(int length) {
        System.out.println(1);
        System.out.flush();
        scanner.nextLine();

        List<Integer> array = new ArrayList<>(Collections.nCopies(length, 0));
        Integer samePosition = null;
        Integer diffPosition = null;
        int sameValue = -1;
        int diffValue = -1;
        int round = 2;
        int index = 0;

        while (round <= 150) {
            if (round % 10 == 2) {
                int currentSame = readControlBit(samePosition);
                int currentDiff = readControlBit(diffPosition);
                round += 2;
                array = adjustArray(array, samePosition, diffPosition, sameValue, diffValue, currentSame, currentDiff);
                continue;
            }

            if (index == length / 2) {
                round++;
                System.out.println(1);
                System.out.flush();
                scanner.nextLine();
                continue;
            }

            System.out.println(index + 1);
            System.out.flush();
            int firstValue = scanner.nextInt();
            scanner.nextLine();
            array.set(index, firstValue);

            System.out.println(length - index);
            System.out.flush();
            int secondValue = scanner.nextInt();
            scanner.nextLine();
            array.set(length - index - 1, secondValue);

            if (samePosition == null && firstValue == secondValue) {
                samePosition = index;
                sameValue = firstValue;
            }
            if (diffPosition == null && firstValue != secondValue) {
                diffPosition = index;
                diffValue = firstValue;
            }

            index++;
            round += 2;
        }

        printArray(array);
    }

    private int readControlBit(Integer position) {
        int controlBit = -1;
        if (position == null) {
            System.out.println(1);
            System.out.flush();
            scanner.nextLine();
        } else {
            System.out.println(position + 1);
            System.out.flush();
            controlBit = scanner.nextInt();
            scanner.nextLine();
        }
        return controlBit;
    }

    private List<Integer> complementArray(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            array.set(i, (array.get(i) + 1) % 2);
        }
        return array;
    }

    private void printArray(List<Integer> array) {
        for (int value : array) {
            System.out.print(value);
        }
        System.out.println();
        System.out.flush();
    }

    private List<Integer> adjustArray(List<Integer> array, Integer samePosition, Integer diffPosition, int sameValue, int diffValue, int currentSame, int currentDiff) {
        if (samePosition == null && diffPosition == null) {
            // nothing happened
        } else if (samePosition == null && diffValue == currentDiff) {
            // nothing happened
        } else if (diffPosition == null && sameValue == currentSame) {
            // nothing happened
        } else if (samePosition == null && diffValue != currentDiff) {
            Collections.reverse(array);
        } else if (diffPosition == null && sameValue != currentSame) {
            array = complementArray(array);
        } else if (sameValue == currentSame && diffValue == currentDiff) {
            // nothing happened
        } else if (sameValue != currentSame && diffValue == currentDiff) {
            Collections.reverse(array);
            array = complementArray(array);
        } else if (sameValue == currentSame && diffValue != currentDiff) {
            Collections.reverse(array);
        } else if (sameValue != currentSame && diffValue != currentDiff) {
            array = complementArray(array);
        }
        return array;
    }
}