import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Solution {
	

		
	
	
	public static void solve(int[] arr1,String[] arr2,HashMap<String, Integer> map,int k) {
		
		
		
		HashMap<String, Character> memory = new HashMap<String, Character>();
		
		int jEnd = 0;
		int cEnd =0;
		
		for(int i =0;i<arr1.length;i++) {
			if (cEnd<=arr1[i]) {
				if(map.containsKey(arr1[i]+"-2")) {
					if(map.get(arr1[i]+"-2")<=map.get(arr1[i]+"-1")) {
						cEnd = map.get(arr1[i]+"-2");
						map.put((arr1[i]+"-2"), Integer.MAX_VALUE);
						memory.put(arr1[i]+"-"+cEnd+"-2", 'C');
					}else {
						cEnd = map.get(arr1[i]+"-1");
						map.put((arr1[i]+"-1"), Integer.MAX_VALUE);
						memory.put(arr1[i]+"-"+cEnd
								+"-1", 'C');
					}
				}else {
					cEnd = map.get(arr1[i]+"-1");
					memory.put(arr1[i]+"-"+cEnd
							+"-1", 'C');
				}
				
			}else if(jEnd<=arr1[i]) {
					if(map.containsKey(arr1[i]+"-2")) {
						if(map.get(arr1[i]+"-2")<=map.get(arr1[i]+"-1")) {
							jEnd = map.get(arr1[i]+"-2");
							map.put((arr1[i]+"-2"), Integer.MAX_VALUE);
							memory.put(arr1[i]+"-"+jEnd+"-2", 'J');
						}else {
							jEnd = map.get(arr1[i]+"-1");
							map.put((arr1[i]+"-1"), Integer.MAX_VALUE);
							memory.put(arr1[i]+"-"+jEnd+"-1", 'J');
						}
					}else {
						jEnd = map.get(arr1[i]+"-1");
						memory.put(arr1[i]+"-"+jEnd+"-1", 'J');
					}
					
//					
					
				}else {
				System.out.println("Case #"+ (k) +": IMPOSSIBLE");
				return;
			}
		}
		
		
		System.out.print("Case #"+ (k) +": ");
		
		for(int i =0;i<arr2.length;i++) {
			System.out.print(memory.get(arr2[i]));
		}
			
		System.out.println();
		
	}
	
    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int  t= s.nextInt();
	int k = t;
	while(t>0) {
		int n = s.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int[] arr1 = new int[n];
		int[] arr3 = new int[n];
		String[] arr2 = new String[n];
		
		for(int i =0;i<n;i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			arr1[i] = start;
			arr3[i] = start;
			
			if(map.containsKey(start+"-2")&&map.containsKey(start+"-1")) {
				System.out.println("Case #"+ (k-t+1) +": IMPOSSIBLE");
				return;
			}
			if(map.containsKey(start+"-1")){
				map.put((start+"-2"), end);
				arr2[i] = start+"-"+end+"-2";
			}else {
				map.put((start+"-1"), end);
				arr2[i] = start+"-"+end+"-1";
			}
			
			
		}
		
		Arrays.sort(arr1);
		
		Arrays.sort(arr3);
		
		int i = 1;
		int j = 0;
		int pN = 1;
		while(i<n&&j<n) {
			if (arr1[i]<arr3[j]) {
				pN++;
                i++;
			}else {
				pN--;
                j++;
			}
			if(pN>2) {
				System.out.println("Case #"+ (k-t+1) +": IMPOSSIBLE");
				return;
			}
		}
		
		
		
		solve(arr1,arr2, map,k-t+1);
		
		t--;
	}
	s.close();
	
	
	}

}