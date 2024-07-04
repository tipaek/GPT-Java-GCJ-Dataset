import java.io.*;
class matrix
{
void input(int t)throws IOException
 {//System.out.println(t);
        int i=0,j=0,k=0,m[][],n,count1=0,count2=0,flag1=0,flag2=0,trace=0,p;
      InputStreamReader obj1 =new InputStreamReader(System.in);
     BufferedReader obj2 =new BufferedReader(obj1);
     //System.out.println("enter n");
   p=1;
    while(t!=0){
     n=Integer.parseInt(obj2.readLine());
     m=new int[n][n];
    //System.out.println("enter");
     for(i=0;i<n;i++)
     {
         for(j=0;j<n;j++)
         {
             m[i][j]=Integer.parseInt(obj2.readLine());
         }
     }
      for(i=0;i<n;i++)
      {
      for(j=0;j<n;j++)
      {
      if(i==j)
      trace=trace+m[i][j];
      for(k=j+1;k<n;k++)
      {
      if(m[i][j]==m[i][k])
      flag1=1;
      if(m[j][i]==m[k][i])
      flag2=1;
      }}
      if(flag1==1)
      {count1++;
      flag1=0;
      }
      if(flag2==1)
      {
      count2++;
     flag2=0;
      }}
    t--;
      System.out.println("Case #"+p+":  "+trace+" "+count1+" "+count2);
     p++; trace=0;count1=0;
     count1=0;}}
      public static void main(String args[])throws IOException
      {int tt;
      InputStreamReader obj1 =new InputStreamReader(System.in);
     BufferedReader obj2 =new BufferedReader(obj1);
    // System.out.println("enter testcase");
     tt=Integer.parseInt(obj2.readLine());
      matrix ob =new matrix();
    ob.input(tt);
      }}