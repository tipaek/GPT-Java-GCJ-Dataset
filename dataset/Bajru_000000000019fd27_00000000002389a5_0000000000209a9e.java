import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args){
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scan.nextInt();
		int n = scan.nextInt();
		int b[] = new int[n];
		
		
		for(int i=0;i<t;i++){
		    for(int j=0;j<n;j++){
		        System.out.println(i+1);
		        b[i] = scan.nextInt();
		    }
		
		    for(int j=0;j<n;j++){
		        System.out.print(b[j]);
		    }
		}
	}
	
    private static void solve(){
        
	}
}