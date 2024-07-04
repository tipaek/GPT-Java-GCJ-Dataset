import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int merp = s.nextInt();

        for(int i=0; i<merp; i++) {
            String str = s.next();
            String ans = "";

            int pre = Character.valueOf(str.charAt(0)) - 48;
            ans+= stringify(pre);
            ans+=str.charAt(0);

            for(int j=0; j<str.length()-1; j++) {
                int diff = -Character.valueOf(str.charAt(j)) + Character.valueOf(str.charAt(j+1));
                ans+= stringify(diff);
                ans+=str.charAt(j+1);
            }
            int suf = Character.valueOf(str.charAt(str.length()-1)) - 48;
            ans += stringify(-suf);

            System.out.println("Case #" + (i+1) + ": " + ans);
        }

        s.close();
    }

    static String getParen(int num) {
        if(num<0) return ")";
        else if(num>0) return "(";
        return "";
    }

    static String stringify(int num) {
        String bleh = "";
        String paren = getParen(num);
        for(int i=0; i<Math.abs(num); i++) {
            bleh+=paren;
        }

        return bleh;
    }
}