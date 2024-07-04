import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int T = Integer.parseInt(sc.nextLine());
	    String s[] = new String[T];
	    for(int i=0;i<T;i++){
	        String str = sc.nextLine();
	        String temp ="";
	        int j=0;
	        while(j<str.length()){
	            if(str.charAt(j)=='0' && j==0){
	                str=str;
	            }
	            else if(str.charAt(j)=='1' && j==0){
	                str="(1)"+str.substring(1);
	                j=j+2;
	            }
	            else if(str.charAt(j)=='1' && str.charAt(j-1)==')'){
	                str=str.substring(0,j-1)+"1)"+str.substring(j+1);
	            }
	            else if(str.charAt(j)=='1'){
	                str=str.substring(0,j)+"(1)"+str.substring(j+1);
	                j=j+2;
	            }
	            j++;
	        }
	        
	        s[i]="Case #"+(i+1)+": "+str;
	    }
	    for(int i=0;i<T;i++){
	        System.out.println(s[i]);
	    }
	}
}
