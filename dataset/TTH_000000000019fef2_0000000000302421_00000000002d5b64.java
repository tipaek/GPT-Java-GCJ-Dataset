import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			ArrayList<int[]> arr = new ArrayList<>();
			helper(R,S,arr);
			int len = arr.size();
			
			sb.append("Case #"+(t+1)+": "+len+"\n");
			for(int i=0; i<len; i++) {
				sb.append(arr.get(i)[0]+" "+arr.get(i)[1]+"\n");
			}
			
		}
		System.out.print(sb.toString());
	}

	public static ArrayList<int[]> helper(int r, int s, ArrayList<int[]> arr) {
		if (r==1) return arr;
		
		for(int i=1; i<s; i++) {
			int[] temp = new int[] {r, r*(s-1)-i};
			//System.out.println(r+ "  "+(r-i));
			arr.add(temp);
		}
		helper(r-1,s,arr);
		return arr;
	}
	
}
