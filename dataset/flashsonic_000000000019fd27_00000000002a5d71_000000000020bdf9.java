import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String args[]){
		Scanner kb=new Scanner(System.in);
		
		int cases=kb.nextInt();

		for(int n=0; n<cases; n++) {
			int tasks=kb.nextInt();
			
			Pair times[]=new Pair[tasks];
			Pair untimes[]=new Pair[tasks];
			
			for(int i=0; i<tasks; i++) {
			    int a=kb.nextInt();
			    int b=kb.nextInt();
				times[i]=new Pair(a, b);
				untimes[i]=new Pair(a, b);
			}
			
			Arrays.sort(times);
			
			int C=0;
			int J=0;
			boolean canDo=true;
			String ans="";
			char corr[]=new char[tasks]; 
			boolean taken[]=new boolean[tasks];
			
			for(int i=0; i<tasks; i++) {
				if(C<=times[i].x) {
					C=times[i].y;
					for(int p=0; p<tasks; p++){
					    if(taken[p]==false&&times[i].x==untimes[p].x
					    &&times[i].y==untimes[p].y){
					        taken[p]=true;
					        corr[p]='C';
					    }
					}
				}
				else if(J<=times[i].x) {
					J=times[i].y;
					for(int p=0; p<tasks; p++){
					    if(taken[p]==false&&times[i].x==untimes[p].x
					    &&times[i].y==untimes[p].y){
					        taken[p]=true;
					        corr[p]='J';
					    }
					}
					
				}
				else {
					canDo=false;
					break;
				}
			}
			
			
			
			System.out.print("Case #" + (n+1) + ": ");
			
			if(canDo) {
			    for(int i=0; i<tasks; i++){
			        ans+=corr[i];
			    }
				System.out.println(ans + " ");
			}
			else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int compareTo(Pair o) {
		return this.x-o.x;
	}
}