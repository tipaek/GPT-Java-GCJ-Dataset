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
            System.out.println(1+" "+1);
            if(n>=2)
                System.out.println(2+" "+1);
            if(n==3)
                System.out.println(3+" "+1);
            else if(n>3)
                System.out.println(3+" "+2);
            int cnt=4;
            if(n>=5)
            {
                int i=3;
                while(cnt<n)
                {
                    System.out.println(i+" "+i);
                    i++;
                    cnt++;
                }
            }
        }
    }
}
