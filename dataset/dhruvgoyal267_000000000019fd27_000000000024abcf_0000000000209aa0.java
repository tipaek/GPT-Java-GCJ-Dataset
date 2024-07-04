import java.util.*;
public class Solution{
        static HashMap<Integer,ArrayList<Integer>> map;
        static int n,trace,temp2[];
     public static void main(String []args){
         
         Scanner s = new Scanner(System.in);
         int t,index;
          t= s.nextInt();
        int temp  =t;
        ArrayList<Integer> arr ;
        while(t-->0)
         {
             map = new HashMap<>();
             n = s.nextInt();
             trace = s.nextInt();
             
             for(int i=0;i<n;i++)
             {
                 arr = new ArrayList();
                 for(int j = 0;j<n;j++)
                 {
                        arr.add(((i+j)%(n)));       
                 }
                 map.put(i,arr);
             }
             
             temp2 = new int[n];
             for(int i =0;i<n;i++)
                temp2[i] = i;
             
             index = checkSum(0);
             
             if(index == -1)
             {
                 System.out.println("Case #" + (temp-t) + ": IMPOSSIBLE");
                 continue;
             }
                 System.out.println("Case #" + (temp-t) + ": POSSIBLE");
        
                    for(int j = 0;j<n;j++)
                        {
                            arr = map.get(temp2[j]);
                        for(int i =0;i<arr.size();i++)
                        {
                            System.out.print(arr.get(i)+1 + " ");
                        }
                        System.out.println();
                       }
                       
         }
     }
     
     
     static int checkSum(int k)
     {
             if (k == n) 
        {
            ArrayList<Integer> arr = new ArrayList();
            int sum = 0;
            for (int i = 0; i < n; i++) 
            {
                arr = map.get(temp2[i]);
                sum+=arr.get(i)+1;
            }
        
            if(sum == trace)
                return 1;
        } 
        else 
        {
            for (int i = k; i <n; i++) 
            {
                int temp = temp2[k];
                temp2[k] = temp2[i];
                temp2[i] = temp;
 
                if( checkSum(k + 1) == 1)
                    return 1;
                temp = temp2[k];
                temp2[k] = temp2[i];
                temp2[i] = temp;
            }
        }
        return -1;
     }
}