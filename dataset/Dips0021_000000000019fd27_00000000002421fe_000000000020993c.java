import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int k=1;k<=T;k++){
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int t=0;
			int r=0;
			int c=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==j)
						t=t+arr[i][j];
				}
			}
			for(int i=0;i<n;i++){
				HashSet<Integer> hs=new HashSet<>();
			for(int j=0;j<n;j++){
					hs.add(arr[i][j]);
				}
				if(hs.size()<n)
					r++;
			}
			for(int i=0;i<n;i++){
				HashSet<Integer> hs=new HashSet<>();
			for(int j=0;j<n;j++){
					hs.add(arr[j][i]);
				}
				if(hs.size()<n)
					c++;
			}
			
			System.out.println("Case #"+ k+": "+ t+" "+r+" "+c);
		}
	}
}
				
			
			