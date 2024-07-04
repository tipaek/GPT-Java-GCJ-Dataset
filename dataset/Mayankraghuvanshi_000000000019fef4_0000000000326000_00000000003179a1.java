/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
	//	System.out.println("GfG!");
		Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	for(int k=1;k<=t;++k){
	    long u=sc.nextLong();
	    String ans="";
	    HashMap<Integer,ArrayList<Character>> map=new HashMap<>(); 
	    int x[]=new int[10000];
	    String [] n=new String [10000];
	    int count=0;
	    while(sc.hasNext()){
	     x[count]=sc.nextInt();
	     n[count]=sc.nextLine();
	      if(x[count]>=1 && x[count]<10){
	          char [] ch=n[count].toCharArray();
	          if(map.containsKey(x[count])){
	              ArrayList<Character> ar=map.get(x[count]);
	              ar.add(ch[1]);
	              map.put(x[count],ar);
	          }
	          else{
	              ArrayList<Character> ar=new ArrayList<>();
	              ar.add(ch[1]);
	              map.put(x[count],ar);
	          }
	    
	      }
	   
	    count++;
	    }
	    HashMap<Character, Integer> map1=new HashMap<>();
	    for(int no=1;no<10;++no){
	         ArrayList<Character> ar=map.get(no);
	        for(int i=0;i<ar.size();++i){
	            if(!map1.containsKey(ar.get(i))){
	                map1.put(ar.get(i),1);
	                ans+=Character.toString(ar.get(i));
	                break;
	            }
	        }
	    }
	    int flag=0;
	    char z='a';
	    for(int i=0;i<10000;++i){
	       char[] ch=n[i].toCharArray();
	       for(int j=1;j<ch.length;++j){
	           if(!map1.containsKey(ch[j])){
	               flag=1;
	               z=ch[j];
	               break;
	           }
	       }
	       if(flag==1)
	       break;
	    }
	    
	    System.out.println("Case #"+k+": "+z+ans);
	    
	}
		
	}
}