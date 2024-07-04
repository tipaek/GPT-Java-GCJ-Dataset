import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder pc = new StringBuilder();
        int t = sc.nextInt();
        sc.nextLine();
        for(int x=1; x<=t; x=x+1)
        {
            String s = sc.nextLine();
            int upper = 0;
            int d = s.charAt(0) - 48;
            pc.append("Case #" + x + ": ");
            for(int j=0; j<d; j=j+1)
            {
                pc.append("(");
            }
            pc.append(d);
            upper = d;
            for(int i=1; i<s.length(); i=i+1)
            {
                d =s.charAt(i) - 48;
                if(upper <= d)
                {
                    for(int j=0; j<d-upper; j=j+1)
                    {
                        pc.append("(");
                    }
                    upper = d;
                }
                else
                {
                    for(int j=0; j<upper-d; j=j+1)
                    {
                        pc.append(")");
                    }
                    upper = d;
                }
                pc.append(d);
            }
            for(int j=0; j<upper; j=j+1)
            {
                pc.append(")");
            }
            upper = d;
            pc.append("\n");
        }
        System.out.println(pc);
    }
}