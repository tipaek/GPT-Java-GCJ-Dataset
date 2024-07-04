import java.util.*;

class Solution {
	public static void main(String args[]){
	    Scanner sc = new Scanner(System.in);
	    int testCases = sc.nextInt();
	    int testCase = 1, rows, rc=0, cc=0, temp, trace,i,j;
	    boolean[] ru,cu;
	    List<Set<Integer>> rs,cs;
	    for ( ; testCase <= testCases; testCase++){
	    	trace=0;rc=0; cc=0;rows=sc.nextInt();rs=new ArrayList();cs=new ArrayList();ru = new boolean[rows]; cu=new boolean[rows];
	        for(i=0;i<rows;i++) {rs.add(new HashSet<>()); cs.add(new HashSet<>()); }
	        for(i=0;i<rows;i++){
	            for(j=0;j<rows;j++){
	            	temp = sc.nextInt(); if(i == j) trace += temp;
	                if(rs.get(i).contains(temp)){ru[i]=true;}rs.get(i).add(temp);
	                if(cs.get(j).contains(temp)){cu[j]=true;}cs.get(j).add(temp);
	            }
	        }
	        for(i=0;i<rows;i++) {if(ru[i]) rc++; if(cu[i]) cc++; }
	        System.out.println("Case #"+testCase+": " + trace + " " + rc + " " + cc);
	    }
    }
}