import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNo = 1;
        while(t--> 0){
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i=0;i<n; i++){
                for(int j =0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for(int i=0; i<n; i++){
                trace+= arr[i][i];
            }
            int dupRow = 0;
             for(int i=0;i<n; i++){
                 List<Integer> list = new ArrayList<>();
                for(int j =0; j<n; j++){
                    if(list.contains(arr[i][j])){
                        dupRow++;
                        break;
                    }
                    list.add(arr[i][j]);
                }
            }
             int dupCol = 0;
             for(int i=0;i<n; i++){
                 List<Integer> list = new ArrayList<>();
                for(int j =0; j<n; j++){
                    if(list.contains(arr[j][i])){
                        dupCol++;
                        break;
                    }
                    list.add(arr[j][i]);
                }
            }
            System.out.println("Case #"+caseNo+++": "+ trace + " "+dupRow+" "+dupCol);
        }
    }
}