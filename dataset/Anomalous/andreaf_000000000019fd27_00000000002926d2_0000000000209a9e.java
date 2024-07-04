import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCase = sc.nextInt();
            int numberOfBits = sc.nextInt();
            for (int test = 0; test < numberOfTestCase; test++) {
                String answer = numberOfBits == 10 ? handleSimpleTestSet(sc) : handleMediumTestSet(sc);
                System.out.println(answer);
                if (sc.next().equals("N")) {
                    return;
                }
            }
        }
    }

    private static String handleSimpleTestSet(Scanner sc) {
        int[] bits = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            bits[i] = Integer.parseInt(sc.next());
        }
        return convertBitsToString(bits);
    }

    private static String handleMediumTestSet(Scanner sc) {
        int[] outerBits = new int[10];
        retrieveBits(sc, outerBits, 1, 5);
        retrieveBits(sc, outerBits, 16, 10);

        int[] firstHalf = new int[5];
        retrieveBits(sc, firstHalf, 1, 5);

        outerBits = applyChange(determineChange(firstHalf, outerBits), outerBits);

        int[] previousHalf = new int[5];
        retrieveBits(sc, previousHalf, 6, 5);

        int[] innerBits = new int[10];
        retrieveBits(sc, innerBits, 6, 10);

        outerBits = applyChange(determineChange(previousHalf, innerBits), outerBits);

        int[] result = new int[20];
        System.arraycopy(outerBits, 0, result, 0, 5);
        System.arraycopy(innerBits, 0, result, 5, 10);
        System.arraycopy(outerBits, 5, result, 15, 5);

        return convertBitsToString(result);
    }

    private static void retrieveBits(Scanner sc, int[] bits, int startPosition, int length) {
        for (int i = 0; i < length; i++) {
            System.out.println(startPosition + i);
            bits[startPosition + i - 1] = Integer.parseInt(sc.next());
        }
    }

    private static Change determineChange(int[] firstHalf, int[] mask) {
        if (Arrays.equals(firstHalf, Arrays.copyOf(mask, firstHalf.length))) {
            return Change.NO_CHANGE;
        }
        if (Arrays.equals(firstHalf, reverse(mask, firstHalf.length))) {
            return Change.REVERSED;
        }
        if (Arrays.equals(firstHalf, complement(mask, firstHalf.length))) {
            return Change.COMPLEMENTED;
        }
        return Change.COMPLEMENTED_AND_REVERSED;
    }

    private static int[] reverse(int[] array, int length) {
        int[] reversed = new int[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    private static int[] complement(int[] array, int length) {
        int[] complemented = new int[length];
        for (int i = 0; i < length; i++) {
            complemented[i] = array[i] == 0 ? 1 : 0;
        }
        return complemented;
    }

    private static int[] applyChange(Change change, int[] mask) {
        return change.transform(mask);
    }

    private static String convertBitsToString(int[] bits) {
        return Arrays.stream(bits).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }

    enum Change {
        NO_CHANGE {
            @Override
            public int[] transform(int[] mask) {
                return mask;
            }
        },
        REVERSED {
            @Override
            public int[] transform(int[] mask) {
                return reverse(mask, mask.length);
            }
        },
        COMPLEMENTED {
            @Override
            public int[] transform(int[] mask) {
                return complement(mask, mask.length);
            }
        },
        COMPLEMENTED_AND_REVERSED {
            @Override
            public int[] transform(int[] mask) {
                return complement(reverse(mask, mask.length), mask.length);
            }
        };

        public abstract int[] transform(int[] mask);
    }
}