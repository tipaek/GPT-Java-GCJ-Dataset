import java.util.*;
public class Vestigium {
     public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++){
            int n = sc.nextInt();
            int arr[][] =new int[n][n];
            for(int j=0; j< n; j++){
                for(int k=0; k<n;k++){
                    arr[j][k]=sc.nextInt();
                }
            }
            int trace = 0;
            for(int j=0; j<n; j++){
                trace =trace+arr[j][j];
            }
            int rows =0;
            for(int j=0; j< n; j++){
                Set<Integer> set = new HashSet<>();
                for(int k=0; k<n;k++){
                    if(set.contains(arr[j][k])){
                        rows++;
                        break;
                    }
                    set.add(arr[j][k]);
                }
                
            }
            int coloumns=0;
             for(int j=0; j< n; j++){
                Set<Integer> set = new HashSet<>();
                for(int k=0; k<n;k++){
                    if(set.contains(arr[k][j])){
                        coloumns++;
                        break;
                    }
                    set.add(arr[k][j]);
                }
                
            }
            System.out.println("Case #"+i+": "+trace+" "+rows+" "+coloumns);
        }
    }
}