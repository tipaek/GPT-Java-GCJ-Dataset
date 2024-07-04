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

class MySort implements Comparator<Pair>{
    public int compare(Pair a,Pair b){
        return a.end-b.end;
    }
}
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
	     Collections.sort(list,new MySort());
	     StringBuffer br= new StringBuffer();
	     HashMap<Integer,Character> hmap= new HashMap<>();
	     for(int i=0;i<n;i++){
	         Pair p=list.get(i);
	         int start=p.start;
	         int end=p.end;
	         if(isSlotAvailable(hmap,start,end,'C')){
	             assignSlot(hmap,start,end,'C');
	             br.append("C");
	         }
	         else if(isSlotAvailable(hmap,start,end,'J')){
	             assignSlot(hmap,start,end,'J');
	                br.append("J");
	         }else{
	             System.out.println("Case #"+count+" IMPOSSIBLE");
	             return;
	         }
	     }
	     System.out.println("Case #"+count+" "+br.toString().trim());
	 }
	 public boolean isSlotAvailable(HashMap<Integer,Character> hmap,int start,int end,char c){
	     for(int i=start+1;i<=end;i++){
	         if(hmap.containsKey(i)&&hmap.get(i)==c)
	            return false;
	     }
	     return true;
	 }
	 public void assignSlot(HashMap<Integer,Character> hmap,int start,int end,char c){
	     for(int i=start;i<=end;i++)
	        hmap.put(i,c);
	 }
}