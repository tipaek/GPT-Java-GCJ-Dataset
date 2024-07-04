import java.util.*;

public class Solution{
    
    static void compare(Task arr[], int N){
        Arrays.sort(arr, new Comparator<Task>(){
           @Override
           public int compare(Task t1, Task t2){
               return t1.end - t2.end;
           }
        });
        Task newArray[] = new Task[N];
        for(int i=0;i<N;i++){
            newArray[i] = new Task(arr[i].start, arr[i].end,arr[i].index);
        }
    }
    
    static String assignTask(Task arr[], int N){
        String ans;
        for(int i=0;i<N;i++){
            if(i+1 < N && arr[i].end > arr[i+1].end && arr[i].start < arr[i+1].start){
                ans = "IMPOSSIBLE";
                return ans;
            }
        }
        
        compare(arr,N);
        ans = "J";
        int i = 0;
        for(int j=1;j<N;j++){
            if(arr[j].start < arr[i].end){
                if(ans.charAt(ans.length()-1) == 'J')
                    ans += "C";
                else
                    ans += "J";
            }
            else{
                ans += ans.charAt(ans.length()-1);
            }
            i = j;
        }
        
        char[] result = new char[N];
        for(int k=0;k<N;k++){
            result[arr[k].index] = ans.charAt(k);
        }
        
        String res = new String(result); 
        return res;
        
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=1;t<=T;t++){
            int N = scan.nextInt();
            
            int start[] = new int[N];
            int end[] = new int[N];
            
            for(int i=0;i<N;i++){
                start[i] = scan.nextInt();
                end[i] = scan.nextInt();
            }
            
            Task arr[] = new Task[N];
            for(int i=0;i<N;i++){
                arr[i] = new Task(start[i],end[i],i);
            }
            
            System.out.println("Case #"+t+": "+assignTask(arr,N));
        }
    }
}

class Task{
    int start;
    int end;
    int index;
    
    public Task(int start, int end, int index){
        this.start = start;
        this.end = end;
        this.index = index;
    }
}