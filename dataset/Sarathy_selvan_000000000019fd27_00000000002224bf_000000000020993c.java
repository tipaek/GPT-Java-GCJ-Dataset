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
            int size=Integer.parseInt(br.readLine());
            String hh[]=new String[size];
            int arr[][]=new int[size][size];
            for(int i=0;i<size;i++)
            {
                hh=br.readLine().split(" ");
                for(int j=0;j<size;j++)
                {
                    arr[i][j]=Integer.parseInt(hh[j]);
                }
            }
            int dia=0;
            int la=0;
            int ba=0;
            int row=0;
            int col=0;
            for(int i=0;i<size;i++)
            {
                HashMap<Integer,Integer> hm1=new HashMap<Integer,Integer>();
                HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
                for(int j=0;j<size;j++)
                {
                    if(i==j)
                    {
                        dia+=arr[i][j];
                    }
                    if(la==0)
                    {
                        Integer key=hm.get(arr[i][j]);
                        if(key==null)
                        {
                           hm.put(arr[i][j],1); 
                        }
                        else
                        {
                            row++;
                            la=9;
                        }
                    }
                    if(ba==0)
                    {
                        Integer key=hm1.get(arr[j][i]);
                        if(key==null)
                        {
                           hm1.put(arr[j][i],1); 
                        }
                        else
                        {
                            col++;
                            ba=9;
                        }
                    }
                }
                la=0;
                ba=0;
            }
            System.out.println("Case #"+ii+":"+" "+dia+" "+row+" "+col);
            test--;
            ii++;
        }
    }
}