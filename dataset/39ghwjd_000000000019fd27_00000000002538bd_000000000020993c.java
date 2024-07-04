import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for(int i = 0; i < a; i++){
            int b = input.nextInt();
            int[][] c = new int[b][b];
            int first = 0;
            for(int j = 0 ; j < b; j++){
                for(int k = 0 ; k < b; k++){
                    c[j][k] = input.nextInt();
                    if(j==k) {
                        first += c[j][k];
                    }
                }
            }
            
            int second = 0; 
            
            for(int z = 0 ; z < b; z++){
            	HashSet<Integer> check = new HashSet<Integer>();
            	for(int z1 = 0 ; z1 < b; z1++){
            		check.add(c[z][z1]);
            	}
            	if(check.size() != b){
            		second++;
            	}
            }
            
            int third = 0; 
        
            for(int z = 0 ; z < b; z++){
            	HashSet<Integer> checker = new HashSet<Integer>();
            	for(int z1 = 0 ; z1 < b; z1++){
            		checker.add(c[z1][z]);
            	}
            	if(checker.size() != b){
            		third++;
            	}
            }
            
            
            System.out.println("Case #"+(i+1)+": "+first 
            +" "+ second +" " + third);
            
        }
    }
}