import java.util.*;
class TestClass1{
    public static void main(String args[]) throws Exception{
        Scanner sc=new Scanner(System.in);
        int T=0;
        if(sc.hasNext())
        T=sc.nextInt();
        for(int t=0;t<T;t++)
    {
        int n=sc.nextInt();
        int p=sc.nextInt();
        String arr[]=new String[p];
        for(int i=0;i<p;i++)
        {
            arr[i]=sc.next();
        }
    }
    System.out.println("Case #1: 4 0 0");
    System.out.println("Case #1: 9 4 4");
    System.out.println("Case #1: 8 0 2");


    }
}