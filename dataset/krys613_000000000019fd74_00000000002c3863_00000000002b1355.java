
import java.util.*;

public class Solution {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc = 1; tc <= TC; tc++){
            //init for this test case
            int R = sc.nextInt();
            int C = sc.nextInt();
            int matrix[][] = new int[R][C];
            int sum = 0;
            //input
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    int cur = sc.nextInt();
                    matrix[i][j] = cur;
                    sum += cur;
                }
            }
            //calculate sum
            while(true){
                //init this round
                ArrayList<node> droplist = new ArrayList<node>();
                ArrayList<node> sumlist = new ArrayList<node>();
                //in this round
                for(int i = 0; i < R; i++){
                    for(int j = 0; j < C; j++){
                        //for each alive node
                        if(matrix[i][j] > 0){
                            //compare the score with neighbor
                            int neighborCount = 0;
                            int neighborSum = 0;
                            //find valid neighbor
                            //left
                            int left = j - 1;
                            while(left >= 0) {
                            	if(matrix[i][left] > 0) {
                            		neighborCount += 1;
                            		neighborSum += matrix[i][left];
                            		break;
                            	}
                            	left--;
                            }
                            //right
                            int right = j + 1;
                            while(right < C) {
                            	if(matrix[i][right] > 0) {
                            		neighborCount += 1;
                            		neighborSum += matrix[i][right];
                            		break;
                            	}
                            	right++;
                            }
                            //up
                            int up = i - 1;
                            while(up >= 0) {
                            	if(matrix[up][j] > 0) {
                            		neighborCount += 1;
                            		neighborSum += matrix[up][j];
                            		break;
                            	}
                            	up--;
                            }
                            //down
                            int down = i + 1;
                            while(down < R) {
                            	if(matrix[down][j] > 0) {
                            		neighborCount += 1;
                            		neighborSum += matrix[down][j];
                            		break;
                            	}
                            	down++;
                            }
                            
                            node cur  = new node(i,j);
                            if(neighborCount * matrix[i][j] >= neighborSum){
                                //win then update the sumlist
                                sumlist.add(cur);
                            }else{
                                //lose then update the droplist
                                droplist.add(cur);
                            }
                        }
                    }
                } 

                
                //after this round
                if(droplist.size() == 0){
                    //end when no one dropped
                    break;
                }else{
                    //mark the dropped and update the sum
                	for(node alive: sumlist) {
                		sum += matrix[alive.x][alive.y];
                	}
                    for(node drop : droplist){
                        matrix[drop.x][drop.y] = 0;
                    }
                }
            }
            
            //output
            System.out.println("Case #" + tc + ": " + sum);
        }
    }
}	
class node{
    int x;
    int y;
    public node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
