import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();

            int[][] ar = new int[N][N];

            int row = 0; 
            int column = 0;

            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < N; j2++) {
                    ar[j][j2] = scan.nextInt();
                }
            }
            
            for (int j = 0; j < ar.length; j++) {
                
            }
            for (int j = 0; j < N; j++) {
                HashSet<Integer> set = new HashSet<>();
                f1 : for (int j2 = 0; j2 < N; j2++) {
                    if(set.contains(ar[j][j2])){
                        row++;
                        break f1;
                    }
                    else{
                        set.add(ar[j][j2]);
                    }

                }
                
            }
            for (int j = 0; j < N; j++) {
                HashSet<Integer> set = new HashSet<>();
                f1 : for (int j2 = 0; j2 < N; j2++) {
                    if(set.contains(ar[j2][j])){
                        column++;
                        break f1;
                    }
                    else{
                        set.add(ar[j2][j]);
                    }
                }
                
            }
            System.out.println(row + " " + column);


        }
    }

   
}