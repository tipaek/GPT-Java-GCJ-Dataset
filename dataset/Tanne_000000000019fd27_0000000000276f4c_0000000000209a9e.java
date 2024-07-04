import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int b = scan.nextInt();
        for (int q = 1; q <= t; q++) {
            String s = scan.next();
            byte[] arr = new byte[b];
            byte[] sol = new byte[b];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = (byte) Character.getNumericValue(s.charAt(i));
            }
            int inde = -1;
            int indd = -1;
            boolean com = false;
            boolean rev = false;
            //get indizes for equal and different bits in case of reversal
            for (int i = 0; i <= (b / 2); i++) {
                if (inde < 0 || indd < 0) {
                    if (arr[i] == arr[b - 1 - i]) {
                        inde = i;
                    } else {
                        indd = i;
                    }
                } else {
                    break;
                }
            }
            //send query one for equal indizes, checking for complementation
            System.out.println(inde);
            int anse = scan.nextInt();
            if (anse != arr[inde]) com = true;
            //second query for different indizes, checking for reversal
            System.out.println(indd);
            int ansd = scan.nextInt();
            if (ansd != arr[indd] && !com) {
                rev = true;
            } else if (ansd == arr[indd] && com) {
                rev = true;
            }
            if (rev) sol = reversal(arr);
            if (com) sol = complement(sol);
            String x = "";
            for (int i = 0; i < b; i++){
                x+=sol[i];
            }
            System.out.println(x);
            if (scan.next().equalsIgnoreCase("Y")){
                break;
            } else {
                System.exit(0);
            }
        }
    }

    public static byte[] reversal(byte[] arr) {
        byte[] rev = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                rev[i] = 0;
            } else if (arr[i] == 0) {
                rev[i] = 1;
            } else {
                System.out.println("OH NEIN, FEHLER!");
            }
        }
        return rev;
    }

    public static byte[] complement(byte[] arr) {
        byte[] comp = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            comp[i] = arr[arr.length - 1 - i];
        }
        return comp;
    }
}
