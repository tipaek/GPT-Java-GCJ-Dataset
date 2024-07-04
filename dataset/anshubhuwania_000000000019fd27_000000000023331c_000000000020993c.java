import java.util.*;

class Main{
    static final int MAXN = 100;
	static final int ROW = 0;
	static final int COL = 1;
    private static int traceMat(int [][]arr,int n){
        int trace = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    trace+=arr[i][j];
                }
            }
        }
        return trace;
    }
    private static int checkDup(int [][]arr,int n,int mod){
        
        int dup=0;int visited[] = new int[MAXN];
        for(int i=0;i<n;i++){
            for(int j=0;j<MAXN;j++){
                visited[j] = 0;
            }
            for(int j=0;j<n;j++){
                if(mod == ROW){
                    if(visited[arr[i][j]]==1)
                    {    dup++;
                    	break;
                    }
                    visited[arr[i][j]] = 1;
                }
                else{
                    if(visited[arr[j][i]]==1)
                        {
                        	dup++;break;
                        }
                    visited[arr[j][i]] = 1;
                }
            }
        }
        return dup;
    }
    
    private static void checkLatinSquare(int [][]arr,int n,int test){
        int dupRow=0,dupCol = 0;
        int trace = traceMat(arr,n);
        dupRow = checkDup(arr,n,ROW);
        dupCol = checkDup(arr,n,COL);
        System.out.println("Case #"+test+": "+trace+" "+dupRow+" "+dupCol);
    }
    public static void main(String []args){
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int test=1;test<=t;test++)
        {
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    arr[i][j] = sc.nextInt();
            }
            checkLatinSquare(arr,n,test);
        }
    }
}