import java.util.*;

class Solution
{
    
    /*
    1. create 2d array (x,y,index),chararry
    2. sort by y
    3. evaluated,for each index,put its chararray[index]=c/j
    4. print char array /IMPOSSIBLE
    */
    
    public static void main(String args[]){
        
        Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        
        for(int z=1;z<=t;z++){
            int n=in.nextInt();
            boolean flag=false;
            char[] ch=new char[n];
        
            int c_free=0,j_free=0;
            
            int ar[][]=new int[n][3];
            for(int i=0;i<n;i++){
              
                ar[i][0]=in.nextInt();
                ar[i][1]=in.nextInt();
                 ar[i][2]=i;
            }
            
          Arrays.sort(ar, new Comparator<int[]>() { 
        
          @Override              
          public int compare(final int[] q,  
                             final int[] w) { 
            if(q[1]==w[1])return q[0]-w[0];
            return q[1]-w[1];
          } 
        });
            
            for(int i=0;i<n;i++){
             int x=ar[i][0];
             int y=ar[i][1];
             
             if(c_free<=x){
                 ch[ar[i][2]]='C';
                 c_free=y;
             }
            else if(j_free<=x){
                ch[ar[i][2]]='J';
                j_free=y;
            }    
            else {
                flag=true;
            }
            }
            
        
            if(flag)
            System.out.printf("Case #%d: IMPOSSIBLE\n",z);
            else
             System.out.printf("Case #%d: %s\n",z,new String(ch));
            
        }
        
    }
    
    
    
}