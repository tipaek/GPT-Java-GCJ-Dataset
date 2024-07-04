
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
        int tc = Integer.parseInt(br.readLine());
        ArrayList<String>result=new ArrayList<String>();

        for (int k = 0; k < tc; k++)
        {
            String s = br.readLine();
            int n = s.length();
            int tempint=0;


            StringBuilder strb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==tempint)
                {
                    strb.append(s.charAt(i));
                }


                else if(val>tempint)
                {
                    int diff = val-tempint;
                    strb.append(myFuncOpen(diff)).append(s.charAt(i));
                    tempint = tempint+diff;
                }
                
                else
                {
                    int diff = tempint-val;
                    strb.append(myFuncCLose(diff)).append(s.charAt(i));
                    tempint=tempint-diff;
                }
            }
            if(tempint>0) 
            {
                strb.append(myFuncCLose(tempint));
            }
        
            
            result.add(strb.toString());

        }
        for(int z=0;z<result.size();z++)
        {
            System.out.println("Case #"+(z+1)+": "+result.get(z));
        }
        
    }

    public static String myFuncOpen(int xyz)
    {
         return String.join("", Collections.nCopies(xyz, "("));
    }
    public static String myFuncCLose(int wxy)
    {
         return String.join("", Collections.nCopies(wxy, ")"));
    }


}