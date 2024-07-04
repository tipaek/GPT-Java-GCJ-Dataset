import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n = sc.nextInt();
            String result = new String();
            for(int j = 0;j<n;j++)
            {
                String s = sc.next();
                if(j==0)
                result=s.substring(1,s.length());
                else
                {
                    if(result.endsWith(s.substring(1,s.length())))
                    continue;
                    else if(s.substring(1,s.length()).endsWith(result))
                    result=s.substring(1,s.length());
                    else
                    {
                        result="*";
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+result);
        }
    }
}