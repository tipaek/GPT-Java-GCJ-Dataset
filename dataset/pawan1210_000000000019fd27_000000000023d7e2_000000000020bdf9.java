/*package whatever //do not write package name here */

import java.util.*;
class pair{
    int time;
    int index;
    char c;
    pair(int time,int index){
       this.time=time;
       this.index=index;
    }
}
public class Solution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int tt=1;tt<=t;tt++){
		    int n=s.nextInt();
		    ArrayList<pair>list=new ArrayList<>();
		    for(int i=0;i<n;i++){
		        int start=s.nextInt();
		        int end=s.nextInt();
		        list.add(new pair(start,i+1));
		        list.add(new pair(end,-1*(i+1)));
		    }
		    Collections.sort(list,new Comparator<pair>(){
		        public int compare(pair p1,pair p2){
		            if(p1.time==p2.time){
		                if(p1.index<0){
		                    return -1;
		                }
		                else{
		                    return 1;
		                }
		            }
		            return p1.time-p2.time;
		        }
		    });       
		    
		    HashMap<Integer,String>map=new HashMap<>();
		    boolean flag=true;
		    int c=0;
		    int j=0;
		    for(int i=0;i<list.size();i++){
		        if(list.get(i).index>0){
		            if(c==0){
		                map.put(list.get(i).index,"C");
		                c=list.get(i).index;
		            }
		            else if(j==0){
		                 map.put(list.get(i).index,"J");
		                j=list.get(i).index;
		            }
		            else{
		                flag=false;
		                break;
		            }
		        }
		        else{
		            if(j==-1*(list.get(i).index)){
		                j=0;
		            }
		            else{
		                c=0;
		            }
		        }
		    }
		    if(!flag){
		        System.out.println("Case #"+tt+": "+"IMPOSSIBLE");
		    }
		    else{
		        System.out.print("Case #"+tt+": ");
		        for(int i=1;i<=n;i++){
		            System.out.print(map.get(i));
		        }
		        System.out.println();
		    }
		}
	}
}