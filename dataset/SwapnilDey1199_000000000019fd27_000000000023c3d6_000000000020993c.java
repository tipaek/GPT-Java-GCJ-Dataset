import java.util.*;
public class Solution{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int z = 1;
        while(t-->0){
            int n = sc.nextInt();
            int[][]arr=new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int trace = 0,r=0,c=0;
            for(int i = 0;i<n;i++){
                trace+=arr[i][i];
                Set<Integer> setR = new HashSet<>();
                Set<Integer> setC = new HashSet<>();
                boolean flagR = true,flagC = true;
                for(int j = 0;j<n;j++){
                    int a = arr[i][j];
                    int b = arr[j][i];
                    if(setR.contains(a)){
                        if(flagR){
                            r++;
                            flagR = false;
                        }
                    }
                    if(setC.contains(b)){
                        if(flagC){
                            c++;
                            flagC = false;
                        }
                    }
                    setR.add(a);
                    setC.add(b);
                }
            }
            System.out.println("Case #"+z+": "+trace+" "+r+" "+c);
            z++;
        }
    }
}