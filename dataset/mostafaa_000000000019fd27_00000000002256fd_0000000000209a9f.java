import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t < T; t++){
			// st = new StringTokenizer(br.readLine());
			// String result = helper(br.readLine());
			String str = br.readLine();
			int N = str.length();
			String[] strValues = str.split("");
			int[] values = new int[N];
			while(N-->0)
				values[N] = Integer.parseInt(strValues[N]);
			String result = helper(str, values);

			if(t==T-1)
			pw.print(String.format("Case #%d: %s", t+1, result));
			else
			pw.println(String.format("Case #%d: %s", t+1, result));
		}
		

		pw.flush();
		pw.close();
	}

	public static String helper(String origin, int[] values){
		if(checkBottom(values, 0))
			return origin;
		if(checkBottom(values, 1))
			return "("+origin+")";
		String out;
		Boolean flag= false;
		if(checkMin(values)){
			decrement(values);
			out = "(";
			flag = true;
		}
		else
			out="";
		int start = 0;
		for(int i = 0; i < values.length; i++){
			if(values[i] == 0){
				String str = origin.substring(start, i);
				int[] strValues = equivalentArr(values, start, i);
				String result = helper(str, strValues);
				out+= result + origin.charAt(i);
				start = i + 1;
			}
		}
		if(start < values.length){
			String str = origin.substring(start);
			int[] strValues = equivalentArr(values, start, values.length);
			String result = helper(str, strValues);	
			out+= result;
		}
		if(flag)
			out+=")";
		return out;
	}
	public static Boolean checkBottom(int[] arr, int x){
		int N = arr.length;
		while(N-->0)
			if(arr[N] != x)
				return false;
		return true;
	}
	public static Boolean checkMin(int[] arr){
		int N = arr.length;
		while(N-->0)
			if(arr[N] == 0)
				return false;
		return true;
	}
	public static void decrement(int[] arr){
		int N = arr.length;
		while(N-->0)
			arr[N]-=1;
	}
	public static int[] equivalentArr(int[] arr, int beg, int end){
		// int N = arr.length;
		int[] subArr = new int[end-beg];
		// while(N-->0)
		int c = 0;
		for(int i = beg; i < end; i++)
			subArr[c++] = arr[i];
		return subArr;

		// return Arrays.asList(arr)
		// 	.subList(beg, end)
		// 	.toArray(new String[0]);
	}
}