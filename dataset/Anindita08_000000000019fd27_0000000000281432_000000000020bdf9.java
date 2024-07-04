import java.lang.*;
import java.io.*;
import java.util.*;

class Task{
	int s, e, i;
	Task(int s, int e, int i){
		this.s=s;
		this.e=e;
		this.i=i;
	}
}
class Solution{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader x= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(x.readLine());
		int T=Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(x.readLine());
			int N=Integer.parseInt(st.nextToken());
			Task[] arr = new Task[N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(x.readLine());
				arr[i]=new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			char[] res=new char[N];
			Arrays.sort(arr,new TimeComparator());
			int f=0; int c=arr[0].e,j=0;
			res[arr[0].i]='C';
			for(int i=1;i<N;i++) {
				if(arr[i].s<c) {
					if(arr[i].s>=j) {
					j=arr[i].e;
					res[arr[i].i]='J';
					}
					else {
						f=1;
						break;
					}
				}
				else {
					c=arr[i].e;
					res[arr[i].i]='C';
				}
			}
			if(f==1)
			System.out.println("Case #"+t+": "+"IMPOSSIBLE");
			else {
				System.out.print("Case #"+t+": ");
				for(int i=0;i<N;i++) {
					System.out.print(res[i]);
				}
				System.out.println();
			}
			
		}
	}
	static class TimeComparator implements Comparator<Task>{
		@Override
		public int compare(Task e1, Task e2) {
			if(e1.e<e2.e) 
				return -1;
				else
					return 1;
			
		}
	}
}
