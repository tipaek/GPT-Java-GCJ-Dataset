import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int jj,i,j,k;
         int T=sc.nextInt();
	     jj=1;
	    while(T-->0){
	        int R=sc.nextInt();
	        int C=sc.nextInt();
	        int arr[][]=new int[R][C];
	        long sum=0;
	        for( i=0;i<R;i++)
	        {
	            for(j=0;j<C;j++)
	            {
	                arr[i][j]=sc.nextInt();
	                sum+=arr[i][j];
	            }
	        }
	        int vis[][]=new int[R][C];
            while(true){
                boolean flag=false;;
                ArrayList<Pair>x=new ArrayList();
                ArrayList<Pair>y=new ArrayList();
                ArrayList<Pair>z=new ArrayList();
    	        for(i=0;i<R;i++){
    	            for(j=0;j<C;j++){
    	                if(vis[i][j]==0){
    	                double st=0,ct=0;
    	                int p=-1,q=-1,r=-1,s=-1;
    	                for( k=i+1;k<R;k++){
    	                    if(vis[k][j]==0){
    	                        ct++;
    	                        p=k;
    	                        st+=arr[k][j];break;
    	                    }
    	                }
    	                for(k=i-1;k>=0;k--){
    	                    if(vis[k][j]==0){
    	                        ct++;
    	                        q=k;
    	                        st+=arr[k][j];break;
    	                    }
    	                }
    	                for(k=j+1;k<C;k++){
    	                    if(vis[i][k]==0){
    	                        ct++;
    	                        r=k;
    	                        st+=arr[i][k];break;
    	                    }
    	                }
    	                for(k=j-1;k>=0;k--){
    	                    if(vis[i][k]==0){
    	                        s=k;
    	                        ct++;
    	                        st+=arr[i][k];break;
    	                    }
    	                }
    	                if(st/ct>arr[i][j]){
    	                    //System.out.println(i+" "+j+" "+st/ct);
    	                    if(p!=-1 && p<R)
    	                    x.add(new Pair(p,j));
    	                    if(q!=-1 && q<R)
    	                    x.add(new Pair(q,j));
    	                    if(r!=-1 && r<C)
    	                    y.add(new Pair(i,r));
    	                    if(s!=-1 && s<C)
    	                    y.add(new Pair(i,s));
    	                    flag=true;
    	                    z.add(new Pair(i,j));
    	                }
    	            }
    	            }
    	        }
    	        if(!flag)break;
    	        
    	        for(Pair ii:z){
    	            vis[ii.x][ii.y]=1;
    	            arr[ii.x][ii.y]=0;
    	            
    	        }
    	        for(i=0;i<R;i++){
    	            for(j=0;j<C;j++){
    	                if(vis[i][j]==0){
    	                    sum+=arr[i][j];
    	                }
    	                //System.out.print(a[i][j]+" ");
    	            }
    	            //System.out.println();
    	        }
    	        
	        }
	        System.out.println("Case #"+jj+": "+sum);
	        jj++;
	    }
    }
}
  class Pair
	{ 
		int x; 
		int y;
		public Pair(int x, int y) 
		{	 
			this.x = x; 
			this.y = y; 
		}	 
	} 