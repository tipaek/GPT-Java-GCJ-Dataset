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
         sc.nextLine();
         int caseNo=1;
        while(testCases!=0)
        {
          
          
              String[] input;
              String ip="";
              int index=0,left=0,right=0;
             
              input=sc.nextLine().split("");
              int[] input1=new int[input.length];
              int[] countBraces=new int[input.length];
              String ans="";
              //System.out.println(input.length);
              for(int i=0;i<input.length;i++)
              {
                input1[i]=Integer.parseInt(input[i]);
                ip=ip+input[i];
                ans=ans+input[i];
              }
              Arrays.sort(input);
              
              for(int i=0;i<input.length;i++)
              {
                index=ip.indexOf(input[i]);
                for(int j=index;j>=0;j--)
                {
                  if(input1[j]<input1[index]){
                    break;
                  }
                  left=j;
                }
                
                for(int j=index;j<input.length;j++)
                {
                  if(input1[j]<input1[index]){
                    break;
                  }
                  right=j;
                }
                
                
                ip=ip.replaceFirst(input[i],".");
//                System.out.print(ip+" ");
//                System.out.println("index="+index+" left= "+left+" right="+right+" \n");
//                
                String subStr="";
                for(int j=left;j<=right;j++)
                {
                  if(input1[index]!=0)
                  countBraces[j]=countBraces[j]+1;
                  subStr=subStr+Integer.toString(input1[j]);
                }
                if(input1[index]!=0){
                ans=ans.replaceFirst(subStr,"("+subStr+")");
//                int ct=input1[index]-countBraces[index];
//                 System.out.println("ct="+ct);
                
//                for(int temp=0;temp<countBraces.length;temp++)
//                {
//                  System.out.print(countBraces[temp]+" ");
//                }
                if(countBraces[index]<input1[index])
                {
                  String sstr=subStr;
                  int ct=input1[index]-countBraces[index];
                  //System.out.println("ct="+ct);
                  for(int k=0;k<ct;k++)
                  {
                    sstr="("+sstr+")";
                  }
                  ans=ans.replaceFirst(subStr,sstr);
                  for(int k=left;k<=right;k++)
                  {
                    countBraces[k]=input1[index];
                  }
                }
               
                //System.out.println(ans);
                
                
                }
              ans=ans.replaceFirst(input[i],".");
              }
              //System.out.println(ans);
              int temp=0;
              String finalAns="";
              for(int k=0;k<ans.length();k++)
                {
                  if(ans.charAt(k)=='.')
                  {
                    finalAns+=Integer.toString(input1[temp]);
                    temp++;                 
                  }
                  else
                  finalAns+=Character.toString(ans.charAt(k));
                }
                System.out.println("Case #"+caseNo+": "+finalAns);
                
             testCases--;
             caseNo++;
        }
  }
}