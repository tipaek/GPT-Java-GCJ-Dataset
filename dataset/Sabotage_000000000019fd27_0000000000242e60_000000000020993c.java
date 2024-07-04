import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int ar[][]=new int[a][3];
        
        for(int i=0;i<a;i++){
            int b = sc.nextInt();
            int arr[][] = new int[b][b];
            int arc[][] = new int[b][b];
            for(int j=0;j<b;j++){
                for(int k=0;k<b;k++){
                    arr[j][k]=sc.nextInt();
                    arc[j][k]=arr[j][k];
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
            
            
            int temp=0;
            for (int j = 0; j < b; j++) 
            for (int k = j + 1; k < b; k++){
                temp=arc[j][k]; 
                arc[i][j]=arc[k][j]; 
                arc[j][i]=temp; 
            } 
            
            for(int j=0 ; j<b;j++){
                Arrays.sort(arc[j]);
            }
                
            for(int j=0;j<b;j++){
                for(int k=0;k<b-1;k++){
                    if(arr[j][k]==arr[j][k+1]){
                        sum3++;
                        break;
                    }
                }
            }
            
            ar[i][0]=sum1;
            ar[i][1]=sum2;
            ar[i][2]=sum3;

        }
        for(int i=0;i<a;i++){
            System.out.println("Case #"+i+": "+ar[i][0]+" "+ar[i][1]+" "+ar[i][2]);
            
        }
        
    }
    
}