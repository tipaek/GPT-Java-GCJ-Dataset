import java.util.*;
public class Solution{

     public static void main(String []args){
         
         Scanner s = new Scanner(System.in);
         int t,n,trace,index;
          t= s.nextInt();
        int temp  =t;
        HashMap<Integer,ArrayList<Integer>> map;
        ArrayList<Integer> arr ;
        while(t-->0)
         {
             map = new HashMap<>();
             index = -1;
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
             
             for(int i =0;i<n;i++)
             {
                 int sum = 0;
                 for(int j =0;j<n;j++)
                 {
                     arr = map.get(((i+j)%(n)));
                     sum+=arr.get(j)+1;
                 }
                 if(sum == trace)
                 {
                     index = i;
                     break;
                 }
             }
             if(index == -1)
             {
                 System.out.println("Case #" + (temp-t) + ": IMPOSSIBLE");
                 continue;
             }
                 System.out.println("Case #" + (temp-t) + ": POSSIBLE");
        
            for(int i = 0 ;i<n;i++)
                {
                    arr = map.get((index+i)%(n));
                    for(int j = 0;j<arr.size();j++)
                        {
                            System.out.print(arr.get(j)+1 + " ");
                        }
                       System.out.println();
                }
         }
     }
}