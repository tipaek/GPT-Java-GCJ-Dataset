import java.util.*;

class Solution{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		int T = Integer.parseInt(s.nextLine());
		int N;
		String I;
		String[][][] cases = {};
		for(int i=0;i<T;i++){
			N = Integer.parseInt(s.nextLine());
			cases = new String[T][N][N];
			for(int j=0;j<N;j++){
				I = s.nextLine();
				cases[i][j] = I.split(" ");
			}
			System.out.println("Case #" + (i+1)+": " + FindTrace(cases[i]) + ","+RepeatedRows(cases[i])+ "," + RepeatedCols(cases[i]));
		}
	}
	public static int FindTrace(String[][] arr){
		int trace = 0;
		for(int i=0;i<arr.length;i++){
			trace += Integer.parseInt(arr[i][i]);
		}
		return trace;
	}
	public static int RepeatedRows(String[][] arr){
		int count=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				boolean isRepeated = false;
				for(int k=j+1;k<arr[i].length;k++){
					if(arr[i][j].equals(arr[i][k])){
						count++;
						isRepeated = true;
						break;
					}
				}
				if(isRepeated)
					break;
			}
		}
		return count;
	}
	public static int RepeatedCols(String[][] arr){
		int count=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				boolean isRepeated = false;
				for(int k=j+1;k<arr[i].length;k++){
					if(arr[j][i].equals(arr[k][i])){
						count++;
						isRepeated = true;
						break;
					}
				}
				if(isRepeated)
					break;
			}
		}
		return count;
	}

}