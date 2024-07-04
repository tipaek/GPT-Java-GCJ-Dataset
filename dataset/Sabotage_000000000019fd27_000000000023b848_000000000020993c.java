import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int arr[][] = new int[b][b];
        
        for(int i=0;i<a;i++){
            
            for(int j=0;j<b;j++){
                for(int k=0;k<b;k++){
                    arr[j][k]=sc.nextInt();
                }
            }
            
            //diagonal
            int sum1=0,sum2=0,sum3=0;
            for(int j=0;j<b;j++){
                for(int k=0;k<b; k++){
                    if(j==k){
                        sum1=sum1+arr[j][k];
                    }
                }
            }
            
            for(int j=0 ; j<b;j++){
                Arrays.sort(arr[j]);
            }
            
            for(int j=0;j<b;j++){
                for(int k=0;k<b-1;k++){
                    if(arr[j][k]==arr[j][k+1]){
                        sum2++;
                        break;
                    }
                }
            }
            
            for(int j=0;j<b-1;j++){
                for(int k=0;k<b;k++){
                    if(arr[j][k]==arr[j+1][k]){
                        sum3++;
                        break;
                    }
                }
            }
            
            System.out.println(sum1+" "+sum2+" "+sum3);

        }
    }
}