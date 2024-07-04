import java.util.*;
import java.io.*;
public class Solution {
    public static int fun(int p,int n,int a[][],int dp[][]){
        int m=0;
        if(p==0||n<0)
        return 0;
        if(dp[p][n]>0)
        return dp[p][n];
        m=Math.max(fun(p, n-1, a, dp), m);
        for(int i=0;i<a[n].length;i++){
            if(p-i-1>=0)
            m=Math.max(a[n][i]+fun(p-i-1, n-1, a, dp), m);
            else break;
        }
        return dp[p][n]=m;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int q=sc.nextInt();
        sc.nextLine();
        for(int p=1;p<=q;p++){
           int n=sc.nextInt();
           Integer a[][]=new Integer[n][3];
           for(int i=0;i<n;i++){
               a[i][0]=sc.nextInt();
               a[i][1]=sc.nextInt();
               a[i][2]=i;
           }
           Arrays.sort(a,column(0));
           int c=-1,j=-1,c1=0,c2=0;
           HashSet<Integer> h=new HashSet<>();
           char ans[]=new char[n];
           int f=0;
           for(int i=0;i<n;i++){
            if(c<=a[i][0]){
                c=a[i][1];
                ans[a[i][2]]='C';
            }
            else if(j<=a[i][0]){
                j=a[i][1];
                ans[a[i][2]]='J';
            }
            else{
                f=1;
                break;
            }
           }
           String s="";
           if(f==1){
               s="IMPOSSIBLE";
           }
           else{
               s=new String(ans);
           }
           System.out.println("Case #" + p + ": " + s);
        }

           
        
        //System.out.println("Case #" + t + ": " + p.remove().a);
        
    }
    public static Comparator<Integer[]> column(int i){
        return 
        new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                
                int result=o1[0].compareTo(o2[0]);
                if(result==0)
                result=o1[1].compareTo(o2[1]);
                return result;
            }
        };
    }
    public static Comparator<Pair> C(){
		return 
		new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
                if(o2.a.compareTo(o1.a)-0==0)
                return o2.in.compareTo(o1.in);
				return o2.a.compareTo(o1.a);//for descending
			}
		};
	}
}
class Pair{
    Integer a;
    Integer in;
    Pair(int a,int in){
        this.a=a;
        this.in=in;
    }
}

class SegmentTree{
	int s[],n;
	SegmentTree(int a[]){
		n=a.length;
		int l=(int)Math.ceil(Math.log(n)/Math.log(2));
		l=2*(int)Math.pow(2,l)-1;
		s=new int[l];
		createSegmentTreeUtil(a, 0, 0, a.length-1);
	}
	
	int createSegmentTreeUtil(int a[],int root,int l,int r){
		if(l==r)
		s[root]=a[l];
		else
		s[root]= Compare(createSegmentTreeUtil(a, 2*root+1, l, (l+r)/2), createSegmentTreeUtil(a,2*root+2, (l+r)/2+1,r));
		return s[root];
	}
	int getValue(int gl,int gr){
		return getValueUtil(0, 0, n-1, gl, gr);
	}
	int getValueUtil(int root,int l,int r,int gl,int gr){
		if(l>=gl&&r<=gr){
			return s[root];
		}
		if(l>gr||r<gl){
			return Integer.MAX_VALUE;
		}
		return Compare(getValueUtil(2*root+1, l, (l+r)/2, gl, gr), getValueUtil(2*root+2, (l+r)/2+1, r, gl, gr));
	}
	void update(int p,int k){
		updateUtil(p, k,0,0,n-1);
	}
	int updateUtil(int p,int k,int root,int l,int r){
		if(l==r&&l==k){
			return s[root]=p;
		}
		else if(l>k||r<k)
		return s[root];
		else{
			return s[root]=Compare(updateUtil(p, k, 2*root+1, l, (l+r)/2), updateUtil(p, k, 2*root+2,(l+r)/2+1,r ));
		}
	}
	int Compare(int a,int b){
		return Math.min(a, b);
	}
}