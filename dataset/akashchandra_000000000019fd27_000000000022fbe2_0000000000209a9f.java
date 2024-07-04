import java.util.Scanner;
class Solution
{
    public static String less(String f, int d)
    {
        for(int i=0;i<d;i++)
        f=f+")";
        return f;
    }
    public static String great(String f, int d)
    {
        for(int i=0;i<d;i++)
        f=f+"(";
        return f;
    }
    public static String man(String a)
    {
        String f="";
        int n=a.length();
        int arr[]= new int[a.length()];
        for(int i=0;i<a.length();i++)
        arr[i] = Character.getNumericValue(a.charAt(i));
        f=great(f,arr[0]) + Integer.toString(arr[0]);
       
        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1])
            {
                f=great(f,arr[i]-arr[i-1]) + Integer.toString(arr[i]);
                
            }
            else if(arr[i]<arr[i-1])
            {
                f=less(f,arr[i-1]-arr[i]) + Integer.toString(arr[i]);
                
            }
            else
            {
                f=f+Integer.toString(arr[i]);
                
            }
        }
        for(int i=0;i<arr[n-1];i++)
        {
            f=f+")";
        }
        return f;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            String a = sc.next();
            a = man(a);
            System.out.println("Case #"+i+": "+a);
        }
    }
}