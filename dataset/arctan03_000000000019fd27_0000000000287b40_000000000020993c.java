import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(f.readLine());

        for(int t = 1; t <= T; t++){

            int N = Integer.parseInt(f.readLine());

            int badr = 0;
            int badc = 0;
            int trace = 0;

            boolean[][] cseen = new boolean[N][N+1]; // [col][val]
            boolean[] cflag = new boolean[N];

            for(int i = 0; i < N; i++){
                StringTokenizer line = new StringTokenizer(f.readLine());
                boolean rflag = false;
                boolean[] rseen = new boolean[N+1];

                for(int j = 0; j < N; j++){
                    int v = Integer.parseInt(line.nextToken());
                    if(i==j) trace+=v;

                    if(rseen[v]) rflag=true;
                    else rseen[v]=true;

                    if(cseen[j][v]) cflag[j]=true;
                    else cseen[j][v]=true;
                }
                if(rflag) badr++;
            }

            for(int i = 0; i < N; i++){
                if(cflag[i]) badc++;
            }


            System.out.println("Case #" + t + ": " + trace + " " + badr + " " + badc);

        }


    }
}
