import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        for (int q = 1; q <= t; q++) {
            byte[] arr = new byte[b];
            String s = "";
            for (int i = 0; i < b; i++) {
                System.out.println(i + 1);
                arr[i] = (byte) scan.nextInt();
                s += arr[i];
            }
            System.out.println(s);
            if(!scan.next().equals("Y")){
                break;
            }
        }
    }

    public static byte[] complement(byte[] arr) {
        byte[] comp = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                comp[i] = 0;
            } else if (arr[i] == 0) {
                comp[i] = 1;
            } else {
                comp[i] = 2;
                System.out.println("Unvollständig, Debug ncoh entfernen");
            }
        }
        return comp;
    }

    public static byte[] reversal(byte[] arr) {
        byte[] rev = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }
}
