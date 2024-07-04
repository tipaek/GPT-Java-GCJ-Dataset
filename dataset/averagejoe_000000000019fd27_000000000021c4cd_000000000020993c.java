import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Vestigium {

    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int nCases;
        try {
            nCases = Integer.parseInt(br.readLine());

            Map<Integer,Integer> map = new HashMap<>();
        
            for (int i = 0; i < nCases; i++) {
                int N = Integer.parseInt(br.readLine());
                int[][] mat = new int[N][N];
                int rCounter = 0;
                int cCounter = 0;
                int k = 0;

                for (int r = 0; r < N; r++) {
                    boolean added = false;
                    String numString = br.readLine();
                    String[] s = numString.split(" ");
                    
                    for (int c = 0; c < N; c++) {
                        int num = Integer.parseInt(s[c]);
                        mat[r][c] = num;
                        if (r == c) k += num;
                        if (map.get(num) != null && !added ) {
                            added = true;
                            rCounter++;
                        } else {
                            map.put(num, 1);
                        } 
                    }
                    map.clear();
                }

                for (int c = 0; c < N; c++) {
                    boolean added = false;
                    for(int r = 0; r < N; r++) {
                        int num = mat[r][c];
                        if (map.get(num) != null && !added ) {
                            added = true;
                            cCounter++;
                        } else {
                            map.put(num, 1);
                        } 
                    }
                    map.clear();
                }
                System.out.println(String.format("Case #%d: %d %d %d", i+1, k, rCounter, cCounter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}