import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int m = 1;
        int n;
        String input;
        String str;
        String temp;
        int l, val, count;

        while(t > 0) {
            input = br.readLine();
            n = Integer.parseInt(input);
            str = "";
            temp = "";

            while(n > 0) {
                l = n % 10;
                val = l;
                n /= 10;

                while(val % 10 == n % 10) {
                    val = (val * 10) + n % 10;
                    n /= 10;
                }

                if(str.contains("(")) {
                    count = 0;
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '(') {
                            count++;
                        }
                    }
                    l -= count;
                }
                for(int i = 0; i < l; i++) {
                    temp = temp + "(";
                }
                temp = temp + val;
                for(int i = 0; i < l; i++) {
                    temp = temp + ")";
                }

                str = temp + str;

                for(int i = str.length() - 1; i > 0; i--) {

                }

                temp = "";
            }

            if (input.charAt(0) == '0') {
                for(int i = 0; i < input.length(); i++) {
                    if(input.charAt(i) == '0') {
                        str = input.charAt(i) + str;
                    } else {
                        break;
                    }
                }

            }


            System.out.println("Case #"+ m + ": " + str);

            t--;
            m++;
        }
    }
}