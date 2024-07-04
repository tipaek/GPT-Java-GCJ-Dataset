import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++){
            int N = scanner.nextInt();
            int[][] arr = new int[N][3];
            for(int j=0;j<N;j++){
                arr[j][0]=scanner.nextInt();
                arr[j][1]=scanner.nextInt();
                arr[j][2]=j;
            }
            Insertionsort(arr);
            boolean[] mem = new boolean[2];
            int[] end = new int[2];
            String result="";
            boolean flag = false;
            for(int j=0;j<N;j++){
                if(arr[j][0]>=end[0]){
                    mem[0]=false;
                }
                if(arr[j][0]>=end[1]){
                    mem[1]=false;
                }
                if(!mem[0]){
                    end[0]=arr[j][1];
                    result+="C";
                    mem[0]=true;
                }else if(!mem[1]){
                    end[1]=arr[j][1];
                    result+="J";
                    mem[1]=true;
                }else{
                    if(end[0]<arr[j][0]){
                        end[0]=arr[j][1];
                        result+="C";
                    }else if(end[1]<arr[j][0]){
                        end[1]=arr[j][1];
                        result+="J";
                    }else{
                        System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                        flag=true;
                        break;
                    }
                }
            }
            if(!flag){
                System.out.print("Case #"+(i+1)+": ");
                for(int n=0;n<N;n++){
                    System.out.print(result.charAt(arr[n][2]));
                }
                System.out.println();
            }
        }
    }
    public static void Insertionsort(int[][] arr){
        for(int i = 1;i<arr.length;i++){
            int[] key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j][0]>key[0]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
