import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=1; t<=tc; t++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            int dR = 0, dC = 0;
            for(int i=0; i<n; i++){
                BitSet r = new BitSet();
                for(int j=0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                    r.set(arr[i][j]);
                    if(i==j) trace+=arr[i][j];
                }
                boolean allOn = true;
                for(int j=1; j<=n; j++) allOn&=r.get(j);
                if(!allOn) dR++;
            }
            for(int i=0; i<n; i++){
                BitSet c = new BitSet();
                for(int j=0; j<n; j++) c.set(arr[j][i]);
                boolean allOn = true;
                for(int j=1; j<=n; j++) allOn&=c.get(j);
                if(!allOn) dC++;
            }
            System.out.println("Case #"+t+": "+trace+" "+dR+" "+dC);
        }
    }
}