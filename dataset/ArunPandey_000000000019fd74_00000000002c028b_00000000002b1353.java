import java.util.Scanner;
public class Solution 
{ 
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n = sc.nextInt();
            System.out.println("Case #"+(k)+": ");
            if(n==501)
            {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                int i=3,j=3;
                while(i<=500)
                {
                    System.out.println(i+" "+j);
                }
            }
            else if(n<=500)
            {
                int i=1,j=1;
                while(n>0)
                {
                    System.out.println(i+" "+j);
                    n--;
                    i++;
                    j++;
                }
            }
        } 
    }
}  

