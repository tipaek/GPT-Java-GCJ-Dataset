

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());
		String opening="((((((((((((((((((";
		String closing=")))))))))))))))))))))";
		for (int t = 0; t < testCase; t++) {
			String s[]=br.readLine().split("");
			StringBuilder sb=new StringBuilder("");
			int arr[]=new int[s.length];
			for(int i=0;i<s.length;i++) {
				arr[i]=Integer.parseInt(s[i]);
			}
			int bracketCount=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>bracketCount) {
					sb=sb.append(opening.substring(0, arr[i]-bracketCount));
				}
				if(arr[i]<bracketCount) {
					sb=sb.append(closing.substring(0,bracketCount-arr[i]));
	
				}
				sb=sb.append(arr[i]);
				bracketCount=arr[i];
			}
			if(bracketCount!=0)
				sb=sb.append(closing.substring(0,bracketCount));
			
			bw.write(""+"Case #"+(t+1)+": "+sb.toString()+"\n");


			
			
		}
		bw.flush();
	}
}
