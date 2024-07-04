import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=1;
        ArrayList<String> ans = new ArrayList<String>();
        while(k<=t){
            int N = sc.nextInt();
            int temp[][] = new int[N][N];
            int trace = 0;
            int row = 0, col=0;
            for(int i=0; i<N; ++i){
                for(int j=0; j<N; ++j){
                    temp[i][j] = sc.nextInt();
                    if(i==j)
                        trace = trace + temp[i][j];
                }
            }

            for(int i=0; i<N; ++i){
                HashSet<Integer> hr = new HashSet<Integer>();
                HashSet<Integer> hc = new HashSet<Integer>();
                for(int j=0; j<N; ++j){
                    hr.add(temp[i][j]);
                    hc.add(temp[j][i]);
                }
                if(hr.size()!=N)
                    row++;
                if(hc.size()!=N)
                    col++;
            }
            ans.add(new String("Case #"+k+": "+trace+" "+row+" "+col));
            //System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
            k++;
        }
        for(int i=0;i <t ; ++i)
        {
            System.out.println(ans.get(i));
        }
        sc.close();
    }
}