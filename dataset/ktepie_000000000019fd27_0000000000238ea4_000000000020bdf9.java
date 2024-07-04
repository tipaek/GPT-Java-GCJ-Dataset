import java.util.*;
import java.io.*;

public class Sol{

  public static boolean hasPlace(int[] time,int start,int end){
    for(int i=start;i<=end-1;++i){
      if(time[i]==-1)return false;
    }
    return true;
  }

  


  public static void main(String[] args){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    
    in.close();

  }
}

