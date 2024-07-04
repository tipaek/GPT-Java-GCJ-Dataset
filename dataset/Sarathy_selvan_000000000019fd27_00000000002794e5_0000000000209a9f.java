import java.io.*;
import java.util.*;
import java.util.HashMap;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        int ii=1;
        while(test>0)
        {
            //System.out.println("hi"+ii);
            String hh[]=br.readLine().split("");
            String baba="";
            int open=0;
            int temp=0;
            for(int i=0;i<hh.length;i++)
            {
                int curr=Integer.parseInt(hh[i]);
                if(i==0)
                {
                open=curr;
                for(int j=0;j<curr;j++)
                {
                    baba+="(";
                }
                baba+=curr+"";
                }
                else if(curr<temp)
                {
                    for(int j=0;j<open-curr;j++)
                    {
                        baba+=")";
                        open--;
                    }
                    baba+=curr+"";
                }
                else if(curr==temp)
                {
                    baba+=curr+"";
                }
                else if(curr>temp)
                {
                    for(int j=0;j<curr-open;j++)
                    {
                        baba+="(";
                        open++;
                    }
                    baba+=curr+"";
                }
                if(i==hh.length-1)
                {
                    for(int j=0;j<open;j++)
                    {
                        baba+=")";
                        open--;
                    }
                }
                temp=curr;
            }
            System.out.println("Case #"+ii+": "+baba);
            ii++;
            test--;
        }
    }
}
            