import java.util.*;
import java.io.*;
class Solution{
    public static int number(char x){
        return (int)(x) - 48;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String ans = "";
            int bracket = number(s.charAt(0));
            for(int k=0 ; k<bracket ; k++)
                    ans += "(";
            ans += s.charAt(0);
            for(int j = 1 ; j<s.length() ; j++){
                if(number(s.charAt(j)) == bracket){
                    ans += s.charAt(j);
                }
                else if(number(s.charAt(j)) > bracket){
                    int temp = bracket;
                    bracket = number(s.charAt(j));
                    for(int k = 0 ; k<bracket-temp ; k++)
                        ans += "(";
                    ans += s.charAt(j);
                }
                else{
                    j-=1;
                    bracket -= 1;
                    ans += ")";
                }
            }
            if(bracket>0){
                for(int k=0 ; k<bracket ; k++)
                    ans += ")";
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}