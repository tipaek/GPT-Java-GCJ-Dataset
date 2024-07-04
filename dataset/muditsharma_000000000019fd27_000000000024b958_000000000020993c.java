import java.util.*;
public class Solution {
    public static int countRows(int[][]arr){
        int n=arr.length;
        Set<Integer> set=new HashSet<>();
        int rowCount=0;
        for(int i=0;i<n;i++){
            set.clear();
            for(int j=0;j<n;j++){
                if(set.contains(arr[i][j])){
                    rowCount+=1;
                    break;
                }
                set.add(arr[i][j]);
            }
        }
        return rowCount;
    }
    public static int countCols(int[][]arr){
        int n=arr.length;
        Set<Integer> set=new HashSet<>();
        int colCount=0;
        for(int i=0;i<n;i++){
            set.clear();
            for(int j=0;j<n;j++){
                if(set.contains(arr[j][i])){
                    colCount+=1;
                    break;
                }
                set.add(arr[j][i]);
            }
        }
        return colCount;
    }
    public static void main (String [] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cases=1;
        while(cases<=t){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trace=0;
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j){
                        trace+=arr[i][j];
                    }   
                }

            }
            System.out.println("Case #"+cases+": "+trace+" "+countRows(arr)+" "+countCols(arr));
            cases++;
        }
    }
}