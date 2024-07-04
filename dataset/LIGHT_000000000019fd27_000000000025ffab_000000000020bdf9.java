import java.util.*;
public class Solution {
	private static int min(int x , int y) {
		return x>y?y:x;
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tt;
		
		for(tt=1;tt<=t;++tt) {
			int n = scan.nextInt();
			int[][] task = new int[n][2];
			HashMap<Integer,Integer> maps = new HashMap();
			int i,j,k;
			boolean flag = true;
			
			for(i=0;i<n;++i){
				task[i][0]=scan.nextInt();
				task[i][1]=scan.nextInt();
			}
			
			if(n==2) {System.out.println("Case #"+tt+": CC");  continue;}
			
			for(i=0;i<n;++i) {
				maps.put(task[i][0]+task[i][1],i);
			}
			//System.out.println(maps);
			int temp;
			char[] person = new char[n];
			char[] realPerson = new char[n];
			for(k=0;k<n;++k)  person[k]='a';
			
			for (i = 0; i < n-1; i++)
			{
				int min_idx = i;
				for (j = i+1; j < n; j++)
					if (task[j][1] < task[min_idx][1])
						min_idx = j;
				
				temp = task[min_idx][0];
				task[min_idx][0] = task[i][0];
				task[i][0] = temp;
				temp = task[min_idx][1];
				task[min_idx][1] = task[i][1];
				task[i][1] = temp;
			}
			
			int last=0;
			
			//for c
			for(i=0;i<n;++i) {
				if(task[i][0]>=last) {
					person[i]='C';
					last = task[i][1];
				}
			}
			
			last=0;
			//for j
			for(i=0;i<n;++i) {
				if(task[i][0]>=last && person[i]=='a') {
					person[i]='J';
					last = task[i][1];
				}
			}
			
			for(i=0;i<n;++i) {
				if(person[i]=='a') {
					System.out.println("Case #"+tt+": IMPOSSIBLE");
					flag = false;
					break;
				}
			}
			StringBuffer sb = new StringBuffer();
			if(flag) {
				
				for(i=0;i<n;++i) {
					realPerson[maps.get(task[i][0]+task[i][1])]=person[i];
				}
				
				for(i=0;i<n;++i)  sb.append(realPerson[i]);
				
				System.out.println("Case #"+tt+": "+sb.toString());
			}
		}
			
	}
}
