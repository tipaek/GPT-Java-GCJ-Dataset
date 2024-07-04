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
			char[] time = new char[1441];
			for(i=0;i<1441;++i)  time[i]='s';
			for(i=0;i<n;++i)  person[i]='s';
			for(i=0;i<n;++i){
				task[i][0]=scan.nextInt();
				task[i][1]=scan.nextInt();
			}
			
			int start,end;
			
			for(i=0;i<n;++i) {
				start = task[i][0];
				end = task[i][1];
				flag = true;
				for(k=start;k<end;++k) {
					if(time[k]=='C'){
						flag = false;
						break;
					}
				}
				if(flag){
					for(k=start;k<end;++k)  time[k]='C';
					person[i]='C';
				}
			}
			
			for(i=0;i<n;++i) {
				if(person[i]=='C')  continue;
				start = task[i][0];
				end = task[i][1];
				flag = true;
				for(k=start;k<end;++k) {
					if(time[k]=='J'){
						flag=false;
						i=n;
						break;
					}
				}
				if(flag){
					for(k=start;k<end;++k)  time[k]='J';
					person[i]='J';
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
				System.out.println("Case #"+tt+": "+sb.toString());
			}
			else
				System.out.println("Case #"+tt+": IMPOSSIBLE");
			
		}
	}
}
