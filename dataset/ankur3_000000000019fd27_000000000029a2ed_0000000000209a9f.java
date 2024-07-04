
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int total = t;
        while (t-- >0) {
            String s = in.next();
            System.out.println("Case #"+ (total-t) + ": " + newWay(s));
        }

    }

    public static String findMinMatchedParanthesis(String s) {
        String arr[] = s.split("0",-1);
        String ans = "";
        int iter=0;
        for (String string : arr) {
           ans=ans.concat(processString(string));
           if (checkIfConcat(iter,arr.length)) {
               ans = ans.concat("0");
           }
           iter++;
        }
        return ans;
    }

    private static String processString(String s) {
        //Find the minimum of the string and put remaining paranthesis
        if (s.equals("")) return "";
        String ans = "";
        //Find minimum of the array.
        int min = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int val = c-'0';
            if (val<min) {
                min=val;
            }
        }

        for (char c : s.toCharArray()) {
            int val = c-'0';
            String start=c+"";
            for (int i=0;i<(val-min);i++) {
                start="("+start+")";
            }
            ans=ans.concat(start);
        }

        for (int i=0;i<min;i++) {
            ans= "("+ans+")";
        }
        return ans;
    }
    private static boolean checkIfConcat(int val,int size) {
        if (val==size-1) return false;
        return true;
    }



    private static String newWay(String s) {
        String ans = "";
        int previousOpen=0;
        for (char c : s.toCharArray()) {
            int charInt = c-'0';
            if (previousOpen<charInt) {
                for (int i=0;i<charInt-previousOpen;i++) {
                    ans= ans.concat("(");
                    previousOpen++;
                }
                ans=ans.concat(c+"");
            } else {
                while (previousOpen-charInt>0) {
                    ans= ans.concat(")");
                    previousOpen--;
                }
                ans=ans.concat(c+"");
            }
        }

        for (int i=0;i<previousOpen;i++) {
            ans=ans.concat(")");
        }
        return ans;
    }
}
