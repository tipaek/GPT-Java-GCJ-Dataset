import java.util.Scanner;

public class Solution{
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            
            int N = sc.nextInt();
            int arr[][] = new int[N][N];
            
            for(int row=0; row<N; row++){
                for(int col=0; col<N; col++){
                    arr[row][col] = sc.nextInt();
                }
            }
            
            //calculate diagonal
            int k=0;
            int r=0;
            int c =0;
            for(int row=0; row<N; row++){
                for(int col=0; col<N; col++)
                {
                    if(row==col)
                        k+= arr[row][col];
                   
                }
            
            }
            //find match in row/col
            for(int row=0; row<N; row++){
                int flag = 0;
                for(int col=0; col<N; col++){
                    for(int f_col=col+1; f_col<N; f_col++)
                    {
                        if(arr[row][col] == arr[row][f_col])
                        {
                            r++;
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1)
                        break;
                }
            }
            
            for(int col=0; col<N; col++){
                int flag = 0;
                for(int row=0; row<N; row++){
                    for(int f_row=row+1; f_row<N; f_row++)
                    {
                        if(arr[row][col] == arr[f_row][col])
                        {
                            c++;
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1)
                        break;
                }
            }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
    }
}