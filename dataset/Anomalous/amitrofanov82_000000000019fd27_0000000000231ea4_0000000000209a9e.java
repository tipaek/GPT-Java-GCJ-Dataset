import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    static Scanner sc;

    public static void main(String[] args) throws Exception {
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        String[] inputLine = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(inputLine[0]);
        int B = Integer.parseInt(inputLine[1]);

        for (int i = 0; i < testCases; i++) {
            processSingleCase(B);
            System.out.flush();
            String response = sc.nextLine();
            if (response.equals("N")) {
                break;
            }
            if (!response.equals("Y")) {
                int[] heapOverflow = new int[Integer.MAX_VALUE];
                System.out.println(heapOverflow);
            }
        }
        sc.close();
    }

    private static void processSingleCase(int B) {
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
}