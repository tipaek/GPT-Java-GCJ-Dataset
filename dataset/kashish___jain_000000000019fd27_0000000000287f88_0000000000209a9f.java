import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Solution
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<String>resultArray=new ArrayList<String>();

        for (int kj = 0; kj < testCase; kj++)
        {
            String s = br.readLine();
            int n = s.length();


            int tempint=0;


            StringBuilder sbuilder = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==tempint)
                {
                    sbuilder.append(s.charAt(i));
                }


                else if(val>tempint)
                {
                    int diff = val-tempint;
                    sbuilder.append(openFunction(diff)).append(s.charAt(i));
                    tempint = tempint+diff;
                }
                
                else
                {
                    int diff = tempint-val;
                    sbuilder.append(closeFunction(diff)).append(s.charAt(i));
                    tempint=tempint-diff;
                }
            }
            if(tempint>0) 
            {
                sbuilder.append(closeFunction(tempint));
            }
        
            
            resultArray.add(sbuilder.toString());

        }
        for(int y=0;y<resultArray.size();y++)
        {
            System.out.println("Case #"+(y+1)+": "+resultArray.get(y));
        }
        
    }

    public static String openFunction(int q)
    {
         return String.join("", Collections.nCopies(q, "("));
    }
    public static String closeFunction(int w)
    {
         return String.join("", Collections.nCopies(w, ")"));
    }


}