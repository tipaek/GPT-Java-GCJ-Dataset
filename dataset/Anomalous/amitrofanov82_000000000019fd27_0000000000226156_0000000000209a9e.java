import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner sc = null;

    public static void main(String[] args) throws Exception {
        initializeScanner();
        
        String[] input = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        
        for (int i = 0; i < testCases; i++) {
            processTestCase(B);
            System.out.flush();
            String response = sc.nextLine();
            if (response.equals("N")) {
                break;
            } else if (!response.equals("Y")) {
                triggerHeapOverflow();
            }
        }
        sc.close();
    }

    private static void initializeScanner() throws Exception {
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }
    }

    private static void processTestCase(int B) {
        final int maxQueries = 150;
        char[] result = new char[B];
        for (int i = 0; i < B; i++) {
            result[i] = '0';
        }

        for (int i = 1; i <= maxQueries; i++) {
            int index = (i - 1) % B;
            result[index] = getBit(index) == 1 ? '1' : '0';
        }
        System.out.println(result);
    }

    private static int getBit(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return Integer.parseInt(sc.nextLine());
    }

    private static void triggerHeapOverflow() {
        int[] heapOverflow = new int[Integer.MAX_VALUE];
        System.out.println(heapOverflow);
    }
}