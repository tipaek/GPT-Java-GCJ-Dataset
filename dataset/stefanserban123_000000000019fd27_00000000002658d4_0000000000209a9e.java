import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = sc.nextInt();
		int n = sc.nextInt();
		
		for (int x=1; x<=tests; x++) {
		    // 0001101111
		    int count = 1;
		    int[] b = new int[n];

            // wave 1		    
		    for (int i=0;i<n;i++) {
	            p(i); // wave 1    
	            b[i] = sc.nextInt();
		        count++;
		    } 
		    // 000110111x
		    
		    //wave 2
		    int[] newB =  new int[n];
		    
		    for (int i=0;i<4;i++) {
	            p(i);   
		        newB[i] = sc.nextInt();
		        count++;
		    }
		    
		    // wave 3
		    if (newB[0] == b[0] &&
		        newB[1] == b[1] &&
		        newB[2] == b[2] &&
		        newB[3] == b[3]) {
		            // nothing case
		            postRes(b);
		            String answer = sc.next();
		            
		            if (answer == "N") {
		            	break;
		            }
		            
		        } else if (newB[0] == flip(b[0]) &&
		                newB[1] == flip(b[1]) &&
		                newB[2] == flip(b[2]) &&
		                newB[3] == flip(b[3])
		        ) {
		            // flip case
		            postRes(flipAll(b));
		            String answer = sc.next();
		            
		            if (answer == "N") {
		            	break;
		            }
		            
		        } else if (newB[1] == b[n-1] &&
		                newB[2] == b[n-2] &&
		                newB[3] == b[n-3]) {
		        	// reverse case
		            postRes(reverse(b));
		            String answer = sc.next();
		            
		            if (answer == "N") {
		            	break;
		            }
		        } else {
		        	// flip and reverse case
		            postRes(flipAll(reverse(b)));
		            String answer = sc.next();
		            
		            if (answer == "N") {
		            	break;
		            }
		        }
		}
	}

    public static void p (int i) {
        System.out.println(i);
    }	
    
    public static void postRes (int[] b) {
        String str = "";
        for (int i=0;i<b.length;i++) {
            str += b[i];
        }
        
        System.out.println(str);
    }
    
    public static int[] flipAll (int[] b) {
        for (int i=0;i<b.length;i++) {
            b[i] = flip(b[i]);
        }
        
        return b;
    }
    
    public static int[] reverse (int[] b) {
        for(int i = 0; i < b.length / 2; i++) {
            int temp = b[i];
            b[i] = b[b.length - i - 1];
            b[b.length - i - 1] = temp;
        }
        
        return b;
    }
    
    public static int flip (int i) {
        return i == 0 ? 1 : 0;
    }
}