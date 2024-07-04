import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws Exception
    {
        Myscanner ms=new Myscanner();
        PrintWriter out=new PrintWriter(System.out);
        int t=ms.nextInt();
        int k=1;
        while(t>0)
        {
            int n=ms.nextInt();
            long arr[][]=new long[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=ms.nextLong();
                }
            }
             long[] tracedArray=trace(arr);
             out.println("Case #"+k+": "+tracedArray[0]+" "+tracedArray[1]+" "+tracedArray[2]);
        k++;
        t--;
        out.flush();
            
        }
    }
    static class Myscanner{
        private BufferedReader br;
        private StringTokenizer tr;
        
        public Myscanner()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        
        public String next()
        {
            try{
                while(tr==null||!tr.hasMoreTokens())
                {
                    tr=new StringTokenizer(br.readLine());
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return tr.nextToken();
        }
        
        public int nextInt(){
            return Integer.parseInt(next());
        }
         public long nextLong(){
            return Long.parseLong(next());
        }
    }
    static long[] trace(long[][] arr)
    {
        int n=arr.length;
       // int rerow=0;
        //int recol=0;
		int count=0;
		int count1=0;
        long[] ab=new long[3];
     for(int i=0;i<n;i++)
     {
		 int j=0;
		 boolean falg=false;
		 for(j=0;j<n;j++)
		 {
			for(int k=j+1;k<n;k++){
				if(arr[i][j]==arr[i][k])
				{
					
                    falg=true;					
					break;
			    }
			}
			if(falg)
			{   
		count++;
				break;
			
	 }
	 }
	 }
	  for(int i=0;i<n;i++)
     {
		 int j=0;
		 boolean falg=false;
		 for(j=0;j<n;j++)
		 {
			for(int k=j+1;k<n;k++){
				if(arr[j][i]==arr[k][i])
				{
					
                    falg=true;					
					break;
			    }
			}
			if(falg)
			{   
		count1++;
				break;
			
	 }
	 }
	 }
     if((count==0)&&(count1==0))
     {
        ab[0]=diagonalsum(arr,n);
        ab[1]=count;
        ab[2]=count1;
     }
     else
     {
        ab[0]=diagonalsum(arr,n);
        ab[1]=count;
        ab[2]=count1;
     }
	 return ab;
    }

    static long diagonalsum(long[][] arr,int n)
    {
        long sum=0;
        for(int i=0;i<n;i++)
        {
           sum+=arr[i][i];
        }
        return sum;
    }
}

