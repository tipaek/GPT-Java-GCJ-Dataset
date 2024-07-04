import java.util.*;
import java.lang.*;
import java.io.*;
class Pair{
    int start;
    int end;
    Pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}

/*class MySort implements Comparator<Pair>{
    public int compare(Pair a,Pair b){
        return a.end-b.end;
    }
}*/
class Solution
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    int count=1;
	    while(t!=0)
	    {
	        t--;
	        
	        int n=Integer.parseInt(br.readLine());
	        ArrayList<Pair> list=new ArrayList<>();
	        for(int i=0;i<n;i++){
	        String data[]=br.readLine().trim().split(" ");
	        
	           int start =Integer.parseInt(data[0]);
	           int end= Integer.parseInt(data[1]);
	           list.add(new Pair(start,end));
	        
	        }
	        Solution obj=new Solution();
	        obj.findOrder(list,n,count);
	        count++;
	        
	    
	     }
	     
	 }
	 public void findOrder(ArrayList<Pair> list,int n,int count){
	     //Collections.sort(list,new MySort());
	     StringBuffer br= new StringBuffer();
	     HashSet<Integer> s_c= new HashSet<>();
	     HashSet<Integer> s_j= new HashSet<>();
	     for(int i=0;i<n;i++){
	         Pair p=list.get(i);
	         int start=p.start;
	         int end=p.end;
	         if(isSlotAvailable(s_c,start,end)){
	             assignSlot(s_c,start,end);
	             br.append("C");
	         }
	         else if(isSlotAvailable(s_j,start,end)){
	             assignSlot(s_j,start,end);
	                br.append("J");
	         }else{
	             System.out.println("Case #"+count+" IMPOSSIBLE");
	             return;
	         }
	     }
	     System.out.println("Case #"+count+" "+br.toString().trim());
	 }
	 public boolean isSlotAvailable(HashSet<Integer> s,int start,int end){
	     for(int i=start+1;i<=end;i++){
	         if(s.contains(i))
	            return false;
	     }
	     return true;
	 }
	 public void assignSlot(HashSet<Integer> s,int start,int end){
	     for(int i=start;i<=end;i++)
	        s.add(i);
	 }
}