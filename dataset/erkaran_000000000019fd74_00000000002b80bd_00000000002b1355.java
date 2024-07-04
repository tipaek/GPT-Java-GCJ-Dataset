import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int o=1 ;o<=t;o++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            if(r==1&&c==1){
                System.out.println("Case #"+o+": "+sc.nextInt());
            }else if(r==1){
                printSum(sc,c,o);
            }else if(c==1){
                printSum(sc,r,o);
            }else{
                int arr[][] = new int[r][c];
                int sum = 0;
                for(int i = 0; i <r ; i++){
                    for(int j = 0; j <c ; j++){
                        arr[i][j] = sc.nextInt();
                        sum += arr[i][j];
                    }
                }
                int sume=0;
                int sumo=0;
                int count = 1;
                for(int i = 0; i <r ; i++){
                    for(int j = 0; j <c ; j++){
                        if(count % 2 == 0)
                            sume += arr[i][j];
                            else sumo += arr[i][j];
                            count++;
                    }
                }
                sum += sumo>=sume?sumo:sume;
                
                System.out.println("Case #"+o+": "+sum);
            }
        }
    }
    public static void printSum(Scanner sc , int size , int o){
        int arr[] = new int[size];
        int sum = 0;
        for(int i = 0; i <size ; i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        Arrays.sort(arr);
        for(int i = 1; i <size ; i++){
            for(int j = i; j <size ; j++){
                    sum += arr[j];
            }
        }
        System.out.println("Case #"+o+": "+sum);
    }
}