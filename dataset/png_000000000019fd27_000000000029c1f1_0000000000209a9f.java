import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        int count =1;
        String s = sn.nextLine();
        while(t != count-1)
        {
            s = sn.nextLine();
            String ans = "";
            int c =0;
            for(int i =0; i < s.length(); i++)
            {
                int x = s.charAt(i) - '0';
                for(; c < x; c++)
                {
                    ans += "(";
                }
                for(; c >x;c--)
                {
                    ans+= ")";
                }
                ans+= String.valueOf(x);
            }
            for(; c>0; c--)
            {
                ans+= ")";
            }

            System.out.println("Case #" + count +": " + ans);
            count++;
        }
    }
}
