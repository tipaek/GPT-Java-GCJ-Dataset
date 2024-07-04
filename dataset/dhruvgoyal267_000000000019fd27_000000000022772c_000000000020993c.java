import java.util.*;
public class Solution{
    
    static int matrix[][],n;
    
    static HashMap<String,Boolean> check; 
    
    static HashMap<String,ArrayList<Integer>> map;
     public static void main(String []args){
        int t,tr,freq,r,c,temp;
        
        
        
        Scanner s = new Scanner(System.in);
         t= s.nextInt();
         temp = t;
         while(t-->0)
         {
             check = new HashMap();
             map = new HashMap();
             r = c = 0;
             n = s.nextInt();
             matrix = new int[n][n];
             for(int i=0;i<n;i++)
             {
                 for(int j =0;j<n;j++) 
                    matrix[i][j] = s.nextInt();
             }
             
             tr = trace();
              ArrayList<Integer> arr = new ArrayList();
             for(int i=0;i<n;i++)
             {
                 for(int j=0;j<n;j++)
                 {
                    if(!check.get("R" + i))
                     {
                        arr = map.get("R"+i);
                     freq = Collections.frequency(arr,matrix[i][j]);
                     if(freq>1)
                         {   
                             r++;
                            check.put("R" + i,true);
                         }
                     }
                    if(!check.get("C" + j))
                     {
                        arr = map.get("C"+j);
                        freq = Collections.frequency(arr,matrix[i][j]);
                        if(freq>1)
                        {
                            c++;
                            check.put("C" + j,true);
                        }
                     }
                 }
             }
             
             
             System.out.println("Case #" + (temp-t) + ": " + tr +" " + r +" " + c);
         }
     }
     
     static int trace()
     {
         int trace =0;
         ArrayList<Integer> arr;
    ArrayList<Integer> arr2;
         for(int i=0;i<n;i++)
         {
             arr = new ArrayList<Integer>();
             for(int j=0;j<n;j++)
             {
                 
                 check.put("R" + i,false);
                 check.put("C" + j,false);
                    if(i == j)
                        trace+= matrix[i][j];
                    arr.add(matrix[i][j]);
                    
                    if(map.get("C"+j) == null)
                        arr2 = new ArrayList<Integer>();
                    else
                        arr2 = map.get("C"+j);
                    arr2.add(matrix[i][j]);
                    map.put("C"+j,arr2);
             }
            map.put("R"+i,arr);
         }
         return trace;
     }
}