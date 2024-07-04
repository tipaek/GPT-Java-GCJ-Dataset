import java.util.*;
class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> res = new ArrayList<>();
        int n = sc.nextInt();
        for(int k=0;k<n;k++){
            int m = sc.nextInt();
            int arr[][]=new int[m][m];
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            res.add(getValue(arr,m,k));
        }
        for(int i=0;i<n;i++){
            System.out.println(res.get(i));
        }
    }
    public static String getValue(int[][] arr,int m,int q){
        int count=0,rows_count=0,col_count=0;
        for(int i=0;i<m;i++){
            count+=arr[i][i];
        }
        for(int i=0;i<m;i++){
            ArrayList<Integer> ar = new ArrayList<Integer>();
            for(int j=0;j<m;j++){
                if(!ar.contains(arr[i][j])){
                    ar.add(arr[i][j]);
                }
            }
            if(ar.size()!=m){
                rows_count++;
            }
        }
        for(int i=0;i<m;i++){
            ArrayList<Integer> ac = new ArrayList<Integer>();
            for(int j=0;j<m;j++){
                if(!ac.contains(arr[j][i])){
                    ac.add(arr[j][i]);
                }
            }
            if(ac.size()!=m){
                col_count++;
            }
        }
       return ("Case #"+q+": "+count+" "+rows_count+" "+col_count);
    }
}