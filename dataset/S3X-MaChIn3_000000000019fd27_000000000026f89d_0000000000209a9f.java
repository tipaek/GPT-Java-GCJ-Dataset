import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
    public static void toNest(String s)
    {
        boolean first = true;
        String balanced = new String();
        LinkedList<Character> L = new LinkedList<Character>();
        int prevN = 0;

        for(int i = 0; i < s.length(); ++i)
        {
            int n = (int) (s.charAt(i) - '0');

            if(first)
            {
                first = false;
                
                for(int j = 0; j < n; ++j)
                {
                    balanced += '(';
                    L.addLast(')');
                }
            }
            else
            {
                int difference = prevN - n;

                if(difference > 0)
                {
                    for(int j = 0; j < difference; ++j)
                    {
                        balanced += L.removeFirst();
                    }
                }
                else
                {
                    difference = Math.abs(prevN - n);
                    
                    for (int j = 0; j < difference; ++j) 
                    {
                        balanced += '(';
                        L.addLast(')');
                    }
                }
            }

            balanced += n;
            prevN = n;
        }

        while(!L.isEmpty())
        {
            balanced += L.removeFirst();
        }

        System.out.println(balanced);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int nExec = sc.nextInt();

        ++nExec;

        for(int i = 0; i < nExec; ++i)
        {
            String s = sc.nextLine();
            toNest(s);
        }

        sc.close();
    }
}