import java.util.*;
import java.io.*;

public class Solution{


  public static void main(final String[] args){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for(int i=1;i<=t;++i){
      HashMap<Long,Integer> slices = new HashMap<Long,Integer>();
      int nSlice = in.nextInt();
      int nGuest = in.nextInt();
      for(int j=0;j<nSlice;++j){
        Long aang = in.nextLong();
        int cur = 0;
        if(slices.get(aang)!=null) cur = slices.get(aang);
        cur++;
        slices.put(aang,cur);
      }
      int max = 0;
      int mCur = 0 ;
      Long loc = 0L;
      for (Long l : slices.keySet()) {
        mCur = slices.get(l);
        if(max<mCur){
          max = mCur;
          loc = l;
        }
      }

      int result =  nGuest - slices.get(loc);
      if(result <= 0) System.out.println("Case #" + i + ": " + 0);
      else{
        System.out.println("Case #" + i + ": " + Math.abs(nSlice - nGuest));

          }
        }
      }
    }
