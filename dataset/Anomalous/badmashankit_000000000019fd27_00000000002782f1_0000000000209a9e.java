import java.io.*;

public class Solution {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = READER.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int base = Integer.parseInt(input[1]);

        switch (base) {
            case 10:
                processBase10(testCases);
                break;
            case 20:
            case 100:
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    private static void processBase10(int testCases) throws IOException {
        for (int i = 1; i <= testCases; i++) {
            char[] bits = new char[10];
            for (int j = 0; j < 10; j++) {
                System.out.println(j + 1);
                int bit = Integer.parseInt(READER.readLine());
                bits[j] = (char) ('0' + bit);
            }
            System.out.println(new String(bits));
        }
    }

    private static void processBase20(int testCases) throws IOException {
        // Implementation for base 20 can be added here
    }

    private static void processBase100(int testCases) throws IOException {
        // Implementation for base 100 can be added here
    }
}