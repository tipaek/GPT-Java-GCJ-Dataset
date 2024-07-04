import java.util.*;
class Solution{
    public static void main(String[] args){
        
    	Scanner sc=new Scanner(System.in);
    	int t=sc.nextInt();
        
        for(int p=0;p<t;p++) {
        	int k=0,r=0,c=0;
        	int n=sc.nextInt();
        	ArrayList<HashSet<Integer>> hr=new ArrayList<>();
	        for(int i=0;i<n;i++){
	        	HashSet<Integer> hc=new HashSet<Integer>();
	            for(int j=0;j<n;j++){
	                int l=sc.nextInt();
	            	if(i==j) {
	            		k+=l;
	            	}
	            	HashSet<Integer> tp;
	            	if(hr.size()>=(j+1)) {
	            		tp=hr.get(j);
	            		tp.add(l);
		            	hr.set(j,tp);
	            	}
	            	else {
	            		tp=new HashSet<Integer>();
	            		tp.add(l);
		            	hr.add(tp);
	            	}
	            	
	            	hc.add(l);
	            }
	            if(hc.size()!=n) {
	            	c++;
	            }
	        }
	        for(HashSet<Integer> h: hr) {
	        	if(h.size()!=n) {
	        		r++;
	        	}
	        }
	        System.out.println("Case #"+(p+1)+": "+k+" "+r+" "+c);
        }
    }
}