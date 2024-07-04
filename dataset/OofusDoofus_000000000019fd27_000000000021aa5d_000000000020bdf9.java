import java.io.*;
import java.util.*;

public class Q2020Parenting {

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
                System.out.println("Case #" + N + ": IMPOSSIBLE");
            else{
                System.out.println("Case #" + N + ": ");
                char C = 'C';
                char J = 'J';
                int prev = 0;
                for(int j  = 0; j< max; i++){
                    if(workers[j] > prev){
                        if(workers[j] == 1){
                            System.out.print(C);

                        }
                        else{
                            if(workers[j - 1] == C){
                                System.out.print(J);

                            }
                            else
                                System.out.print(C);

                        }

                    }
                    prev = workers[j];


                }

            }

        }

    }

}
