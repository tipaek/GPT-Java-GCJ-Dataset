import java.util.Scanner;


public class Solution
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();

            System.out.println(calculMatrice(N, K, ks));
        }

    }
    
    static String calculMatrice(int n, int trace, int iteration) {
        
        if(trace % n == 0)
        {
            return "Case #" + iteration + ": "+"POSSIBLE";
        }
        else
        {
           return "Case #" + iteration + ": "+"IMPOSSIBLE";
        }
    }
}