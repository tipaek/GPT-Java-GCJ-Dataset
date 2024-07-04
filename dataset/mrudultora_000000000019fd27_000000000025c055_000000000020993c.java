import java.util.*;
public class Solution{
    public static void main(String[] args)
    {
        int n,t,count=0;int [][] arr=new int[100][100];
        int [] k= new int[100];
        int [] r= new int[100];
        int [] c= new int[100];
        Scanner sc=new Scanner(System.in);
        t=Integer.parseInt(sc.nextLine());
        for(int a=0;a<n;a++)
        {
            n=Integer.parseInt(sc.nextLine());
            for(int b=0;b<n;b++)
            {
                for(int c=0;c<n;c++)
                {
                    arr[b][c]=sc.nextInt();
                }
            }
        }
        for(int b=0;b<n;b++)
            {
                for(int c=0;c<n;c++)
                {   if(b==c)
                    k[count]+=arr[b][c];
                }
                for(int m=b;m<n;m++)
                {
                    if(arr[b][m]==arr[b][m+1])
                    { r[count]++;break;}
                }
                for(int l=b;l<n;l++)
                {
                    if(arr[b][l]==arr[b+1][l])
                    { c[count]++;break;}
                }
                count++;
            }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+i+1+":"+" "+k[i]+" "+r[i]+" "+c[i]);
        }
    }
}