import java.util.*;

class Solution{
    
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test = 1;test<=t;test++){
            int l = sc.nextInt();
            int [][] arr = new int[l][l];
            
            int trace = 0;
            int repeatr = 0;
            int repeatc = 0;
            
            for(int i = 0;i<l;i++){
                boolean [] checker = new boolean[l];
                boolean count = true;
                for(int j = 0;j<l;j++){
                    arr[i][j] = sc.nextInt();
                    if(i == j){
                        trace+=arr[i][j];
                    }
                    if(checker[arr[i][j] - 1] && count){
                        repeatr++;
                        count = false;
                    }
                    else{
                        checker[arr[i][j] - 1] = true;
                    }
                }
            }
            
            
            for(int i = 0;i<l;i++){
                boolean [] checker = new boolean[l];
                boolean count = true;
                for(int j = 0;j<l;j++){
                    if(checker[arr[j][i] - 1] && count){
                        repeatc++;
                        count = false;
                    }
                    else{
                        checker[arr[j][i] - 1] = true;
                    }
                }
            }
            
            
            System.out.println("Case #"+test+": "+trace+" "+repeatr+" "+repeatc);
        }
    } 
}