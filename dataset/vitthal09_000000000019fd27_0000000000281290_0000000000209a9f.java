import java.io.*;
import java.util.*;

class Solution{
    
    static void maxDepth(String s, int count){
        int currentMax=0;
        int max=0;
        int n=s.length();
        StringBuffer newStringValue = new StringBuffer();
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) =='1'){
                newStringValue.append('(');
                newStringValue.append(s.charAt(i));
                newStringValue.append(')');
            } else{
                newStringValue.append(s.charAt(i));
            }
        }
		System.out.println("Case #"+count+":"+ " "+newStringValue);
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		sc.nextLine();
		for(int i=1;i<=t;i++){
			String temp = sc.nextLine();
			maxDepth(temp,i);
		}
    }
}