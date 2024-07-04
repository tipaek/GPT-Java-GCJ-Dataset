
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        int N, T;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int sum =0;
        int rows =0;
        int columns = 0;
        for (int i = 0; i < N; i++) {
            T = s.nextInt();
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
         //   Case #1: 4 0 0

            for (int j = 0; j <T ; j++) {
                 Set<Integer> tempSet = new HashSet<>();
                for (int k = 0; k <T ; k++) {
                    
                    int num=ar[j][k];
                     if(!tempSet.add(num)){
                        rows++;
                        break;
                    }
                   
                }
            }
            for (int j = 0; j <T ; j++) {
                Set<Integer> tempSet = new HashSet<>();
                for (int k = 0; k <T; k++) {
                        int num = ar[k][j];
                    if(!tempSet.add(num)){
                        columns++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+":" +" "+sum+" "+rows+" "+columns);
            sum = rows = columns = 0;
        }

    }
}