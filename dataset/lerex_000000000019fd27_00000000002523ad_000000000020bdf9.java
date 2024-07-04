import java.util.*;
import java.io.*;
public class Solution {
    static void merge(int arr[],int b[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        int L1[] = new int [n1]; 
        int R1[] = new int [n2]; 
        
        for (int i=0; i<n1; ++i){
            L[i] = arr[l + i]; 
            L1[i] = b[l+i];
        } 
            
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j]; 
            R1[j] = b[m + 1+ j]; 
        }
            
  
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                b[k]=L1[i];
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                b[k]=R1[j];
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            b[k]=L1[i];
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            b[k]=R1[j];
            j++; 
            k++; 
        } 
    } 
  
    static void sort(int arr[],int b[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr,b, l, m); 
            sort(arr ,b, m+1, r); 
            merge(arr,b, l, m, r); 
        } 
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int s[] = new int [n];
      int e[] = new int [n];
      for(int j = 0;j<n;j++){
          s[j]=in.nextInt();
          e[j]=in.nextInt();
      }
      sort(s,e,0,n-1);
      boolean p = true;
      char result[] = new char[n];
      int cs=-1,ce=-1,js=-1,je=-1;
      for(int j = 0;j<n;j++){
          if(cs==-1||ce<=s[j]){
              cs = s[j];
              ce = e[j];
              result[j]='C';
          }
          else if(js==-1||je<=s[j]){
              js=s[j];
              je=e[j];
              result[j]='J';
          }
          else{
              p = false;
              break;
          }
      }
      if(p)
        System.out.println("Case #" + i + ": "+String.valueOf(result));
      else
        System.out.println("Case #" + i + ": IMPOSSIBLE");
    }
  }
} 