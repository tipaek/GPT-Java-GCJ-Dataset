/**
 * Created by user on 4/3/2020.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int c=1;c<=cases;c++){
           wr.write("Case #"+c+":");
           int size = Integer.parseInt(br.readLine());
           int[][] arr = new int[size][size];
           for(int i=0;i<size;i++){
               StringTokenizer st = new StringTokenizer(br.readLine());
               for(int j=0;j<size;j++){
                   arr[i][j] = Integer.parseInt(st.nextToken());
               }

           }
           long trace = 0;
           for(int i=0;i<size;i++){
               trace+=arr[i][i];
           }
           int colCount=0;
           for(int i=0;i<size;i++) {
               boolean[] seen = new boolean[size+1];
               for (int j = 0; j < size; j++) {
                   int val = arr[i][j];
                   if(seen[val]) {
                       colCount++;
                        break;
                   }
                   seen[val]=true;
               }
           }

            int rowCount=0;
            for(int i=0;i<size;i++) {
                boolean[] seen = new boolean[size+1];
                for (int j = 0; j < size; j++) {
                    int val = arr[j][i];
                    if(seen[val]) {
                        rowCount++;
                        break;
                    }
                    seen[val]=true;
                }
            }

            wr.write(" "+trace);
            wr.write(" "+colCount);
            wr.write(" "+rowCount);
            wr.write("\n");


        }
        wr.close();
    }
}

