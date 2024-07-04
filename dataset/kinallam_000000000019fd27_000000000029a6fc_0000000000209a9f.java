import java.util.*;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int m =0; m<testcases;m++) {
            String line = in.next();
            getnestdepth(line, m+1);
        }


    }

    public static void getnestdepth(String s, int t) {
        String output = "";

        int temp = Character.getNumericValue(s.charAt(0));
        while (temp > 0) {
            output = output + "(";
            temp --;
        }
        output = output + s.charAt(0);

        for (int i=1; i<s.length(); i++) {
            int prev = Character.getNumericValue(s.charAt(i-1));
            int curr = Character.getNumericValue(s.charAt(i));

            if (prev > curr) {
                int rem2 = prev - curr;
                while (rem2 > 0) {
                    output = output + ")";
                    rem2 --;
                }
            }

            if (prev < curr) {
                int rem2 = curr - prev;
                while (rem2 > 0) {
                    output = output + "(";
                    rem2 --;
                }
            }

            output = output + s.charAt(i);


        }

        int tem = Character.getNumericValue(s.charAt(s.length()-1));
        while (tem > 0) {
            output = output + ")";
            tem --;
        }

        System.out.println("Case #" + t + ": " +  output);
    }


}
