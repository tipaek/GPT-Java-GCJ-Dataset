import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
			//pair.sort((Pair a, Pair b) ->a.e-b.e);
			
			Collections.sort(pair, new Comparator<Pair>() {
				@Override
				public int compare(Pair o1,Pair o2) {
					if(o1.e<o2.e) {
						return -1;
					}else if(o1.e==o2.e) {
						if(o1.s<=o2.s)
							return -1;
						else
							return 1;
					}else {
						return 1;
					}
						
				}
			});
			
			StringBuilder sb= new StringBuilder();
			
			int cs=pair.get(0).s;int ce = pair.get(0).e;
			int js=-1,je=-1;
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
					continue;
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
						if((ch[j]=='C'||ch[j]=='J')) continue;
						if(p1.s==p.s && p.e==p1.e) {
								ch[j]=s.charAt(i);
								break;
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
