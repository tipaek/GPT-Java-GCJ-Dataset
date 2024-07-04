import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Solution {

    public static void bubble_sort(int[][] arrs, int n){

        int temp,flag;
        for(int i=0;i<n-1;i++){
            flag=0;
            for(int j=0;j<n-i-1;j++){

                if(arrs[j][0]>arrs[j+1][0]){
                    temp=arrs[j][0];
                    arrs[j][0]=arrs[j+1][0];
                    arrs[j+1][0]=temp;

                    temp=arrs[j][1];
                    arrs[j][1]=arrs[j+1][1];
                    arrs[j+1][1]=temp;
                    flag=1;
                }
            }
            if(flag==0){
                break;
            }
        }
    }

    public static void main(String[] args) {

        try{
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int n =Integer.parseInt(read.readLine());

            char[][] out = new char[n][110];

            for (int i=0;i<n;i++){

                int k = Integer.parseInt(read.readLine());
                int[][] arr = new int[k][2];

                for(int j=0;j<k;j++){

                    String s = read.readLine();
                    StringTokenizer tk = new StringTokenizer(s," ");

                    arr[j][0] = Integer.parseInt(tk.nextToken());
                    arr[j][1] = Integer.parseInt(tk.nextToken());

                }

                bubble_sort(arr,k);

                int[] part = new int[2];


                for (int j=0;j<k;j++){
                    if(part[0]<=arr[j][0]){
                        part[0] = arr[j][1];
                        out[i][j] = 'C';
                    }

                    else if(part[1]<=arr[j][0]){
                        part[1] = arr[j][1];
                        out[i][j] = 'J';
                    }

                    else {
                        out[i] = "IMPOSSIBLE".toCharArray();
                        break;
                    }

                }

            }

            for (int i = 0;i<n;i++){
                System.out.print("Case #"+(i+1)+": ");
                System.out.println(out[i]);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
