import java.util.Scanner;

/**
 *
 * @author user
 */
public class Solution implements Runnable
{

    public static void main(String[] args)
    {
        new Solution().run();
    }

    int[] bits;
    @Override
    public void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        
        for (int t = 1; t <= T; t++)
        {
            bits = new int[B];
            for (int b = 0; b <10; b++)
            {
                System.out.println(b+1);
                bits[b] = sc.nextInt();
            }
            printBits();
            sc.nextLine();
            sc.nextLine();
        }

    }
    
    void printBits(){
        for(int b:bits){
            System.out.print(b);
        }
        System.out.println("");
    }
}
