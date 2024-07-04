import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

class Solution {
      public static void main(String args[]){
	    Scanner sc = new Scanner(System.in);
	    int noOfTest = sc.nextInt();
	    String solution[] = new String[noOfTest];
	    while(noOfTest>0){
	        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();
	        ArrayList<Integer> [] test = new ArrayList[sc.nextInt()];
	        for(int i=0;i<test.length;i++){
	            test[i] = new ArrayList<>();
	            test[i].add(sc.nextInt());
	            test[i].add(sc.nextInt());
	            map.put(test[i],i);
	        }
            solution[solution.length-noOfTest] = helper(test,map);
            noOfTest--;
	    }
	        for(int i=0;i<solution.length;i++){
	            System.out.println("Case #"+(i+1)+": "+solution[i]);
	        }
	    }
	    
	    public static String helper(ArrayList<Integer>[] test, HashMap<ArrayList<Integer>,Integer> map){
	       ArrayList<Integer> s1 = null;
	       ArrayList<Integer> s2 = null;
	       char[] s = new char[map.size()];
	       Arrays.sort(test, new Comparator<ArrayList<Integer>>(){
	           public int compare(ArrayList<Integer> t1,
	           ArrayList<Integer> t2){
	               if(t1.get(0)>t2.get(0))
	               return 1;
	               else if(t1.get(0)<t2.get(0))
	               return -1;
	               return 0;
	           }
	       });
	     //  int startptr = test[0].get(0);
	     //  int endptr = test[0].get(1);
	       s1 = test[0];
	   //if(map.get(test[0])==null || map.get(test[0])>=s.length){
	   //    return "IMPOSSIBLE";
	   //}
	       s[map.get(test[0])] = 'C';
	      // StringBuilder sb= new StringBuilder("C");
	       for(int i=1;i<test.length;i++){
	           if(s1==null){
	               s1= test[i];
	               s[map.get(test[i])] = 'C';
	               //sb.append("C");
	           }else if(s1!=null && s1.get(1)<=test[i].get(0)){
                   s1 = test[i];
                //   if(map.get(test[i])==null || map.get(test[i])>=s.length){
                //       return "IMPOSSIBLE";
                //   }
                   s[map.get(test[i])] = 'C';
//                   sb.append("C");
               }else if(s2==null){
	               s2 = test[i];
	               s[map.get(test[i])] = 'J';
//	               sb.append("J");
	           }else{
	            if(s2!=null && s2.get(1)<=test[i].get(0)){
	                   s2= test[i];
	                   //if(map.get(test[i])==null || map.get(test[i])>=s.length){
	                   //    return "IMPOSSIBLE";
	                   //}
	                   s[map.get(test[i])] = 'J';
	 	              
	                  // sb.append("J");
	               }else{
	                   return "IMPOSSIBLE";
	               }
	           }
	       }
	       return String.valueOf(s);
	   }
}