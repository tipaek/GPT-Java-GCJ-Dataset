import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int test = obj.nextInt(),q;
        for(q=1;q<=test;q++)
        {
            String str = obj.next();
            int i,j,k;
            Stack<Character> s = new Stack<Character>();
            for(i=0;i<str.length();i++)
            {
                int n = (int)str.charAt(i)-48;
                for(j=0;j<n;j++)
                {
                    s.push('(');
                }
                s.push(str.charAt(i));
                for(j=0;j<n;j++)
                {
                    s.push(')');
                }
            }
            String s1 = "";
            while(!(s.isEmpty()))
            {
                s1 = s.pop() + s1;
            }
            System.out.println(s1);
        }
    }
}