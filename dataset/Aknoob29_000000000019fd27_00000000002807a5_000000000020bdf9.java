
import java.util.*; import java.io.*;
public class Solution {
static Scanner sc=new Scanner(System.in); static int tn=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int t=sc.nextInt();
while(t-->0) {
	solve();
}
	}
	
	private static void solve() { StringBuilder sb=new StringBuilder();
			
		int n=sc.nextInt();
		int arr[][]=new int[n][2];  char per='J'; int arrSort[][]=arr.clone();
		Stack<int[]> js=new Stack<>();
		Stack<int[]> cs=new Stack<>();  char[] cc=new char[n];
		Map<int[],Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=sc.nextInt();
				
			}
			map.put(arr[i],i);
		}
	Arrays.sort(arr, new Comparator<int[]>() {
			
			public int compare(int[]a,int[]b) {
				return a[0]-b[0];
			}
		});	
	int check=0;
	for(int i1=0;i1+1<n;i1++) {
		if(arr[i1][1]>arr[i1+1][0] ) {
			check++;
		}
	} 
	if(check==n-1) {
		System.out.println("Case #"+(++tn)+": "+"IMPOSSIBLE");
	}
	else {
		for(int i=0;i<arrSort.length;i++) {
		cc[map.get(arrSort[i])]=per;
			if(i<arrSort.length-1 && over(arrSort[i],arrSort[i+1])){
		per=getper(per);
			}
			
			
		}
	System.out.println("Case #"+ (++tn)+": "+new String(cc));
	}
	}
	private static char getper(char c) {
		return c=='J' ? 'C' : 'J';
	}
	private static boolean over(int[]a,int []b) {
		return a[1]>b[0];
	}
}

