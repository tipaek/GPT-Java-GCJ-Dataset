import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static boolean isFree(int[] calendar,int start,int end) {
		
		for(int i=start;i<end;i++) {
			if(calendar[i]!=0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<T;i++) {
			
			int N = Integer.parseInt(sc.nextLine());
			int[][] tasks = new int[N][3];
			
			for(int j=0;j<N;j++) {
				
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				tasks[j][0]=start;
				tasks[j][1]=end;
				tasks[j][2]=j+1;
			}
			
			Arrays.sort(tasks,new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) {
						return -Integer.compare(o1[1],o2[1]);
					}
					return Integer.compare(o1[0], o2[0]);
				}
				
			});
			
			int[] jamie = new int[((24*60)+1)];
			int[] cameron = new int[((24*60)+1)];
			char[] result = new char[N];

			boolean impossible = false;
			
			for(int j=0;j<N;j++) {
				int start = tasks[j][0];
				int end = tasks[j][1];
				int numTask = tasks[j][2];
				
				if(isFree(jamie, start, end)) {
					for(int k=start;k<end;k++) {
						jamie[k]=numTask;
					}
					result[numTask-1]='J';
				}
				else if(isFree(cameron,start,end)){
					for(int k=start;k<end;k++) {
						cameron[k]=numTask;
					}
					result[numTask-1]='C';
				}
				else {
					impossible = true;
				}
			}
			if(impossible) {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}else {
				System.out.print("Case #"+(i+1)+": ");
				for(int k=0;k<N;k++) {
					System.out.print(result[k]);
				}
				System.out.println("");
			}
		}
		
		sc.close();
	}
}
