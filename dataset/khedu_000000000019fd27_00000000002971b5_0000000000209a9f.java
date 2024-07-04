import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<String> resultArray=new ArrayList<String>();

        for (int x = 0; x < testCase; x++)
        {
            String s = br.readLine();
            int n = s.length();
            int tempInt=0;
            StringBuilder SB = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==tempInt)
                {
                    SB.append(s.charAt(i));
                }


                else if(val>tempInt)
                {
                    int diff = val-tempInt;
                    SB.append(openFunction(diff)).append(s.charAt(i));
                    tempInt = tempInt+diff;
                }

                else
                {
                    int diff = tempInt-val;
                    SB.append(closeFunction(diff)).append(s.charAt(i));
                    tempInt=tempInt-diff;
                }
            }
            if(tempInt>0)
            {
                SB.append(closeFunction(tempInt));
            }


            resultArray.add(SB.toString());

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