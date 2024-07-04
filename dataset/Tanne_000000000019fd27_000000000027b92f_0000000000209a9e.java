import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        if (b == 10) {
            set1(t,b, scan);
        }
    }

    public static void set1(int t, int b, Scanner scan){
        for (int q = 1; q <= t; q++) {
            byte[] arr = new byte[b];
            String s = "";
            for (int i = 0; i < b; i++) {
                System.out.println(i + 1);
                arr[i] = (byte) scan.nextInt();
                s += arr[i];
            }
            System.out.println(s);
            if (!scan.next().equals("Y")) {
                break;
            }
        }
    }
}
