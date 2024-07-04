import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numberOfTestcases = sc.nextInt();
        for(int i = 0; i<numberOfTestcases; i++){
            int sizeOfmatrix = sc.nextInt();
            int arr[][] = new int[sizeOfmatrix][sizeOfmatrix];
            for(int j = 0; j<sizeOfmatrix; j++){
                for(int k = 0; k<sizeOfmatrix; k++){
                    arr[j][k] = sc.nextInt();
                }
            }
            int trace = 0;
            for(int j = 0; j<sizeOfmatrix; j++){
                for(int k = 0; k<sizeOfmatrix; k++){
                    if(j == k){
                        trace = trace + arr[j][k];
                    }
                }
            }
            int countrow = 0;
            for(int j = 0; j<sizeOfmatrix; j++){
                for(int k = 0; k<sizeOfmatrix - 1; k++){
                    int flag = 0;
                    for(int l = k+1; l<sizeOfmatrix; l++){
                        if(arr[j][k] == arr[j][l]){
                            countrow++;
                            flag++;
                            break;
                        }
                    }
                    if(flag == 1){
                        break;
                    }
                }
            }
            int countcol = 0;
            for(int k = 0; k<sizeOfmatrix; k++){
                for(int j = 0; j<sizeOfmatrix - 1; j++){
                    int flag = 0;
                    for(int l = j+1; l<sizeOfmatrix; l++){
                        if(arr[j][k] == arr[l][k]){
                            countcol++;
                            flag++;
                            break;
                        }
                    }
                    if(flag == 1){
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ":" + " " +trace + " " + countrow + " " + countcol);
        }
    }
}