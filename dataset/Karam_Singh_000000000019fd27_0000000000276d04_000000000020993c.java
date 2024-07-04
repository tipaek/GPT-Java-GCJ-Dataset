import java.util.*;
    import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt(),count=1;
		while(t>0) {
		int n=scn.nextInt();
	
		int[][] arr=new int[n][n];
		int r=0,c=0,trace=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=scn.nextInt();
				if(i==j) {
					trace+=arr[i][j];
				}
				
			}
		}
		boolean[] col=new boolean[n];
		for(int i=0;i<n;i++) {
			boolean flag=false;
			HashMap<Integer, Integer> m=new HashMap<>();
			for(int j=0;j<n;j++) {
				if(m.containsKey(arr[i][j])) {
					m.put(arr[i][j], m.get(arr[i][j]+1));
					if(flag==false) {
						r++;
					}
					
					flag=true;
				}else {
					m.put(arr[i][j], 1);
				}
			}
		}
		for(int i=0;i<n;i++) {
			boolean flag=false;
			HashMap<Integer, Integer> m=new HashMap<>();
			for(int j=0;j<n;j++) {
				if(m.containsKey(arr[j][i])) {
					m.put(arr[j][i], m.get(arr[j][i]+1));
					if(flag==false) {
						c++;
					}
					
					flag=true;
				}else {
					m.put(arr[j][i], 1);
				}
			}
		}
		System.out.println("Case #"+count+": "+ trace+" "+r+" "+c);
		count++;
		t--;
	}
		}

}
