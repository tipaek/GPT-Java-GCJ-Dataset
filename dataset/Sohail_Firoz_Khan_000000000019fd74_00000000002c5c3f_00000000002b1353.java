import java.util.*;
import java.io.*;

 class Solution{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
       int ts=sc.nextInt();
       sc.nextLine();
       while(ts-- > 0){
       	solve();
       }
	}
	static String[] sort(String []s, int n) 
{ 
    for (int i=1 ;i<n; i++) 
    { 
        String temp = s[i]; 
  
        // Insert s[j] at its correct position 
        int j = i - 1; 
        while (j >= 0 && temp.length() < s[j].length()) 
        { 
            s[j+1] = s[j]; 
            j--; 
        } 
        s[j+1] = temp; 
    }
    return s; 
} 
	public static void solve(){
		int N=sc.nextInt();
		sc.nextLine();
		int[] a=new int[N];
		String[] s=new String[N];
		for(int i=0;i<s.length;i++){
			s[i]=sc.nextLine();
		}
		sort(s,N);
		boolean b=true;
	
		for(int i=s.length-1;i<=0;i--){
			for(int j=0;j<s[i].length();j++){
				if(s[i].charAt(j)=='*'){
                      index=s[i].indexOf('*');
                      String [] temp=s[i].split("*");
                      
                      
      
				}
				
			}
		}
	} 
}