import java.util.*;

class Solution{
    
    static class pair implements Comparable<pair>{
        int start;
        int end;
        int index;
        
        pair(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        public int compareTo(pair p){
            if(p.start==this.start){
                return this.end-p.end;
            }
            return this.start-p.start;
        }
        
    }
    
    public static void main(String[] srgs){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int c=1;c<=t;c++){
            int n = input.nextInt();
            pair[] parr = new pair[n];
            char[] arr = new char[n];
            for(int i=0;i<n;i++){
                parr[i] = new pair(input.nextInt(), input.nextInt(), i);
            }
            Arrays.sort(parr);
            int a = 0;
            int b = 0;
            boolean isAns = true;
            for(int i=0;i<n;i++){
                if(parr[i].start<a && parr[i].start<b){
                    isAns = false;
                    break;
                }
                else if(parr[i].start<a){
                    arr[parr[i].index] = 'J';
                    b = parr[i].end;
                }
                else{
                    arr[parr[i].index] = 'C';
                    a = parr[i].end;
                }
            }
            if(!isAns){
                System.out.println("Case #"+c+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+c+": "+new String(arr));
            }
            
        }
    }
    
}