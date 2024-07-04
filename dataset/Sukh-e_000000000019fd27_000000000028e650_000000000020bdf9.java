import java.util.*;
public class Solution{
    static class Pair implements Comparable<Pair>{ 
		int x,y,z;
		public Pair(int x, int y,int z){	 
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
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int f=1;f<=t;f++){
	        StringBuilder sbr=new StringBuilder("");
	        int n=s.nextInt();
	        ArrayList<Pair> a=new ArrayList();
	        char[] ch=new char[n];
	        for(int i=0;i<n;i++){
	            int x=s.nextInt();
	            int y=s.nextInt();
	            a.add(new Pair(y,x,i));
	        }
	        Collections.sort(a);
	        int c=0,j=0;
	        int d=1;
	        for(int i=0;i<a.size();i++){
	            if(a.get(i).y>=c){
	                 c=a.get(i).x;
	                 ch[a.get(i).z]='C';
	            }
	            else if(a.get(i).y>=j){
	                j=a.get(i).x;
	                ch[a.get(i).z]='J';
	            }
	            else{
	                d=-1;break;
	            }
	        }
	        if(d==1){
	            for(int i=0;i<n;i++){
	                sbr.append(ch[i]);
	            }
	            System.out.println("Case #"+f+": "+sbr);
	        }
	        else{
	            System.out.println("Case #"+f+": IMPOSSIBLE");
	        }
        }
    }

}