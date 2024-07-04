import java.util.*;
import java.io.*;

import java.util.function.Function;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    
	    for(int i=1;i<=t;i++){
	        int k = in.nextInt();
	        int q = in.nextInt();
	        String p = in.next();
	        Map<Integer,Integer> map= new HashMap<>();
	        int m=0;
	        int[] lisp = new int[k];
	        for(int j=0;j<k;j++){
	            char c =p.charAt(j);
	            if( c=='('){
	                m++;
	                map.put(m,j);
	            }else{
	                int temp = map.get(m);
	                m--;
	                lisp[temp]=j;
	                lisp[j]=temp;
	            }
	        }
	       // for(int j=0;j<k;j++){
	       //     System.out.print(lisp[j]+" ");
	       // }
	        for(int j=0;j<k;j++){
	            int temp = in.nextInt()+in.nextInt()+in.nextInt();
	        }
	        long res = 0L;
	        int[] s =new int[q];
	        int[] e =new int[q];
	        for(int j=0;j<q;j++){
	            s[j]=in.nextInt()-1;   
	        }
	        for(int j=0;j<q;j++){
	            e[j]=in.nextInt()-1;   
	        }
	        for(int j=0;j<q;j++){
	            res += solve(lisp,s[j],e[j]);
	        }
	        System.out.println("Case #"+i+": "+res);
	        
	    }
	    in.close();
	}
	
	public static int solve(int[] lisp, int s, int e){
	   // System.out.println(s+"---"+e);
	    int left = s<e?s:Integer.MIN_VALUE;
	    int right = s>e?s:Integer.MAX_VALUE;
	    int cost = 0 ;
	    while(left != e && right != e){
	        List<Integer> list = new ArrayList<>();
	        if(left!=Integer.MIN_VALUE){
	            list.add(left+1);
	            list.add(lisp[left]);
	        }
	        if(right!=Integer.MAX_VALUE){
	            list.add(right-1);
	            list.add(lisp[right]);
	        }
	        left = Integer.MIN_VALUE;
	        right = Integer.MAX_VALUE;
	        for(Integer i:list){
	            if(i<=e){
	                left = Math.max(left,i);
	            }else{
	                right = Math.min(right,i);
	            }
	           // System.out.println(i);
	        }
	       // System.out.println(left+" "+right);
	        cost++;
	    }
	    return cost;
	}
	
}