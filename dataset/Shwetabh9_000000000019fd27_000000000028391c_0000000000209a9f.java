import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner fr=new Scanner(System.in);
        int t=fr.nextInt();
        for(int x =1;x<=t;x++) {
            String s= fr.next();
            StringBuilder ans=new StringBuilder();
            int open=s.charAt(0)-48;
            int close=0;
            for(int i=0;i<open;i++)
                ans.append('(');
            for(int i=0;i<s.length()-1;i++)
            {
                char c1=s.charAt(i);
                ans.append(c1);
                char c2=s.charAt(i+1);
                int v=c2-c1;
                //StringBuilder braces=new StringBuilder();
                if(v<0) {
                    v = v * -1;
                    close+=v;
                    for(int j=0;j<v;j++)
                        ans.append(')');
                }
                else if(v>0) {
                    open+=v;
                    for(int j=0;j<v;j++)
                        ans.append('(');
                }
            }
            ans.append(s.charAt(s.length()-1));
            for(int i=0;i<(open-close);i++)
                ans.append(')');
            System.out.println("Case #"+x+": "+ans);
        }
    }
}
