import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {
	
	/**
	 * 
	 * Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.
	 * The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).
	 * An N-by-N square matrix is a Latin square if each cell contains one of N different values, and no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.
	 * Given a matrix that contains only integers between 1 and N, we want to compute its trace and check whether it is a natural Latin square. To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, please compute the number of rows and the number of columns that contain repeated values.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */
	
	private static int r= 0;
	private static int c= 0;
	
	private static Integer calcTrace(ArrayList<ArrayList<String>> matrix,int N) {
//		System.out.println(matrix);
		
		int sum=0;
		int j=0;
		Set<String> hSet = null;
		
		for(int i=0;i <N;i++) {
			
			sum += Integer.parseInt(matrix.get(i).get(j));
			j++;
			hSet = new HashSet<String>(matrix.get(i));
			
			if(hSet.size() != N) {
				r += 1;
			}
		}

		for(int k = 0; k<N; k++) {
			hSet = new HashSet<String>();
			for (int i =0; i<N; i++) {			
				hSet.add(matrix.get(i).get(k));
//				System.out.println("("+i+","+k+")="+matrix.get(i).get(k));
				}
//			System.out.println(hSet);
			if(hSet.size() != N) {
				c += 1;
			}
		}
		return sum;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = 0;
		int N = 0;
		int sum = 0;
		ArrayList<String> cols = new ArrayList<String>();
		ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=(Integer.parseInt(br.readLine()));
		for (int t=0; t<T; t++) {
			sum = 0;
			N = (Integer.parseInt(br.readLine()));
			for (int n=0; n<N; n++) {
				String[] arow = br.readLine().split(" ");				
				Collections.addAll(cols, arow);
				rows.add(n, (ArrayList<String>) cols.clone());
				cols.clear();
			}
			sum = calcTrace(rows,N);
			System.out.println(sum +" "+r+" "+c);
			r=0;
			c=0;
		}
	}
}