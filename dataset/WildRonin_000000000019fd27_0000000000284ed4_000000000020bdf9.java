import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



class Solution{

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

              else if(arrs[j][0]==arrs[j+1][0]){
                    if(arrs[j][1]>arrs[j+1][1]){
                        temp=arrs[j][0];
                        arrs[j][0]=arrs[j+1][0];
                        arrs[j+1][0]=temp;

                        temp=arrs[j][1];
                        arrs[j][1]=arrs[j+1][1];
                        arrs[j+1][1]=temp;
                        flag=1;
                    }
                }
            }
            if(flag==0){
                break;
            }
        }
    }

    public static int search(int []arr,int sind,int k,int n){
        int a =0;
        for(int i=sind;i<n;i++){
            if(arr[i]==k) {
                a = i;
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        try{
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int n =Integer.parseInt(read.readLine());

            char[][] out = new char[n][1100];

            for (int i=0;i<n;i++){

                int k = Integer.parseInt(read.readLine());
                int[][] arr = new int[k][2];
                int[][] arr2 = new int[k][2];

                for(int j=0;j<k;j++){

                    String s = read.readLine();
                    StringTokenizer tk = new StringTokenizer(s," ");

                    arr[j][0] = Integer.parseInt(tk.nextToken());
                    arr2[j][0] = arr[j][0];
                    arr[j][1] = Integer.parseInt(tk.nextToken());
                    arr2[j][1] = arr[j][1];

                }

                bubble_sort(arr,k);
                int[] check = new int[k];

                for(int j=0;j<k;j++){
                    check[j] = arr2[j][0];
                }

               /* for (int j=0;j<k;j++){
                    for(int m=0;m<2;m++){
                        System.out.print(arr[j][m] + " ");
                    }
                    System.out.println();
                }

                for(int j=0;j<k;j++){
                    System.out.println(check[j]);
                }*/

                int[] part = new int[2];
                int index;


                for (int j=0;j<k;j++){
                    if(part[0]<=arr[j][0]){
                        part[0] = arr[j][1];
                        index = search(check,0,arr[j][0],k);
                        while (index < k) {
                            if (arr2[index][1] == arr[j][1]){
                                out[i][index] = 'C';
                                check[index]=-99;
                                break;
                            }
                            index = search(check,index+1,arr[j][0],k);
                        }
                       // out[i][index] = 'C';
                    }

                    else if(part[1]<=arr[j][0]){
                        part[1] = arr[j][1];
                        index = search(check,0,arr[j][0],k);
                        while (index < k) {
                            if (arr2[index][1] == arr[j][1]){
                                out[i][index] = 'J';
                                check[index]=-99;
                                break;
                            }
                            index = search(check,index+1,arr[j][0],k);
                        }
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
