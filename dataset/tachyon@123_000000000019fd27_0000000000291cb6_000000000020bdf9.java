import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test = sc.nextInt();
		for(int t=0; t<test; t++){
			int n=sc.nextInt();
			sc.nextLine();
			int[][] m=new int[n][2];
			
			for (int i=0;i<n;i++){
				//System.out.println("row "+i+"=");
				String[] s=sc.nextLine().split(" ");
				for (int j=0;j<2;j++){
					m[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			String res="C";
			int cfirst=m[0][0],clast=m[0][1],jfirst=0,jlast=0;
			for (int i=1;i<n;i++){
				if(clast<=m[i][0] || cfirst>=m[i][1]){
						res+="C";
						clast=m[i][1];
						cfirst=m[i][0];
						continue;
				}
				else if(jlast<=m[i][0] || jfirst>=m[i][1]){
					res+="J";
					jlast=m[i][1];
					jfirst=m[i][0];
				}
				else{
					res="IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+(t+1)+": "+res);
		}

	}

}
