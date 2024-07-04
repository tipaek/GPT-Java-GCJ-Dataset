import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        int B = in.nextInt();
        int bitArray[] = new int[B];
        for (int i = 1; i <= T; i++) {
            secret(B, bitArray);
//            System.out.println("Case #" + i + ": " + secret(B));
        }
    }

    private static void secret(int B, int[] bitArray) {
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
        for (int represntorIndex = 0; represntorIndex < NUM_TEAMS; represntorIndex++) {
            int valueOfRepresentor = representors[represntorIndex];

            if (valueOfRepresentor != bitArray[represntorIndex * 5]) {
                for (int j = 0; j < 5; j++) {
                    int leftIndexInBitArray = represntorIndex * 5 + j;
                    int rightIndexInBitArray = (B - 1 - represntorIndex * 5) - j;

                    bitArray[leftIndexInBitArray] = (bitArray[leftIndexInBitArray] + 1) % 2;
                    bitArray[rightIndexInBitArray] = (bitArray[rightIndexInBitArray] + 1) % 2;
                }
            }
        }

        StringBuilder currentBitStringArray = new StringBuilder();

        for (int bit : bitArray) {
            currentBitStringArray.append(bit);
        }

        String result = currentBitStringArray.toString();

        System.out.println(result);

        String firstTest = in.next(); // Received Y/N :), Should be y
        if (firstTest.charAt(0) == 'N') {
            System.exit(0); // Failure error test doesn't run forever
        }
    }
}
