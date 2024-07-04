import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int bits = scanner.nextInt();


        for (int test = 0; test < numberOfTestCases; test++) {
            int[] bitArray = new int[bits];
            boolean[] knownVisited = new boolean[bits];

            int[] bitArrayComplemented = new int[bits];
            boolean[] knownVisitedComplemented = new boolean[bits];

            int[] bitArrayReversed = new int[bits];
            boolean[] knownVisitedReversed = new boolean[bits];

            int[] bitArrayBoth = new int[bits];
            boolean[] knownVisitedBoth = new boolean[bits];

            for (int query = 1; query <= 150; query++) {
                Random random = new Random();
                // this is the position we request for from the judge
                int randomNumber = random.nextInt(bits) + 1;
                System.out.println(randomNumber);
                int numberAtPosition = scanner.nextInt();

                if (query % 10 == 1) {
                    // quantum fluctuation occurs
                    if (knownVisited[randomNumber]) {
                        Pair complemented = complementBitArray(bitArray, knownVisited);
                        Pair reversed = reverseBitArray(bitArray, knownVisited);
                        Pair both = complementAndReverseBitArray(bitArray, knownVisited);

                        bitArrayComplemented = complemented.fst;
                        bitArrayReversed = reversed.fst;
                        bitArrayBoth = both.fst;

                        knownVisitedComplemented = complemented.snd;
                        knownVisitedReversed = reversed.snd;
                        knownVisitedBoth = both.snd;
                    }
                } else {
                    if (knownVisited[randomNumber]) {
                        if ((bitArrayComplemented[randomNumber] == numberAtPosition) && (knownVisitedComplemented[randomNumber])) {
                            bitArray = bitArrayComplemented;
                            knownVisited = knownVisitedComplemented;
                        } else if ((bitArrayReversed[randomNumber] == numberAtPosition) && (knownVisitedReversed[randomNumber])) {
                            bitArray = bitArrayReversed;
                            knownVisited = knownVisitedReversed;
                        } else if ((bitArrayBoth[randomNumber] == numberAtPosition) && (knownVisitedBoth[randomNumber])) {
                            bitArray = bitArrayBoth;
                            knownVisited = knownVisitedBoth;
                        }
                    }
                    // no fluctuation occurs
                    bitArray[randomNumber] = numberAtPosition;
                    knownVisited[randomNumber] = true;
                }
            }

            String result = Arrays.toString(bitArray);
            System.out.println(result);
            String judgeResponse = scanner.next();
            if (judgeResponse == "N") {
                break;
            }
        }
    }

    private static Pair complementBitArray(int[] bitArray, boolean[] knownVisited) {
        for(int v = 0; v < bitArray.length; v++) {
            if (knownVisited[v]) {
                bitArray[v] = bitArray[v] == 0 ? 1 : 0;
            }
        }
        return new Pair(bitArray, knownVisited);
    }

    private static Pair reverseBitArray(int[] bitArray, boolean[] knownVisited) {
        for (int v = 0; v < bitArray.length/2; v++) {
            int index = bitArray.length - (v + 1);

            int temp = bitArray[v];
            boolean tempVisited = knownVisited[v];

            bitArray[v] = bitArray[index];
            knownVisited[v] = knownVisited[index];

            bitArray[index] = temp;
            knownVisited[index] = tempVisited;
        }
        return new Pair(bitArray, knownVisited);
    }

    private static Pair complementAndReverseBitArray(int[] bitArray, boolean[] knownVisited) {
        Pair pair = complementBitArray(bitArray, knownVisited);
        pair = reverseBitArray(pair.fst, pair.snd);
        return pair;
    }

    static class Pair {
        int[] fst;
        boolean[] snd;
        Pair(int[] first, boolean[] second) {
            this.fst = first;
            this.snd = second;
        }
    }
}
