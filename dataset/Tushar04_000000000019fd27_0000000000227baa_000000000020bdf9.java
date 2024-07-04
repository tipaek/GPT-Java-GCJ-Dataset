import java.util.*;
public class Solution{
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            int n= sc.nextInt();
            int arr[][] = new int[n][3];
            for(int i=0;i<n;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = i;
            }
            Arrays.sort(arr, (ints, t1) -> ints[0] - t1[0]);
            int j=0,c=0;
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++){
                if(j<=arr[i][0]){
                    sb.append('J');
                    j = arr[i][1];
                }else if(c<=arr[i][0]){
                    sb.append('C');
                    c = arr[i][1];
                }else{
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("Case #"+(k-t)+": "+"IMPOSSIBLE");
            }else {
                StringBuilder res = new StringBuilder();
                for(int i=0;i<n;i++){
                    res.append(sb.charAt(arr[i][2]));
                }
                System.out.println("Case #"+(k-t)+": "+res.toString());
            }
        }
    }
}

