import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int sum=0,r=0,c=0;
        for(int x=0;x<T;x++){
            int N=sc.nextInt();
            int n[][]=new int[N][N];
            for(int y=0;y<N;y++){
                for(int z=0;z<N;z++){
                    n[y][z]=sc.nextInt();
                    if(y==z)
                        sum=sum+n[y][z];
                }
            }
            for(int y=0;y<N;y++){
                for(int z=0;z<N;z++){
                    int n1=n[y][z];
                    for(int z1=z+1;z1<N;z1++){
                        if(n1==n[y][z1]){
                            r++;
                        }
                    }
                    for(int y1=y+1;y1<N;y1++){
                        if(n1==n[y1][z]){
                            c++;
                        }
                    }
                }
            }
            System.out.println("Case #"+x+": "+sum+" "+r+" "+c);
        }
    }
}
