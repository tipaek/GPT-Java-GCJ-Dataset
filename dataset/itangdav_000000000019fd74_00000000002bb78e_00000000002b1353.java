
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			int N = Integer.parseInt(br.readLine());
			int [] sums = new int[30];
			for(int i=0;i<30;i++){
				sums[i]=(int) Math.pow(2, i)-1;
			}
			boolean [] trav = new boolean[30];
			Arrays.fill(trav, false);
			int end = 0;
			if(N<=30){
				end= N;
			}
			else{
				end = 30;
				N-=30;
				for(int i=29;i>=0;i++){
					if(N>=sums[i]){
						N-=sums[i];
						trav[i]=true;
					}
				}
				end+=N;
			}
			
			
			System.out.println("Case #" + test + ": ");
			
			int currR=1;
			int currC=1;
			boolean done = false;
			System.out.println("1 1");
			while(!done){
				currR++;
				if(currC==currR-1) currC++;
				if(currR<=end){
					if(!trav[currR-1]){
						System.out.println(currR+" "+currC);
					}
					else{
						if(currC==currR){
							System.out.println(currR+" "+currC);
							while(currC>1){
								currC--;
								System.out.println(currR+" "+currC);
							}
						}
						else{
							System.out.println(currR+" "+currC);
							while(currC<currR){
								currC++;
								System.out.println(currR+" "+currC);
							}
						}
					}
				}
				else{
					done=true;
				}
			}
			
		}
	}
}