import java.util.*;
public class Solution{
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=t;
        while(t-->0){
            Solution obj = new Solution();
            int n= sc.nextInt();
            int trace = sc.nextInt();
            ArrayList<int[]> al = new ArrayList<>();
            obj.tracelist(al,new int[n],0,trace,n);
            int res[][] = new int[n][n];
            boolean result =false;
            for(int i=0;i<al.size();i++){
                if(!result){
                    res = new int[n][n];
                    for(int j=0;j<n;j++){
                        res[j][j] = al.get(i)[j];
                    }
                    result = obj.getresult(res);
                }else break;
            }
            if(result){
                System.out.println("Case #"+(k-t)+": POSSIBLE");
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        System.out.print(res[i][j]+" ");
                    }
                    System.out.println();
                }
            }else{
                System.out.println("Case #"+(k-t)+": IMPOSSIBLE");
            }
        }
    }

    private boolean getresult(int arr[][]){
        int n=arr.length;
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (arr[i][j] == 0)
                {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }
        if (isEmpty)
        {
            return true;
        }

        for (int num = 1; num <= n; num++)
        {
            if (ifValid(arr, row, col, num,n))
            {
                arr[row][col] = num;
                if (getresult(arr))
                {
                    return true;
                }
                else
                {
                    arr[row][col] = 0;
                }
            }
        }
        return false;

    }

    private boolean ifValid(int arr[][], int ii, int jj, int num, int n){
        for(int i=0;i<n;i++){
            if(arr[i][jj] == num)
                return false;
        }
        for(int i=0;i<n;i++){
            if(arr[ii][i] == num)
                return false;
        }
        return true;
    }

    private void tracelist(ArrayList<int[]> al,int temp[],int i, int trace,int n){

        if(n==i && trace ==0){
            al.add(Arrays.copyOf(temp,n));
            return;
        }
        if(n==i || trace <=0){
            return;
        }

        int min = trace/(n-i);
        int max = trace-n+i+1;
        for(int j=min;j<=max;j++){
            temp[i] = j;
            tracelist(al,temp,i+1,trace-j,n);
        }

    }


}
