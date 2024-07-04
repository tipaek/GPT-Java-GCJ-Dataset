import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int[] bitArray = new int[B];
        
        for (int i = 1; i <= T; i++) {
            processBits(B, bitArray);
        }
    }

    private static void processBits(int B, int[] bitArray) {
        int P;

        for (int i = 0; i < B / 2; i++) {
            P = i + 1;
            System.out.println(P);
            bitArray[P - 1] = scanner.nextInt();
            P = B - i;
            System.out.println(P);
            bitArray[P - 1] = scanner.nextInt();
        }

        int times = 41 - (B % 40);
        int numTeams = B / 10;
        int[] representors = new int[numTeams];
        
        for (int i = 0; i < times - 1; i++) {
            int representorIndex = i % 10 % numTeams; 
            P = representorIndex * 5 + 1;
            System.out.println(P);
            representors[representorIndex] = scanner.nextInt();
        }

        System.out.println(1);
        scanner.nextInt();

        for (int representorIndex = 0; representorIndex < numTeams; representorIndex++) {
            int valueOfRepresentor = representors[representorIndex];

            if (valueOfRepresentor != bitArray[representorIndex * 5]) {
                for (int j = 0; j < 5; j++) {
                    int leftIndex = representorIndex * 5 + j;
                    int rightIndex = (B - 1 - representorIndex * 5) - j;

                    bitArray[leftIndex] = (bitArray[leftIndex] + 1) % 2;
                    bitArray[rightIndex] = (bitArray[rightIndex] + 1) % 2;
                }
            }
        }

        StringBuilder bitString = new StringBuilder();
        for (int bit : bitArray) {
            bitString.append(bit);
        }

        String result = bitString.toString();
        System.out.println(result);

        String response = scanner.next();
        if (response.charAt(0) == 'N') {
            StringBuilder flippedBitString = new StringBuilder();
            for (int bit : bitArray) {
                flippedBitString.append((bit + 1) % 2);
            }
            String flippedResult = flippedBitString.toString();
            System.out.println(flippedResult);
            scanner.nextInt();
        }
    }
}