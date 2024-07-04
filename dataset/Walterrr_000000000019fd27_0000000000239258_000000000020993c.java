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
			numberOfTestes = readFromInput(-1);	
		}
		for(int x=0; x< numberOfTestes; x++) {
			matrixSize = readFromInput(-1);
			while(matrixSize < 2 || matrixSize >100) {
				matrixSize = readFromInput(-1);
			}
			matrix = new int[matrixSize][matrixSize];
			for(int i=0; i<matrixSize; i++) {
				readFromInput(i);
			}
			computeMatrix(x);
		}
	}

	public int readFromInput(int row) {
		String input = "";
		while(true) {
			try {
				input = reader.readLine();
				if(row != -1) {
					String[] in= input.split("\\s+");
					if(in.length != matrixSize) {
						throw new IOException();
					} else {
						for(int i=0; i<matrixSize; i++) {
							matrix[row][i] = Integer.valueOf(in[i]);
						}
						return 0;
					}
				}
				if(Integer.valueOf(input) > 0) {
					return Integer.valueOf(input);
				} else {
					throw new IOException();
				}
			} catch(IOException e) {
				System.out.println("Must provide numbers greater than 0!");
				continue;
			} catch(Exception e) {
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


