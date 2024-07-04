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
            ArrayList<Character> al = new ArrayList<Character>();
            while(!(s.isEmpty()))
            	al.add(s.pop());
            for(i=0;i<al.size()-1;i++)
            {
            	if(al.get(i)=='(' && al.get(i+1)==')')
            	{
            		al.remove(i+1);
            		al.remove(i);
            		i=i-2;
            	}
            }
            String s1="";
            for(i=al.size()-1;i>=0;i--)
            	s1+=al.get(i);
            System.out.println(s1);
        }
    }
}