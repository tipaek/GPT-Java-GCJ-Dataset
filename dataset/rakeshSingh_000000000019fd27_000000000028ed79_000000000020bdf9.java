

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
			
			
			boolean isJamieBusy[]=new boolean[1441];
			boolean isCameronBusy[]=new boolean[1441];
			
			
			int n=Integer.parseInt(br.readLine());
			StringBuilder sNew=new StringBuilder();
			boolean bl=true;
			while(n-->0){
				st=new StringTokenizer(br.readLine());
				int workStartTime=Integer.parseInt(st.nextToken());
				int workEndTime=Integer.parseInt(st.nextToken());
				boolean isPossible = false;
				char toAppend='N';
				
				
				if(bl){
					for(int i=workStartTime;i<workEndTime;i++){
						
						if(isJamieBusy[i]){
							break;
						}
						if(i==workEndTime-1){
							isPossible=true;
							toAppend='J';
						}
						
					}
					
					if (isPossible==false) {
						for(int i=workStartTime;i<workEndTime;i++){
							
							if(isCameronBusy[i]){
								break;
							}
							if(i==workEndTime-1){
								isPossible=true;
								toAppend='C';
							}
							
						}
					}
					
					if(isPossible){
						sNew.append(toAppend);
						if(toAppend=='C'){
							for(int i=workStartTime;i<workEndTime;i++){
								isCameronBusy[i]=true;
							}
						}else{
							for(int i=workStartTime;i<workEndTime;i++){
								isJamieBusy[i]=true;
							}
						}
					}else{
						bl=false;
						sNew=new StringBuilder("IMPOSSIBLE");
					}
				}
				
				
			
				
				
				
				
			}
			
			
			
			
		  
		    out.println("Case #"+(caseN++)+": "+sNew);		    //caseN++;
			
		}
		out.flush();
		out.close();
		

	}

}
