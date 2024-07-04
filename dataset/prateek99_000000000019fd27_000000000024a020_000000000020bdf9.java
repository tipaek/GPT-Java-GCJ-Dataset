import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t1 = sc.nextInt();
        sc.nextLine();
        int count=0;
        while(++count<=t1){
            int n=sc.nextInt();
            int t[][]=new int[n][4];
            for(int i=0;i<n;i++){
                t[i][0]=sc.nextInt();
                t[i][1]=sc.nextInt();
                t[i][2]=i;
            }
            Arrays.sort(t, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0]==b[0]) return a[1]-b[1];
                    return a[0]-b[0];
                }
            });
            
            int endC = -1, endJ = -1;
            int i=0;
            for(;i<n;i++){
                if(t[i][0]>=endC){
                    endC = t[i][1];
                    t[i][3] = 1;//1 for C, 2 for J
                }
                else if(t[i][0]>=endJ){
                    endJ = t[i][1];
                    t[i][3] = 2;//1 for C, 2 for J
                }
                else break;
            }
            String f = "";
            if(i==n){
                Arrays.sort(t, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b){
                        return a[2]-b[2];
                    }
                });
                for(int a[]:t){
                    if(a[3]==1) f+="C";
                    else f+="J";
                }
            }
            else{
                f = "IMPOSSIBLE";
            }
            System.out.print("Case #"+count+": "+f+"\n");
        }
    }
}