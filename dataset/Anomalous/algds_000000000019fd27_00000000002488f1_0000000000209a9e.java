import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            if (!processTestCase(in, t, b)) {
                System.out.println("Wrong answer!");
                break;
            }
        }
    }

    private static boolean processTestCase(Scanner in, int t, int b) {
        int[] bits = new int[b];
        int pos = 1;
        
        for (int i = 1; pos <= b; i++) {
            System.out.println(pos);
            int bit = in.nextInt();
            
            if (i % 10 != 1) {
                bits[pos - 1] = bit;
                pos++;
            }
        }
        
        for (int bit : bits) {
            System.out.print(bit);
        }
        System.out.println();
        
        String result = in.next();
        return result.equals("Y");
    }
}