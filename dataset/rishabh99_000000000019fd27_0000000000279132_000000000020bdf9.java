import java.util.*;
import java.io.*;
class Obj{
    int index;
    int start;
    int end;
    char a;
 
    public String toString() 
    { 
        return this.start + " " + this.end + 
                           " " + this.index+" "; 
    }
}

class Sortbyroll implements Comparator<Obj> 
{ 
    public int compare(Obj a, Obj b) 
    { 
        return a.start - b.start; 
    } 
} 
class Solution{
    
    public static void main(String[] args) throws IOException{
        BufferedReader b  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        int k=0;
        
        while(t--!=0){
            int n = Integer.parseInt(b.readLine());
            int[] arr2 = new int[1441];
            Obj[] arr = new Obj[n];
            for(int i=0;i<n;i++){
                arr[i] = new Obj();
                String[] in = b.readLine().split(" ");
                int s = Integer.parseInt(in[0]);
                int e = Integer.parseInt(in[1]);
                arr[i].start = s;
                arr[i].end = e;
                arr[i].index = i;
                arr2[s]+=1;
                arr2[e]-=1;
            }
            boolean flag = true;
            for(int i=1;i<1441;i++){
                arr2[i]+= arr2[i-1];
                if(arr2[i]>2){
                    System.out.println("Case #"+ (++k)+": "+"IMPOSSIBLE");
                    flag = false;
                    break;
                }
            }
            if(flag){
            Arrays.sort(arr,new Sortbyroll());
            // for(int i=0;i<n;i++){
            //     System.out.print(arr[i]);
            // }
            char[] ans = new char[n];
            int end = arr[0].end;
            arr[0].a = 'C';
            for(int i=1;i<n;i++){
                if(arr[i].start>=end){
                    arr[i].a=arr[i-1].a;
                    end = arr[i].end;
                }
                else{
                    arr[i].a = arr[i-1].a=='C'?'J':'C';
                    end = arr[i].end;
                }
            }
            for(int i=0;i<n;i++){
                ans[arr[i].index] = arr[i].a;
            }
            System.out.print("Case #"+ (++k)+": ");
            for(int i=0;i<n;i++){
                System.out.print(ans[i]);
            }
            System.out.println();
            }
        }
    }
}