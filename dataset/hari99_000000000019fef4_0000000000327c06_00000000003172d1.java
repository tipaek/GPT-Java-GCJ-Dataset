import java.util.*;
public class Solution{
    public static void main(String args){
        Scanner sc=new Scanner(System.in);
        int tst=sc.nextInt();
        for(int t=1;t<=tst;t++){
            int n=sc.nextInt();
            int d=sc.nextInt();
            if(n==1){
            System.out.println("Case #"+t+": "+(d-1));
            continue;
            }
            long arr[]=new long[n];
            Map<Long,Integer> map=new HashMap<>();
            boolean mod3=false;
            boolean mod2=false;
            boolean mod2con=false;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
                if(arr[i]%2==0)
                mod2=true;
                if(arr[i]%3==0)
                mod3=true;
                if(map.containsKey(arr[i]%2)||map.containsKey(arr[i]*2))
                mod2con=true;
                
                if(!map.containsKey(arr[i])){
                    map.put(arr[i],1);
                }else{
                    map.put(arr[i],map.get(arr[i])+1);
                }
            }
            int max=0;
            for(Map.Entry<Long,Integer> entry:map.entrySet()){
             if(entry.getValue()>max){
                 max=entry.getValue();
             }   
            }
            if(max>=d){
                System.out.println("Case #"+t+": 0");
            }else if(d==2){
                System.out.println("Case #"+t+": 1");
            }else if(d==3){
                if(mod2con==true)
                System.out.println("Case #"+t+": 1");
                else
                System.out.println("Case #"+t+": 2");
            }else{
                System.out.println("Case #"+t+": 1");
            }
        }
    }
}