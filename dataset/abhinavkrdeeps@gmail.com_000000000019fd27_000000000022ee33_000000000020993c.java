import java.util.*;
 class Vestigium {
    public static int trace(int a[][],int n){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) {
                    sum = sum + a[i][j];
                }
            }
        }
        return sum;
    }
    public static boolean checkDuplicatesRow(int a[][],int i,int n){
        HashSet<Integer> set = new HashSet<>();
        for(int j=0;j<n;j++){

            if(set.contains(a[i][j]))
                return true;
            else
                set.add(a[i][j]);
        }
        return false;
    }
    public static boolean checkDuplicatesColumn(int a[][],int i,int n){
        HashSet<Integer> set = new HashSet<>();
        for(int j=0;j<n;j++){

            if(set.contains(a[j][i]))
                return true;
            else
                set.add(a[j][i]);
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int p=1;
        while(t>0){
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            int k = trace(a,n);
            int r=0;
            int c=0;
            for(int i=0;i<n;i++){
                if(checkDuplicatesRow(a,i,n)){
                    r=r+1;
                }
                if(checkDuplicatesColumn(a,i,n)){
                    c=c+1;
                }
            }
            System.out.println("case #"+p+": "+k+" "+r+" "+c);
            t--;
            p++;

        }
    }
}
