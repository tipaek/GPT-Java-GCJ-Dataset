import java.util.Scanner;

public class Solution {

    private static final int MAX_QUERIES = 150;
    private Scanner scanner = new Scanner(System.in);
    private int queryCount = 0;
    private int testCases;
    private int bitLength;
    private int[] bits;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void run() throws Exception {
        testCases = scanner.nextInt();
        bitLength = scanner.nextInt();
        bits = new int[bitLength];
        
        for (int t = 0; t < testCases; t++) {
            solve();
            if (scanner.next().equals("N")) {
                System.exit(-205);
            }
        }
    }

    private void solve() throws Exception {
        for (int i = 0; i < bitLength / 2; i++) {
            query(i);
            query(bitLength - i - 1);
        }
        System.out.println(bits);
    }

    private void query(int index) {
        if (queryCount++ < MAX_QUERIES) {
            System.out.println(index + 1);
            System.out.flush();
            String response = scanner.next();
            
            if (response.equals("N")) {
                System.exit(-1);
            } else {
                bits[index] = Integer.parseInt(response);
            }
        }
    }

    private void reverse() {
        for (int i = 0; i < bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }

    private void flip() {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = 1 - bits[i];
        }
    }

    private void reverseFlip() {
        flip();
        reverse();
    }
}