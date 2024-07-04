import java.util.*;
public class Solution {
    static class pair
	{ 
		int x; 
		int y;
		int z;
		public pair(int x, int y,int z) 
		{	 
			this.x = x; 
			this.y = y;
			this.z = z;
		}
	}
    public static void main(String args[]) {
     Scanner sc=new Scanner(System.in);
     int T=sc.nextInt();
     for(int t=1;t<=T;t++){
       StringBuilder sb=new StringBuilder("");
       int n=sc.nextInt();
       ArrayList<pair> ar=new ArrayList<>();
       char a[]=new char[n];
       for(int i=0;i<n;i++){
           int st=sc.nextInt();
	            int fn=sc.nextInt();
	            ar.add(new pair(fn,st,i));
       }
       Collections.sort(ar,new Comparator<pair>(){
           @Override public int compare(pair p1,pair p2){
            if(p1.y>p2.y)return 1;
		    if(p1.y<p2.y)return -1;
		    if(p1.x>p1.x)return 1;
		    return -1;
           }}
           );
           int c=0,j=0,b=1;
           for(int i=0;i<ar.size();i++){
	            if(ar.get(i).y>=c){
	                c=ar.get(i).x;
	                a[ar.get(i).z]='C';
	            }else if(ar.get(i).y>=j){
	                j=ar.get(i).x;
	                a[ar.get(i).z]='J';
	            }else{
	                b=-1;
	                break;
	            }
	        }
	        if(b==1){
	            for(int k=0;k<n;k++){
	                sb.append(a[k]);
	            }
	            System.out.println("Case #"+t+": "+sb);
	        }
	        else{
	            System.out.println("Case #"+t+": IMPOSSIBLE");
	        }
     }
    }
}