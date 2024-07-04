import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            long sum = 0;
            if(N < 501)
            {
                System.out.println("Case #" + (i+1) + ": ");
                for(int j=0;j<N;j++) {
                    sum++;
                    System.out.println(j + 1 + " " + 1);
                }
            }
            else if(N == 501)
            {
                System.out.println("Case #" + (i+1) + ": ");
                for(int j=0;j<N-3;j++)
                {
                    if(j == 2)
                    {
                        sum+=2;
                        System.out.println(j+1 + " " + 2);
                    }
                    sum++;
                    System.out.println(j+1 + " " + 1);
                }
            }
        }
    }
}
