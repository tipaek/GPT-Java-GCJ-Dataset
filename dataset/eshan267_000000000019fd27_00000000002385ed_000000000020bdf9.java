import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
class Solution
{
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
    public static void sw(int i,int []ar,int []br)
    {
       int temp = ar[i];
        ar[i] = ar[i+1];
        ar[i+1] = temp ;
        
        temp = br[i];
        br[i] = br[i+1];
        br[i+1] = temp ;
    }
    
    public static void main(String []args)
    {
       FastReader sc = new FastReader();
       StringBuilder ans = new StringBuilder("");
     int t = sc.nextInt();
     for(int i=1;i<=t;i++)
     {
       int n = sc.nextInt();
       int []ar = new int[n];
       int []br = new int[n];
       
 HashMap<String,ArrayList<Integer>> hm = new HashMap<>();
      int kh =0;
       for(int j=0;j<n;j++)
       {
           
       ar[j]=sc.nextInt();
       br[j]=sc.nextInt();
       ArrayList<Integer> al = hm.get(ar[j]+" "+br[j]);
     
       if(al==null)
       {
    	   al =new ArrayList<Integer>();
    	   hm.put(ar[j]+" "+br[j],al);
       }
    	   al.add(j);
    	   if(al.size()>=3)
    		   kh=1;
       
       }
       
       if(kh!=1) {
       for(int k=0;k<n;k++)
       {
           for(int j=0;j<n-1;j++)
           {
              if(ar[j]>ar[j+1])
              sw(j,ar,br);
           }
        }
        
     String []ae = new String[n]  ; 
  StringBuilder se = new StringBuilder("");
    
       int cd = br[0];
       int jd = -1;
       int r=1;
       ArrayList<Integer> al = hm.get(ar[0]+" "+br[0]) ;
       if(al.size()==1)
           ae[al.get(0)]= "C" ;
       else
       {
    	   ae[al.get(0)]= "C" ;
    	   ae[al.get(1)] ="J";
    	   jd = cd ;
    	   r++ ;
       }
        
        int fg =1;
       for(int j=r;j<n;j++)
       {
          if(ar[j]>=cd)
          {
              cd = br[j];
             al = hm.get(ar[j]+" "+br[j]) ;
             if(al.size()==1)
                 ae[al.get(0)]= "C" ;
             else
             {
          	   ae[al.get(0)]= "C" ;
          	   if(ar[j]>=jd) {
          	   ae[al.get(1)] ="J";
          	   jd = cd ;
          	   j++ ;
          	   }
          	   else {
          		 fg=0;
          		 break ;
             }
             }
              
          }
          else if(ar[j]>=jd)
          {
           jd = br[j];
           al = hm.get(ar[j]+" "+br[j]) ;
           if(al.size()==1)
              ae[al.get(0)]= "J" ;
           else
           {
        		 fg=0;
        		 break ;
           }
          }
          else
          {
            fg =0;
             break ;
          }
       }
       
       if(fg!=0){
           for(int e=0;e<n;e++)
           se.append(ae[e]);
           }
       else
    	se = new StringBuilder("IMPOSSIBLE");  
       
       ans.append("case #"+(i)+": "+se+"\n");
       }
       
       if(kh==1)
   ans.append("case #"+(i)+": IMPOSSBLE"+"\n");
       
      
       
 
       
       
     }
     System.out.print(ans);
        
    }
}
