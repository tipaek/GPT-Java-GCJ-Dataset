import java.lang.*;
import java.util.*;
import java.io.*;

class Solution
{
  
  public static void main(String[] args) throws Exception
  {
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      
       int testCases=sc.nextInt();
       //System.out.println(testCases);
        int testNum=1;
        while(testCases!=0)
        {
          
            
            int N=sc.nextInt();
            int[] C=new int[2];
            int[] J=new int[2];
            String ans="";
            int flag=0;
            sc.nextLine();
            int[] schedule1=new int[N];
            int[] schedule1t=new int[N];
            int[] schedule2t=new int[N];
            int[] schedule2=new int[N];
            int[] ansSch=new int[N];
            for(int i=0;i<N;i++)
            {
              String[] input;
              
              input=sc.nextLine().split(" ");
              //System.out.println(input[0]);
              schedule1[i]=Integer.parseInt(input[0]);
              schedule1t[i]=Integer.parseInt(input[0]);
              schedule2t[i]=Integer.parseInt(input[1]);
              ansSch[i]=Integer.parseInt(input[0]);
            }
            Arrays.sort(schedule1);
            for(int i=0;i<N;i++)
            {
              for(int j=0;j<N;j++)
              {
                if(schedule1[i]==schedule1t[j])
                {
                  schedule2[i]=schedule2t[j];
                  schedule1t[j]=-222;
                }
              }
            }
            for(int i=0;i<N;i++)
            {
              if(C[1]==0)
              {
                C[0]=schedule1[i];
                C[1]=schedule2[i];
                ans=ans+"C";
                //System.out.print("C");
              }
              else if(schedule1[i]>=C[1])
              {
                C[0]=schedule1[i];
                C[1]=schedule2[i];
                ans=ans+"C";
                //System.out.print("C");
              }
              else if(J[1]==0)
              {
                J[0]=schedule1[i];
                J[1]=schedule2[i];
                ans=ans+"J";
                //System.out.print("J");
              }
              
              else if(schedule1[i]>=J[1])
              {
                J[0]=schedule1[i];
                J[1]=schedule2[i];
                ans=ans+"J";
                //System.out.print("J");
              }
              else
              {
                System.out.println("Case #"+testNum+": IMPOSSIBLE");
                flag=1;
                break;
              }
              //System.out.println(schedule1[i]+" "+schedule2[i]+"\n");
              //System.out.println(C[0]+" "+C[1]+"\t"+J[0]+" "+J[1]+"\n");
            }
            if(flag==0)
            {
              System.out.print("Case #"+testNum+": ");
              for(int i=0;i<N;i++)
              {
                for(int j=0;j<N;j++)
                {
                  if(ansSch[i]==schedule1[j])
                  {
                    //System.out.println("ans="+ansSch[i]);
                    System.out.print(ans.charAt(j));
                    schedule1[j]=-222;
                    break;
                  }
                }
              }
              System.out.println();
             // System.out.println(ans);
            }
            
            testCases--;
            testNum++;
        }
  }
}