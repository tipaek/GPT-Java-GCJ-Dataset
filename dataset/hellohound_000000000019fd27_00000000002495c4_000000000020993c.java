import java.util.*;
class  Solution {
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        for(int tc = 1; tc <= t; tc++) {
	            int n = sc.nextInt();
	            int[][] arr = new int[n][n];
	            for(int i = 0; i < n; i++) {
	                for(int j = 0; j < n; j++) {
	                    arr[i][j] = sc.nextInt();
	                }
	            }
	            
	            Set<Integer> hs = new HashSet<>();
	            
	            int rs = 0, cs = 0, trace = 0;
	            for(int i = 0; i < n; i++) {
	            	trace+=arr[i][i];
	                for(int j = 0; j < n; j++) {
	                    
	                    if(hs.contains(arr[i][j])) {
	                    	rs++;
	                    	break;
	                    } else hs.add(arr[i][j]);
	                }
	                hs.clear();
	            }
	            
	            for(int i = 0; i < n; i++) {
	            	for(int j = 0; j < n; j++) {
	            		if(hs.contains(arr[j][i])) {
	            			cs++;
	            			break;
	            		} else hs.add(arr[j][i]);
	            	}
	            	hs.clear();
	            }
	            
	            System.out.println("Case #" + tc + ": " + trace + " " + rs + " " + cs);
	        }
	    }
	}