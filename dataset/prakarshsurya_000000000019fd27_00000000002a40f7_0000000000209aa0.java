import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int trace = scan.nextInt();
			String out = "IMPOSSIBLE";
			if(trace < n || trace > n * n) {
				System.out.println("Case #" + i + ": " + out);
			} else {
				int[][] arr = new int[n][n];
				boolean flag = false;
				int[] trArr = new int[n];
				if(trace == n) {
					arr = assignTrace(1, arr);
					flag = true;
				} else if(trace == n * n) {
					arr = assignTrace(n, arr);
					flag = true;
				}
				if(!flag) {
					int tr = calcTrace(trace,n);
					flag = false;
					if(tr != 0) {
						arr = assignTrace(tr, arr);
						flag = true;
					} else {
						trArr = calculateTrace(trace, n);
						if(isValidTraceArr(trArr)) {
							arr = assignTraceArr(trArr, arr);
							flag = true;
						}
					}
				}
				
				if(flag && assignArr(arr)) {
					System.out.println("Case #" + i + ": " + "POSSIBLE");
					for(int k = 0; k < arr.length; k++) {
						String o = Arrays.toString(arr[k]);
						o = o.replaceAll(",", "");
						o = o.replace("[", "");
						o = o.replace("]", "");
						System.out.println(o);
					}
				} else {
					System.out.println("Case #" + i + ": " + out);
				}
			}
		}
		scan.close();
		return;
	}
	
	public static boolean isInRow(int row, int num, int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[row][i] == num)
				return true;
		return false;
	}
	
	public static boolean isInCol(int col, int num, int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i][col] == num)
				return true;
		return false;
	}
	
	public static int[][] assignTrace(int n, int[][] arr){
		for(int i =0; i < arr.length;i++) {
			arr[i][i] = n;
		}
		return arr;
	}
	public static int[] calculateTrace(int trace, int n) {
		int[] traceArr = new int[n];
		for(int i =n; i > 0; i++) {
			int t = trace / n;
			trace = trace % n;
			int j = 0;
			while(j < t) {
				traceArr[j] = n;
				j++;
			}
			if(j == traceArr.length - 1)
				break;
			n--;
		}
		return traceArr;
	}
	
	public static int[][] assignTraceArr(int[] traceArr, int[][] arr) {
		for(int i = 0; i< arr.length; i++) {
			arr[i][i] = traceArr[i];
		}
		return arr;
	}
	
	public static int calcTrace(int trace, int n) {
		for(int i = 2; i < n; i++) {
			if((trace / i) == n) {
				return i;
			}
		}
		return 0;
	}
	public static boolean assignArr(int[][] arr) {
		for (int j = 0; j < arr.length; j++) {
	         for (int l = 0; l < arr.length; l++) {
	          
	          if (arr[j][l] == 0) {
	          
	            for (int in = 1; in <= arr.length; in++) {
	              if (!isInRow(j, in, arr) && !isInCol(l, in, arr)) {
	                arr[j][l] = in;

	                if (assignArr(arr)) { 
	                  return true;
	                } else { 
	                  arr[j][l] = 0;
	                }
	             }
	            }

	            return false; 
	           }
	          }
	         }

	         return true; 
	}
	public static boolean isValidTraceArr(int[] artrr) {
		for(int f = 0; f < artrr.length; f++) {
			if(artrr[f] == 0) {
				return false;
			}
		}
		return true;
	}
}
