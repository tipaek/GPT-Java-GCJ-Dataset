
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        int N, T;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int sum =0;
       
        int K =0;
        for (int i = 0; i < N; i++) {
            T = s.nextInt();
            K =s.nextInt();
            int ar[][] = new int[T][T];
            for (int j = 0; j <T ; j++) {
                for (int k = 0; k <T ; k++) {
                    ar[j][k] = s.nextInt();
                }
            }
            for (int j = 0; j <T ; j++) {
                for (int k = 0; k <T ; k++) {
                        if(j==k)
                            sum = sum +ar[j][k];
                }
            }
            if(sum==K)
            System.out.println("Case #"+(i+1)+":" +" POSSIBLE");
            else
            System.out.println("Case #"+(i+1)+":" +" IMPOSSIBLE");
            K=0;
        }

    }
}
