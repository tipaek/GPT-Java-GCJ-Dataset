import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Scanner scn=new Scanner(System.in);
           int t =scn.nextInt();
           int k=1;
           while(t-->0){
        	   int n = scn.nextInt();
        	//   System.out.print('a');
        	   boolean [] arr1 =new boolean [n];
        	   boolean [] arr2 = new boolean[n];
        	   HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
        	   HashMap<Integer,HashSet<Integer>> hm1 =new HashMap<>();
        	   int r=0;
        	   int c =0;
        	   int sum=0;
        	 //  System.out.println(t+"@"+n);
        	   for(int i=0;i<n;i++){
        		   for(int j=0;j<n;j++){
        			   int val =scn.nextInt();
        			   if(i==j){
        				   sum+=val;
        			   }
        			   if(hm1.containsKey(j)){
        				   HashSet<Integer> hs =hm1.get(j);
        				   if(hs.contains(val)){
        					   if(!arr2[j]){
        					 c++;   
        					 arr2[j]=true;}
        				   }else{
        					   hs.add(val);
        				   }
        			   }else{
        				   HashSet<Integer> hs = new HashSet<>();
        				   hs.add(val);
        				   hm1.put(j,hs);
        			   }
        			   if(hm.containsKey(i)){
        				   HashSet<Integer> hs = hm.get(i);
        				    if(hs.contains(val)){
        				    	if(!arr1[i]){
        				    	r++;
        				    	arr1[i]=true;
        				    	}
        				    }else{
        				    	hs.add(val);
        				    }
        			   }else{
        				   HashSet<Integer> hs =new HashSet<>();
        				   hs.add(val);
        				   hm.put(i, hs);
        			   }
        		   }
        	   }
        	   System.out.println("Case #"+k+": "+sum+" "+r+" "+c);
        	   k++;
           }
	}

}