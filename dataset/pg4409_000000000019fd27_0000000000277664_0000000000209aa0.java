import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        int x = 1;
        while(t-- >0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr=new int[n+1][n+1];
            // for(int i=1;i<n;i++){}
            if(k%n!=0 ) {
                // ans=false;
                // break;
                System.out.println("Case #"+x+": IMPOSSIBLE");x++;
                continue;
            }
            else{
                int val = k/n;
                for(int i=1;i<=n;i++){
                    arr[val][i]=i;
                }

                 //lower half
               
                for(int i=val+1;i<=n;i++){
                    int val2=1;
                    // int x = 1;
                    for(int j= i-val+1;j<=n;j++){
                        arr[i][j] = val2++;
                    }

                    for(int j=1;j<= i-val;j++){
                        arr[i][j]= val2++;
                    }

                }

                //upper half
                int tx = val;
                int tx2 = val;
                for(int i= 1;i<=val-1;i++){
                        int j=1;
                        tx = tx2;
                        while(tx<=n){
                            arr[i][j]=tx;
                            tx++;
                            j++;
                        }
                        int val3 = 1;
                        while(j<=n){
                            arr[i][j]=val3++;
                            j++;
                        }
                        tx2--;
                        // t++;
                }

                
                System.out.println("Case #"+x+": POSSIBLE");
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n;j++){
                        // arr[i][j]
                        System.out.print(arr[i][j]+" ");

                    }
                    System.out.println();
                }

            }
            x++;
        }
    }
}