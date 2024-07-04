import java.io.*;
class Solution
{

    public static void main(String args[])throws IOException
    {int t;
    InputStreamReader obj1 =new InputStreamReader(System.in);
     BufferedReader obj2 =new BufferedReader(obj1);
     System.out.println("enter t");
     t=Integer.parseInt(obj2.readLine());
     
     int c=0,j=0,S[],E[],i,N,minj=0,minc=0,p=1,flag=1;
String st="";
while(t!=0)
    {
     //System.out.println("enter N");
    N=Integer.parseInt(obj2.readLine());
    S=new int[N];
    E=new int[N];
    for(i=0;i<N;i++)
    {
    S[i]=Integer.parseInt(obj2.readLine());
    E[i]=Integer.parseInt(obj2.readLine());
    }
    for(i=0;i<N;i++)
    {
    if(S[i]>=j)
    {st=st+"J";
    j=E[i];
    minj=S[i];
    }
    else if(S[i]>=c)
    {
    st=st+"C";
    c=E[i];
   minc=S[i];
    }else if(E[i]<minj&&S[i]<minj)
    {
        st=st+"J";
    }
    else if(E[i]<minc&&S[i]<minc)
    {
        st=st+"C";
    }
    else
    {st="IMPOSSIBLE";
    break;
    }}
   // if(flag==1)
    System.out.println("Case #"+p+": "+st);
    t--;st="";j=0;p++;
    c=0;minj=0;flag=0;
    minc=0;
    }
    }}
    