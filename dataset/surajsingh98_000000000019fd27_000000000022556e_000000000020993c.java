import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int trace=0;
            int countRows=0;
            int countCols=0;
            int arr[][]=new int[n][n];
            for(int row=0;row<n;row++){
                String checkRow[] = new String[n];
                for(int col=0;col<n;col++){
                    arr[row][col]=sc.nextInt();
                    checkRow[col]=Integer.toString(arr[row][col]);
                    if(row==col){
                        trace+=arr[row][col];
                    }
                }
                Set<String> set =new HashSet<>(Arrays.asList(checkRow));
                if(checkRow.length != set.size()){
                    countRows++;
                }
            }
            for(int row=0;row<n;row++){
                String checkCol[] = new String[n];
                for(int col=0;col<n;col++){
                    checkCol[col]=Integer.toString(arr[col][row]);
                }
                Set<String> setcol =new HashSet<>(Arrays.asList(checkCol));
                if(checkCol.length != setcol.size()){
                    countCols++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+countRows+" "+countCols);
        }
    }
}