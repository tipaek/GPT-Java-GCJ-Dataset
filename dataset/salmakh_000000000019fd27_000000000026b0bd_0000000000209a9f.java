import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out  =new  PrintWriter(System.out);
		int T= Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			String s = br.readLine();
			StringBuilder result= new StringBuilder();
			int countOpen=0;
			for(int i=0;i<s.length();i++){
				int cur=Integer.parseInt(s.charAt(i)+"");
				if(cur==countOpen){
					result.append(cur);
				}
				else if (cur<countOpen){
					int rem=countOpen-cur;
					countOpen-=rem;
					for(int j=0;j<rem;j++){
						result.append(")");
					}
					result.append(cur);
				}
				else{
					int rem=cur-countOpen;
					countOpen=cur;
					for(int j=0;j<rem;j++){
						result.append("(");
					}
					result.append(cur);
				}
			}
			if(countOpen!=0){
				for(int j=0;j<countOpen;j++){
					result.append(")");
				}
			}
			
			if(t==T-1){
				out.print("Case #"+(t+1)+": "+result);
			}
			else
				out.println("Case #"+(t+1)+": "+result);

		}
		out.flush();
		out.close();
	}

}
