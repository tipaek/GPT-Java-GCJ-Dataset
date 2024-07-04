
import java.util.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = T;
        while(T-->0){
            int k = 0;
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    arr[i][j] = sc.nextInt();
                    if(i == j){
                        k += arr[i][j];
                    }
                }
            }
            int rowC=0,colC=0;
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> col = new ArrayList<>();
            for(int i = 0;i<N;i++){
                row.clear();
                for(int j = 0;j<N;j++){
                    if(row.contains(arr[i][j])){
                        rowC++;
                        break;
                    }
                    else{
                        row.add(arr[i][j]);    
                    }
                }
            }
            for(int j = 0;j<N;j++){
                col.clear();
                for(int i = 0;i<N;i++){
                    if(col.contains(arr[i][j])){
                        colC++;
                        break;
                    }
                    else{
                        col.add(arr[i][j]);    
                    }
                }
            }
            System.out.println("Case #"+(t-T)+": "+k+" "+rowC+" "+colC);
        }
        return;
	}
}
