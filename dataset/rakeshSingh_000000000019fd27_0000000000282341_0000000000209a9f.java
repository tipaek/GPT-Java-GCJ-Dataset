

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		int caseN=1;
		
		while(t-->0){
	       
			String S=br.readLine();
			int length=S.length();
			int gOpens=0;
			StringBuilder sNew=new StringBuilder();
			
			for(int i=0;i<length;i++){
				int num=Integer.parseInt(String.valueOf(S.charAt(i)));
				int loop=Math.abs(gOpens-num);
				if(gOpens>num){
					while(loop-->0){
						sNew.append(")");
						gOpens--;
					}
					sNew.append(num);
				}else if(gOpens<num){
					while(loop-->0){
						sNew.append("(");
						gOpens++;
					}
					sNew.append(num);
				}else{
					sNew.append(num);
				}
			}
			
			while(gOpens-->0){
				sNew.append(")");
			}
		  
		    out.println("Case #"+(caseN++)+": "+sNew);		    //caseN++;
			
		}
		out.flush();
		out.close();
		

	}

}
