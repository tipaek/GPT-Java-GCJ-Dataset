import java.io.*;
class Solution
{
void input(int t)throws IOException
{String st,stt="";
int i=0,j,l,k=0,count1=0,n[],p=1,x;
InputStreamReader obj1 =new InputStreamReader(System.in);
     BufferedReader obj2 =new BufferedReader(obj1);
     //st=new String[t];
     while(t!=0)
     {
    
     st=obj2.readLine();
   
    
     l=st.length();
     n=new int[l];
     for(i=0;i<l;i++)
     n[i]=st.charAt(i)-48;
      count1=0;
     for(i=0;i<l;i++)
     {
      if(n[i]>=count1)
      {for(j=0;j<(n[i]-count1);j++)
      stt=stt+"(";
      count1=count1+(n[i]-count1);
      }
      else
     { for(j=0;j<count1-n[i];j++)
      stt=stt+")";
      count1=count1-(count1-n[i]);
      }
      stt=stt+n[i];
      }
      for(i=0;i<count1;i++)
      {
      stt=stt+")";
      }
      System.out.println("Case #"+p+": "+stt);
      p++;  t--;
      stt="";}}
      public static void main(String args[])throws IOException
      {int t;
      InputStreamReader obj1 =new InputStreamReader(System.in);
     BufferedReader obj2 =new BufferedReader(obj1);
     //System.out.println("enter test");
    t=Integer.parseInt(obj2.readLine());
   Solution ob =new Solution();
    ob.input(t);
    }}
      