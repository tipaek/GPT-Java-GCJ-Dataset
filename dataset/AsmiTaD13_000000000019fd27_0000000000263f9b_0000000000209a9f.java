import java.util.*;
import java.lang.*;

public class Solution{
     public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int T=0;
        T=sc.nextInt();
        int len=0;
        String N[]=new String[T];
        String R[]=new String[T];
        String temp="";
        int i=0,j=0;
        for(i=0;i<T;i++)
        {
            N[i]=sc.next();
            len=N[i].length();
            for(j=0;j<len;j++)
            {
                if(N[i].charAt(j)=='0' && j==0)
                {
                    temp=temp+"0";
                }
                else if(N[i].charAt(j)=='1' && j==0 && 0==(len-1))
                {
                    temp=temp+"(1)";
                }
                else if(N[i].charAt(j)=='0' && N[i].charAt(j-1)=='1')
                {
                    temp=temp+")0";
                }
                else if(N[i].charAt(j)=='1' && j==0)
                {
                    temp=temp+"(1";
                }
                else if (N[i].charAt(j)=='1' && j==(len-1) && N[i].charAt(j-1)=='0' )
                {
                    temp=temp+"(1)";
                }
                else if (N[i].charAt(j)=='1' && j==(len-1) )
                {
                    temp=temp+"1)";
                }
                else if (N[i].charAt(j)=='1' && N[i].charAt(j-1)=='1')
                {
                    temp=temp+"1";
                }
                else if (N[i].charAt(j)=='1')
                {
                    temp=temp+"(1";
                }
                else if (N[i].charAt(j)=='0')
                {
                    temp=temp+"0";
                }
            }
            R[i]=temp;
            temp="";
        }
        for(i=0;i<T;i++)
            System.out.println(R[i]);
    }
}