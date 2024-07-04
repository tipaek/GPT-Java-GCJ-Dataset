import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),t1=0;
        while(t1++<t){
            int n=sc.nextInt();
            int[][] a=new int[n][4];
            String s="";
            for(int i=0;i<n;i++){
                a[i][0]=i;
                a[i][1]=sc.nextInt();
                a[i][2]=sc.nextInt();
                a[i][3]=-1;
            }
            Arrays.sort(a,new Comparator<int[]>() {
                public int compare(final int[] entry1,final int[] entry2){
                    if (entry1[1] > entry2[1])
                        return 1; 
                    else
                        return -1; 
                }
            });
            ArrayList<Integer> ca=new ArrayList<Integer>(),ja=new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                if(!ca.contains(a[i][1]+1) && !ca.contains(a[i][2])){
                    for(int j=a[i][1];j<=a[i][2];j++)
                        ca.add(j);
                    a[i][3]=0;
                }
                else if(!ja.contains(a[i][1]+1) && !ja.contains(a[i][2])){
                    for(int j=a[i][1];j<=a[i][2];j++)
                        ja.add(j);
                    a[i][3]=1;
                }
                else{
                    s="IMPOSSIBLE";
                    break;
                }
            }
            if(s==""){
                Arrays.sort(a,new Comparator<int[]>() {
                    public int compare(final int[] entry1,final int[] entry2){
                        if (entry1[0] > entry2[0])
                            return 1; 
                        else
                            return -1; 
                    }
                });
                for(int i=0;i<n;i++)
                    s+=a[i][3]==0?"C":"J";
            }
            System.out.println("Case #"+t1+": "+s);
        }
    }
}