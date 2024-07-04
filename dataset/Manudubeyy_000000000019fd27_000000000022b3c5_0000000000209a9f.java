
import java.io.*;
import java.util.Scanner;
public class Main
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextLine();
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }
    }
}