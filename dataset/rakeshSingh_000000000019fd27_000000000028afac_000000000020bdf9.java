

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
	       
			StringTokenizer st;
			int CameronEndTime=-1;
			int JamieEndTime=-1;
			int CameronStartTime=Integer.MAX_VALUE;
			int JamieStartTime=Integer.MAX_VALUE;
			
			
			
			int n=Integer.parseInt(br.readLine());
			StringBuilder sNew=new StringBuilder();
			boolean bl=true,cameronWork=false,jamieWork=false;
			while(n-->0){
				st=new StringTokenizer(br.readLine());
				int workStartTime=Integer.parseInt(st.nextToken());
				int workEndTime=Integer.parseInt(st.nextToken());
				
				
				
				
				if((workStartTime<CameronStartTime && workEndTime<=CameronStartTime) || (workStartTime>=CameronEndTime )){
					if(bl){
						sNew.append("C");
						CameronEndTime=workEndTime;
						CameronStartTime=workStartTime;
					}
				}else if((workStartTime<JamieStartTime && workEndTime<=JamieStartTime) || (workStartTime>=JamieEndTime)){
					if(bl){
						sNew.append("J");
						JamieEndTime=workEndTime;
						JamieStartTime=workStartTime;
					}
					
				}else if (bl){
					sNew=new StringBuilder();
					sNew.append("IMPOSSIBLE");
					bl=false;					
				}
				
				
				
				
			}
			
			
			
			
		  
		    out.println("Case #"+(caseN++)+": "+sNew);		    //caseN++;
			
		}
		out.flush();
		out.close();
		

	}

}
