import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        int cs=1;
        while(t-->0){
            int n=in.nextInt();
            int[][] a=new int[n][n];
            for(int i=0;i<n;i++)for(int j=0;j<n;j++)a[i][j]=in.nextInt();
            int[] map1=new int[n];
            int[] map2=new int[n];
            for(int i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    if(j==0)hs.add(a[i][j]);
                    else if(hs.contains(a[i][j])){
                        map1[i]=1;
                        break;
                    }
                    hs.add(a[i][j]);
                }
            }
            for(int i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    if(j==0)hs.add(a[j][i]);
                    else if(hs.contains(a[j][i])){
                        map2[i]=1;
                        break;
                    }
                    hs.add(a[j][i]);
                }
            }
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=a[i][i];
            }
            int r=0,c=0;
            for(int i=0;i<n;i++){
                if(map1[i]==1)r+=1;
                if(map2[i]==1)c+=1;
            }
            System.out.println("Case #"+cs+": "+sum+" "+r+" "+c);
            cs+=1;
        }
    }
}