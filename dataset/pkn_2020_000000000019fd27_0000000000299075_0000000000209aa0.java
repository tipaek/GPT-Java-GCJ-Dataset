import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < T; i++) {

			String[] NK = br.readLine().trim().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);
			Integer[][] manufacMatrix = new Integer[N][N];

			String result = "";

			if (K % N == 0)
				result = "POSSIBLE";
			else
				result = "IMPOSSIBLE";

			// modifying according to the requirement
			if (result.equals("POSSIBLE")) {
				Integer[][] finalMatrix = Solution(N, K, manufacMatrix);
				System.out.println("Case #" + (i + 1) + ": " + result);
				for (Integer[] integers : finalMatrix) {
					for (Integer elem : integers) {
						System.out.print(elem + " ");
					}
					System.out.println("");
				}
			} else {
				System.out.println("Case #" + (i + 1) + ": " + result);
			}

		}
		wr.close();
		br.close();
	}

	private static Integer[][] Solution(int N, int K,Integer[][] manufacMatrix) {
		int divide = K/N ;
		//adding digonal elements with trace
		addingDiagonalElements(manufacMatrix, divide) ;
		
		//add remaining value in other places
		addingNonDiagonalElements(manufacMatrix, K, N);
		
		return manufacMatrix;
	}

	private static void addingNonDiagonalElements(Integer[][] manufacMatrix, int K, int N) {
		// TODO if i!=j then allocate random number to the location of arrays
		Integer[] seqArray = genSeqArray(1,N,K);
		for (int row = 0; row < manufacMatrix.length; row++) {
				int seqCount = 0;
				if(row%2!=0) {
					Arrays.sort(seqArray,Collections.reverseOrder());
				}
				else {
					Arrays.sort(seqArray);
				}
			for (int col = 0; col < manufacMatrix.length; col++) {
				if(row!=col) {
					//filling elements with 1,0 then 2,0 and so on\
					int randomNum = seqArray[seqCount] ;
					manufacMatrix[col][row] = randomNum;
					seqCount++;
				}
			}		
		}
	}

	private static Integer[] genSeqArray(int min, int N, int K) {
		// get the array of element you want to sent to the method
		ArrayList<Integer> seq = new ArrayList<>();		
		for (int i = 0; i <N; i++) {
			seq.add(i+1);
		}
		Integer trace = K/N ;
		seq.remove(trace);
	
        Integer[] finalSeq = new Integer[seq.size()]; 
        finalSeq = seq.toArray(finalSeq); 
		return finalSeq;
	}

	private static void addingDiagonalElements(Integer[][] manufacMatrix, int divide) {
		// TODO divide the trace by size of the matrix
		for (int i = 0; i < manufacMatrix.length; i++) {
			manufacMatrix[i][i] = divide ; 
		}
	}

}
