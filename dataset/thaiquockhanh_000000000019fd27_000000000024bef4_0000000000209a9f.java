import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int totalTests = scan.nextInt();
        scan.nextLine();
        for(int test = 0; test<totalTests; test++){
            String s = scan.nextLine();
            StringBuilder r = new StringBuilder();
            int sz = s.length();
            int counter = 0;
            for(int i=0;i<sz;i++) {
                int c = Character.getNumericValue(s.charAt(i));
                if(counter < c) {
                    for(int x = 0; x < c- counter; x++) r.append('(');
                } else {
                    for(int x = 0; x < counter - c; x++) r.append(')');
                }
                r.append(c);
                counter = c;
                if(i == sz - 1) {
                    for(int x = 0; x < counter; x++) r.append(')');
                }
            }
            System.out.printf("Case #%d: %s%n", test+1, r.toString());
        }
    }
}