import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int t=s.nextInt();
        int n;
        int sum=0,row=0,col=0;
        int [][]m;
        for(int i=0;i<t;i++){
            n=s.nextInt();
            m=new int[n][n];
            for(int j=0;j<n;j++)
            for(int k=0;k<n;k++)
                m[j][k]=s.nextInt();
            sum=0; 
            for(int j=0;j<n;j++)
             sum+=m[j][j];
            row=0;
            for(int j=0;j<n;j++){
            HashSet<Integer> hs = new HashSet<>(); 
            for(int k=0;k<n;k++){
            hs.add(m[j][k]);
            }
            if(hs.size()<n)
              row++;
            }
            col=0;
            for(int j=0;j<n;j++){
            HashSet<Integer> hh = new HashSet<>(); 
            for(int k=0;k<n;k++){
            hh.add(m[k][j]);
            }
            if(hh.size()<n)
              col++;
            }
            System.out.println("Case #"+(i+1)+": "
            +sum+" "+row+" "+col);
            
        }
        s.close();
    }
}