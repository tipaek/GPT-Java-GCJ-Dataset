import java.lang.*;
import java.util.*;
import java.io.*;
class vestigium{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    int x=0;
    
    int ro=0;
    int co=0;
    int sum=0;

    void check(int ar[][],int n,int tc){
        Boolean roi[]=new Boolean[n];
        Boolean coi[]=new Boolean[n];
        for(int i=0;i<n;i++){
            roi[i]=false;
            coi[i]=false;
        }
        int left=-1,right=-1,top=-1,down=-1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                       x=ar[i][j];
                       left=j-1;
                       right=j+1;
                       top=i-1;
                       down=i+1;
                       for(int k=left;k>=0;k--){
                           if(ar[i][left]==x&&!roi[i]){
                               roi[i]=true;
                               ro++;
                               break;
                           }
                       } 
                       for(int k=right;k<n;k++){
                           if(ar[i][k]==x&&!roi[i]){
                               ro++;
                               roi[i]=true;


                               break;
                           }
                       }
                       for(int k=top;k>=0;k--){
                            if(ar[k][j]==x&&!coi[j]){
                                co++;
                                coi[j]=true;

                                break;
                            }

                        } 
                        for(int k=down;k<n;k++){
                            if(ar[k][j]==x&&!coi[j]){
                                coi[j]=true;
                                co++;

                                break;
                            }

                        }
                        if(i==j){
                            sum=sum+ar[i][j];
                        }
                            
                  }
                  
            }
            System.out.println("Case #"+tc+":"+sum+" "+ro+" "+co);

    }





    public static void main(String[] args){
        FastReader sc=new FastReader(); 
        int tc=sc.nextInt();
        vestigium v=new vestigium();
        for(int t=0;t<tc;t++){
            int n=sc.nextInt();
            int ar[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ar[i][j]=sc.nextInt();
                }
            }
            v.check(ar,n,tc);
        }
    }
}