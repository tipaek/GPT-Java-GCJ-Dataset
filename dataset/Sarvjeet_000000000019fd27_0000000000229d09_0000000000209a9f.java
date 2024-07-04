import java.util.*;
public class Solution {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {

            String s=sc.next();
            Stack<Character> st=new Stack<>();

            StringBuilder sb=new StringBuilder(s);
            StringBuilder ans=new StringBuilder("");

            for(int i=0;i<sb.length();i++)
            {
                int t1=s.charAt(i)-'0';

                while(st.size()<t1)
                {
                    ans.append('(');
                    st.push(')');
                }
                while(st.size()>t1)
                {
                    ans.append(st.pop());
                }
                ans.append(t1);
            }
            while(!st.isEmpty())
            {
                ans.append(st.pop());
            }

            System.out.println("Case #"+(ii+1)+": "+ans.toString());

        }

    }

}
