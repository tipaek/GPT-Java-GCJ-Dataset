import java.lang.reflect.Array;
import java.util.*;
public class Solution{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        outer: for(int i = 1; i <= t; i++){
            int n = scanner.nextInt();
            int [] start = new int [n];
            int [] end = new int [n];
            for(int j = 0; j < n; j++){
                start[j] = scanner.nextInt();
                end[j] = scanner.nextInt();
            }
            sort(start, end, 0, n - 1);
            ArrayList<String> ans = new ArrayList<>();
            ans.add("J");
            if(n == 2){
                ans.add("C");
                System.out.println(Arrays.toString(ans.toArray()));
                continue outer;
            }
            if(n == 1){
                System.out.println(Arrays.toString(ans.toArray()));
                continue outer;
            }
            if((start[0] < start[1] && start[0] < start[2]) && (end[0] > end[1] && end[0] > end[2])){
                System.out.println("IMPOSSIBLE");
                continue outer;
            }
            for(int j = 1; j < n; j++){
                if(noOverlap(start, end, j, j-1)){
                    String temp = ans.get(j - 1);
                    ans.add(temp);
                }
                else{
                    if(ans.get(j-1).equals("C")){
                        ans.add("J");
                    }
                    else{
                        ans.add("C");
                    }
                }
            }
            System.out.println(" ");
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
    public static class Time{
        int min1;
        int min2;
        public Time(int min1, int min2){
            this.min1 = min1;
            this.min2 = min2;
        }
        public int getFirst(){
            return min1;
        }
    }
    static int partition(int arr[], int [] arr1,  int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                int temp1 = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] = temp1;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        int temp1 = arr1[i+1];
        arr1[i+1] = arr1[high];
        arr1[high] = temp1;

        return i+1;
    }
    static void sort(int arr[], int arr1[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr,arr1, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr,arr1, low, pi-1);
            sort(arr,arr1,  pi+1, high);
        }
    }
    static boolean noOverlap(int [] start, int [] end, int cur, int prev){
        if(start[cur] > end[prev]){
            return true;
        }
        return false;
    }
}