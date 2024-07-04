import java.util.*;
import java.io.*;
public class Solution {
    static void merge(int arr[],int b[],int c[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        int L1[] = new int [n1]; 
        int R1[] = new int [n2];
        int L2[] = new int [n1]; 
        int R2[] = new int [n2];
        
        for (int i=0; i<n1; ++i){
            L[i] = arr[l + i]; 
            L1[i] = b[l+i];
            L2[i] = c[l+i];
        } 
            
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j]; 
            R1[j] = b[m + 1+ j]; 
            R2[j] = c[m + 1+ j]; 
        }
            
  
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                b[k]=L1[i];
                c[k]=L2[i];
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                b[k]=R1[j];
                c[k]=R2[j];
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            b[k]=L1[i];
            c[k]=L2[i];
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            b[k]=R1[j];
            c[k]=R2[j];
            j++; 
            k++; 
        } 
    } 
  
    static void sort(int arr[],int b[],int c[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr,b,c, l, m); 
            sort(arr ,b,c, m+1, r); 
            merge(arr,b,c, l, m, r); 
        } 
    }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int s[] = new int [n];
      int e[] = new int [n];
      int ind[] = new int [n];
      for(int j = 0;j<n;j++){
          s[j]=in.nextInt();
          e[j]=in.nextInt();
          ind[j]=j;
      }
      sort(s,e,ind,0,n-1);
      boolean p = true;
      char result[] = new char[n];
      int cs=-1,ce=-1,js=-1,je=-1;
      for(int j = 0;j<n;j++){
          if(cs==-1||ce<=s[j]){
              cs = s[j];
              ce = e[j];
              result[ind[j]]='C';
          }
          else if(js==-1||je<=s[j]){
              js=s[j];
              je=e[j];
              result[ind[j]]='J';
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