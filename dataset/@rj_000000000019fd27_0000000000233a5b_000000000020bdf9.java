import java.util.Scanner;
public class Solution
{
    public static void main(String args[])
    {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
for(int i=0;i<t;i++)
{
    int n=sc.nextInt();
    char arr[]=new char[n];
    int minc=-1,maxc=-1,minj=-1,maxj=-1,start=-1,end=-1;
    for(int j=0;j<n;j++)
    {
        start =sc.nextInt();
        end=sc.nextInt();
        if(start>=maxc || end<=minc)
        {
           arr[j]='C';
           minc=start;
           maxc=end;
           
        }
       else if(start<maxc && (start>=maxj || end<=minj))
        {
            arr[j]='J';
            minj=start;
            maxj=end;
        
        }
       else if(start<maxc && start<maxj)
        {
            arr[j]='A';
            break;
        }
    }
    String s="";
    System.out.print("Case #"+""+(i+1)+": ");
    for(int k=0;k<arr.length;k++)
    {
        
        if(arr[k]=='A')
        {
            s="IMPOSSIBLE";
            break;
        }
        else
        {
        s=s+""+arr[k];
    
        }
        
    }
    System.out.print(s);
    System.out.println("");
}
}
}