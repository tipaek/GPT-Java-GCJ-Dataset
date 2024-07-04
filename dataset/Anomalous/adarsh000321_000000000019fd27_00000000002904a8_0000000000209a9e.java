import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        PrintWriter writer = new PrintWriter(System.out);
        
        for (int test = 1; test <= testCases; test++) {
            StringBuilder bitString = new StringBuilder();
            for (int i = 0; i < bitLength; i++) {
                bitString.append("4");
            }

            int round = 1;
            int position = 0;
            int complementIndex = 0;
            int reverseIndex = 0;

            while (position < bitLength / 2) {
                if (round >= 11 && round % 10 == 1) {
                    if (complementIndex != 0) {
                        writer.println(complementIndex);
                        writer.flush();
                        char response = scanner.next().charAt(0);
                        if (response != bitString.charAt(complementIndex - 1)) {
                            for (int j = 0; j < bitLength; j++) {
                                bitString.setCharAt(j, bitString.charAt(j) == '1' ? '0' : '1');
                            }
                        }
                    } else {
                        writer.println(2);
                        writer.flush();
                    }

                    if (reverseIndex != 0) {
                        writer.println(reverseIndex);
                        writer.flush();
                        char response = scanner.next().charAt(0);
                        if (response != bitString.charAt(reverseIndex - 1)) {
                            bitString.reverse();
                        }
                    } else {
                        writer.println(2);
                        writer.flush();
                    }
                } else {
                    writer.println(position + 1);
                    writer.flush();
                    String response = scanner.next();
                    bitString.setCharAt(position, response.charAt(0));

                    int mirrorPosition = bitLength - position;
                    writer.println(mirrorPosition);
                    writer.flush();
                    response = scanner.next();
                    bitString.setCharAt(mirrorPosition - 1, response.charAt(0));

                    if (bitString.charAt(position) == bitString.charAt(mirrorPosition - 1)) {
                        complementIndex = position + 1;
                    } else {
                        reverseIndex = position + 1;
                    }
                    position++;
                }
                round += 2;
            }

            writer.println(bitString);
            writer.flush();
            String verification = scanner.next();
            if (verification.equals("N")) {
                return;
            }
        }
    }
}