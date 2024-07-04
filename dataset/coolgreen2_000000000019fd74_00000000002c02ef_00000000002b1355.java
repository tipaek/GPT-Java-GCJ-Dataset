import java.util.*;
import java.io.*;


public class Solution {

   static int[][] locations;
   static boolean[][] eliminated;
   static int[][][] neighbors;
	
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
      int T = Integer.parseInt(br.readLine());
   	
      for (int cases = 1; cases <= T; cases++) {
         pw.print("Case #" + cases + ": " );
         StringTokenizer st = new StringTokenizer(br.readLine());
         int R = Integer.parseInt(st.nextToken());
         int C = Integer.parseInt(st.nextToken());
         locations = new int[R][C];
         eliminated = new boolean[R][C];
         neighbors = new int[R][C][4];
      	 int count = 0;
      	 for (int i = 0; i < R; i++) {
      		 st = new StringTokenizer(br.readLine());
      		 for (int j = 0; j < C; j++) {
      			 locations[i][j] = Integer.parseInt(st.nextToken());
      			 count += locations[i][j];
      			 Arrays.fill(neighbors[i][j], -1);
      		 }
      	 }
         boolean good = true;
         while (good) {
            good = false;
            int temp_count = 0;
            LinkedList<State> ll = new LinkedList<State>();
            for (int i = 0; i < R; i++) {
               for (int j = 0; j < C; j++) {
                  if (!eliminated[i][j]) {
                     int avg = 0;
                     int temp = 0;
                     if (i-1 >= 0 && !eliminated[i-1][j]) {
                    	 avg += locations[i-1][j]; temp++;
                     } else if (neighbors[i][j][0] != -1 && !eliminated[neighbors[i][j][0]][j]){
                    	 avg += locations[neighbors[i][j][0]][j]; temp++;
                     } else {
                    	 int a = i;
                    	 while (--a >= 0 && eliminated[a][j]);
                    	 if (a >= 0) {
                    		 neighbors[i][j][0] = a;
                    		 avg += locations[a][j];
                    		 temp++;
                    	 }
                     }
                     if (i + 1 < R && !eliminated[i+1][j]) {
                    	 avg += locations[i+1][j]; 
                    	 temp++;
                     } else if (neighbors[i][j][1] != -1 && !eliminated[neighbors[i][j][1]][j]){
                    	 avg += locations[neighbors[i][j][1]][j]; temp++;
                     } else {
                    	 int a = i;
                    	 while (++a < R && eliminated[a][j]);
                    	 if (a < R) {
                    		 neighbors[i][j][1] = a;
                    		 avg += locations[a][j];
                    		 temp++;
                    	 }
                     }
                     if (j - 1 >= 0 && !eliminated[i][j-1]) {
                    	 avg += locations[i][j-1]; 
                    	 temp++;
                     } else if (neighbors[i][j][2] != -1 && !eliminated[i][neighbors[i][j][2]]){
                    	 avg += locations[i][neighbors[i][j][2]]; temp++;
                     } else {
                    	 int a = j;
                    	 while (--a >= 0 && eliminated[i][a]);
                    	 if (a >= 0) {
                    		 neighbors[i][j][2] = a;
                    		 avg += locations[i][a];
                    		 temp++;
                    	 }
                     }
                     if (j + 1 < C && !eliminated[i][j+1]) {
                    	 avg += locations[i][j+1]; 
                    	 temp++;
                     } else if (neighbors[i][j][3] != -1 && !eliminated[i][neighbors[i][j][3]]){
                    	 avg += locations[i][neighbors[i][j][3]]; temp++;
                     } else {
                    	 int a = j;
                    	 while (++a < C && eliminated[i][a]);
                    	 if (a < C) {
                    		 neighbors[i][j][3] = a;
                    		 avg += locations[i][a];
                    		 temp++;
                    	 }
                     }
                     if (avg > temp * locations[i][j]) {
                        good = true;
                        ll.add(new State(i,j));
                     } 
                     else temp_count += locations[i][j];
                  }
               }
               
               
            }
            for (State s : ll) {
            	eliminated[s.x][s.y] = true;
            }
            if (good) count += temp_count;
         }
      
      	pw.println(count);
      	
      }
      pw.close();
   	
   	
   	
   }
   
   static class State {
	   int x;
	   int y;
	   
	   public State(int a, int b) {
		   x = a;
		   y = b;
	   }
	   
   }



}