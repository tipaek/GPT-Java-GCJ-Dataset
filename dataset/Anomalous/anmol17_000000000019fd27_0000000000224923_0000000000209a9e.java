import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            try {
                handleTestCase(bitLength, scanner);
            } catch (Exception e) {
                return;
            }
        }
    }

    private static void handleTestCase(int bitLength, Scanner scanner) throws Exception {
        char[] bitArray = new char[bitLength];
        
        for (int i = 0; i < bitLength; i++) {
            System.out.println(i + 1);
            bitArray[i] = (char) (scanner.nextInt() + '0');
        }

        System.out.println(new String(bitArray));
        String result = scanner.next();
        
        if ("N".equals(result)) {
            throw new Exception();
        }
    }
}