import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        int B = in.nextInt();
        int[] bitArray = new int[B];
        
        for (int i = 1; i <= T; i++) {
            solve(B, bitArray);
        }
    }

    private static void solve(int B, int[] bitArray) {
        int P;
        
        // Reading bits from both ends
        for (int i = 0; i < B / 2; i++) {
            P = i + 1;
            System.out.println(P);
            bitArray[P - 1] = in.nextInt();
            
            P = B - i;
            System.out.println(P);
            bitArray[P - 1] = in.nextInt();
        }

        int times = (41 - (B % 40));
        int NUM_TEAMS = B / 10;
        int[] representors = new int[NUM_TEAMS];
        
        for (int i = 0; i < times - 1; i++) {
            int representorIndex = i % 10 % NUM_TEAMS;
            P = representorIndex * 5 + 1;
            System.out.println(P);
            representors[representorIndex] = in.nextInt();
        }

        int DONT_CARE = 1;
        System.out.println(DONT_CARE);
        in.nextInt();

        for (int representorIndex = 0; representorIndex < NUM_TEAMS; representorIndex++) {
            int valueOfRepresentor = representors[representorIndex];

            if (valueOfRepresentor != bitArray[representorIndex * 5]) {
                for (int j = 0; j < 5; j++) {
                    int leftIndexInBitArray = representorIndex * 5 + j;
                    int rightIndexInBitArray = B - 1 - representorIndex * 5 - j;

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

        String firstTest = in.next();
        if (firstTest.charAt(0) == 'N') {
            StringBuilder reverseBitStringArray = new StringBuilder();
            for (int bit : bitArray) {
                reverseBitStringArray.append((bit + 1) % 2);
            }
            String flipResult = reverseBitStringArray.toString();
            System.out.println(flipResult);
            in.next();
        }
    }
}