import java.io.*;
import java.util.*;
public class solution {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int testcases = sc.nextInt();
        for(int kmn=1;kmn<=testcases;kmn++)
        {
            int boom=0;
            int act = sc.nextInt();
            int[][] arr = new int[act][2];
            int[][] real= new int[act][2];
            char[] res = new char[act];
            int c=0;
            int j=0;
            for(int i=0;i<act;i++)
            {
                arr[i][0] =sc.nextInt();
                arr[i][1] =sc.nextInt();
                real[i][0]=arr[i][0];
                real[i][1]=arr[i][1];
            }
            for(int kl=0;kl<act;kl++)
            {
                for(int i=0;i<act-1;i++)
                {
                    if(arr[i][0]>arr[i+1][0])
                    {
                        int temp1=arr[i+1][0];
                        int temp2=arr[i+1][1];
                        arr[i+1][0]=arr[i][0];
                        arr[i+1][1]=arr[i][1];
                        arr[i][0]=temp1;
                        arr[i][1]=temp2;
                    }
                }
            }





            res[0]='C';
            c=arr[0][1];

            for(int i=1;i<act;i++)
            {
                if(arr[i][0]>=c)
                {   
                    res[i]='C';
                    c=arr[i][1];
                }
                else if(arr[i][0]<c&&arr[i][0]>=j)
                {
                    res[i]='J';
                    j=arr[i][1];
                }
                else
                {
                    boom=1;
                }
                
            }
            for(int i=0;i<act;i++)
            {
                for(int q=0;q<act;q++)
                {
                    if(real[i][0]==arr[q][0] && real[i][1]==arr[q][1])
                    {
                        int temp1=arr[q][0];
                        int temp2=arr[q][1];
                        arr[q][0]=arr[i][0];
                        arr[q][1]=arr[i][1];
                        arr[i][0]=temp1;
                        arr[i][1]=temp2;

                        char temp=res[i];
                        res[i]=res[q];
                        res[q]=temp;

                    }
                }
            }
            if(boom==1)
            {
                System.out.println("Case #"+kmn+": IMPOSSIBLE");
            }    
            else{
                System.out.print("Case #"+kmn+": ");
                for(int i=0;i<act;i++)
                {
                    System.out.print(res[i]);
                }
                System.out.println();
            }
        }
    }

}