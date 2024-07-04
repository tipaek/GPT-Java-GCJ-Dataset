import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int[][] arr=new int[n][2];
            int[][] arr1=new int[n][2];
            for(int j=0;j<n;j++)
            {
                int val1 = sc.nextInt();
                int val2 = sc.nextInt();
                arr[j][0]=val1;
                arr[j][1]=val2;
                arr1[j][0]=val1;
                arr1[j][1]=val2;
            }
            for(int j=0;j<n-1;j++)
            {
                for(int k=0;k<n-j-1;k++)
                {
                    if(arr[k][0]>arr[k+1][0])
                    {
                        int temp = arr[k][0];
                        arr[k][0] = arr[k+1][0];
                        arr[k+1][0] = temp;
                        temp = arr[k][1];
                        arr[k][1] = arr[k+1][1];
                        arr[k+1][1] = temp;
                    }
                    if(arr[k][0]==arr[k+1][0])
                    {
                        if(arr[k][1]>arr[k+1][1])
                        {
                            int temp = arr[k][1];
                            arr[k][1] = arr[k + 1][1];
                            arr[k + 1][1] = temp;
                        }
                    }
                }
            }
            char[] ch=new char[n];
            char last='C';
            int flag=0;
            for(int j=0;j<n;j++)
            {
                int val=-1;
                for(int k=0;k<n;k++)
                {
                    if(arr[j][0]==arr1[k][0] && arr[j][1]==arr1[k][1])
                    {
                        arr1[k][0]=-1;
                        arr1[k][1]=-1;
                        val=k;
                        break;
                    }
                }
                if(j==0)
                {
                    ch[val]='C';
                }
                else
                {
                    if(last=='C')
                    {
                        if(arr[j][0]>=arr[j-1][1])
                            ch[val]='C';
                        else
                        {
                            ch[val]='J';
                            last='J';
                        }
                    }
                    else
                    {
                        if(arr[j][0]>=arr[j-2][1])
                        {
                            ch[val]='C';
                            last='C';
                        }
                        else
                        {
                            if(arr[j][0]>=arr[j-1][1])
                                ch[val]='J';
                            else
                            {
                                flag=1;
                                break;
                            }
                        }
                    }
                }
            }
            String s= new String(ch);
            if(flag==0)
                System.out.println("Case #"+i+": "+s);
            else
                System.out.println("Case #"+i+": IMPOSSIBLE");
        }
    }
}