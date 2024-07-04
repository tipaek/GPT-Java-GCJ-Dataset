

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
	static class time{
		int start;
		int end;
		time(int start,int end){
			this.start=start;
			this.end=end;
		}
	}
	
	public static StringBuilder schedule(time t1[],int n) {
		StringBuilder st=new StringBuilder();
		StringBuilder str=new StringBuilder("IMPOSSIBLE");
		int xc=0,yc=0,xj=0,yj=0;
		ArrayList<ArrayList>c=new ArrayList<ArrayList>();
		ArrayList<ArrayList>j=new ArrayList<ArrayList>();
		
		
		
		
		for(int i=0;i<n;i++) {
			//System.out.println("is is"+ i);
			if(c.isEmpty()) {
				xc=t1[i].start;
				yc=t1[i].end;
				ArrayList m=new ArrayList();
				m.add(xc);
				m.add(yc);
				c.add(m);
				
				//System.out.println("C");
				st.append("C");
			}
			
			else if(j.isEmpty()) {
				xj=t1[i].start;
				yj=t1[i].end;
				ArrayList m=new ArrayList();
				m.add(xj);
				m.add(yj);
				j.add(m);
				//System.out.println("J");
				st.append("J");
				
			}
			
			else {
				int flag1=0;
				int cr=0;
				int jr=0;
				for(int i1=0;i1<c.size();i1++) {
					/*
					 * System.out.println((int)c.get(i1).get(0));
					 * System.out.println((int)c.get(i1).get(1)); System.out.println(t1[i].start);
					 */
					
					if(((int)c.get(i1).get(0)<=t1[i].start && (int)c.get(i1).get(1)<=t1[i].start)||((int)c.get(i1).get(0)>=t1[i].end && (int)c.get(i1).get(1)>=t1[i].end)) {
						cr++;
						
					}
					
					if(cr==c.size()) {
						xc=t1[i].start;
						yc=t1[i].end;
						ArrayList m=new ArrayList();
						m.add(xc);
						m.add(yc);
						c.add(m);
						flag1=1;
						//System.out.println("C");
						st.append("C");
						
					}
					
					
				}
					
				
				if(flag1==0) {
				for(int i1=0;i1<j.size();i1++) {
					if(((int)j.get(i1).get(0)<=t1[i].start && (int)j.get(i1).get(1)<=t1[i].start)||((int)j.get(i1).get(0)>=t1[i].end && (int)j.get(i1).get(1)>=t1[i].end)) {
						jr++;
					}
				}
				if(jr==j.size()) {
					xj=t1[i].start;
					yj=t1[i].end;
					ArrayList m=new ArrayList();
					m.add(xj);
					m.add(yj);
					flag1=1;
					j.add(m);
					//System.out.println("J");
					st.append("J");
					
				}
					
				}
				
				if(flag1==0) {
					return str;
				}
				flag1=0;
				
			}
				
			}
			/*else {
				StringBuilder str=new StringBuilder("IMPOSSIBLE");
				
				if(xc<t1[i].start &&yc>t1[i].end) {
					if(xj<t1[i].start && yj>t1[i].end) {
						
						
						return str;
						
					}
					
				}
				
				 if((xc<=t1[i].start && yc<=t1[i].start)||(xc>=t1[i].end && yc>=t1[i].end) ) {
					xc=Math.min(t1[i].start,xc);
					yc=Math.max(t1[i].end,yc);
					System.out.println("C");
					st.append("C");
					
				}
				 if((xj<=t1[i].start && yj<=t1[i].start)||(xj>=t1[i].end && yj>=t1[i].end) ) {
					//System.out.println("soooo");
					xj=Math.min(t1[i].start,xj);
					yj=Math.max(t1[i].end,yj);
					System.out.println("J");
					st.append("J");
					
				}
				 else {
					 return str;
				 }
				
				
				
			}
		}
		*/
			return st;
		
	}
	
	public static void main(String[] args) {
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		time t1[] = null;
		int n=0;
		for(int i=0;i<t;i++) {
			 n=sc.nextInt();
			t1=new time[n];
			int start,end;
			for(int j=0;j<n;j++) {
			
			start=sc.nextInt();
			end=sc.nextInt();
			t1[j]=new time(start,end);
			
			}

			System.out.println("Case #"+(i+1)+": "+schedule(t1,n));
		
			
		}
			
	}

}
