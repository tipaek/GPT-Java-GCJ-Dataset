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
		if(Math.min(a.end, b.end)<=Math.max(a.start, b.start)){ 
			return false;
		}
		return true;
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
            	for(int i=0;i<n;i++){
            		int st=s.nextInt();
            		int e=s.nextInt();
            		Interval in = new Interval(st, e);
            		if(map.get('C').isEmpty()){
            			map.get('C').add(in);
            			res.append('C');
            		}else if(map.get('J').isEmpty()){ 
            			map.get('J').add(in);
            			res.append('J');
            		}
            		else{
            			boolean x=true;
            			ArrayList<Interval> a=map.get('C');
            			for(int j=0;j<a.size();j++){
            				if(mergingInterval(a.get(j),in)){
            					x=false;
            					break;
            				}
            			}
            			if(x){
            				a.add(in);
            				res.append('C');
            			}else{
            				boolean y=true;
            				a=map.get('J');
            				for(int j=0;j<a.size();j++){
            					if(mergingInterval(a.get(j), in)){
            						y=false;
            						break;
            					}
            				}
            				if(y){
                				a.add(in);
                				res.append('J');
                			}else res=new StringBuilder("IMPOSSIBLE");
            			}
            		}
            	}
            	System.out.println("Case #"+z+": "+res.toString());
                z++;
                t--;
            }
            s.close();
        }catch(Exception e){
            
        }
    }

}