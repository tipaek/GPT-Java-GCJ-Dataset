import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		Integer cases = sc.nextInt();
	
		ArrayList<String> Result = new ArrayList<String>();
		Solution sol=new Solution();
		for (int i = 0; i < cases; i++) {
			String Output="";
			
			Integer taskCount = sc.nextInt();
			
			
			
			int[][] arr= new int[taskCount][2];
			for (int j1 = 0; j1 < taskCount; j1++) {
	            for (int k = 0; k< 2; k++) {
	               
	                arr[j1][k] = sc.nextInt();
	            }
	            sc.nextLine();
  
	        }
			HashMap<Integer,String > map = new HashMap<>(); 
			for (int k = 0; k < taskCount; k++) {
				map.put(k,"C");
			}
			boolean imp=false;
			
			for (int j1 = 1; j1 < taskCount; j1++) {
				
				int[] jb= {arr[j1][0],arr[j1][1]};
				for (int k = 0; k < j1; k++) {
					int[] kb= {arr[k][0],arr[k][1]};
					if(sol.isOverlap(jb,kb) && map.get(k)==map.get(j1) && imp==false) {
						map.put(j1,sol.Switch(map.get(j1)));
						for (int l = 0; l < j1; l++) {
							int[] kl= {arr[l][0],arr[l][1]};
							if(sol.isOverlap(kl,jb) && map.get(j1)==map.get(l) && imp==false) {
								
								imp=true;
								
								map.put(0, "IMPOSSIBLE");
								for (int j = 1; j < taskCount; j++) {
									map.put(j,"");
								}
							}
							
						}
					}
				}
			
			}
			
			for (int k = 0; k < taskCount; k++) {
				
				Output+=map.get(k);
			
			}
			Result.add(Output);
			
		}
		for (int i = 0; i < cases; i++) {
			System.out.println("Case #"+(i+1)+":"+Result.get(i));
		}
		 
		
	sc.close();
	}
	
	public String Switch(String a) {
		if(a=="C") {
			return "J";
		}
		return "C";
	}
	public boolean isOverlap(int[] a,int[] b) {
		if (a[0]<=b[0]) {
			if(a[1]<=b[0]) {
				return false;
			}
			
		}
		else if(b[0]<=a[0]) {
			if(b[1]<=a[0]) {
				return false;
			}
		}
		return true;
	}
}
