import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int numberOfTests = input.nextInt();
        int numberOfBytes = input.nextInt();

        if (numberOfBytes == 10) {
            solveTen(input, numberOfTests);
        } else if (numberOfBytes == 20) {
            solveTwenty(input, numberOfTests, numberOfBytes);
        }
    }

    private static void solveTwenty(Scanner input, int numberOfTests, int numberOfBytes) {
        int outer[] = new int[10];
        int inner[] = new int[10];

        for (int test = 0; test < numberOfTests; test++) {
            int outerCount = 0;
            int innerCount = 0;

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                outer[outerCount] = input.nextInt();
                outerCount++;
            }

            for (int i = 16; i <= 20; i++) {
                System.out.println(i);
                outer[outerCount] = input.nextInt();
                outerCount++;
            }

            for (int i = 6; i <= 15; i++) {
                System.out.println(i);
                inner[innerCount] = input.nextInt();
                innerCount++;
            }

            outer = getCorrectOuter(input, outer);

            inner = getCorrectInner(input, inner);

            int bytes[] = new int[numberOfBytes];

            for (int i = 0; i < numberOfBytes; i++) {
                if (i < 5) {
                    bytes[i] = outer[i];
                } else if (i < 15) {
                    bytes[i] = inner[i - 5];
                } else {
                    bytes[i] = outer[i - 10];
                }
            }

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < numberOfBytes; i++) {
                stringBuilder.append(bytes[i]);
            }

            System.out.println(stringBuilder.toString());
            System.out.flush();

            String reply = input.next();
            if (reply.equals("N")) {
                return;
            }
        }
    }

    private static int[] getCorrectInner(Scanner input, int[] inner) {
        boolean innerFlipped = false;
        boolean innerMirrored = false;

        if (Arrays.equals(inner, getMirrored(inner)) || Arrays.equals(getFlipped(inner), getMirrored(inner))) {
            System.out.println(6);
            int result = input.nextInt();

            innerFlipped = result != inner[1];
        } else {
            int differingIndex = getDifferingIndex(inner, getMirrored(inner));

            differingIndex += 6;

            System.out.println(differingIndex);
            int result = input.nextInt();

            differingIndex -= 6;

            innerMirrored = result != inner[differingIndex];

            int conformingIndex = getConformingIndex(inner, getMirrored(inner));

            conformingIndex += 6;

            System.out.println(conformingIndex);
            result = input.nextInt();

            conformingIndex -= 6;

            if (result != inner[conformingIndex]) {
                innerFlipped = true;
                innerMirrored = !innerMirrored;
            }
        }

        if (innerFlipped) {
            inner = getFlipped(inner);
        }

        if (innerMirrored) {
            inner = getMirrored(inner);
        }
        return inner;
    }

    private static int[] getCorrectOuter(Scanner input, int[] outer) {
        boolean outerFlipped = false;
        boolean outerMirrored = false;

        if (Arrays.equals(outer, getMirrored(outer)) || Arrays.equals(getFlipped(outer), getMirrored(outer))) {
            System.out.println(1);
            int result = input.nextInt();

            outerFlipped = result != outer[1];
        } else {
            int differingIndex = getDifferingIndex(outer, getMirrored(outer));
            if (differingIndex >= 5) {
                differingIndex += 10;
            }
            differingIndex++;
            System.out.println(differingIndex);
            int result = input.nextInt();

            if (differingIndex >= 15) {
                differingIndex -= 10;
            }
            differingIndex--;

            outerMirrored = result != outer[differingIndex];

            int conformingIndex = getConformingIndex(outer, getMirrored(outer));

            if (conformingIndex >= 5) {
                conformingIndex += 10;
            }
            conformingIndex++;

            System.out.println(conformingIndex);
            result = input.nextInt();

            if (conformingIndex >= 15) {
                conformingIndex -= 10;
            }
            conformingIndex--;

            if (result != outer[conformingIndex]) {
                outerFlipped = true;
                outerMirrored = !outerMirrored;
            }
        }

        if (outerFlipped) {
            outer = getFlipped(outer);
        }

        if (outerMirrored) {
            outer = getMirrored(outer);
        }

        return outer;
    }

    private static int getConformingIndex(int[] bytes, int[] mirrored) {
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == mirrored[i]) {
                return i;
            }
        }

        System.out.println("bytes should be conforming!!!");
        return -1;
    }

    private static int getDifferingIndex(int[] bytes, int[] mirrored) {
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != mirrored[i]) {
                return i;
            }
        }

        System.out.println("bytes should be different!!!");
        return -1;
    }

    private static int[] getMirrored(int[] bytes) {
        int[] mirroredBytes = new int[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            mirroredBytes[i] = bytes[bytes.length - 1 - i];
        }

        return mirroredBytes;
    }

    private static int[] getFlipped(int[] bytes) {
        int[] mirroredBytes = new int[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            mirroredBytes[i] = bytes[i] == 0 ? 1 : 0;
        }

        return mirroredBytes;
    }

    private static void solveTen(Scanner input, int numberOfTests) {
        int bytes[] = new int[10];

        for (int test = 0; test < numberOfTests; test++) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                bytes[i] = input.nextInt();
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                stringBuilder.append(bytes[i]);
            }
            System.out.println(stringBuilder.toString());
            String reply = input.next();
            if (reply.equals("N")) {
                return;
            }
        }
    }
}
