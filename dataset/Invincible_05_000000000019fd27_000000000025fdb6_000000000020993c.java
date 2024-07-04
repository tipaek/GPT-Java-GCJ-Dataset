import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int[][] input(int N) throws IOException {
        int arr[][] = new int[N][N];
        for(int j=0; j<N; j++) {
            String input[] = br.readLine().split(" ");
            for(int k=0; k<N; k++)
                arr[j][k] = Integer.parseInt(input[k]);
        }
        return arr;
    }
    
    private static int countRows(int arr[][], int N) {
    int row=0, flag;
    for(int j=0; j<N; j++) {
        flag=0;
        for(int k=0; k<N-1; k++) {
            for(int l=k+1; l<N; l++) {
                if(arr[j][k] == arr[j][l]) {
                    row++;
                    flag=1;
                    break;
                }
                if(flag == 1)
                    break;
                }
                if(flag ==1)
                break;
            }   
        }
        return row;
    }
    private static int countColumns(int arr[][], int N) {
    int column=0, flag;
    for(int j=0; j<N; j++) {
        flag=0;
        for(int k=0; k<N-1; k++) {
            for(int l=k+1; l<N; l++) {
                if(arr[k][j] == arr[l][j]) {
                    column++;
                    flag=1;
                    break;
                    
                }
                if(flag == 1)
                    break;
                }
                if(flag ==1)
                break;
            }   
        }
        return column;
    }
    private static int trace(int arr[][], int N) {
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum+=arr[i][i];
        }
        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine().trim());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int arr[][] = input(N);
            int rows = countRows(arr, N);
            int columns = countColumns(arr, N);
            int trace = trace(arr, N);
            System.out.println("Case #" + i + ": "+trace+ " "+rows+ " "+columns);
            
        }
    }
}
