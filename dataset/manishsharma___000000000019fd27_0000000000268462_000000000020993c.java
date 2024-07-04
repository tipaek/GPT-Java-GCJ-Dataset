
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class d {
	
	
	public static void main(String[] args) throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		for(int ie=0;ie<t;ie++) {
			int n=s.nextInt();
			int[][] arr=new int[n][n];
			int k=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=s.nextInt();
					if(i==j) {
						k=k+arr[i][j];
					}
				}
				
			}
			
			
			int r=0;
			int c=0;
		
			for(int i=0;i<n;i++) {
				HashMap<Integer,Integer> map=new HashMap<>();
				for(int j=0;j<n;j++) {
					if(map.containsKey(arr[i][j])) {
						r++;
						break;
					}else {
						map.put(arr[i][j], 1);
					}
				}
				
			}
			
			
			for(int i=0;i<n;i++) {
				HashMap<Integer,Integer> map=new HashMap<>();
				for(int j=0;j<n;j++) {
					if(map.containsKey(arr[j][i])) {
						c++;
						break;
					}else {
						map.put(arr[j][i], 1);
					}
				}
				
			}
			
			
			
			System.out.println("Case"+"#"+(ie+1)+": "+k+" " +r+" "+ c);
			
			
			
		}
		
	}
	
}