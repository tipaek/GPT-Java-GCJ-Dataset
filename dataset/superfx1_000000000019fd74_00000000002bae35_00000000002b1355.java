

import java.util.*;
import java.io.*;
public class Solution {
    static int interrestlevel;
    public static int[][] nextRound(int[][] in,int R,int C){
        int[][] advance=new int[R][C]; 
        for(int i =0;i<R;i++){
                for(int j=0;j<C;j++){
                    int sum=0;
                    double count=0.0;
                    int k=j-1;
                    while(k>=0){
                        if(in[i][k]!=0){
                            sum+=in[i][k];
                            count++;
                            break;
                        }
                        k--;
                    }
                    k=i-1;
                    while(k>=0){
                        if(in[k][j]!=0){
                            sum+=in[k][j];
                            count++;
                            break;
                        }
                        k--;
                    }
                    k=j+1;
                    while(k<C){
                        if(in[i][k]!=0){
                            sum+=in[i][k];
                            count++;
                            break;
                        }
                        k++;
                    }
                    k=i+1;
                    while(k<R){
                        if(in[k][j]!=0){
                            sum+=in[k][j];
                            count++;
                            break;
                        }
                        k++;
                    }
                    if(in[i][j]<sum/count)
                        advance[i][j]=0;
                    else advance[i][j]=in[i][j];
            }
        }
        return advance;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=input.nextInt();
        for(int t=0;t<T;t++){
            int R=input.nextInt();
            int C=input.nextInt();
            int[][] player=new int[R][C]; 
            interrestlevel=0;
            for(int i =0;i<R;i++){
                for(int j=0;j<C;j++){
                    player[i][j]=input.nextInt();
                }
                
            }
            int[][] oldplayer=new int[R][C];
            while(!Arrays.deepEquals(oldplayer,player)){
                for(int i =0;i<R;i++){
                for(int j=0;j<C;j++){
                    interrestlevel+=player[i][j];
                }    
            }
                oldplayer=player;
                player=nextRound(player,R,C);
                
            }
            
            
        System.out.println("Case #"+(t+1)+": "+interrestlevel);
        }
    }
    
}
