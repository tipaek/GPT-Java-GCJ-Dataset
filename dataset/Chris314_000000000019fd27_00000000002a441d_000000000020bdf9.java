import java.util.*;
    import java.io.*;
public class Solution{
     public static void main(String []args){
               Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t; i++) {
            int N = in.nextInt();
            int start[] = new int[N];
            int end[] = new int[N];
            int nums[] = new int[N];
            int start2[] = new int[N];
            for (int j = 0; j < N; j++) {
                start[j] = in.nextInt();
                start2[j] = start[j];
                end[j] = in.nextInt();
                nums[j] = j;
            }
            sort(start, end, 0, N-1);
            sort(start2, nums, 0, N-1);
            String ans = "C";
            char mode = 'C';
            int[] max = maxArray(end);
           
            for (int j = 1; j < N; j++) {
                if (start[j] >=max[j-1])// they don't intersect 
                ans += mode;//mode stays unchanged
                else { 
                    int countC = 0;
                    int countJ = 0;
                    for (int k = 0 ; k <= j-1; k++) {
                        if (start[j] < end[k]) {
                            if (ans.charAt(k) == 'C')
                            countC++;
                            else
                            countJ++;
                        }
                    }
                    if (countC >= 1 && countJ >= 1) {
                        ans = "IMPOSSIBLE";
                        break;
                    }
                    if (countC >= 1)
                        mode = 'J';
                    else
                        mode = 'C';
                    ans += mode;
                }
            }
            if (!ans.equals("IMPOSSIBLE")) {
            char[] array = new char[N];
            for (int k = 0; k < N; k++) {
                array[nums[k]] = ans.charAt(k);
            }
            ans = "";
            for (int k = 0; k<N;k++) {
                ans+=array[k];
            }
            }
          System.out.println("Case #" + (i+1) + ": " + ans);
 
        }
     
     }
     public static int[] maxArray(int end[] ) {
         int max = -1;
         int ans[] = new int[end.length];
         for (int i = 0; i < end.length; i++) {
             if (end[i] > max) {
                 max =end[i];
                 
             }
             ans[i] = max;
         }
         return ans;
     }
 public static void sort(int start[], int end[], int first, int last) {
         //sort the arrays by start times

         int mid =first+last;
         mid/=2;
         if (first>= last)
            return;
         sort(start, end, first, mid);
         sort(start, end, mid+1, last);
         //now need to merge the sorted halves
      
         int sortedArray[] = new int[last-first+1];
         int sortedArrayEnd[] = new int[last-first+1];
         int counterFirst = first;
         int counterLast = mid+1;
         int i = 0;
         for (; i < last-first+1; i++) {
             if (start[counterFirst] < start[counterLast]) {
               
                 sortedArray[i]= start[counterFirst];
                 sortedArrayEnd[i] = end[counterFirst++];
                 if (counterFirst > mid)
                    break;
             }
             else {
    
                 sortedArray[i] = start[counterLast];
                 sortedArrayEnd[i] = end[counterLast++];
                               
                 if (counterLast > last)
                    break;
             }
         }
         i++;
         for (int j = counterFirst; j <= mid; j++) {
             sortedArray[i] = start[j];
             sortedArrayEnd[i++] = end[j];
         }
           for (int j = counterLast; j <= last; j++) {
             sortedArray[i] = start[j];
             sortedArrayEnd[i++] = end[j];
         }
   
         for (int j = first; j <= last; j++) {
             start[j] = sortedArray[j - first];
             end[j] = sortedArrayEnd[j-first];
         }
         
     }
}