import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        int N = sc.nextInt();
	        int D = sc.nextInt();
	        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	        int maximum = 0;
	        if(D == 2){
	            int max = 0;
	            for(int i = 0; i < N; i++){
	                int A = sc.nextInt();
	                if(hm.containsKey(A)){
	                    hm.put(A, hm.get(A) + 1);
	                }
	                else{
	                    hm.put(A, 1);
	                }
	                Integer a = hm.get(A);
	                if(hm.get(A) > max){
	                    max = hm.get(A);
	                }
	            }
	            if(max >= 2){
	                System.out.println("Case #" + tt + ": " + 0);
	            }
	            else{
	                System.out.println("Case #" + tt + ": " + 1);
	            }
	        }
	        else if(D == 3){
	            int max = 0;
	            for(int i = 0; i < N; i++){
	                int A = sc.nextInt();
	                if(A > maximum){
	                    maximum = A;
	                }
	                if(hm.containsKey(A)){
	                    hm.put(A, hm.get(A) + 1);
	                }
	                else{
	                    hm.put(A, 1);
	                }
	                Integer a = hm.get(A);
	                if(hm.get(A) > max){
	                    max = hm.get(A);
	                }
	            }
	            if(max >= 3){
	                System.out.println("Case #" + tt + ": " + 0);
	            }
	            else if(max == 1){
	                System.out.println("Case #" + tt + ": " + 2);
	            }
	            else{
	                for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
	                    int v = entry.getValue();
	                    if(v == 2 && maximum > entry.getKey()){
                	        System.out.println("Case #" + tt + ": " + 1);
	                    }
	                    else{
                	        System.out.println("Case #" + tt + ": " + 2);
	                    }
	                }
	            }
	        }
	    }
	}
}