import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		Scanner in1 = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int totInp = in1.nextInt();
		int[][] x = null;
		for (int i = 0; i < totInp; i++) {
            int diag=0;
            
			int size = in1.nextInt();

			x = new int[size][size];
            
            int repRow=0;
            
			for (int j = 0; j < size; j++) {
				HashSet<Integer> hsr = new HashSet<Integer>();
                boolean rower = false;
				BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				int c = 0;
				int sec = 0;
				while ((c = buffer.read()) != -1 && sec < size) {

					x[j][sec] = (int) c - 48;
				    if (hsr.add(x[j][sec]) == false ) {
				         rower=true;
				    }
				    sec++;
					buffer.skip(1);
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
			


		}

		
	}
}