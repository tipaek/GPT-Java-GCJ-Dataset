import java.util.ArrayList;
import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int r=1;
		while(t--!=0){
			int n=s.nextInt();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[i][j]=s.nextInt();
				}
			}
			int trace=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==j) trace+=arr[i][j];
				}
			}
		//	System.out.println(trace);
			int count1=0;
			for(int i=0;i<n;i++){
				ArrayList<Integer> list=new ArrayList<>();
				for(int j=0;j<n;j++){
					if(!list.contains(arr[i][j])){
						list.add(arr[i][j]);
					}else{
						count1+=1;
						break;
					}
				}
			}
			//System.out.println(count1);
			int count2=0;
			for(int i=0;i<n;i++){
				ArrayList<Integer> list=new ArrayList<>();
				for(int j=0;j<n;j++){
					if(!list.contains(arr[j][i])){
						list.add(arr[j][i]);
					}else{
						count2+=1;
						break;
					}
				}
			}
			System.out.println("Case #"+r+": "+trace+" "+count1+" "+count2);
			r++;
		}
	}

}
