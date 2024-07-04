import java.io.*;

class Solution{
    
    public static void main(String args[]){
        DataInputStream in = new DataInputStream(System.in);
        String Line = in.readLine();
        String a = Integer.parseInt(Line.trim());
        System.out.println(a);
    }
}