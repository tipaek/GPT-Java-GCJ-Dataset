import java.util.*;

public class Solution {
  public static String fun(int s[], int e[], int n){
      int c[] = new int[n];
      //for (int i=0; i<n; i++)
        //c[i]=i;
      MergeSort(s, e, c, 0, n-1);
      int a=e[0], b=0;
      String x="C";
      for (int i=1; i<n; i++){
          if (s[i]>=a){
              x=x+"C";
              a=e[i];
          }
          else if (s[i]>=b){
              x=x+"J";
              b=e[i];
          }
          else
            return "IMPOSSIBLE";
      }
      return x;
  }
  
  public static void Merge(int s[], int e[], int c[], int l, int m, int r){
      int n1 = m-l+1;
      int n2 = r-m;
      
      int s1[] = new int[n1];
      int e1[] = new int[n1];
      int c1[] = new int[n1];
      
      int s2[] = new int[n2];
      int e2[] = new int[n2];
      int c2[] = new int[n1];
      
      for (int i=l; i<=m; i++){
          s1[i-l]=s[i];
          e1[i-l]=e[i];
          c1[i-l]=c[i];
      }
      for (int i=m+1; i<=r; i++){
          s2[i-m-1]=s[i];
          e2[i-m-1]=e[i];
          c2[i-m-1]=c[i];
      }
      
      int i=0, j=0, k=l;
      
      while (i<n1 && j<n2){
          if (e1[i]<=e2[j]){
              e[k]=e1[i];
              s[k]=s1[i];
              i++;
          }
          else {
              e[k]=e2[j];
              s[k]=s2[j];
              j++;
          }
          k++;
      }
      
      while (i<n1){
          e[k]=e1[i];
          s[k]=s1[i];
          i++;
          k++;
      }
      
      while (j<n2){
          e[k]=e2[j];
          s[k]=s2[j];
          j++;
          k++;
      }
      
  }
  
  public static void MergeSort(int s[], int e[], int c[], int l, int r){
      if (l<r){
          int m = (l+r)/2;
          MergeSort(s, e, c, l, m);
          MergeSort(s, e, c, m+1, r);
          Merge(s, e, c, l, m, r);
      }
  }
    
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    
    for (int t=1; t<=test; t++){
        if (t!=1)
            System.out.println();
        
        int n = sc.nextInt();
        int s[] = new int[n];
        int e[] = new int[n];
        
        for (int i=0; i<n; i++){
            s[i]=sc.nextInt();
            e[i]=sc.nextInt();
        }
        System.out.print("Case #"+t+": "+fun(s, e, n));
    }
    
    
  }
}