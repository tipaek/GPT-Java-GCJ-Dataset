import java.util.*;
import java.util.stream.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        for(int i=1;i<=T;i++){
            int nr=0,nc=0,n = sc.nextInt(),arr[][] = new int[n][n+1];
            long trace=0;
			boolean cflag[] = new boolean[n+1];
            for(int r = 0;r<n;r++){
                int temp[] = new int[n+1];
                boolean rflag = false;
                for(int j=0;j<n;j++){
                    int x = sc.nextInt();
                    if(r==j)trace+=x;
                    if(temp[x]!=0 && rflag == false){
                        nr++;
                        rflag = true;
                    }else temp[x] = 1;
                    if(arr[j][x]!=0 && cflag[j] == false){
                       //System.out.println("At "+r+" "+j);
					    nc++;
                        cflag[j] = true;
                    }else arr[j][x] = 1;
                }
            }
            ans.add(new String("Case #"+i+": "+trace+" "+nr+" "+nc));
        }
        ans.stream().forEach(s->System.out.println(s));
    }
}