import java.util.* ;
public class Solution{

    private static int dupR(int[][] arr){
        int r=0;
        for(int i=0;i<arr.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<arr[i].length;j++){
                if(set.contains(arr[i][j])){
                    r++;
                    break;
                }
                set.add(arr[i][j]);
            }
        }
        return r;
    }

    private static int dupC(int[][] arr){
        int c=0;
        for(int i=0;i<arr.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<arr[i].length;j++){
                if(set.contains(arr[j][i])){
                    c++;
                    break;
                }
                set.add(arr[j][i]);
            }
        }
        return c;
    }
    public static void main(String args[]){

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int q=1;q<=t;q++){
            int n =s.nextInt();
            int[][] a= new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=s.nextInt();
                    if(i==j)
                        trace += a[i][j];
                }
            }
            int r=dupR(a);
            int c=dupC(a);
            


        System.out.println("Case #"+q+": "+trace+" "+r+" "+c);
            
        }
    }
}