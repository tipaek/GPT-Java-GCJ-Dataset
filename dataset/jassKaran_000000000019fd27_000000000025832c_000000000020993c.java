
import java.util.Scanner;

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
                for (int k = 0; k <T ; k++) {
                    boolean isDuplicate = false;
                    int num=ar[j][k];
                    for (int l = k+1; l <T ; l++) {
                        if(num==ar[j][l]){
                            rows++;
                            isDuplicate= true;
                            break;
                        }
                    }
                    if(isDuplicate)
                        break;
                }
            }
            for (int j = 0; j <T ; j++) {
                for (int k = 0; k <T ; k++) {
                    boolean isDuplicate = false;
                    int num=ar[j][k];
                    for (int l = k+1; l <T ; l++) {
                        if(num==ar[l][j]){
                            isDuplicate= true;
                            columns++;
                            break;
                        }
                    }
                    if(isDuplicate)
                        break;
                }
            }
            System.out.println("Case #"+(i+1)+":" +" "+sum+" "+rows+" "+columns);
            sum = rows = columns = 0;
        }

    }
}
