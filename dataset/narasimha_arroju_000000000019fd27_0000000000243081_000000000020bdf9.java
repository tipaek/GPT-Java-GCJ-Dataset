import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),t1=0;
        while(t1++<t){
            int n=sc.nextInt();
            int[][] a=new int[n][2];
            String s="";
            for(int i=0;i<n;i++){
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
            }
            ArrayList<Integer> ca=new ArrayList<Integer>(),ja=new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                if(!ja.contains(a[i][0]+1) && !ja.contains(a[i][1])){
                    for(int j=a[i][0];j<=a[i][1];j++)
                        ja.add(j);
                    s+="J";
                }
                else if(!ca.contains(a[i][0]+1) && !ca.contains(a[i][1])){
                    for(int j=a[i][0];j<=a[i][1];j++)
                        ca.add(j);
                    s+="C";
                }
                else{
                    s="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+t1+": "+s);
        }
    }
}