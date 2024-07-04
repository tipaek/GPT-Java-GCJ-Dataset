import java.util.*;
public class Solution {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tt;
		
		for(tt=1;tt<=t;++tt) {
			int n = scan.nextInt();
			int[][] task = new int[n][2];
			HashMap<Integer,Integer> maps = new HashMap();
			int i,j,temp,k,min_idx;
			boolean flag;
			char[] person = new char[n];
			char[] realPerson = new char[n];
			char[] time = new char[1441];
			for(i=0;i<1441;++i)  time[i]='s';
			for(i=0;i<n;++i)  person[i]='s';
			for(i=0;i<n;++i){
				task[i][0]=scan.nextInt();
				task[i][1]=scan.nextInt();
				maps.put(73*task[i][0]+71*task[i][1],i);
			}
			
			for (i = 0; i < n-1; i++)
			{
				k=100000;
				min_idx = i;
				for (j = i+1; j < n; j++) {
					if ((task[j][1] < task[min_idx][1]) && (k>task[j][1]-task[j][0])) {
						min_idx = j;
						k=task[j][1]-task[j][0];
					}
				}
				temp = task[min_idx][0];
				task[min_idx][0] = task[i][0];
				task[i][0] = temp;
				temp = task[min_idx][1];
				task[min_idx][1] = task[i][1];
				task[i][1] = temp;
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
			
			for(i=0;i<n;++i) {
				start=task[i][0];
				end=task[i][1];
				realPerson[maps.get(73*start+71*end)]=person[i];
			}
			
			flag=true;
			for(i=0;i<n;++i) {
				if(person[i]=='s') {  flag=false;  break;  }
			}
			
			if(flag) {
				StringBuffer sb = new StringBuffer();
				for(i=0;i<n;++i) {
					sb.append(realPerson[i]);
				}
				System.out.println("Case #"+tt+": "+sb.toString());
			}
			else
				System.out.println("Case #"+tt+": IMPOSSIBLE");
			
		}
	}
}
