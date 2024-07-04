import java.util.*;
class Interval{
    int start,end;
    Interval(){
        start=0;
        end=0;
    }
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tests=sc.nextInt();
        for(int t=1;t<=tests;t++){
            int n=sc.nextInt();
            Interval arr[]=new Interval[n];
            Interval arr1[]=new Interval[n];
            
            for(int i=0;i<n;i++){
                int st=sc.nextInt();
                int ed=sc.nextInt();
                arr[i]=new Interval(st,ed);
                arr1[i]=new Interval(st,ed);
            }
            
            int dp[]=new int[24*60+1];
            int max=0;
            for(int i=0;i<n;i++){
                for(int j=arr[i].start;j<arr[i].end;j++){
                    dp[j]++;
                    max=Math.max(dp[j],max);
                }
            }
            if(max>2){
                System.out.println("Case #"+t+": IMPOSSIBLE");
                continue;
            }
            Arrays.fill(dp,0);
            Arrays.sort(arr, new Comparator<Interval>(){
                public int compare(Interval a,Interval b){
                    return a.start-b.start;
                }
            });
            
            Map<String,Queue<Character>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                int value=0;
                for(int j=arr[i].start;j<arr[i].end;j++){
                    if(dp[j]!=0){
                        value=dp[j];
                        break;
                    }
                }
                if(value!=0){
                    if((char)value=='J'){
                        for(int j=arr[i].start;j<arr[i].end;j++){
                            dp[j]='C';
                        }
                        String s=arr[i].start+" "+arr[i].end;
                        if(!map.containsKey(s)){
                            Queue<Character> queue=new LinkedList<>();
                            queue.add('C');
                            map.put(s,queue);
                        }else{
                            Queue<Character> queue=map.get(s);
                            queue.add('C');
                            map.put(s,queue);
                        }
                    }else{
                        for(int j=arr[i].start;j<arr[i].end;j++){
                            dp[j]='J';
                        }
                        String s=arr[i].start+" "+arr[i].end;
                        if(!map.containsKey(s)){
                            Queue<Character> queue=new LinkedList<>();
                            queue.add('J');
                            map.put(s,queue);
                        }else{
                            Queue<Character> queue=map.get(s);
                            queue.add('J');
                            map.put(s,queue);
                        }
                        
                    }
                }else{
                    for(int j=arr[i].start;j<arr[i].end;j++){
                            dp[j]='C';
                        }
                        String s=arr[i].start+" "+arr[i].end;
                        if(!map.containsKey(s)){
                            Queue<Character> queue=new LinkedList<>();
                            queue.add('C');
                            map.put(s,queue);
                        }else{
                            Queue<Character> queue=map.get(s);
                            queue.add('C');
                            map.put(s,queue);
                        }
                }
            }
        
           String ans="";
           
            for(int i=0;i<n;i++){
                String s=arr1[i].start+" "+arr1[i].end;
                ans+=Character.toString(map.get(s).peek());
                map.get(s).remove();
            }
            System.out.println("Case #"+t+": "+ans);
            
        }
    }
}
