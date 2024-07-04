import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.println("Case #"+test+": ");
            test++;
            int n=in.nextInt();
            int i=1;
            int c=0;
            while(i<n+1)
            {
                i*=2;
                c++;
            }
            if(i>n+1)
            {
                i/=2;
                c--;
            }
            int ii=1;
            for(ii=1;ii<=c;ii++)
            {
                if((ii&1)==0)
                {
                    for(int j=1;j<=ii;j++)
                        System.out.println(ii+" "+j);
                }
                else
                {
                    for(int j=ii;j>=1;j--)
                        System.out.println(ii+" "+j);
                }
            }
            while(i<n+1)
            {
                if((c&1)==1)
                    System.out.println(ii+" "+1);
                else
                    System.out.println(ii+" "+ii);
                i++;
                ii++;
            }
            
        }
    }
}
