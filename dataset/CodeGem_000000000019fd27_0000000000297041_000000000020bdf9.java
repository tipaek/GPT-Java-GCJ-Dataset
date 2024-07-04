//sort actvty on the basis of end time

import java.util.*;

public class Solution
{

    class Obj implements Comparable<Obj>{
    	int start,end;
    	String s;

    	public Obj(int st,int et){
    	  this.start = st;
    	  this.end = et;
    	}
    	

    	public int compareTo(Obj o){
    		return this.end - o.end;
    	}
    }
    
    public void solve(){
        	Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			List<Obj> list;
			List<Obj> orig;
			int count = 1;
			int flag = 0;
			while(count<=t){
               list = new ArrayList<>();
               orig = new ArrayList<>();
			   int n =sc.nextInt();
			   flag = 0;
			 
			   for(int i=0; i<n; i++){
			       
			   		int st = sc.nextInt();
			   		int et = sc.nextInt();
			   		Obj o = new Obj(st, et);
			   		list.add(o);
			   		orig.add(o);

			   }
			   Collections.sort(list);

			   List<Obj> sublist1 = new ArrayList<>(); //J
			   List<Obj> sublist2 = new ArrayList<>(); //C
			   StringBuilder sb = new StringBuilder();
			   for(Obj curr: list){
			   	if(sublist1.isEmpty()){
			   	  sublist1.add(curr);
			   	  //System.out.println(curr.start+" "+curr.end+" goes to L1");
			   	  curr.s = "J";
			   	}else{
			   	  Obj lastObj = sublist1.get(sublist1.size()-1);
			   	  if(lastObj.end <= curr.start){
			   	  	sublist1.add(curr);
			   	  	//System.out.println(curr.start+" "+curr.end+" goes to L1");
			   	  	curr.s = "J";
			   	  }
			   	  else if(sublist2.isEmpty()){
			   	  	sublist2.add(curr);
			   	  	curr.s = "C";
			   	  	//System.out.println(curr.start+" "+curr.end+" goes to L2");
			   	  }else{
			   	       Obj lastObj2 = sublist2.get(sublist2.size()-1);
			   	        if(lastObj2.end <= curr.start){
			   	  	    sublist2.add(curr);
			   	  	    curr.s = "C";
			   	  	    //System.out.println(curr.start+" "+curr.end+" goes to L2");
			   	        }else{
			   	            System.out.println("Case #"+count+": "+"IMPOSSIBLE");
			   	            flag = 1;
			   	            break;
			   	        }
			   	  }
			   	}
			   }//for closed
                
               for(Obj x : orig)sb.append(x.s);
               if(flag == 0)
			   System.out.println("Case #"+count+": "+sb.toString());
			   count++;
			}//end of while
  
    }

	public static void main(String[] args)
	{
	    new Solution().solve();
  
	}

}