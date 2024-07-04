import java.util.*;
class Solution {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        test:
	        for(int i = -5; i<= 5; i++){
	            for(int j= -5; j <= 5; j++){
	                System.out.println(i + " " + j);
	                String s = sc.next();
	                if(s.equals("CENTER")){
	                    break test;
	                }
	            }
	        }
	    }
	}
}
