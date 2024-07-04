import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=1;
        while(k<=t){
            int n=sc.nextInt();
            HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
            int r=0,c=0,trace=0;
            Set<Integer>rowset=new HashSet<>();
            Set<Integer>colset=new HashSet<>();
            for(int i=0;i<n;i++){
                Set<Integer>set=new HashSet<>();
                for(int j=0;j<n;j++){
                    int x=sc.nextInt();
                    if(set.contains(x)){
                        rowset.add(i);
                    }
                    set.add(x);
                    if(map.containsKey(j)){
                        Set <Integer> cset=map.get(j);
                        if(cset.contains(x)){
                            colset.add(j);
                        }else{
                            colset.add(j);
                        }
                    }else{
                        Set <Integer> cset=new HashSet<>();
                        cset.add(x);
                    }
                    
                    if(i==j){
                        t=t+x;
                    }
                    
                }
            }
            System.out.println("Case #"+k+": "+trace+" "+rc+" "+cc);
            k++;
        }
    }
}