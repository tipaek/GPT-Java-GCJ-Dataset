import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Vest1 {


	BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
	int matrixSize = -1;
	int numberOfTestes = -1;
	int[][] matrix = null;

	public static void main(String[] args) {

		Vest1 main = new Vest1();
		main.runSolution();
	}

	public void runSolution() {
		while(numberOfTestes < 1 || numberOfTestes > 100) {
			numberOfTestes = readFromInput();	
		}
		for(int x=0; x< numberOfTestes; x++) {
			matrixSize = readFromInput();
			while(matrixSize < 2 || matrixSize >100) {
				matrixSize = readFromInput();
			}
			matrix = new int[matrixSize][matrixSize];
			for(int i=0; i<matrixSize; i++) {
				for(int j=0; j< matrixSize; j++) {
					matrix[i][j] = readFromInput();
				}
			}
			computeMatrix(x);
		}
	}

	public int readFromInput() {
		int input = -1;
		while(true) {
			try {
				input = Integer.parseInt(reader.readLine());
				if(input > 0) {
					return input;
				} else {
					throw new IOException();
				}
			} catch(IOException e) {
				System.out.println("Must provide numbers greater than 0!");
				continue;
			} catch(Exception e) {
//				System.out.println("This is not a number, try again!");
				continue;
			}
		}
	}

	public boolean check(int element, String decide) {
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

	public void computeMatrix(int x) {
		int[] output = new int[]{0,0,0};
		for(int i=0; i<matrixSize; i++) {
			output[0] += matrix[i][i];
			if(!check(i, "rows")) { ++output[1]; }
			if(!check(i, "columns")) { ++output[2]; }
		}
		System.out.println("Case #"+x+": "+output[0]+" "+output[1]+" "+output[2]+" ");
	}


}


