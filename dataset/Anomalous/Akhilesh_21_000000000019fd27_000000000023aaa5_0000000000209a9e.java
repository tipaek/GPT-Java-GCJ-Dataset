import java.util.*;

public class ESABATAD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            List<String> bits = new ArrayList<>();
            boolean shouldExit = false;

            for (int queryCount = 1, bitIndex = 1; queryCount < 150; queryCount++) {
                System.out.println(bitIndex);
                String response = scanner.next();

                if (queryCount % 10 == 1) {
                    // Skipping the response for every 10th query
                    continue;
                } else {
                    bits.add(response);
                    bitIndex++;
                }

                if (bits.size() == bitLength) {
                    StringBuilder bitString = new StringBuilder();
                    for (String bit : bits) {
                        bitString.append(bit);
                    }
                    System.out.println(bitString.toString());

                    String verdict = scanner.next();
                    if ("N".equals(verdict)) {
                        shouldExit = true;
                        break;
                    } else if ("Y".equals(verdict)) {
                        break;
                    }
                }
            }

            if (shouldExit) {
                break;
            }
        }

        scanner.close();
    }
}