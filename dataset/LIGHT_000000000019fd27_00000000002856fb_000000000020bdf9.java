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
			for(i=0;i<n;++i)  person[i]='s';
			for(i=0;i<n;++i){
				task[i][0]=scan.nextInt();
				task[i][1]=scan.nextInt();
				maps.put(733*task[i][0]+713*task[i][1],i);
			}
			
			for (i = 0; i < n-1; i++)
			{
				min_idx = i;
				for (j = i+1; j < n; j++) {
					if ((task[j][0] < task[min_idx][0])) {
						min_idx = j;
					}
				}
				temp = task[min_idx][0];
				task[min_idx][0] = task[i][0];
				task[i][0] = temp;
				temp = task[min_idx][1];
				task[min_idx][1] = task[i][1];
				task[i][1] = temp;
			}
			
			int start=task[0][0],end=task[0][1];
			person[0]='C';
			for(i=1;i<n;++i) {
				if(task[i][1]<=start) {
					start = task[i][0];
					person[i]='C';
				}
				else if(task[i][0]>=end) {
					end = task[i][1];
					person[i]='C';
				}
			}
			
			for(i=1;i<n;++i) {
				if(person[i]=='s')  break;
			}
			
			if(i==n){}
			else {
				start=task[i][0];
				end=task[i][1];
				person[i]='J';
				for(k=i+1;k<n;++k) {
					if(person[k]=='C'){}
					else if(task[k][1]<=start) {
						start = task[k][0];
						person[k]='J';
					}
					else if(task[k][0]>=end) {
						end = task[k][1];
						person[k]='J';
					}
				}
			}
			
			for(i=0;i<n;++i) {
				start=task[i][0];
				end=task[i][1];
				realPerson[maps.get(733*start+713*end)]=person[i];
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
