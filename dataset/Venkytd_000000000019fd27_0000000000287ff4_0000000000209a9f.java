import java.util.*;
import java.io.*;

class Solution {

    public static void update(StringBuilder sb, int braces, int current) {
        if(braces == 0 && current == 0) {
            sb.append(String.valueOf(current));
            return;
        }

        if(braces > 0) {
            while(braces > 0) {
                sb.append(")");
                braces--;
            }
        } else {
            braces = Math.abs(braces);
            while(braces > 0) {
                sb.append("(");
                braces--;
            }
        }
        sb.append(String.valueOf(current));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests =  in.nextInt();
        in.nextLine();
        for(int test = 1; test <= tests; test++) {
            String s = in.nextLine();

            StringBuilder sb = new StringBuilder();
            int current = 0;

            while(current < s.length() && Character.getNumericValue(s.charAt(current)) == 0) {
                sb.append(String.valueOf(s.charAt(current)));
                current += 1 ;
            }

            if(current < s.length()) {
                int number = Character.getNumericValue(s.charAt(current));
                for(int i = 0; i < number; i++) {
                    sb.append("(");
                }
                sb.append(String.valueOf(number));
                current += 1;

                while(current < s.length()) {
                    int previous = Character.getNumericValue(s.charAt(current - 1));
                    number = Character.getNumericValue(s.charAt(current));
                    update(sb, previous - number, number);
                    current += 1;
                }

                for(int i = 0; i < Character.getNumericValue(s.charAt(s.length() - 1)); i++) {
                    sb.append(")");
                }
            }


            System.out.println("Case #" + test + ": " + sb.toString());
        }
    }
}