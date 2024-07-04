import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	 public static void main(String[] args) 
	 { 
		 Scanner sc = new Scanner(System.in);
		 int t = sc.nextInt();
		 int index = 1;
		 List<String> list = new ArrayList<String>();
		while (t>0) {
			 int N = sc.nextInt();
			 int mat[][] = new int[N][2];
			 for (int i=0;i<N;i++) {
				 for (int j=0;j<2;j++) {
					 mat[i][j] = sc.nextInt();
				 }
			 } 
			 list.add("Case #"+ index +": "+ findSchedule(mat));
		     t--;
		     index++;
		}
		for (String var:list) {
			System.out.println(var);
		}
	 }
	 
	 public static String findSchedule(int arr[][]) {
		 String schedule = null;
		 for (int i=0;i<arr.length;i++) {
			if (arr[i][1] >=1440 || arr[i][0] >=1440) {
				schedule = "IMPOSSIBLE";
				break;
			}
			if (i == 0) {
				schedule = "C";
				continue;
			}
			if (arr[i][1] > arr[i-1][1]) {
				schedule+="J";
			} else {
				schedule+="C";
			}
			
		 }
		 
		 
		 return schedule;
	 }

}
