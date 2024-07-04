import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + (i+1) + ": ");
            long sum = 0;
            if(N < 501)
            {
                for(int j=0;j<N;j++) {
                    System.out.println((j+1) + " " + 1);
                }
            }
            else if(N == 501)
            {
                for(int j=0;j<N;j++)
                {
                    if(j == 2)
                    {
                        System.out.println(j+1 + " " + 2);
                        sum+=2;
                    }
                    else {
                        System.out.println(j+1 + " " + 1);
                        sum++;
                    }
                    if(sum == 501)
                        break;
                }
            }

        }
    }
}
