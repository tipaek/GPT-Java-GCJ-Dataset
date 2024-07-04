import java.util.*;
public class Solution{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			int n = sc.nextInt();
			int[][]m = new int[n][n];
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					m[j][k] = sc.nextInt();
				}
			}
			int trace = 0;
			int r = 0, c = 0;
			for(int j = 0; j < n; j++){
				trace+=m[j][j];
			}for(int j = 0; j < n; j++){
				ArrayList<Integer> list1 = new ArrayList<Integer>();
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				p:
					for(int k = 0; k < n; k++){
						if(!list1.contains(m[j][k])){
							list1.add(m[j][k]);
						}else{
							r++;
							break p;
						}
					}
				p:
					for(int k = 0; k < n; k++) {
						if(!list2.contains(m[k][j])){
							list2.add(m[k][j]);
						}else{
							c++;
							break p;
						}
					}
			}System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
		}
	}
}