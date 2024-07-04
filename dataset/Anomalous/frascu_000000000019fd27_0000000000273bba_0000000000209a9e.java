import java.util.Scanner;

public class FourthSolution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            int bits = scanner.nextInt();

            for (int testCase = 0; testCase < testCases; testCase++) {
                char[] bitArray = new char[bits];

                for (int bitIndex = 0; bitIndex < bits; bitIndex++) {
                    System.out.println(bitIndex + 1);
                    bitArray[bitIndex] = scanner.next().charAt(0);
                }

                System.out.println(new String(bitArray));

                char feedback = scanner.next().charAt(0);
                if (feedback == 'N') {
                    break;
                }
            }
        }
    }
}