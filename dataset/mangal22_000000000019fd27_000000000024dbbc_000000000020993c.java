import java.util.*;
 class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            int m=sc.nextInt();
            int[][] a=new int[m][m];
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    a[j][k]=sc.nextInt();
                }
            }
            int row=findRow(a);
            int col=findCol(a);
            int trace=findTrace(a);
            li.add(("Case #"+(i+1)+": "+trace+" "+row+" "+col));
        }
        for(int i=0;i<n;i++){
            System.out.println(li.get(i));
        }
    }
    static int findRow(int[][] a){
        int count=0;
        for(int i=0;i<a.length;i++){
          Set<Integer> hs=new HashSet<>();
            for(int j=0;j<a.length;j++){
                if(hs.contains(a[i][j])){
                    count++;
                    break;
                }
                hs.add(a[i][j]);
            }
        }
        return count;
    }
     static int findCol(int[][] a){
        int count=0;
        for(int i=0;i<a.length;i++){
          Set<Integer> hs=new HashSet<>();
            for(int j=0;j<a.length;j++){
                if(hs.contains(a[j][i])){
                    count++;
                    break;
                }
                hs.add(a[j][i]);
            }
        }
        return count;
    }
     static int findTrace(int[][] a){
        int sum=0;
        for(int i=0;i<a.length;i++){
         sum+=a[i][i];
        }
        return sum;
    }
}