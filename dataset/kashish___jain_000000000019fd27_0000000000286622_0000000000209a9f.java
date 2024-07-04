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
        int Test = Integer.parseInt(br.readLine());
        ArrayList<String>Results=new ArrayList<String>();

        for (int i = 0; i < Test; i++)
        {
            String st = br.readLine();
            int stl = st.length();
            int tint=0;


            StringBuilder strbs = new StringBuilder();
            for(int j=0;j<stl;j++)
            {
                int val = st.charAt(j)-48;
                if(val==tint)
                {
                    strbs.append(st.charAt(j));
                }


                else if(val>tint)
                {
                    int d = val-tint;
                    strbs.append(Open(d)).append(st.charAt(j));
                    tint = tint+d;
                }
                
                else
                {
                    int d = tint-val;
                    strbs.append(Close(d)).append(st.charAt(i));
                    tint=tint-d;
                }
            }
            if(tint>0) 
            {
                strbs.append(Close(tint));
            }
        
            
            Results.add(strbs.toString());

        }
        for(int a=0;a<Results.size();a++)
        {
            System.out.println("Case #"+(a+1)+": "+Results.get(a));
        }
        
    }

    public static String Open(int v)
    {
         return String.join("", Collections.nCopies(v, "("));
    }
    public static String Close(int e)
    {
         return String.join("", Collections.nCopies(e, ")"));
    }


}