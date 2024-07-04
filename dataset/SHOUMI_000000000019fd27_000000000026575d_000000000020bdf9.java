import java.util.*;
public class Solution {
  public static void main(String[] args) {
	  String result = "J";
	  
	  Scanner in= new Scanner(System.in);
	  ArrayList<Integer> list = new ArrayList<Integer>();
	  ArrayList<Integer> similar_to_list = new ArrayList<Integer>();
	  ArrayList<Integer> jlist = new ArrayList<Integer>();
	  ArrayList<Integer> clist = new ArrayList<Integer>();
	  int t = in.nextInt();
      for(int q=1;q<=t;q++) {
	  int number_of_activites = in.nextInt();
	  
	  for(int i=0;i<number_of_activites*2;i++) {
		  list.add(in.nextInt());
	  }
	  //creating arraylist containg same elements of list
	  for(int n=0;n<list.size();n++) {
		  similar_to_list.add(list.get(n));
	  }
	  //adding first and second element of list to jlist
	  jlist.add(list.get(0));
	  jlist.add(list.get(1));
	   list.remove(0);
	   list.remove(0);
	   for(int j=1;j<list.size();j++) {
		 for(int k=1;k<jlist.size();k++) {
			 if(list.size() == 0)
				 break;
				   if(list.get(j-1)>jlist.get(k-1) && list.get(j-1)<jlist.get(k) ||list.get(j)>jlist.get(k-1) && list.get(j)<jlist.get(k)) {
					   result += "C";
					   clist.add(list.get(j-1));
					   clist.add(list.get(j));
					   list.remove(0);
					   list.remove(0);
				   }else {
					   result +="J";
					   jlist.add(list.get(j-1));
					   jlist.add(list.get(j));
					   list.remove(0);
					   list.remove(0);
				   }
				   
			   }
		       j=0;
			   }
	   for(int v=1;v<similar_to_list.size();v +=2) {
		   
		   for(int z=1;z<jlist.size();z +=2) {
		   if(similar_to_list.get(v-1)>jlist.get(z-1) && similar_to_list.get(v-1)<jlist.get(z) ||similar_to_list.get(v)>jlist.get(z-1) && similar_to_list.get(v)<jlist.get(z)) {
			   for(int u=1;u<clist.size();u +=2) {
				   if(similar_to_list.get(v-1)>clist.get(u-1) && similar_to_list.get(v-1)<clist.get(u) ||similar_to_list.get(v)>clist.get(u-1) && similar_to_list.get(v)<clist.get(u)) {
					   result = "IMPOSSIBLE";
				   }
			   }
		   }
	   }
	   }	
		System.out.println("Case #" + q + ": " + result);
		list.clear();
		similar_to_list.clear();
		jlist.clear();
		clist.clear();
		result="J";
 }
}
}
