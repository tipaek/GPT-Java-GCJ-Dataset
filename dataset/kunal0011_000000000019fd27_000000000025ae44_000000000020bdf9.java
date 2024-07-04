import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int testCase=1;
		
		while(testCase<=t) {
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Pair> pair = new ArrayList<>(); 
			for(int i=0;i<n;i++) {
				String s[] = br.readLine().split(" ");
				pair.add( new Pair(Integer.parseInt(s[0]),Integer.parseInt(s[1]),i));
			}
			pair.sort((Pair a, Pair b) ->a.e-b.e);
			StringBuilder sb= new StringBuilder();
			int cs=pair.get(0).s;int ce = pair.get(0).e;
			int js=-1,je=-1;
			sb.append("C");
			
			for(int j=1;j<n;j++) {
				
				int currentS = pair.get(j).s;
				int currentE = pair.get(j).e;
				
				if(currentS>=ce) {
					ce=currentE;
					cs=currentS;
					sb.append("C");
					continue;
				} 
				if(currentS>=je) {
					js=currentS;
					je=currentE;
					sb.append("J");
					continue;
				}
				
			}
			
			if(sb.toString().length()<n) {
				System.out.println("Case #"+testCase+":"+" "+"IMPOSSIBLE");
			} else {
			
				StringBuilder sb1  = new StringBuilder();
				String s = sb.toString();
				char ch[] = new char[n];
				
				for(int i=0;i<n;i++) {
					Pair p = pair.get(i);
					int index=p.index;
					ch[index]=s.charAt(i);
				}
				for(int i=0;i<n;i++) { sb1.append(ch[i]); }
				System.out.println("Case #"+testCase+":"+" "+sb1.toString());
			}
			testCase++;
		}

	}

}
class Pair{
	int s,e,index;

	public Pair(int s, int e,int index) {
		this.s = s;
		this.e = e;
		this.index=index;
	}
	
}
