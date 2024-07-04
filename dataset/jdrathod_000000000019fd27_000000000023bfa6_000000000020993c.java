import java.util.*;
public class MyClass {
    public static void main(String[] args)
    {
        MyClass ob=new MyClass();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int i;
        for(i=0;i<t;i++)
        {
            int sum=0;
            int r=0;
            int c=0;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int temp[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                int ary[]=new int[n];
                for(int k=0;k<n;k++)
                {
                    a[j][k]=sc.nextInt();
                    ary[k]=a[j][k];
                    temp[k][j]=a[j][k];
                    if(j==k)
                        sum=sum+a[j][k];
                }
                Arrays.sort(ary);
                for(int k=1;k<n;k++)
                {
                    if(ary[k-1]==ary[k])
                    {
                        r+=1;
                        break;
                    }
                }
            }
            for(int j=0;j<n;j++)
            {
                int ary[]=new int[n];
            for(int k=0;k<n;k++)
            {
              ary[k]=temp[j][k];  
            }
            Arrays.sort(ary);
            for(int k=1;k<n;k++)
                {
                    if(ary[k-1]==ary[k])
                    {
                        c+=1;
                        break;
                    }
                }
            }
            System.out.print("Case #"+(i+1)+":");
            System.out.print(sum+" ");
            System.out.print(r+" ");
            System.out.println(c);
        }
        
    }
}
