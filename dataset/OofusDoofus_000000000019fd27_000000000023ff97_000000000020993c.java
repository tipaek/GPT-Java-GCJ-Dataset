import java.io.*;
import java.util.*;

public class Q2020Vestigium {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for(int a = 1; a <= T; a++){
            int N = in.nextInt();
            int[][] square = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    square[i][j] = in.nextInt();

                }

            }


            System.out.print("Case #" + a + ": ");

            int k = 0;

            for(int i = 0; i < N; i++){
                k+= square[i][i];

            }

            System.out.print(k+" ");

            int r = 0;

            for(int i = 0; i < N; i++){
                HashSet<Integer> h = new HashSet<>();
                for(int j = 0; j < N; j++){
                    h.add(square[i][j]);

                }
                if(h.size() < N)
                    r++;
            }

            System.out.print(r + " ");

            int c = 0;

            for(int i = 0; i < N; i++){
                HashSet<Integer> h = new HashSet<>();
                for(int j = 0; j < N; j++){
                    h.add(square[j][i]);

                }
                if(h.size() < N)
                    c++;
            }

            System.out.println(c + " ");


        }

    }

}
