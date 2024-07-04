import java.util.*;  

public class Solution {
  public static void solve(int[] s, int[] e,
                     int ks, int[] o) {
    int n = s.length, c = e[0], j = 0;
    String res = "C";
    String out = "";
    for(int i=1; i < n; i++){
        char temp;
        if(s[i] >= c){
            temp = 'C';
            c = e[i];
        } else if(s[i] >= j) {
            temp = 'J';
            j = e[i];
        } else {
    System.out.println("Case #"+ks+": "+"IMPOSSIBLE");
    return;
        }
        res += temp;
    }
    for(int i=0; i <n; i++){
        out += res.charAt(o[i]);
    }

System.out.println("Case #"+ks+": "+out);
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int n = input.nextInt();
      int[] start = new int[n];
      int[] end = new int[n];
      int[] o = new int[n];
      for(int i=0; i < n; i++){
        start[i] = input.nextInt();
        end[i] = input.nextInt();
        o[i] = i;
      }
      sort(start,0,n-1,end, o);
      solve(start, end, ks, o);
    }
  }
  
   public static int partition
                (int arr[], int low, int high, int[] e,int[] o) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                
                int t = o[i]; 
                o[i] = o[j]; 
                o[j] = t; 
                
                int s = e[i]; 
                e[i] = e[j]; 
                e[j] = s;                 
                
            } 
        } 

        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        
        int t = o[i+1]; 
        o[i+1] = o[high]; 
        o[high] = t; 

        int s = e[i+1]; 
        e[i+1] = e[high]; 
        e[high] = s;         
        
  
        return i+1; 
    } 

    public static void sort
            (int arr[], int low, int high, int[] e, int[] o) 
    { 
        if (low < high) 
        { 

            int pi = partition(arr, low, high, e, o); 
            sort(arr, low, pi-1, e, o); 
            sort(arr, pi+1, high, e, o); 
        } 
    } 
}
