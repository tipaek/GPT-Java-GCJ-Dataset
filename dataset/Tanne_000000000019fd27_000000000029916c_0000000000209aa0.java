import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        for (int q = 1; q <= t; q++) {
            set2(t, b, scan);
        }
    }

    private static void set2(int t, int b, Scanner scan) {
        //leeres Array mit 2en füllen
        byte[] arr = new byte[b];
        for (int i = 0; i < b; i++) {
            arr[i] = 2;
        }
        String s = "";
        int e = -1;
        int d = -1;

        int overall = 1;
        int i = 1;

        boolean rev = false;
        boolean com = false;

        while (i <= b / 2) {
            if (overall % 10 == 1 && overall != 1) {
                if (e < 0) {
                    System.out.println(1);
                    int trash = scan.nextInt();
                    overall++;
                } else {
                    System.out.println(e + 1);
                    overall++;
                    if (scan.nextInt() != arr[e]) com = true;
                }
            } else if (overall % 10 == 2 && overall != 2) {
                if (d < 0) {
                    System.out.println(1);
                    int trash = scan.nextInt();
                    overall++;
                } else {
                    System.out.println(d + 1);
                    overall++;
                    int ansd = scan.nextInt();
                    if (ansd != arr[d] && !com) {
                        rev = true;
                    } else if (ansd == arr[d] && com) {
                        rev = true;
                    }
                }
            } else {
                if (com) arr = complement(arr);
                if (rev) arr = reversal(arr);
                rev = false;
                com = false;
                System.out.println(i);
                overall++;
                arr[i - 1] = (byte) scan.nextInt();
                System.out.println(b - (i - 1));
                overall++;
                arr[b - i] = (byte) scan.nextInt();
                if (arr[i - 1] == arr[b - i]) {
                    e = i - 1;
                } else {
                    d = i - 1;
                }
                i++;
            }
            System.out.println("i: " + i + " o: " + overall);
        }


        print(b, arr, s);
        if (!scan.next().equals("Y")) {
            System.exit(0);
        }
    }

    private static void print(int b, byte[] arr, String s) {
        for (int i = 0; i < b; i++) {
            s += arr[i];
        }
        System.out.println(s);
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
