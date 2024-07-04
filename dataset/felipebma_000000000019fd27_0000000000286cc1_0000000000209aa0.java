import java.util.*;

class Solution{

    static Scanner in = new Scanner(System.in);
    static ArrayList<HashSet<Integer>> lines, columns;
    public static void main(String args[]){
        int nCases = in.nextInt();
        for(int i=1;i<=nCases;i++) solve(i);
    }

    static void solve(int nCase){
        int n=in.nextInt(), k = in.nextInt();
        int arr[][] = new int[n][n];
        lines = new ArrayList<HashSet<Integer>>();
        columns = new ArrayList<HashSet<Integer>>();
        int aux = k/n, resto = k%n;

        for(int i =0;i<n;i++){
            lines.add(new HashSet<Integer>());
            columns.add(new HashSet<Integer>());
            arr[i][i] = aux+resto;
            resto = Math.max(0,resto-1);
            lines.get(i).add(arr[i][i]);
            columns.get(i).add(arr[i][i]);
        }

        if(solve(arr,0,1)){
            System.out.printf("Case #%d: POSSIBLE\n", nCase);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }else{
            System.out.printf("Case #%d: IMPOSSIBLE\n", nCase);
        }
    }

    static boolean solve(int[][] arr, int i, int j){
        if(i==arr.length-1 && j==arr.length-1) return true;
        if(i==j) return solve(arr,i,j+1);
        if(j==arr.length) return solve(arr,i+1,0);
        for(int num=1;num<=arr.length;num++){
            if(!lines.get(i).contains(num) && !columns.get(j).contains(num)){
                arr[i][j] = num;
                lines.get(i).add(num);
                columns.get(j).add(num);
                if(solve(arr,i,j+1)) return true;
                lines.get(i).remove(num);
                columns.get(j).remove(num);
            }
        }
        return false;
    }
}


