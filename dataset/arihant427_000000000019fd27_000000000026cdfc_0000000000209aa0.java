import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t;
		t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int m = in.nextInt();
			if (m < n) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}else if(n*n <m){
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {	
				int[][] finalArr = new int[n][n];
				int num = m/n;
				if(num*n == m){
					for (int j = 0; j < n; j++) {
						finalArr[j][j] = num;
					}
				}else {
					int h = m-(num*n);
					if(h <= (n-num)){
						for (int j = 0; j < n; j++) {
							finalArr[j][j] = num;
						}
						finalArr[0][0] = num+h;
					}else {
						for (int j = 0; j < n; j++) {
							if(h == 0)
							finalArr[j][j] = num;
							else{
								finalArr[j][j] = num+1;
								h = --h;
							}
						}
					}
				}
				System.out.println(finalArr[0][0]+" "+finalArr[1][1]+" "+finalArr[2][2]);
				Set s = new HashSet();
				for (int j = 0; j < n; j++) {
					s.add(finalArr[j][j]);
				}
				System.out.println(s.size());
				System.out.println((n%2==0 ?n/2 :n/2+1));
				if(s.size() !=1 && (n-s.size()+1)>= (n%2==0 ?n/2 :n/2+1)){
					System.out.println("Case #" + i + ": IMPOSSIBLE");
				}else{
					
					for (int j = 0; j < n; j++) {
						for (int j2 = n-1; j2 >= 0; j2--) {
							if(j == j2){
								continue;
							}
							List<String> list = new ArrayList<>();
							for (int k = 0; k < n; k++) {
								list.add(String.valueOf(k+1));
							}
							list.forEach(System.out::println);
							System.out.println("size ==:"+list.size());
							for (int k = 0; k < n; k++) {
								//if(k == j2)continue;
								if(list.contains(String.valueOf(finalArr[j][k]))){
									System.out.println("removing: "+String.valueOf(finalArr[j][k]));
									list.remove(String.valueOf(finalArr[j][k]));
}// doubt
							}
							for (int k = 0; k < n; k++) {
								//if(k == j2)continue;
								if(list.contains(String.valueOf(finalArr[k][j2]))){
									System.out.println("removing: "+String.valueOf(finalArr[k][j2]));
									list.remove(String.valueOf(finalArr[k][j2]));
								}// doubt
							}
							System.out.println("size:"+list.size());
							if(list.size() ==0){
								System.out.println("Case #" + i + ": IMPOSSIBLE");
								System.exit(0);
							}else{
								System.out.println("set :finalArr "+j+" "+j2+" "+Integer.parseInt(list.get(0)));					
								
								for (int k = 0; k < finalArr.length; k++) {
									for (int k2 = 0; k2 < finalArr.length; k2++) {
										if(list.contains(finalArr[k][k2])){
											finalArr[j][j2] = finalArr[k][k2];
										}
									}
								}
								if(finalArr[j][j2] ==0){
									finalArr[j][j2] = Integer.parseInt(list.get(0));
								}
							}
							
							
						}
					}
					
					
				}
				for(i = 0; i < n; i++)
			  	{
			   	    for(int i2 = 0; i2 < n; i2++) 
			     	    {
			        	System.out.print(finalArr[i][i2]+" ");
			            }
			   	    System.out.println();
			  	}
			}
			
				
				
				//System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
			}
		}
	

}