import java.util.ArrayList;

public class Vestivium {
	
	public double[][] transpose(double[][] m) {

		double[][] result = new double[m.length][m.length];
		for(int i = 0;i<m.length;i++) {
		    for(int j = 0;j<m[i].length;j++) {
		        result[j][i] = m[i][j];
		    }
		  }
		  return result;
		}

	public int getNumRepeatingRows(double[][] m) {	
		int result = 0;
		for(int i = 0;i<m.length;i++) {
			for(int j = 0;j<m[i].length+1;j++) {
				if(m[i][j] == m[i][j-1]) {
					result++;
				}
			}
		}
		return result;
	}
	
	public int getNumRepeatingCols(double[][] m) {
		double[][] mTransposed = transpose(m);
		return getNumRepeatingRows(mTransposed);
	}
	
	public int trace(double[][] m) {
		int sum = 0;
		int currentIndex = m.length-1;
		for(int i = 0;i<m.length;i++) {
			double[] currentVector = m[i];
			for(int j = 0;j<currentVector.length;j++) {
				sum += currentVector[currentIndex];
				currentIndex--;
			}
		}
		return sum;
	}
	
	public String getIndivResult(double[][] m) {
		String result = "";
		String k = Integer.toString(trace(m));
		String r = Integer.toString(getNumRepeatingRows(m));
		String c = Integer.toString(getNumRepeatingCols(m));
		result += k + " " + r + " " + c;
		return result;
	}
	
	public void getResult(ArrayList<double[][]> tests) {
		for(int i = 0;i<tests.size();i++) {
			double[][] currentTest = tests.get(i);
			String currentResult = getIndivResult(currentTest);
			System.out.println("#" + (i+1) + ":" + " " + currentResult);
		}
	}
}
