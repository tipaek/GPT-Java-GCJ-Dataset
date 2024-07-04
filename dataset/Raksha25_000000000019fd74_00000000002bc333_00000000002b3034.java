import java.util.*;
import java.io.*;

public class Solution {
	public static String deletechar(String s) {
		StringBuilder S= new StringBuilder();
		for(int i=1;i<s.length();i++) {
			S.append(s.charAt(i));
		}
		return S.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			List<String> p1= new ArrayList<>();
			List<String> p= new ArrayList<>();
			List<Integer>plength= new ArrayList<>();
			//taking p1	
			for(int j=0;j<n;j++) {
				p1.add(sc.next());
				p.add(deletechar(p1.get(j)));
				plength.add(p1.get(j).length());
			}
			//creating p
			
			//finding output
			 
			 int mindex= plength.indexOf(Collections.max(plength));
			int lgo=1;
			for(int j=0;j<n && lgo==1;j++) {
				if (mindex==j)
					continue;
				else{
					if(p.get(mindex).contains(p.get(j)))
						lgo=1;
					else lgo=0;
				}
			}
			String ans;
			if(lgo==1)
				ans=p.get(mindex);
			else ans="*";
				
				System.out.println("Case#" + (i+1)+": "+ans);
		}

	}

}
