import java.util.Scanner;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        int B = in.nextInt();
        int[] bitArray = new int[B];
        int[] resultBitArray = new int[B];

        for (int i = 1; i <= T; i++) {
            processBits(B, bitArray, resultBitArray);
        }
    }

    private static void processBits(int B, int[] bitArray, int[] resultBitArray) {
        for (int i = 0; i < B / 2; i++) {
            int P = i + 1;
            System.out.println(P);
            bitArray[P - 1] = in.nextInt();

            P = B - i;
            System.out.println(P);
            bitArray[P - 1] = in.nextInt();
        }

        int NUM_TEAMS = B / 10;
        int[] representors = new int[NUM_TEAMS];

        for (int i = 0; i < NUM_TEAMS; i++) {
            int representorIndex = i % 10 % NUM_TEAMS;
            int P = representorIndex * 5 + 1;
            System.out.println(P);
            representors[representorIndex] = in.nextInt();
        }

        for (int type = 0; type < 4; type++) {
            StringBuilder currentBitStringArray = new StringBuilder();

            for (int represntorIndex = 0; represntorIndex < NUM_TEAMS; represntorIndex++) {
                int valueOfRepresentor = representors[represntorIndex];
                boolean isValSame = valueOfRepresentor == bitArray[represntorIndex * 5];

                for (int j = 0; j < 5; j++) {
                    int leftIndexInBitArray = represntorIndex * 5 + j;
                    int rightIndexInBitArray = (B - 1 - represntorIndex * 5) - j;

                    if (isValSame) {
                        resultBitArray[leftIndexInBitArray] = bitArray[leftIndexInBitArray];
                        resultBitArray[rightIndexInBitArray] = bitArray[rightIndexInBitArray];
                    }

                    switch (type) {
                        case 0:
                            break;
                        case 1:
                            resultBitArray[leftIndexInBitArray] = bitArray[rightIndexInBitArray];
                            resultBitArray[rightIndexInBitArray] = bitArray[leftIndexInBitArray];
                            break;
                        case 2:
                            resultBitArray[leftIndexInBitArray] = (bitArray[leftIndexInBitArray] + 1) % 2;
                            resultBitArray[rightIndexInBitArray] = (bitArray[rightIndexInBitArray] + 1) % 2;
                            break;
                        case 3:
                            resultBitArray[leftIndexInBitArray] = (bitArray[rightIndexInBitArray] + 1) % 2;
                            resultBitArray[rightIndexInBitArray] = (bitArray[leftIndexInBitArray] + 1) % 2;
                            break;
                    }
                }
            }

            for (int bit : resultBitArray) {
                currentBitStringArray.append(bit);
            }

            System.out.println(currentBitStringArray.toString());

            String testResponse = in.next();
            if (testResponse.charAt(0) == 'Y') {
                return;
            }
        }

        System.exit(0);
    }
}