import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int q = sc.nextInt();
    
    for(int i = 0; i<q; i++) {
    	String s = sc.nextLine();
    	System.out.println(s);
    	int temp = 0;
    	
    	int index = 0;
    	int[] temparr = new int[s.length()];
    	String[] arr = new String[100]; 
    	for(int j =0; j< s.length(); j++) {
    		temparr[j] = s.charAt(j);
    		if(j>0 && temparr[j] != temparr[j-1]) {
    			arr[index] = s.substring(temp,j);
    			temp = j;
    			index++;
    		}
    	}
    	arr[index] = s.substring(temp,s.length());
    	
    	System.out.print("Case #" +(i+1)+": ");
    	
    	for(int a = 0; a< index+1; a++) {
    		if(arr[a].charAt(0) == 1) {
    			System.out.print("("+arr[a]+")");
    		}
    		else {
    			System.out.print(arr[a] +" ");
    		}
    	}
    	System.out.println();
    	
    	
    	
    }
  }
}
