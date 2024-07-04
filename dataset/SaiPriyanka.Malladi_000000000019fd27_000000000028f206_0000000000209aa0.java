import java.util.*;
class Main
{
 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  int t = s.nextInt();
  for(int y=0;y<t;y++){
  int n = s.nextInt();
  int k = s.nextInt();
  int[] a = new int[n];
  ArrayList a1 = split(n,k);
  int occurrences = Collections.frequency(a1, a1.get(0));
  if(occurrences == k)
  {
      for(int i=0;i<k;i++) a[i] = i+1;
      int[][] h = new int[k][k]; int l=0;
    // for(int i=0;i<k;i++)
    // System.out.print(a[i]);
      for(int i=0;i<k;i++){ h[i][i] = (int)a1.get(i);}
      for(int i=0;i<k;i++)
      {
          for(int j=0;j<k;j++)
          {
              l=l%k;
              if(i!=j && a[l] != h[i][i])
              h[i][j] = a[l];
              l++;
          }
      }
      System.out.println("Case #"+y+": POSSIBLE");
      for(int i=0;i<k;i++){
      for(int j=0;j<k;j++)
      System.out.print(h[i][j]+" ");
      System.out.println();}
  }
  else
  {
      System.out.println("Case #"+y+": IMPOSSIBLE");
  }}
}
 static ArrayList<Integer> split(int x, int n) 
    { 
        ArrayList<Integer> as = new ArrayList<Integer>();
        if(x < n) 
        as.add(-1); 
        else if (x % n == 0) 
        { 
            for(int i=0;i<n;i++) 
            as.add(x/n); 
        } 
        else
        { 
            int zp = n - (x % n); 
            int pp = x/n; 
            for(int i=0;i<n;i++)  
            { 
                if(i>= zp) 
                as.add(pp+1) ;
                else
                as.add(pp);
            } 
        } 
        return as;
    } 
}