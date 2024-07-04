import java.util.Scanner;
public class CodeJamProb3 
{
    public static void main(String[] args) 
    {     
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j=0;j<t;j++) 
        {
            int n = sc.nextInt();
            int x = sc.nextInt();
            System.out.println(n+x);
        }
    }
}