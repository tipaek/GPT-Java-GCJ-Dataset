import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int K = in.nextInt();
      System.out.println("Case #" + i + ": " + Solution(sum(N,K),perm(N),N));
    }
  }

    public static String toString(int[][] doubleAR) {
		String output = "";
		for(int i=0; i<doubleAR.length; i++) {
			for(int j=0; j<doubleAR[0].length; j++)
				output += doubleAR[i][j] + " ";
			output += "\n";
		}
		return output;
	}
	
	public static ArrayList<int[]> filter(ArrayList<int[]> perms, int ind, int num){
		ArrayList<int[]> valid = new ArrayList<int[]>();
		for(int i=0; i<perms.size(); i++)
			if(perms.get(i)[ind]==num)
				valid.add(perms.get(i));
		return valid;
	}
	
	public static String Solution(ArrayList<int[]> paths, ArrayList<int[]> perms, int N) {
		String str = "IMPOSSIBLE";
		for(int i=0; i<paths.size(); i++) {
			ArrayList<ArrayList<int[]>> comb = new ArrayList<ArrayList<int []>>();
			int product = 1;
			for(int j=0; j<N; j++) {
				comb.add(filter(perms,j,paths.get(i)[j]));
				product*=filter(perms,j,paths.get(i)[j]).size();
			}
			int count = 0;
			while(count<product) {
				int[][] dAR = new int[N][N];
				for(int k=0; k<N; k++) {
					dAR[k] = comb.get(k).get(convert(comb,count,k));
				}
				if(columns(dAR))
					return "POSSIBLE \n"+toString(dAR);
				count++;
			}
		}
		return str;
	}
	
	public static int convert(ArrayList<ArrayList<int[]>> arrr, int count, int place) {
		for(int i=arrr.size()-1; i>=place+1; i--) {
			count/=arrr.get(i).size();
		}
		count %= arrr.get(place).size();
		return count;
	}
	
	public static ArrayList<int[]> perm(int n) {
		ArrayList<int[]> solutions = new ArrayList<int[]>();
		for(int i=0; i<n; i++) {
			int[] store = new int[n];
			store[0] = i+1;
			solutions.add(store);
		}
			
		for(int i=1; i<n; i++) {
			ArrayList<int[]>picktemp = new ArrayList<int[]>();
			for(int e=0; e<solutions.size(); e++) {
				for(int u=1; u<=n; u++) {
					if(!contains(solutions.get(e),u)) {
						int[] store = new int[n];
						for(int o=0; o<i; o++)
							store[o] = solutions.get(e)[o];
						store[i] = u;
						picktemp.add(store);
					}
						
				}
			}
			solutions = picktemp;
		}
		return solutions;
	}
	
	public static boolean contains(int[] ar, int a) {
		for(int i=0; i<ar.length; i++)
			if(ar[i]==a)
				return true;
		return false;
	}
	
	public static int sum(int[] ar) {
		int total = 0;
		for(int i=0; i<ar.length; i++)
			total+=ar[i];
		return total;
	}
	
	// 111   333
	public static ArrayList<int[]> sum(int n, int k) {
		ArrayList<int[]> paths = new ArrayList<int []>();
		int count=0;
		while(count < Math.pow(n, n)) {
			int[] ar = new int[n];
			for(int i=0; i<n; i++) {
				ar[i] = (int)((count/Math.pow(n, n-i))%n)+1;
			}
			if(sum(ar)==k)
				paths.add(ar);
			count++;
		}
		return paths;
	}
	

	public static boolean columns (int [][] array){
	    for(int i=0; i<array.length; i++){
	        int[] Rar = new int[array.length];
	        for(int j=0; j<array.length; j++)
	            Rar[j] = array[j][i];
	        Arrays.sort(Rar);
	        if((Rar[0] != 1) || (Rar[array.length-1] != array.length))
	           return false;
	    }
	    return true;
	}
}