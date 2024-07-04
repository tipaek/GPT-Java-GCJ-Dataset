import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(bufferedReader.readLine().trim());
		for(int i=1;i<=T;i++){
			String s=bufferedReader.readLine().replaceAll("\\s+$", "");
			String y="";

			for(int m=0;m<s.length();m++){
				if(m==0){
					for(int x=0;x<Integer.parseInt(String.valueOf(s.charAt(m)));x++){
						y=y+"(";
					}
				}
				if(m-1>=0 && s.charAt(m)>s.charAt(m-1)){
					int num1=Integer.parseInt(String.valueOf(s.charAt(m)));
					int num2=Integer.parseInt(String.valueOf(s.charAt(m-1)));
					int num3=num1-num2;
					for(int x=0;x<num3;x++){
						y=y+"(";
					}
				}
				if(m-1>=0 && s.charAt(m)<s.charAt(m-1)){
					int num1=Integer.parseInt(String.valueOf(s.charAt(m)));
					int num2=Integer.parseInt(String.valueOf(s.charAt(m-1)));
					int num3=num2-num1;
					for(int x=0;x<num3;x++){
						y=y+")";
					}
				}
				y=y+String.valueOf(s.charAt(m));
				if(m==s.length()-1){
					for(int x=0;x<Integer.parseInt(String.valueOf(s.charAt(m)));x++){
						y=y+")";
					}
				}

			}

			System.out.println("Case #"+i+": "+y+"");
		}
	}
}
