import java.util.*;
import java.io.*;
public class Solution
{
    static BufferedWriter bw;
    static BufferedReader br;
    static int countBits(int n)
    {
        int count =0 ;
        while(n!=0)
        {
            n=n&(n-1);
            count++;
        }
        return count;
    }
    static boolean valid(int row,int col)
    {
        
        if((row &(row-1))==0 && ((col-1)&(col-2))==0)
        return true;
        else if((col&(col-1))==0 && ((row-1)&(row-2))==0)
        return true;
        return false;
    }
    static void solve()throws Exception
    {
       int input[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       int row = input[0];
       int col = input[1];
       if((row<=0&&col<=0)||(row>=0&&col>=0))
       {
           if(row==0)
           {
               int count=countBits(Math.abs(col));
               if(col>0){
                   for(int i=0;i<count;i++)
                   bw.write("N");
               }
               else
               {
                   for(int i=0;i<count;i++)
                   bw.write("S");
               }
           }
           else if(col==0)
           {
               int count=countBits(Math.abs(row));
               if(row>0){
                   for(int i=0;i<count;i++)
                   bw.write("E");
               }
               else
               {
                   for(int i=0;i<count;i++)
                   bw.write("W");
               }
           }
           else if(!valid(Math.abs(row),Math.abs(col)))
            {
                bw.write("IMPOSSIBLE");
            }
           else{
               if(row>0&&col>0)
               {
                   if((row&(row-1))==0)
                   {
                       bw.write("SEN");
                   }
                   else
                   {
                       bw.write("WNE");
                   }
               }
               if(row<0&&col<0)
               {
                   row = Math.abs(row);
                   col = Math.abs(col);
                   if((row&(row-1))==0)
                   {
                       bw.write("NWS");
                   }
                   else
                   {
                       bw.write("ESW");
                   }
               }
           }
       }
       else
       {
           bw.write("IMPOSSIBLE");
       }
       bw.newLine();
    }
    public static void main(String []args)throws Exception
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            bw.write("Case #"+(i+1)+": ");
            solve();
        }
        br.close();
        bw.close();
    }
}
