import java.util.*;
public class Solution {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tt;
		
		for(tt=1;tt<=t;++tt) {
			int n = scan.nextInt();
			int[][] task = new int[n][2];
			int i,j,k;
			boolean flag;
			char[] person = new char[n];
			for(i=0;i<n;++i)  person[i]='s';
			for(i=0;i<n;++i){
				task[i][0]=scan.nextInt();
				task[i][1]=scan.nextInt();
			}
			
			int start=task[0][0],end=task[0][1];
			person[0]='J';
			//J
			for(i=1;i<n;++i) {
				if(task[i][1]<=start) {
					start = task[i][0];
					person[i]='J';
				}
				else if(task[i][0]>=end) {
					end = task[i][1];
					person[i]='J';
				}
			}
			
			//C
			for(i=1;i<n;++i) {
				if(person[i]=='s')  break;
			}
			
			if(i==n){}
			else {
				start=task[i][0];
				end=task[i][1];
				person[i]='C';
				for(k=i+1;k<n;++k) {
					if(person[k]=='J'){}
					else if(task[k][1]<=start) {
						start = task[k][0];
						person[k]='C';
					}
					else if(task[k][0]>=end) {
						end = task[k][1];
						person[k]='C';
					}
				}
			}
			
			flag=true;
			for(i=0;i<n;++i) {
				if(person[i]=='s') {  flag=false;  break;  }
			}
			
			if(flag) {
				StringBuffer sb = new StringBuffer();
				for(i=0;i<n;++i) {
					sb.append(person[i]);
				}
				System.out.printf("Case #%d: %s\n",tt,sb.toString());
			}
			else
				System.out.printf("Case #%d: IMPOSSIBLE\n",tt);
			
		}
	}
}
