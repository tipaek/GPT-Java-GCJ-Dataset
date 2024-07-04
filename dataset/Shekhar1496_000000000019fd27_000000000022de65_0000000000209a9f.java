import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for (int j = 1; j <=t ; j++) {
            String str = s.next();
            str = "0" + str;
            str += "0";
            String res = "";
            for (int i = 1; i < str.length(); i++) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(i - 1);
                int diff = ch2 - ch1;
                if (diff < 0) {
                    int n = Math.abs(diff);
                    while (n != 0) {
                        res += "(";
                        n--;
                    }
                } else {
                    int n = Math.abs(diff);
                    while (n != 0) {
                        res += ")";
                        n--;
                    }
                }
                res += ch1;
            }
            System.out.println("Case #" + j + ": " + res.substring(0, res.length() - 1));

        }
    }
}