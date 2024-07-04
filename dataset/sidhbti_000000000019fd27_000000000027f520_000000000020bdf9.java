import java.util.*;
import java.io.*;
public class Solution {
    
    
    static class Pair implements Comparable<Pair>
	{ 
		int x; 
		int y;
		int z;
		public Pair(int x, int y,int z) 
		{	 
			this.x = x; 
			this.y = y;
			this.z = z;
		}
		public int compareTo(Pair p){
		    if(this.y>p.y)return 1;
		    if(this.y<p.y)return -1;
		    if(this.x>p.x)return 1;
		    return -1;
		}
	}
    
    	public static void find(ArrayList<Pair>ar,char ch[],char p,HashSet<Integer>set){
	    int i=0,j=0;
	    if(ar.size()>0){
	        set.add(ar.get(i).z);
    	    ch[ar.get(i).z]=p;
    	    for(j=1;j<ar.size();j++){
    	        if(ar.get(j).y>=ar.get(i).x){
    	            set.add(ar.get(j).z);
    	            ch[ar.get(j).z]=p;
    	            i=j;
    	        }
    	    }
	    }
	}
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int l= 1; l <= t; ++l) {
      
	        StringBuffer sb=new StringBuffer();
	        int n=in.nextInt();
	        ArrayList<Pair>al=new ArrayList<>();
	       
	        char[]ch=new char[n];
	        
	        for(int i=0;i<n;i++){
	            int a=in.nextInt();
	            int b=in.nextInt();
	            al.add(new Pair(b,a,i));
	        }
	        
	        Collections.sort(al);
	        int c=0,j=0,tr=1;
	        for(int i=0;i<al.size();i++){
	            if(al.get(i).y>=c){
	                c=al.get(i).x;
	                ch[al.get(i).z]='C';
	            }else if(al.get(i).y>=j){
	                j=al.get(i).x;
	                ch[al.get(i).z]='J';
	            }else{
	                tr=-1;break;
	            }
	        }
	        
	        if(tr==1){
	            for(int i=0;i<n;i++){
	                sb.append(ch[i]);
	            }
	            System.out.println("Case #"+l+": "+sb);
	        }else{
	            System.out.println("Case #"+l+": IMPOSSIBLE");
	        }
	       
	    }
	} 

	      
	    
    }
  