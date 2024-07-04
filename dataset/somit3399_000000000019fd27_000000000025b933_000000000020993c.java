import java.util.Scanner;

class Solution{
    public static void main(String...args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++){
            int n = scan.nextInt();
            int arr[][] = new int[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    arr[j][k] = scan.nextInt();
                }
            }
            int dSum = 0;
            int r = 0, c = 0;
            boolean flagR = true, flagC = true;
            for (int j = 0; j < n; j++){
                flagR = true;
                flagC = true;
                for (int k = 0; k < n; k++){
                    if (j == k){
                        dSum = dSum + arr[j][k];
                    }
                    int item = arr[j][k];
                    for (int l = 0; l < n; l++){
                        if (k != l){
                            if (arr[j][l] == item){
                                flagR = false;
                            }
                            if(arr[l][j] == arr[k][j]){
                                flagC = false;
                            }
                        }
                    }
                }
                if(flagR == false){
                    r++;
                }
                if(flagC == false){
                    c++;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + dSum + " " + r + " " + c);
        }
    }
}