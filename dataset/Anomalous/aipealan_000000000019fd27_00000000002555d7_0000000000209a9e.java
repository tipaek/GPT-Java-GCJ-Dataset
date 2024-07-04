import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        in.nextLine();

        for (int i = 0; i < t; i++) {
            char[] bitarr = new char[b];
            Arrays.fill(bitarr, 'N');
            boolean isSamePair = false, isDifferentPair = false;
            int index = 1, thresholdIndex = b, queryNo = 0;
            int[] samePairIndexes = {0, 0}, differentPairIndexes = {0, 0};

            while (!(isSamePair && isDifferentPair) && index <= thresholdIndex) {
                if (queryNo != 0 && queryNo % 10 == 0) {
                    index = 1;
                    thresholdIndex = b;
                }
                if (index == thresholdIndex) {
                    System.out.println(index);
                    bitarr[index - 1] = in.nextLine().charAt(0);
                    break;
                }
                System.out.println(index);
                bitarr[index - 1] = in.nextLine().charAt(0);
                System.out.println(thresholdIndex);
                bitarr[thresholdIndex - 1] = in.nextLine().charAt(0);
                queryNo += 2;

                if (!isSamePair && bitarr[index - 1] == bitarr[thresholdIndex - 1]) {
                    isSamePair = true;
                    samePairIndexes[0] = index - 1;
                    samePairIndexes[1] = thresholdIndex - 1;
                } else if (!isDifferentPair && bitarr[index - 1] != bitarr[thresholdIndex - 1]) {
                    isDifferentPair = true;
                    differentPairIndexes[0] = index - 1;
                    differentPairIndexes[1] = thresholdIndex - 1;
                }
                index++;
                thresholdIndex--;
            }

            while (queryNo <= 150 && index < thresholdIndex) {
                if (queryNo % 10 == 0) {
                    char[] response = {'N', 'N'};
                    System.out.println(samePairIndexes[0] + 1);
                    response[0] = in.nextLine().charAt(0);
                    System.out.println(differentPairIndexes[0] + 1);
                    response[1] = in.nextLine().charAt(0);
                    queryNo += 2;

                    if (bitarr[samePairIndexes[0]] == response[0] && bitarr[differentPairIndexes[0]] == response[1]) {
                        // No change
                    } else if (bitarr[samePairIndexes[0]] != response[0] && bitarr[differentPairIndexes[0]] != response[1]) {
                        flipBits(bitarr, 0, index);
                        flipBits(bitarr, thresholdIndex - 1, b);
                    } else if (bitarr[samePairIndexes[0]] != response[0] && bitarr[differentPairIndexes[0]] == response[1]) {
                        reverseArray(bitarr, b);
                        int temp = b - index;
                        index = b - thresholdIndex;
                        thresholdIndex = temp;
                    } else {
                        flipBits(bitarr, 0, index);
                        flipBits(bitarr, thresholdIndex - 1, b);
                        reverseArray(bitarr, b);
                        int temp = b - index;
                        index = b - thresholdIndex;
                        thresholdIndex = temp;
                    }

                } else {
                    System.out.println(index);
                    bitarr[index - 1] = in.nextLine().charAt(0);
                    index++;
                }
            }

            if (index >= thresholdIndex) {
                System.out.println(new String(bitarr));
            }
        }
    }

    private static void flipBits(char[] bitarr, int start, int end) {
        for (int i = start; i < end; i++) {
            bitarr[i] = (bitarr[i] == '0') ? '1' : '0';
        }
    }

    private static void reverseArray(char[] bitarr, int length) {
        for (int i = 0; i < length / 2; i++) {
            char temp = bitarr[i];
            bitarr[i] = bitarr[length - i - 1];
            bitarr[length - i - 1] = temp;
        }
    }
}