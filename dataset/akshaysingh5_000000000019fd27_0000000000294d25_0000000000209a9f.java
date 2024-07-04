import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Solution
{
    private static Scanner ramu;
    static int haryana =1;
    public static void main(String args[])
    {
        ramu = new Scanner(System.in);
        int pep= ramu.nextInt();
        ramu.nextLine();

        while(pep-- >0)
        {
            solve();
        }
    }
    public static void solve()
    {
        String Akshay= ramu.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] jaat= Akshay.toCharArray();

        int sumeet =0;
        int brackets =0;
        int first = Character.getNumericValue(jaat[0]);
        sumeet =first;
        brackets= first;
        for(int i=0;i<first;i++)
        {
            sb.append('(');
        }
        sb.append(first);
        for(int i=1;i<jaat.length;i++)
        {
            int d = Character.getNumericValue(jaat[i]);
            
            if(d == sumeet)
            {
                sb.append(d);
            }
            else if(d>sumeet)
            {
                int diff = d-sumeet;
                for(int j=0;j< diff;j++)
                {
                    sb.append('(');
                    brackets++;
                }
                sb.append(d);
            }
            else 
            {
                int diff = sumeet -d;
                for(int j=0;j<diff;j++)
                {
                    sb.append(')');
                    brackets--;
                }
                sb.append(d);
            }
            sumeet = Character.getNumericValue(jaat[i]);
        }

        while(brackets -- > 0)
        {
            sb.append(')');
        }
        System.out.println("Case #"+(haryana++)+": "+sb.toString());

    }
}