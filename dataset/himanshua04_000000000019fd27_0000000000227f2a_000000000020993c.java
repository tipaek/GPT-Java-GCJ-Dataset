import java.util.*;
class Solution{

    static boolean isValid(int row ,int col , int n){
        if(row>=0 && row<n && col>=0 && col<n) return true;
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc =sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int cases = 1;
        while(tc-->0){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int rowCount = 0;
            int colCount = 0;
            int digCount = 0;
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            int i=0;
            int j=0;
            while(i<n && j<n){
                digCount+=arr[i][j];
                for(int k=0;k<n;k++){
                    if(isValid(i+k , j , n)){
                        if(!row.contains(arr[i+k][j])) row.add(arr[i+k][j]);
                    }
                    if(isValid(i-k, j, n)){
                        if(!row.contains(arr[i-k][j])) row.add(arr[i-k][j]);
                    }  
                    if(isValid(i, j-k, n)){
                        if(!col.contains(arr[i][j-k])) col.add(arr[i][j-k]);
                    }
                    if(isValid(i, j+k, n)){
                        if(!col.contains(arr[i][j+k])) col.add(arr[i][j+k]);
                    }
                }
                if(row.size()<n) rowCount++;
                if(col.size()<n) colCount++;
                row.clear();
                col.clear();
                i++;
                j++;
            }
            sb.append("Case #"+(cases++)+": "+digCount+" "+colCount+" "+rowCount).append("\n");
        }
        System.out.println(sb);
    }
}