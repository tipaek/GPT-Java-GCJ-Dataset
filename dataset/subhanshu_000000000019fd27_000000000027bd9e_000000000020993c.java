import java.util.*;
public class vestigium{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        vestigium v = new vestigium();
        int t = s.nextInt();
        for(int i =0;i<t;i++){
            int n = s.nextInt();
            int sum=0;
            int a[][]=new int [n][n];
            for (int r = 0 ; r<n;r++){
                for(int c =0 ;c<n;c++){
                    a[r][c]=s.nextInt();
                    if(r==c)
                    sum+=a[r][c];
                }
            }
            int cr=0,cc=0;
            for(int x=0;x<n;x++){
                int r=0,c=0;
                for(int y=0;y<n;y++){
                for(int z=0;z<n;z++)
                {
                    if(a[x][y]==a[x][z]&&r!=1){
                    r++;cr++;}
                    if(a[y][x]==a[z][y]&&c!=1){
                    c++;cc++;}
                }
                }
                }
            System.out.println("Case #"+i+": "+sum+" "+cr+" "+cc);
        }
        s.close();
    }
}