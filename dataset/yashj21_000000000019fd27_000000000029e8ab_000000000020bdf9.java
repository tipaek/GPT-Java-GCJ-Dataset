
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
class Solution {
    enum Selection{
        J,C;
    }
   public static void main(String args[]){
	        Scanner sc = new Scanner(System.in);
	        int noOfTest = sc.nextInt();
	        String solution[] = new String[noOfTest];
	        while(noOfTest>0){
	            ArrayList<Integer> [] test = new ArrayList[sc.nextInt()];
	            for(int i=0;i<test.length;i++){
	                test[i] = new ArrayList<>();
	                test[i].add(sc.nextInt());
	                test[i].add(sc.nextInt());
	            }
	            solution[solution.length-noOfTest] = helper(test);
	            noOfTest--;
	        }
	        for(int i=0;i<solution.length;i++){
	            System.out.println("Case #"+(i+1)+": "+solution[i]);
	        }
	    }
	    
	    public static String helper(ArrayList<Integer>[] test){
	       Stack<ArrayList<Integer>> s1 = new Stack<>();
	       Stack<ArrayList<Integer>> s2 = new Stack<>();
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
	       int startptr = test[0].get(0);
	       int endptr = test[0].get(1);
	       s1.push(test[0]);
	       StringBuilder sb= new StringBuilder("C");
	       for(int i=1;i<test.length;i++){
	           if(s1.isEmpty()){
	               s1.add(test[i]);
	               sb.append("C");
	           }else if(s2.isEmpty()){
	               s2.add(test[i]);
	               sb.append("J");
	           }else{
	               if(s1.peek().get(1)<=test[i].get(0)){
	                   s1.pop();
	                   s1.push(test[i]);
	                   sb.append("C");
	               }else if(s2.peek().get(1)<=test[i].get(0)){
	                   s2.pop();
	                   s2.push(test[i]);
	                   sb.append("J");
	               }else{
	                   return "IMPOSSIBLE";
	               }
	           }
	       }
	       return sb.toString();
	    }
}