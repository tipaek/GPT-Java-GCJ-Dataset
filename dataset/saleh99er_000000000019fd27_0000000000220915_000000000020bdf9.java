import java.util.*;
import java.io.*;
import java.util.Random;
import java.lang.StringBuilder;

class Event{
    int i;
    int startTime;
    int endTime;
}

class Soln {
    boolean isPossible;
    boolean[] assignment; // true at index i if parent 1 assigned, C, false OW, Parent 2 J
}

public class Solution {
    
    static Event[] events;
    static int N;
    static int[] eventLabel;

    static final int IFP1 = 4; // inelligible for parent 1
    static final int IFP2 = 8; // inelligible for parent 2
    static final int IFPB = 12; // inelligible for either
    static final int P2 = 2; // labeled to parent 2
    static final int P1 = 1; // labeled to parent 1
    static final int UNASSIGNED = 0;

    // credit to geeksforgeeks for mergesort -----
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    static void merge(Event arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        Event L[] = new Event [n1]; 
        Event R[] = new Event [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i].startTime <= R[j].startTime) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    static void sort(Event arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    // ---------------------------------

    public static void sortEvents(){
        sort(events, 0, N-1);
    }

    public static Soln parenting(int n){
        sortEvents();
        Soln soln = new Soln();
        soln.isPossible = true;
        soln.assignment = new boolean[n];

        for(int j = 0; j < n; j++){
            for(int i = 0; i < j; i++){
                if(events[i].endTime > events[j].startTime ){
                    int parentTaken = eventLabel[i];
                    int inelligibleLabel = parentTaken == P1 ? IFP1 : IFP2;
                    eventLabel[j] = eventLabel[j] | inelligibleLabel;
                    if(eventLabel[j] == 12) {
                        soln.isPossible = false;
                        return soln;
                    }
                }
                
            }
            // assign label for j if possible
            if(eventLabel[j] == IFP1){
                eventLabel[j] = P2;
                soln.assignment[events[j].i] = false;
            }
            else if(eventLabel[j] == IFP2){
                eventLabel[j] = P1;
                soln.assignment[events[j].i] = true;
            }
            else{
                eventLabel[j] = P1;
                soln.assignment[events[j].i] = true;
            }
        }
        return soln;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int t = 1; t <= testCases; ++t) {
            N = in.nextInt();
            events = new Event[N];
            eventLabel = new int[N];

            for(int i = 0; i < N; i++){
                Event e = new Event();
                e.i = i;
                e.startTime = in.nextInt();
                e.endTime = in.nextInt();
                events[i] = e;
            }
            Soln soln = parenting(N);
            if(!soln.isPossible) System.out.println("Case #" + t+ ": IMPOSSIBLE");
            else{
                StringBuilder sb = new StringBuilder();
                sb.append("Case #");
                sb.append(t);
                sb.append(": ");
                for(int i = 0; i < N; i++){
                    sb.append(soln.assignment[i] ? "C" : "J");
                }
                System.out.println(sb.toString());
            }
        }
    }
}