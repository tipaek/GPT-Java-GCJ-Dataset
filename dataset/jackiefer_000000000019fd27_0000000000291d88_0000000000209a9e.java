import java.util.*;
class Solution
{
    public static void main(String ar[])
    {   Scanner sc=new Scanner(System.in);
        int tcases=sc.nextInt();
        int bytes=sc.nextInt();
        for(int t=0;t<tcases;t++)
        {   String str="";
            int ch='Y';
            int arr[]=new int[bytes];
            while(ch='Y')
            {
                for(int i=0;i<bytes;i++)
                {
                    System.out.println(i);
                    arr[i]=sc.nextInt();
                }
                for(int j=0;j<bytes;j++)
                {
                    str+=arr[j];
                }
                System.out.println(str);
                ch=sc.nextChar();
                if(ch=='N')
                exit();
            }
        }
    }
}