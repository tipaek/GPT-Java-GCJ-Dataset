import java.io.*;
import java.util.*;
class Solution{
public static void main(String args[])throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int T = Integer.parseInt(br.readLine());
int z = 0;
while(T--!=0){
z++;
String str = "";
StringTokenizer str1 = new StringTokenizer(br.readLine());
long x = Long.parseLong(str1.nextToken());
long y = Long.parseLong(str1.nextToken());
long sum = Math.abs(x)+Math.abs(y);
long start_x = 0;
long start_y = 0;
if(sum%2 == 0){
System.out.println("Case #"+z+": IMPOSSIBLE");}
else{
    //long step = (sum/2)+1;
    //long step_copy = step;
    
    //for edge start
    if(x==0){
        long j=0;
        if(y>0){
            while(start_y!=y){
                str=str.concat("N");
                start_y = start_y + (long)Math.pow(2,j-1);
                j++;
            }
            System.out.println("Case #"+z+": "+str);
        }
        else if(y<0){
            while(start_y!=y){
                str=str.concat("S");
                start_y = start_y - (long)Math.pow(2,j-1);
                j++;
            }
            System.out.println("Case #"+z+": "+str);
        }
    }
    else if(y==0){
        long i=0;
        if(x>0){
            while(start_x!=x){
                str=str.concat("E");
                start_x = start_x + (long)Math.pow(2,i-1);
                i++;
            }
            System.out.println("Case #"+z+": "+str);
        }
        else if(x<0){
            while(start_x!=x){
                str=str.concat("W");
                start_x = start_x - (long)Math.pow(2,i-1);
                i++;
            }
            System.out.println("Case #"+z+": "+str);
        }
    }
    //for edge close
    
    //for diagonal start
    else if(diagonal(sum)){
        long i=0;
        long j=0;
        if(x>0){
            while(start_x!=x){
                str = str.concat("E");
                start_x = start_x + (long)Math.pow(2,i-1);
                i++;
            }
        }
        if(x<0){
            while(start_x!=x){
                str = str.concat("W");
                start_x = start_x - (long)Math.pow(2,i-1);
                i++;
            }
        }
        if(y>0){
            while(start_y!=y){
                str = str.concat("N");
                start_y = start_y + (long)Math.pow(2,j-1);
                j++;
            }
        }
         if(y<0){
            while(start_y!=y){
                str = str.concat("S");
                start_y = start_y - (long)Math.pow(2,j-1);
                i++;
            }
        }
        System.out.println("Case #"+z+": "+str);
    }
    //for diagonal end
    
    else{
        long p = nearestDiagonal(sum);
        long diff = p - sum;
        if(diff%2!=0){
            System.out.println("Case #"+z+": IMPOSSIBLE");
        }
        else{
            long m =diff/2;
        }
    }
         
    }
    
}
}

static boolean diagonal(long sum){
    long j = 0;
    for(long i=0; i<Long.MAX_VALUE;i++){
        j = j + (long)Math.pow(2,i);
        if(sum == j){
            return true;
        }
        else if(sum<j){
            return false;
        }
    }
        return false;
    }

static long nearestDiagonal(long sum){
    long j = 0;
    for(long i=0; i<Long.MAX_VALUE;i++){
        j = j + (long)Math.pow(2,i);
        if(sum <= j){
            break;
        }
    }
        return j;
    }

}
