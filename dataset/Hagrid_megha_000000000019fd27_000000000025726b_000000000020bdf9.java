import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ParentingParenthesis {
    public static String parentingTasks(int[][] arr,int n){
        String result = "J";
        int temp = arr[0][1];
        int maxC =0;
        int maxJ =temp;
        int max =0;
        for(int i=1;i<n;i++){
            max=Math.max(arr[i-1][1],max);
            if(arr[i][0]<=max){
                if( arr[i][0]>=maxC){
                    result+="C";
                    maxC = arr[i][1];
                }
                else if(arr[i][0]>=maxJ){
                    result+="J";
                    maxJ = arr[i][1];
                }
                else {
                    String res = "IMPOSSIBLE";
                    return res;
                }
            }
            else{
                result+="C";
                maxC = arr[i][1];
            }
        }
        return result;
    };
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int arr[][] = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]= scan.nextInt();
                arr[i][1]= scan.nextInt();
            }
            //Sort by starting interval;
            Arrays.sort(arr, new Comparator<int[]>(){
                public int compare(int[] i1,int[]i2){
                        return i1[0]>i2[0] ? 1:-1;
                }
            });
            System.out.println(parentingTasks(arr,n));
//            for(int i=0;i<n;i++){
//                System.out.println(arr[i][0] + " "+arr[i][1]);
//            }
        }
    }
}
