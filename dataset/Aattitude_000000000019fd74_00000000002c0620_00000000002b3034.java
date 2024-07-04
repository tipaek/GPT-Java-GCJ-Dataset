

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

 class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			int n=Integer.parseInt(br.readLine());
			boolean flag=true;
			String min=br.readLine();
			String max=min;
			for(int i=1;i<n;i++) {
			String curr=br.readLine();
			if(curr.length()>max.length())
				max=curr;
			String temp="";
			if(curr.length()>min.length()) {
				temp=curr;
				
			}
			else {
				temp=min;
				min=curr;
			}
			int l=temp.length()-1;
			for(int j=min.length()-1;j>0;j--) {
				
				if(min.charAt(j)==temp.charAt(l)) {
					
				}
				else {
					flag=false;
					
				}
				l--;
			}
			}
			if(flag && max.length()>1) {
				bw.write("Case #" + (t + 1) + ": "+max.substring(1)+"\n");
			}
			else {
				bw.write("Case #" + (t + 1) + ": "+"*\n");
			}
		}
		bw.flush();
	}
}
