import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t =scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String[] ar = new String[n];
            String start = "";
            String end = "";

            for (int j = 0; j < n; j++) {
                ar[j] = scanner.next();
            }
            Arrays.sort(ar);
            boolean factor = false;

            outer: for (int j = 0; j < n; j++) {
                String curfirst = "";
                String curlast = "";
                for (int k = 0; k < ar[j].length(); k++) {
                    if(ar[j].charAt(k) == '*') {
                        curfirst = ar[j].substring(0, k);
                        curlast = ar[j].substring(k + 1);
                        break;
                    }
                }

                for (int k = 0; k < Math.min(curfirst.length(), start.length()); k++) {
                    if(! (start.charAt(k) == curfirst.charAt(k))) {
                        System.out.println("Case #" + (i + 1) + ": *");
                        factor = true;
                        break outer;
                    }
                }
                for (int k = 0; k < Math.min(curlast.length(), end.length()); k++) {
                    if(!(curlast.charAt(curlast.length() - k - 1) == end.charAt(end.length() - k - 1))) {
                        System.out.println("Case #" + (i + 1) + ": *");
                        factor = true;
                        break outer;
                    }
                }
                if(curfirst.length() > start.length()) {
                    start = curfirst;
                }
                if(curlast.length() > end.length()) {
                    end = curlast;
                }
            }


            if(!factor) {
                int cut = 0;
                for (int j = 0; j < Math.min(start.length(), end.length()); j++) {
                    if(start.charAt(start.length() - j - 1) == end.charAt(j)) {
                        cut++;
                    }
                    else {
                        break;
                    }
                }


                System.out.println("Case #" + (i + 1) + ": " + start + end.substring(cut));
            }



        }
    }
}
