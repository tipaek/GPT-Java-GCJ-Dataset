import java.util.*;

public class Solution {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int t = Integer.parseInt(sc.nextLine());
    
    for(int x=1; x <= t; x++) {
        int n = Integer.parseInt(sc.nextLine());
        int a[][] = new int[n][n];
        int sum =0;
        int rowcount = 0;
        int colcount = 0;
        for(int i=0; i<n; i++) {
            String ip = sc.nextLine();
            String[] arr = ip.split(" ");
            Set<Integer> rset = new HashSet<>();
            boolean rflag = true;
            for(int j=0; j<n; j++) {
                a[i][j] = Integer.parseInt(arr[j]);
                
                if(i==j) {
                	sum = sum +a[i][j];
                }
                
                if(rflag && rset.contains(a[i][j])) {
                	rflag = false;
                	rowcount = rowcount + 1;
                } else {
                	rset.add(a[i][j]);
                }
            }
        }
        
        // column calculation
        for(int i=0; i < n; i++) {
        	Set<Integer> cset = new HashSet<>();
            boolean cflag = true;
        	for(int j=0; j < n; j++) {
        		if(cflag && cset.contains(a[j][i])) {
                	cflag = false;
                	colcount = colcount + 1;
                } else {
                	cset.add(a[j][i]);
                }
        	}
        }   
        System.out.println("Case #"+ x +": "+ sum +" "+ rowcount +" "+ colcount);
        
    }
}
}