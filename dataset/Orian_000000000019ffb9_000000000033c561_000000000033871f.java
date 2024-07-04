
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String args[]){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int C = in.nextInt();
            int D = in.nextInt();

            System.out.print("Case #" + i + ": ");

            int[] xs = new int[C];
            xs[0] = 0;
            // int[] latency = new int[D];

            for (int numComputer = 2; numComputer <= C; numComputer++){
                xs[numComputer - 1] = in.nextInt();
            }

            for (int numConnection = 0; numConnection < D; numConnection++){

                int xa = xs[in.nextInt()-1];
                int xb = xs[in.nextInt()-1];

                if (xa == xb){
                    System.out.print(1 + " ");
                }
                else{
                    System.out.print(Math.abs(xa - xb) + " ");
                }


            }

            System.out.println();

        }

        in.close();

    }

}