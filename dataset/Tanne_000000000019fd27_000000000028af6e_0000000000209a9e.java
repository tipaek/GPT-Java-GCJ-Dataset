import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        for (int q = 1; q <= t; q++) {
            if (b == 10) {
                set1(t, b, scan);
            } else {
                set2(t, b, scan);
            }
        }
    }

    private static void set2(int t, int b, Scanner scan) {

        byte[] arr = new byte[b];
        for (int i = 0; i < b; i++) {
            arr[i] = 2;
        }
        String s = "";
        int e = 0;
        int d = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            arr[i - 1] = (byte) scan.nextInt();
            System.out.println(b - (i - 1));
            arr[b - i] = (byte) scan.nextInt();
            if (arr[i - 1] == arr[b - i]) {
                e = i - 1;
            } else {
                d = i - 1;
            }
        }
        arr = getBytes(scan, arr, e, d);


        for (int i = 6; i <= 9; i++) {
            System.out.println(i);
            arr[i - 1] = (byte) scan.nextInt();
            System.out.println(b - (i - 1));
            arr[b - i] = (byte) scan.nextInt();
        }

        arr = getBytes(scan, arr, e, d);


        for (int i = 10; i <= 10; i++) {
            System.out.println(i);
            arr[i - 1] = (byte) scan.nextInt();
            System.out.println(b - (i - 1));
            arr[b - i] = (byte) scan.nextInt();
        }


        print(b, arr, s);
        if (!scan.next().equals("Y")) {
            break;
        }
    }


    private static void print(int b, byte[] arr, String s) {
        for (int i = 0; i < b; i++) {
            s += arr[i];
        }
        System.out.println(s);
    }

    private static byte[] getBytes(Scanner scan, byte[] arr, int e, int d) {
        boolean rev = false;
        boolean com = false;
        System.out.println(e + 1);
        if (scan.nextInt() != arr[e]) com = true;
        System.out.println(d + 1);
        int ansd = scan.nextInt();
        if (ansd != arr[d] && !com) {
            rev = true;
        } else if (ansd == arr[d] && com) {
            rev = true;
        }
        if (rev) arr = reversal(arr);
        if (com) arr = complement(arr);
        return arr;
    }

    public static void set1(int t, int b, Scanner scan) {

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

    public static byte[] complement(byte[] arr) {
        byte[] comp = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                comp[i] = 0;
            } else if (arr[i] == 0) {
                comp[i] = 1;
            } else {
                comp[i] = 2;
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
