import java.util.*;
public class Solution {
  public static void main(String[] args) {
	  String result = "J";
	  boolean flow = true;
	  Scanner in= new Scanner(System.in);
	  ArrayList<Integer> list = new ArrayList<Integer>();
	  int t=in.nextInt();
	  for(int m=1;m<=t;m++) {
	  int number_of_activites = in.nextInt();
	  
	  for(int i=0;i<number_of_activites*2;i++) {
		  list.add(in.nextInt());
	  }
	  //computing schedule for jamie and cammeron
	  //loop to check if all 'times' overlap each other
	  // then print Impossible
	  for(int j=2;j<list.size();j +=2) {
		  if(list.get(j)<list.get(j-1) ) {
			  if(j==list.size()-2) {
				  System.out.println("Case #" + m +": "+"IMPOSSIBLE");
				  flow = false;
			  }
			  continue;
		  }else {
			  break;
		  }
	  }
	  //loop to assign times to jammie and cameron
	  if(flow) {
	  for(int k=3;k<list.size();k +=2) {
		   
  if(list.get(k-1)>=list.get(0) && list.get(k-1)<list.get(1)     
	|| list.get(k)<list.get(1) && list.get(k)>=list.get(0) ) {
			  result += "C";
			  }else {
			 result += "J";
		  }
	  }
	  System.out.println("Case #" + m +": "+ result);
	  }
	   result = "J";
	  flow = true;
	  list.clear();
  }
}
}