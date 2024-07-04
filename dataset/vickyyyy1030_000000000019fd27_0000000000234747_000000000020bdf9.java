import java.util.*;

public class Solution {
    public static void main(String[] args){
        int T;
        int num=0;
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        while (T>0){
            T--;
            num++;
            int N;
            N=in.nextInt();
            int[][] se=new int[N][4];
            for(int i=0;i<N;i++){
                se[i][0]=in.nextInt();
                se[i][1]=in.nextInt();
                se[i][2]=i;
            }
            Arrays.sort(se, new Comparator<int[]>(){
                @Override
                public int compare(int[] t1, int[] t2){
                    return t1[0] - t2[0];
                }
            });
            StringBuilder s=new StringBuilder();
            int flag=0;
            int c=0;
            int j=0;
            for(int i=0;i<N;i++){
                if(c==0||c<=se[i][0]){
                    se[i][3]=1;
                    c=se[i][1];
                }
                else if(j==0||j<=se[i][0]){
                    se[i][3]=2;
                    j=se[i][1];
                }
                else {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                System.out.println("Case #"+num+": "+"IMPOSSIBLE");
            if(flag==0){
                Arrays.sort(se, new Comparator<int[]>(){
                    @Override
                    public int compare(int[] t1, int[] t2){
                        return t1[2] - t2[2];
                    }
                });
                for(int i=0;i<N;i++){
                    if(se[i][3]==1)
                        s.append('C');
                    else
                        s.append('J');
                }
                System.out.println("Case #"+num+": "+s);
            }
        }
    }
}

