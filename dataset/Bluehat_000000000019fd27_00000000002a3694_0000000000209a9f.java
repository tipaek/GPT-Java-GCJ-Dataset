import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Solution
{

    public static void main(String[] x) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        ArrayList<String>result=new ArrayList<String>();

        for (int k = 0; k < testcase; k++)
        {
            String vars = br.readLine();
            int n = vars.length();
            int tempint=0;


            StringBuilder newstring = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = vars.charAt(i)-48;
                if(val==tempint)
                {
                    newstring.append(vars.charAt(i));
                }


                else if(val>tempint)
                {
                    int diff = val-tempint;
                    newstring.append(funcone(diff)).append(vars.charAt(i));
                    tempint = tempint+diff;
                }
                
                else
                {
                    int diff = tempint-val;
                    newstring.append(functwo(diff)).append(vars.charAt(i));
                    tempint=tempint-diff;
                }
            }
            if(tempint>0) 
            {
                newstring.append(functwo(tempint));
            }
        
            
            result.add(newstring.toString());

        }
        for(int z=0;z<result.size();z++)
        {
            System.out.println("Case #"+(z+1)+": "+result.get(z));
        }
        
    }

    public static String funcone(int xyz)
    {
         return String.join("", Collections.nCopies(xyz, "("));
    }
    public static String functwo(int wxy)
    {
         return String.join("", Collections.nCopies(wxy, ")"));
    }


}