import java.util.*;
public class Solution
{
    static String minimum(String inp)
    {
        String op="";
        int n=inp.length();
        int open=0;
        for(int i=0;i<n;i++)
        {
            int num=inp.charAt(i)-'0';
            if(open==num)
                op=op.concat(String.valueOf(num));
            else if(open<num)
            {
                int rep=num-open;
                for(int j=0;j<rep;j++)
                {
                    op=op.concat(Character.toString('('));
                }
                op=op.concat(String.valueOf(num));
                open+=rep;
            }
            else
            {
                int rep=open-num;
                for(int j=0;j<rep;j++)
                {
                    op=op.concat(Character.toString(')'));
                }
                op=op.concat(String.valueOf(num));
                open-=rep;
            }
        }
        for(int i=0;i<open;i++)
            op=op.concat(String.valueOf(')'));
        return op;
    }
    public static void main(String s[])
    {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        int i=0;
        while(i<t)
        {
            String inp=sc.next();
            System.out.println("Case #"+(i+1)+": "+minimum(inp));
            i++;
        }
    }
}