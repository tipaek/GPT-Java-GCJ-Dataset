import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        int B = in.nextInt();
        int bitArray[] = new int[B];
        int resultBitArray[] = new int[B];
        for (int i = 1; i <= T; i++) {
            secret(B, bitArray, resultBitArray);
//            System.out.println("Case #" + i + ": " + secret(B));
        }
    }

    private static void secret(int B, int[] bitArray, int[] resultBitArray) {
        // I print P, in [1,B], where I search for bit value
//        int countQueriesMade = 0;
//        int P = 1;
//        System.out.println(P); // Check if ln or without
        // Response is R, the value (Or N if error... DON"T DO ERROR.. or THINK)

        // Output 1 line String B characters, of 0/1, currently stored in array

        int P;

        for (int i = 0; i < B / 2; i++) {
            P = i + 1;
            System.out.println(P);
            bitArray[P - 1] = in.nextInt();
            P = B - i;
            System.out.println(P);
            bitArray[P - 1] = in.nextInt();
        }

        int NUM_TEAMS = B / 10;

        int[] representors = new int[NUM_TEAMS];
        for (int i = 0; i < NUM_TEAMS; i++) { // Print to get cycle of queries, divided by 4 (25% of the time) :)
            // x1-x9 | (x+1)0
            // + 9 to (x+1)0-8 | (x+1)9
            // % 10 to 0-8 | 9 (Which is 0-9 now)
            int representorIndex = i % 10 % NUM_TEAMS;
            P = representorIndex * 5 + 1; // 1,6,... Let's print!
            System.out.println(P);
            representors[representorIndex] = in.nextInt();
        }

        // Represntor, ensures all 9 brothers in set, flip if necessary, just like him!
        for (int type = 0; type < 4; type++) {

            StringBuilder currentBitStringArray = new StringBuilder();

            for (int represntorIndex = 0; represntorIndex < NUM_TEAMS; represntorIndex++) {
                int valueOfRepresentor = representors[represntorIndex];
                boolean isValSame = valueOfRepresentor == bitArray[represntorIndex * 5]; //
                /*
                    If true:
                        xy will stay xy
                        00 -> 00
                        01 -> 01
                        10 -> 10
                        11 -> 11
                    Else false:
                        xy will change to (x+1)%2 (y+1)%2
                        00 -> 11
                        01 -> 10
                        10 -> 01
                        11 -> 11
                 */

                for (int j = 0; j < 5; j++) {
                    int leftIndexInBitArray = represntorIndex * 5 + j;
                    int rightIndexInBitArray = (B - 1 - represntorIndex * 5) - j;

                    if (isValSame) {
                        resultBitArray[leftIndexInBitArray] = bitArray[leftIndexInBitArray];
                        resultBitArray[rightIndexInBitArray] = bitArray[rightIndexInBitArray];
                    }
                    switch (type) {
                        case 0: // xy will stay xy
                            break;
                        case 1: // xy will become yx
                            resultBitArray[leftIndexInBitArray] = bitArray[rightIndexInBitArray];
                            resultBitArray[rightIndexInBitArray] = bitArray[leftIndexInBitArray];
                            break;
                        case 2: // xy will become ~x~y
                            resultBitArray[leftIndexInBitArray] = (bitArray[leftIndexInBitArray] + 1) % 2;
                            resultBitArray[rightIndexInBitArray] = (bitArray[rightIndexInBitArray] + 1) % 2;
                            break;
                        case 3: // xy will become ~y~x
                            resultBitArray[leftIndexInBitArray] = (bitArray[rightIndexInBitArray] + 1) % 2;
                            resultBitArray[rightIndexInBitArray] = (bitArray[leftIndexInBitArray] + 1) % 2;
                            break;
                    }
                }
            }
            for (int bit : resultBitArray) {
                currentBitStringArray.append(bit);
            }
            String result = currentBitStringArray.toString();
            System.out.println(result);
            // Attemp result

            String testResponse = in.next(); // Received Y/N :), Should be y, at some point
            if (testResponse.charAt(0) == 'Y')
                return;
        }

        System.exit(0); // Failure error test doesn't run forever
    }
}
