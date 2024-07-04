import java.util.Scanner;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        sc.nextLine();
        int z=1;
        while(t!=0)
        {
            StringBuffer str1=new StringBuffer();
            int n;
            n=sc.nextInt();
            int a[][]=new int[n][3];
            char ch[]=new char[n];
            for(int i=0;i<n;i++)
            {
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                a[i][2]=i;
            }
            int c=0;
            int cend=0;
            int jend=0;
            int j=0;

            for(int i=0;i<n-1;i++)
            {
                for(int k=i;k<n-i-1;k++)
                {
                    if(a[k][0]>a[k+1][0])
                    {
                        int temp;
                        temp=a[k][0];
                        a[k][0]=a[k+1][0];
                        a[k+1][0]=temp;

                        temp=a[k][1];
                        a[k][1]=a[k+1][1];
                        a[k+1][1]=temp;

                        temp=a[k][2];
                        a[k][2]=a[k+1][2];
                        a[k+1][2]=temp;
                    }
                }
            }

            for(int i=0;i<n;i++)
            {
                if(cend<=a[i][0])
                    c=0;
                if(jend<=a[i][0])
                    j=0;
                if(c==0)
                {
                    c=1;
                    cend=a[i][1];
                    ch[a[i][2]]='C';
                }
                else if(j==0)
                {
                    j=1;
                    jend=a[i][1];
                    ch[a[i][2]]='J';
                }
                else
                {
                    str1=new StringBuffer("IMPOSSIBLE");
                    break;
                }

            }
            String str=str1.toString();
            if(str.equals("IMPOSSIBLE")==false)
                str1.append(ch);
            System.out.println("Case #"+z+":"+" "+str1);
            z++;
            t--;
        }
    }
}
