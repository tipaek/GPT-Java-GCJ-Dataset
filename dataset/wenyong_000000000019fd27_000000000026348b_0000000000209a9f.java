import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Solution{
    public static int r;
    public static int c;

    public static void main(String[] args){
        FastIO fio = new FastIO();
        int numberofcases = fio.nextInt();

        String open = "(";
        String close = ")";

        ArrayList<char[]> array = new ArrayList<>();
        
        for(int i=0; i<numberofcases; i++){
            String input = fio.nextLine();
            char[] temp = input.toCharArray();
            array.add(temp);
        }

        for(int i=0; i<numberofcases; i++){
            fio.print("Case #"+(i+1)+": ");
            int compare = Integer.parseInt(String.valueOf(array.get(i)[0]));
            //fio.println(compare);
            if(compare!=0){
                //fio.println("True");
                fio.print("(");
            }    
            char[] temp = array.get(i);
            int memory = 0;
            
            boolean closed = false;

            for(int j =0; j<temp.length; j++){
                
                boolean toprint = true;
                int num = Integer.parseInt(String.valueOf(temp[j]));

                if(closed==true && num==1){
                    fio.print("(");
                }

                try{
                    if(num==1 && temp[j+1]=="0".charAt(0)){
                    fio.print(num);
                    toprint = false;
                    fio.print(")");
                    closed = true;
                    }
                }
                catch(Exception e){
                    toprint = true;
                }
                

                if(num==memory && toprint==true){
                    fio.print(num);
                }
                else{
                    for(int l=0 ; l< num-1;l++){
                        fio.print("(");
                    }
                    if(toprint == true){
                        fio.print(num);
                    }
                    for(int m=0 ; m< num-1;m++){
                        fio.print(")");
                    }
                    memory = num;
                }
            }
            if(Integer.parseInt(String.valueOf(array.get(i)[array.get(i).length-1]))!=0){
                fio.print(")");
            }
            fio.println(); 
        }
        fio.close();
    }
}



class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

