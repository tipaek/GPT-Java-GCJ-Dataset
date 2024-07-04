import java.util.*;
import java.io.*;
class a{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1; i<=t; i++){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            boolean[] col = new boolean[n];
            boolean[] row = new boolean[n];
            for(int j=0; j<n; j++){
                HashMap<Integer,Integer> map = new HashMap();
                for(int k=0; k<n; k++){
                    a[j][k] = sc.nextInt();
                    if(map.get(a[j][k])!=null)
                        row[j] = true;
                    map.put(a[j][k],1);
                }
            }
            for(int j=0; j<n; j++){
                HashMap<Integer,Integer> map = new HashMap();
                for(int k=0; k<n; k++){
                    if(map.get(a[k][j])!=null)
                        col[j] = true;
                    map.put(a[k][j],1);
                }
            }
            int b=0, c=0,sum=0;
            for(int j=0; j<n; j++){
                sum+=a[j][j];
                if(row[j])
                    b++;
                if(col[j])
                    c++;
            }
            System.out.println("Case #"+i+": "+sum+" "+b+" "+c);
        }
    }
}