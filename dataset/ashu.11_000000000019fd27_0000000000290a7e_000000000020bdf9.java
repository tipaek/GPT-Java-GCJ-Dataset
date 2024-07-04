import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	
	public static class Interval{
		int start;
		int end;
		Interval(int s, int e){
			start=s;
			end=e;
		}
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
	}
	
	public static boolean mergingInterval(Interval a, Interval b){
		if(Math.min(a.end, b.end)>Math.max(a.start, b.start)){ 
			return true;
		}
		return false;
	}

    public static void main(String[] args){
        try{
            Scanner s = new Scanner(System.in);
            int t=s.nextInt();
            int z=1;
            while(t>0){
            	int n=s.nextInt();
            	StringBuilder res = new StringBuilder();
            	HashMap<Character,ArrayList<Interval>> map = new HashMap<>();
            	map.put('C', new ArrayList<>());
            	map.put('J', new ArrayList<>());
            	boolean poss=true;
            	for(int i=0;i<n;i++){
            		int st=s.nextInt();
            		int e=s.nextInt();
            		Interval in = new Interval(st, e);
        			ArrayList<Interval> b=map.get('C');
        			boolean x=true;
        			if(poss){
	        			for(int j=0;j<b.size();j++){
	        				if(mergingInterval(b.get(j),in)){
	        					x=false;
	        					break;
	        				}
	        			}
	        			if(x){
	        				b.add(in);
	        				map.put('C', b);
	        				res.append('C');
	        			}else{
	        				boolean y=true;
	        				ArrayList<Interval> a=map.get('J');
	        				for(int j=0;j<a.size();j++){
	        					if(mergingInterval(a.get(j), in)){
	        						y=false;
	        						break;
	        					}
	        				}
	        				if(y){
	            				a.add(in);
	            				map.put('J', a);
	            				res.append('J');
	            			}else{ 
	            				poss=false;
	            			}
	        			}
        			}
        		}
            	if(!poss) res = new StringBuilder("IMPOSSIBLE");	
            	System.out.println("Case #"+z+": "+res.toString());
                z++;
                t--;
            }
            s.close();
        }catch(Exception e){
            
        }
    }

}