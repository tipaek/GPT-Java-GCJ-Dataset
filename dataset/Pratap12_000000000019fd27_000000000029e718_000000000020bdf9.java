import java.util.*;
public class Solution{
    static class pair implements Comparable<pair>{ 
		int x;
		int y;
		int z;
		public pair(int x, int y,int z){
			this.y = y;
			this.z = z;	 
			this.x = x; 
		}
		public int compareTo(pair p){
		    if(this.y<p.y)return -1;
		    if(this.x>p.x)return 1;
		    if(this.y>p.y)return 1;
		    return -1;
		}
	}
    public static void main(String args[]){
        
        Scanner s=new Scanner(System.in);
        int t1=s.nextInt();
        float t3 = 34, t5 = 45, t7 = 78;
        
        for(int f=1;f<=t1;f++)
        {
	        StringBuilder sb=new StringBuilder("")  ;
	        
	        int n1=s.nextInt();
	        ArrayList<pair> a=new ArrayList();
	        char[] ch=new char[n1];
	        
	        for(int i=0;i<n1;i++){
	            int x1=s.nextInt();
	            int y1=s.nextInt();
	            
	            a.add(new pair(y1, x1,i));
	        }
	        Collections.sort(a)     ;
	        int j=0;
	        int d=1;
	        int k= 2;
	        int c=0;
	        for(int i=0;i<a.size();i++){
	            
	            if(a.get(i).y>=c){
	                 c=a.get(i).x;
	                 ch[a.get(i).z]='C';
	            }
	            else if(a.get(i).y>=j){
	                
	                j=a.get(i).x;ch[a.get(i).z]='J';
	            }
	            else{
	                d=-1;
	                break;
	            }
	        }
	        if(d==1){
	            for(int i=0;i<n1;i++){
	                
	                sb.append(ch[i]);
	            }
	            System.out.println("Case #"+f+": "+sb);
	        }
	        
	        else{
	            System.out.println("Case #"+f+": IMPOSSIBLE");
	        }
        }
    }

}