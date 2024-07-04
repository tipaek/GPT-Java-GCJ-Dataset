import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t;
	    int tt = 1;
	    t = sc.nextInt();
	    while(t > 0) {
	    	int n;
	    	n = sc.nextInt();
	    	Map<int[],Integer> mp = new HashMap<>();
	    	int temp[][] = new int[n][2];
	    	for(int i = 0;i<n;i++) {
	    		temp[i][0] = sc.nextInt();
	    		temp[i][1] = sc.nextInt();
	    		mp.put(temp[i],i);
	    	}
	    	Arrays.sort(temp,new Comparator<int[]>(){ 
	            public int compare(final int[] s1,final int[] s2 ) 
	            { 
	            	int d;
	            	if(s1[0] == s2[0]) {
	            		d = s1[1] > s2[1] ? 1 : -1;
	            	}
	            	else {
	            		d = s1[0] > s2[0] ? 1 : -1;
	            	}
	                return d; 
	            } 
	        }); 
	    	int flagj = 0,flagc = 0;
	    	char[] ch = new char[n];
	    	ch[mp.get(temp[0])] = 'J';
			flagj = temp[0][1];
			int i;
	    	for(i=1;i<n;i++) {
	    		if(temp[i-1][1] <= temp[i][0]) {
	    			if(flagj <= temp[i][0]) {
	    				ch[mp.get(temp[i])] = 'J';
	    				flagj = temp[i][1];
	    			}
	    			else if(flagc <= temp[i][0]) {
	    				ch[mp.get(temp[i])] = 'C';
	    				flagc = temp[i][1];
	    			}
	    			else {
	    				break;
	    			}
	    		}
	    		else if(temp[i-1][1] > temp[i][0]) {
	    			if(flagc <= temp[i][0]) {
	    				ch[mp.get(temp[i])] = 'C';
	    				flagc = temp[i][1];
	    			}
	    			else if(flagj <= temp[i][0]) {
	    				ch[mp.get(temp[i])] = 'J';
	    				flagj = temp[i][1];
	    			}
	    			else {
	    				break;
	    			}
	    			
	    		}
	    	}
	    	if(i == n) {
	    	    System.out.print("Case #" + tt + ": ");
	    		for(int j=0;j<n;j++) {
		    		System.out.print(ch[j]);
		    	}
		    	System.out.println();
	    	}
	    	else {
	    		System.out.println("Case #" + tt + ": " +"IMPOSSIBLE");
	    	}
	    
	    	t--;
	    	tt++;
	    	//System.out.println();
	    }

	}

}
