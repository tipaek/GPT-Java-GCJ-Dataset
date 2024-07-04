
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {

            String str = s.next();
            String ans = check(str);
            System.out.println("case #" + i + ": " + ans);

        }
    }

    private static String check(String str) {
        String s = "";
        int c=0;
        for (int i = 0; i <str.length() ; i++) {
            int val=str.charAt(i)-'0';
            if (val<c){
                int temp=c-val;
                while (temp>0){
                    s+=")";
                    temp--;
                }
                c=val;
                s+=str.charAt(i);
            }else {
                int temp=val-c;
                while (temp>0){
                    s+="(";
                    temp--;
                }
                c=val;
                s+=str.charAt(i);
            }
        }
        while (c>0){
            c--;
            s+=")";
        }
        return s;
    }
}
