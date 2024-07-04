import java.io.*;
import java.util.ArrayList;
public class Solution {

	public static void rec(int size, String s, int n, ArrayList<String>ans) {
		if(size==n) {
			ans.add(s);
			return;
		}
		else {
			rec(size+1,s+"C",n, ans);
			rec(size+1,s+"J",n, ans);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		 ArrayList<String>ans=new ArrayList<String>();
		for(int a=0;a<cases;a++) {
			
			int n=Integer.parseInt(br.readLine());
			boolean[]ctimes=new boolean[1441];
			boolean[]jtimes=new boolean[1441];
			int[]starttimes=new int[n];
			boolean taken=false;
			boolean bothno=false;
			int[]endtimes=new int[n];
			String temp="";
			for(int i=0;i<n;i++) {
				String []s=br.readLine().split(" ");
		
				starttimes[i]=Integer.parseInt(s[0]);
				endtimes[i]=Integer.parseInt(s[1]);		
				}
			
			
		
			for(int i=0;i<starttimes.length;i++) {
				for(int j=starttimes[i];j<=endtimes[i];j++) {
					if(ctimes[j]&&j!=starttimes[i]) { //if c has already occupied that time slot and it is not at the very beginning
						break;
					}
					
					if(j==endtimes[i]) { //if the final time has been reached w/o any obstructions (final time can be occupied as long as none of the ones in the middle are), we assign the activity to c by blocking off all 
										//corresponding times
						for(int k=starttimes[i];k<=endtimes[i];k++) {
							ctimes[k]=true;
							
						}
						temp+="C";
						taken=true;
					}
				}
				
				if(!taken) {
					
				
					for(int j=starttimes[i];j<=endtimes[i];j++) {
						if(jtimes[j]&&j!=starttimes[i]&&j!=endtimes[i]) { //if j has already occupied that time slot and it is not at the very beginning or very end, as they can be doubly booked
							break;
						}
						
						if(j==endtimes[i]) { //if the final time has been reached w/o any obstructions (final time can be occupied as long as none of the ones in the middle are), we assign the activity to j by blocking off all 
											//corresponding times
							for(int k=starttimes[i];k<=endtimes[i];k++) {
								jtimes[k]=true;
								
							}
							temp+="J";
							taken=true;
						}
				}
					
					
				}
				
				
				if(!taken) { //if the activity cannot be done by either party it is impossible
					bothno=true;
					break;
				}
				
				taken=false;
				
			}
			if(bothno) {
				ans.add("IMPOSSIBLE");
				
			}
			else {
				ans.add(temp);
			}
			bothno=false;
		}

		for(int i=0;i<ans.size();i++) {
			System.out.println("Case #"+(i+1)+": "+ans.get(i));
		}
}
}
