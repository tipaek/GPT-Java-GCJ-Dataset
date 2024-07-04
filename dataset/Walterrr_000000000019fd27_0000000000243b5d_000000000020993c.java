import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

 class Vest2 {

	BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
	int matrixSize = -1;
	int numberOfTestes = -1;
	int[][] matrix = null;
	ArrayList<int[]> myarr = new ArrayList<>();

	public static void main(String[] args) {
		Vest2 vest2 = new Vest2();
		vest2.runSolution();

	}

	public void runSolution() {
		while(numberOfTestes < 1 || numberOfTestes > 100) {
			numberOfTestes = readFromInput(1,100);	
		}
		for(int x=0; x< numberOfTestes; x++) {
			matrixSize = readFromInput(2,100);
			while(matrixSize < 2 || matrixSize >100) {
				matrixSize = readFromInput(2,100);
			}
			matrix = new int[matrixSize][matrixSize];
			for(int i=0; i<matrixSize; i++) {
				readFromInput(i,matrixSize);
			}
				computeMatrix(x);
		}
		showResults();
	}

	private int readFromInput(int minim, int maxim) {
		String numberString = "";
		while(true) {
			try {
				numberString = reader.readLine();
				String[] arr = numberString.split("\\s+");
				if(arr.length == 1) {
					if(Integer.valueOf(arr[0]) >=minim && Integer.valueOf(arr[0]) <=maxim) {
						return Integer.valueOf(arr[0]);
					}
				} else if(arr.length == matrixSize) {
					for(int j=0; j<matrixSize; j++) {
						if(Integer.valueOf(arr[j]) <= matrixSize) {
							matrix[minim][j] = Integer.valueOf(arr[j]);
						} else { throw new Exception();
						}
					}
					return 0;
				}
				throw new Exception();
			} catch(Exception e) {
				System.out.println("Error");
				continue;
			}
		}
	}

	private void computeMatrix(int x) {
		int[] output = new int[]{0,0,0};
		for(int i=0; i<matrixSize; i++) {
			output[0] += matrix[i][i];
			if(!check(i, "rows")) { ++output[1]; }
			if(!check(i, "columns")) { ++output[2]; }
		}
		myarr.add(output);
	}

	private boolean check(int element, String decide) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<matrixSize; i++) {
			if(decide.equals("rows")) {
				set.add(matrix[element][i]);
			} else if(decide.equals("columns")) {
				set.add(matrix[i][element]);
			}
		}
		if(set.size() != matrixSize) {
			return false;
		} 
		return true;
	}
	
	private void showResults() {
		int count = 1;
		for(int[] output: myarr) {
			System.out.println("Case #"+count+": "+output[0]+" "+output[1]+" "+output[2]+" ");
			++count;
		}
	}
}
