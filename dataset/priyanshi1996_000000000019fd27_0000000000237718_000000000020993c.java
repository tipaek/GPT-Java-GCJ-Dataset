import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int N = sc.nextInt();
            sc.nextLine();
            String[][] arr = new String[N][N];
            for(int i=0;i<N;i++){
                arr[i] =sc.nextLine().split(" ");
            }
            int row=0,col=0,trace=0;
            for(int i=0;i<N;i++){
                Set<String> setRow = new HashSet<String>();
                Set<String> setCol = new HashSet<String>();
                for(int j=0;j<N;j++){
                    setRow.add(arr[i][j]);
                    setCol.add(arr[j][i]);
                    if(i==j)
                        trace+=Integer.parseInt(arr[i][j]);
                }
                if(setRow.size()<N)
                    row++;
                if(setCol.size()<N)
                    col++;
            }
            System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
        }
    }
}