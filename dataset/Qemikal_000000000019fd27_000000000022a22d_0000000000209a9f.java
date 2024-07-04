import java.util.Scanner;

public class Solution
{
    private static String result(String s) {
        String r = "";
        char add = '(';
        int d1 = Integer.parseInt(s.charAt(0) + "");
        int d2 = 0;
        for (int i = 0; i < d1; i++) {
            r += add;
        }
        r += s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            d1 = Integer.parseInt(s.charAt(i - 1) + "");
            d2 = Integer.parseInt(s.charAt(i) + "");
            
            int nr = 0;
            if (d1 > d2) {
                nr = d1 - d2;
                add = ')';
            } else {
                nr = d2 - d1;
                add = '(';
            }
            for (int j = 0; j < nr; j++) {
                r += add;
            }
            r += s.charAt(i);
        }
        d2 = Integer.parseInt(s.charAt(s.length() - 1) + "");
        for (int i = 0; i < d2; i++) {
            r += ')';
        }
        
        return r;
    }
    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        read.nextLine();
        for (int ca = 1; ca <= cases; ca++) {
            String s = read.nextLine();
            System.out.println("Case #"+ca+": "+result(s));
        }
    }
}