import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        String par = "";
        String[] output = new String[testCases];
        for(int i=0; i<testCases; i++)
        {
            String str = scan.next();
            par = "";

            for(int j=0; j<str.length(); j++)
            {
                String open = "";
                String closed = "";
                for(int k=0; k<Integer.parseInt(str.substring(j,j+1)); k++)
                {
                    open += "(";
                    closed += ")";
                }
                par += open + str.substring(j,j+1) + closed;
            }
            while(par.contains(")("))
            {
                par = par.replace(")(","");
            }
            output[i] = par;
        }
        
        for(int i=0; i<output.length; i++)
        {
            System.out.println("Case #" + (i+1) + ": " + output[i]);
        }
    }
}
