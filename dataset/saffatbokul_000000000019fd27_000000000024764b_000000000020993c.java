import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		

		int totInp = Integer.valueOf(reader.readLine());
		int[][] x = null;
		for (int i = 0; i < totInp; i++) {
            int diag=0;
            
			int size = Integer.valueOf(reader.readLine());

			x = new int[size][size];
            
            int repRow=0;
            
			for (int j = 0; j < size; j++) {
				
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine()," " );
				
				
				HashSet<Integer> hsr = new HashSet<Integer>();
                boolean rower = false;
				
				int sec = 0;
				

				
				while (tokenizer.hasMoreTokens() && sec < size) {

					x[j][sec] = Integer.valueOf(tokenizer.nextToken());
				    if (hsr.add(x[j][sec]) == false ) {
				         rower=true;
				    }
				    sec++;
					
				}
				if(x[j][j]>0) {
					diag=diag+x[j][j];
				}
				if(rower==true) {
					repRow++;
				}



			}
			int repCol=0;
			for(int c=0; c<size; c++) {
				boolean coller=false;
				HashSet<Integer> hsr = new HashSet<Integer>();
				for(int row=0; row<size; row++) {
				    if (hsr.add(x[row][c]) == false ) {
				    	coller=true;
				    }
				}
				
				if(coller) {
					repCol++;
				}

				
			}
			
			System.out.println("Case #"+(i+1)+": "+diag+" "+repRow+" "+repCol);
			


		}

		
	}
}