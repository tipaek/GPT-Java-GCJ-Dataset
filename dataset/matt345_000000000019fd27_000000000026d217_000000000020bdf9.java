import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution{

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
	public static boolean test(int start,int end,  boolean[]times ) {
		for(int i=start+1;i<end;i++) { //the starting and ending positions can be occupied, we simply check if the middle ones are not occupied
			if(times[i]==true) return false;
		}
		
		for(int i=start;i<=end;i++) {
			times[i]=true;
		}
		return true; //if the loop finishes successfully it doesn't conflict, we assign it to c and block off those times
		//this method is used for both tests b/c you can simply put the other corresponding array as a parameter
	}
	
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		 
		 ArrayList<String>fin=new ArrayList<String>();
		 
		for(int a=0;a<cases;a++) {
			ArrayList<String>ans=new ArrayList<String>();
			int n=Integer.parseInt(br.readLine());
			boolean[]ctimes=new boolean[1441];
			boolean[]jtimes=new boolean[1441];
			int[]starttimes=new int[n];
			int[]endtimes=new int[n];
			
			
			for(int i=0;i<n;i++) {
		
				String []s=br.readLine().split(" ");

				starttimes[i]=Integer.parseInt(s[0]);
				endtimes[i]=Integer.parseInt(s[1]);		
				}

		
			rec(0,"",n,ans); //generate all possibilities with size n
			
			for(int i=0;i<ans.size();i++) { //go through all possibilities; if this reaches the end, it is not possible
				int c=0;
				String cur=ans.get(i); //consider current possibility
				for(int j=0;j<cur.length();j++) { //go thru who gets assigned to what and see if it works
				
					int start=starttimes[j]; //corresponding starting and finihsing times 
					int end=endtimes[j];
				
					if(cur.charAt(j)=='C') { //if it is assigned to C, we see if it works with C's schedule, if not, we simply discount this possibility
						if(test(start, end, ctimes )==true) {
							c++;
							continue;
						}
						else {
							
							break;
						}
					}
					else if(cur.charAt(j)=='J') {
						if(test(start,end,jtimes)==true) {
							c++; //add one to the counter; if this equals n, we know that the assignments have worked out
							continue;
						}
						else {
							break;
						}
					}
					
					
				}
				if(c==n) { //if it went through all assignements w/o trouble
					fin.add(cur); //add this and break;
					c=0;
					Arrays.fill(ctimes, false); //reset bc we are considering a new possibility
					Arrays.fill(jtimes, false);
					break;
				}
				else if(i==ans.size()-1) { //if the whole loop has went thru and nothing has been added, add impossible and break
					fin.add("IMPOSSIBLE"); 
					Arrays.fill(ctimes, false); //reset bc we are considering a new possibility
					Arrays.fill(jtimes, false);
					c=0;
					break;
				}
				else {
					c=0; //if none of these, keep going thru possibilities
					Arrays.fill(ctimes, false); //reset bc we are considering a new possibility
					Arrays.fill(jtimes, false);
				}
				
				
			}
			
		
}
		for(int i=0;i<fin.size();i++) {
			System.out.println("Case #"+(i+1)+": "+fin.get(i));
		}
}
}

