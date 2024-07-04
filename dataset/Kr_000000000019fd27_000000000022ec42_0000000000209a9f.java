import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        for(int x=1;x<=t;x++){
            StringBuilder str=new StringBuilder(sc.next());

            System.out.println("Case #"+x+": "+solve(str));
        }
    }

    private static StringBuilder solve(StringBuilder str) {
        StringBuilder ans=new StringBuilder();
        int val=0,rem=str.charAt(0)-'0';
        for(int j=0;j<rem;j++){
            ans.append("(");
        }
        ans.append(str.charAt(0));
        for(int i=1;i<str.length();i++){
            char ch=str.charAt(i);
            char prev=str.charAt(i-1);
            if(prev<ch){
                for(int j=0;j<(ch-'0')-rem;j++)
                    ans.append("(");
                ans.append(ch);
                rem=ch-'0';
            }
            else if(prev>ch){
                for(int j=0;j<rem-(ch-'0');j++){
                    ans.append(")");
                }
                ans.append(ch);
                rem=ch-'0';
            }
            else
                ans.append(ch);

        }
        for(int j=0;j<rem;j++)
            ans.append(")");

        return ans;
    }
}
/*while (i + 1 < str.length() && str.charAt(i + 1) == ch) {
        ans.append(ch);
        i++;
}*/