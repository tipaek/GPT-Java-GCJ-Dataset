import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int testCase=1;
		
		while(testCase<=t) {
			
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<Pair> pair1 = new ArrayList<>(); 
			for(int i=0;i<n;i++) {
				String s[] = br.readLine().split(" ");
				pair1.add( new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
			}
			
			ArrayList<Pair> pair = new ArrayList<>();
			pair.addAll(pair1);
			pair.sort((Pair a, Pair b) ->a.e-b.e);
			
			StringBuilder sb= new StringBuilder();
			
			int cs=pair.get(0).s;int ce = pair.get(0).e;
			int js=0,je=0;
			sb.append("C");
			int flag=0;
			for(int j=1;j<n;j++) {
				
				int currentS = pair.get(j).s;int currentE = pair.get(j).e;
				
				if(currentS>=ce) {
					ce=currentE;cs=currentS;
					sb.append("C");
					continue;
				} else if(currentS>=je) {
					js=currentS;je=currentE;
					sb.append("J");
				}else {
					flag=1;
				}
				
				if(flag==1) break;
				
			}
			
			if(flag==1) {
				System.out.println("Case #"+testCase+":"+" "+"IMPOSSIBLE");
			} else {
			
			//after assigining task to c and j rearrange according to original order.
				StringBuilder sb1  = new StringBuilder();
				String s = sb.toString();
				char[] ch  = new char[n];
				for(int i=0;i<n;i++) {
					Pair p = pair.get(i);
					for(int j=0;j<n;j++) {
						Pair p1 = pair1.get(j);
						if(p1.s==p.s && p.e==p1.e) {
								ch[j]=s.charAt(i);
						}
					}
				}
				
				for(int i=0;i<n;i++) {
				sb1.append(ch[i]);	
				}
			System.out.println("Case #"+testCase+":"+" "+sb1.toString());
			}
			testCase++;
		}

	}

}
class Pair{
	int s,e;

	public Pair(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}
	
}
