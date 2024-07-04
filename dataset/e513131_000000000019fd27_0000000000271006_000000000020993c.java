import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
    	Scanner s = new Scanner(System.in);
        int merp = s.nextInt();

        for(int i=0; i<merp; i++) {
            int N = s.nextInt();
            int[][] square = new int[N][N]; 

            int t = 0;
            int r = 0;
            int c = 0;

            for(int j=0; j<N; j++) {
                List<Integer> seen = new ArrayList<Integer>();
                boolean repeated = false;
                boolean traced = false; 

                for(int k=0; k<N; k++) {
                    int current = s.nextInt();
                    square[j][k] = current;
                    if(j==k) {
                        t+=current;
                        traced = true;
                        // System.out.println("Adding " + current);
                    }
                    if(seen.contains(current) && !repeated) {
                        r++;
                        repeated = true;
                    } else {
                        seen.add(current);
                    }
                }
            }

            for(int j=0; j<N; j++) {
                List<Integer> seen = new ArrayList<Integer>();

                for(int k=0; k<N; k++) {
                    int current = square[k][j];
                    if(seen.contains(current)) {
                        c++;
                        break;
                    } else {
                        seen.add(current);
                    }
                }
            }

            System.out.println("Case #" + (i+1) + ": " + t + " " + r + " " + c);
        }

        s.close();
    }
}