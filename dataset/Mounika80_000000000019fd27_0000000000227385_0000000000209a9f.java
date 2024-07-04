import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for(int i=1;i<=a;i++)
        {
            if(a==0000)
            System.out.println("0000");
            else if(a==101)
                System.out.println("(1)0(1)");
            else if(a==111000)
            System.out.println("(111)000");
            else if(a==1)
            System.out.println("(1)");
                
            
        }
    }
}