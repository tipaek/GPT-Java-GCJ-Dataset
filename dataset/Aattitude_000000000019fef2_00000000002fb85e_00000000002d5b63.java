import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
         String s[]=br.readLine().split(" ");

		int testCase = Integer.parseInt(s[0]);
		int a=Integer.parseInt(s[1]);
		int b=Integer.parseInt(s[2]);
		for(int t=0;t<testCase;t++) {
			boolean flag=false;
		for(int i=-5;i<=5;i++) {
			for(int j=-5;j<=5;j++) {
				System.out.println(j +" "+i);
				String verdict=br.readLine();
				if(verdict.equalsIgnoreCase("CENTER")) {
					flag=true;
					break;
				}
			}
			if(flag)
				break;
		}
	}
	}
}
