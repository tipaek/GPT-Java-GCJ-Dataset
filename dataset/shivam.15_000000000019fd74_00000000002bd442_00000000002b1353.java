
import java.util.*;
import java.io.*;
class Solution{
    static int a[][];
    static boolean visited[][];
    static ArrayList<String> result;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        a = new int[100][100];
        createPascal();
        
        for(int i=0;i<10;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
        
        for(int t_=1;t_<=t;t_++){
            int n = Integer.parseInt(br.readLine());
            System.out.println("Case #"+t_+":");
            visited = new boolean[100][100];
            result = new ArrayList<String>();
            if(n == 1) System.out.println("1 1");
            else getResult(0, 0, n, 0);
        }
    }
    
    public static boolean getResult(int i, int j, int n, int count){
        if(count>500 || n < 0 || i>=100 || j>i)
            return false;
        visited[i][j] = true;
        result.add((i+1)+" "+(j+1));
        if(n == 0){
            print();
            return true;
        }
        
        boolean res = false;
        if(!res && i-1>=0 && j-1>=0 && !visited[i-1][j-1]) res = getResult(i-1, j-1, n-a[i-1][j-1], count+1);
        if(!res && i-1>=0 && !visited[i-1][j]) res = getResult(i-1, j, n-a[i-1][j], count+1);
        if(!res && j-1>=0 && !visited[i][j-1]) res = getResult(i, j-1, n-a[i][j-1], count+1);
        if(!res && j+1<=i && !visited[i][j+1]) res = getResult(i, j+1, n-a[i][j+1], count+1);
        if(!res && i+1<100 && !visited[i+1][j]) res = getResult(i+1, j, n-a[i+1][j], count+1);
        if(!res && i+1<100 && !visited[i+1][j+1]) res = getResult(i+1, j+1, n-a[i+1][j+1], count+1);
        visited[i][j] = false;
        result.remove(result.size()-1);
        return res;
    }
    
    static void print(){
        for(String s:result)
            System.out.println(s);
    }
    
    public static void createPascal(){
        a[0][0] = 1;
        for(int i=0;i<100;i++){
            for(int j=0;j<i+1;j++){
                if(j == 0 || j == i)
                    a[i][j] = 1;
                else
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
    }
    
} 



