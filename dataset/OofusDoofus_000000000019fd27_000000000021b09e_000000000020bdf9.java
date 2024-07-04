import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int N = in.nextInt();
            int[][] times = new int[N][2];
            int max = 0;
            for(int j = 0; j< N; j++){
                times[j][0] = in.nextInt();
                times[j][1] = in.nextInt();
                max = Math.max(times[j][1],max);

            }

            int[] timeline = new int[max + 1];

            for(int j = 0; j < N; j++){
                timeline[times[j][0]]++;
                timeline[times[j][1]]--;

            }

            int[] workers = new int[max + 1];
            int add = 0;

            boolean b = false;

            for(int j = 0; j < max; j++){
                add+= timeline[j];
                if(add > 2){
                    b = true;
                    break;

                }
                workers[j] = add;

            }
            if(b)
                System.out.println("Case #" + T + ": IMPOSSIBLE");
            else{
                System.out.println("Case #" + T + ": ");
                char C = 'C';
                char J = 'J';
                int prev = 0;
                char prevC = J;
                for(int j  = 0; j< max; j++){
                    if(workers[j] > prev){
                        if(workers[j] == 1){
                            System.out.print(C);
                            prevC = C;

                        }
                        else{
                            if(prevC == C){
                                System.out.print(J);
                                prevC = J;

                            }
                            else {
                                System.out.print(C);
                                prevC = C;
                            }

                        }

                    }
                    prev = workers[j];


                }

            }

        }

    }

}
