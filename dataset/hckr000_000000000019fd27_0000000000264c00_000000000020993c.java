// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0;k<t;k++){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int c=0,r=0;
           
       for(int i=0;i<n;i++){Set<Integer> row = new HashSet<Integer>();
           for(int j=0;j<n;j++){
               a[i][j] = sc.nextInt();
               if(i==j){c=c+a[i][j];}
              row.add(a[i][j]);
               
           }
           if(row.size()<n){r=r+1;}
       }int c1=0;
            for(int d=0;d<n;d++){Set<Integer> col = new HashSet<Integer>();
                for(int f=0;f<n;f++){
                    col.add(a[f][d]);
                }
                if(col.size()<n){c1=c1+1;}                 
            }
    System.out.println(c+" "+r+" "+c1);}
    }
}