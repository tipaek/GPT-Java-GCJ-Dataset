import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

        public static void main(String[] args) {
                Scanner sc= new Scanner(System.in);
                byte test_cases = sc.nextByte();
                
                for(byte t=0;t<test_cases;t++) {
                        byte N = sc.nextByte();
                        
                        byte[][] mat = new byte[N][N];
                        
                        for(byte x= 0;x<N;x++) {
                                for(byte y=0;y<N;y++) {
                                        mat[x][y]=sc.nextByte();                                
                                        }
                        
                        }
                        
                        int k=0,c=0,r=0;
                        Set<Byte> set;
                        
                        for(byte i=0;i<N;i++) {
                                k+=mat[i][i];
                        }
                        
                        for(byte i=0;i<N;i++) {
                                 set= new HashSet<Byte>();
                                for(byte j=0;j<N;j++) {
                                        set.add(mat[i][j]);
                                }
                                if(set.size()<N) r++;
                        }
                        
                        for(byte i=0;i<N;i++) {
                                 set= new HashSet<Byte>();
                                for(byte j=0;j<N;j++) {
                                        set.add(mat[j][i]);
                                }
                                if(set.size()<N) c++;
                        }
                        System.out.println("Case #" + test_cases+1 + ": "+k+" "+r+" "+c);                        
                }
        }
}