import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for (int i=0;i<t;i++){
            int n=s.nextInt();
            int[][] m=new int[n][n];
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    m[x][y]=s.nextInt();
                }
            }int x=i+1;
            int k=0;
            for(int e=0;e<n;e++){
                k+=m[e][e];
            }
            int r=0;
            for(int a=0;a<n;a++){
                HashSet<Integer> set=new HashSet();
                for(int b=0;b<n;b++){
                    if(set.contains(m[a][b])){
                        r+=1;
                        break;
                    }set.add(m[a][b]);
                }
            }
            int c=0;
            for(int a=0;a<n;a++){
                HashSet<Integer> set=new HashSet();
                for(int b=0;b<n;b++){
                    if(set.contains(m[b][a])){
                        c+=1;
                        break;
                    }set.add(m[b][a]);
                }
            }

            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        }
    }
}