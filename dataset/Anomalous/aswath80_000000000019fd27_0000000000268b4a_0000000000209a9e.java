import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter output = new PrintWriter(System.out);

    private static int sendAndReceive(int pos) {
        output.print(pos);
        output.flush();
        return scanner.nextInt();
    }

    private static char sendAndReceive(int[] bitArray) {
        StringBuilder sb = new StringBuilder();
        for (int bit : bitArray) {
            sb.append(bit);
        }
        output.print(sb.toString());
        output.flush();
        return (char) scanner.nextInt();
    }

    public static void main(String[] args) {
        String[] input = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0].trim());
        int bits = Integer.parseInt(input[1].trim());
        boolean success = true;

        for (int i = 0; i < testCases && success; i++) {
            success = solve(bits);
        }
    }

    private static boolean solve(int bits) {
        int[] bitArray = new int[bits];
        int attempts = 0;
        char response = 'N';

        while (attempts < 150) {
            for (int i = 0; i < bits; i++) {
                bitArray[i] = sendAndReceive(i + 1);
            }
            response = sendAndReceive(bitArray);
            break;
        }

        return response == 'Y';
    }
}