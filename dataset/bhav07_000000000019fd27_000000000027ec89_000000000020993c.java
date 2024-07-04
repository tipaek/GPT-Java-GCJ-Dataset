import java.util.*;
public class Solution{
 public static void main(String[] args){
 Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int test=1;test<=t;test++) {
			int n=scn.nextInt();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=scn.nextInt();
				}
			}
			
			int trace=0;
			for(int i=0;i<n;i++) {
				trace+=arr[i][i];
			}
			
			
			int rowDup=0;
			int colDup=0;
			
			for(int j=0;j<n;j++) {
				int[] temp=new int[n];
				for(int i=0;i<n;i++) {
					temp[i]=arr[i][j];
				}
				if(check(temp)) {
					colDup++;
				}
			}
			for(int i=0;i<n;i++) {
				int[] temp=new int[n];
				for(int j=0;j<n;j++) {
					temp[j]=arr[i][j];
				}
				if(check(temp)) {
					rowDup++;
				}
			}
			
			System.out.println("Case #"+test+": "+trace + " " + rowDup+" "+colDup);
		}
 }
 public static boolean check(int[] arr) {
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				return true;
			}
			else {
				map.put(arr[i],1);
			}
		}
		return false;
	}
}