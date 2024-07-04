import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int n=sc.nextInt();
            Map<Integer,Integer> s1=new HashMap<>();
            int cs=0,ce=0,js=0,je=0;
            
            String sol="";
            for(int i=0;i<n;i++){ s1.put(sc.nextInt(),sc.nextInt());}
            TreeMap<Integer,Integer> s=new TreeMap<>(s1);
            
            
            for(Map.Entry<Integer,Integer> entry: s.entrySet())
            {
                if(ce<=entry.getKey() || cs>=entry.getValue())
                {
                    sol+="C";
                    cs=entry.getKey();ce=entry.getValue();
                }
                
                
                else if(je<=entry.getKey() || js>=entry.getValue())
                {
                    sol+="J";
                    js=entry.getKey();je=entry.getValue();
                }
                
                
            }
            if(sol.length()==n) System.out.println("Case #"+t+": "+sol);
            else System.out.println("Case #"+t+": "+"IMPOSSIBLE");
        }
    }
}