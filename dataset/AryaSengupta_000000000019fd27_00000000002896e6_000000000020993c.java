import java.util.Scanner;
public class Vestigium{
    public static void main(String[] args){
        int k=0;
        int r=0;
        int c=0;
        int a1=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter T");
        int t=sc.nextInt();
        while(t!=0){
            System.out.println("Enter N");
            int n= sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    }
                }
                for (int x = 0; x <n;x++){
                    for (int y = 0; y < n-1; y++) {
                        for (int z = x; z < n; z++){
                            if (arr[x][y] == arr[x][z]){
                                a1=1;
                                break;
                                
                            }
                            
                        }
                        
                    }
                    if(a1==1){
                        c++;
                        
                    }
                    
                }
                System.out.println(r + "," + c);
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i==j){
                         k=k+arr[i][j];
                    }   
                }
                System.out.println(k);
            }
        }
    }    
}
    