import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
import java.util.HashMap;


public class Solution {


  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t1 = Integer.parseInt(br.readLine());

    for (int t = 0; t < t1; ++t) {
      int n = Integer.parseInt(br.readLine());
      int arr[][]=new int[n][n];
      int sum=0;
      int row=0,col=0;
      for(int i=0;i<n;++i)
      {
        HashMap<Integer,Integer> hm=new HashMap<>();
        String s1[]=br.readLine().trim().split(" ");
        int flag=0;
        for(int j=0;j<n;++j)
        {
          int k=Integer.parseInt(s1[j]);
          arr[i][j]=k;
          if(j==i)
            sum+=k;
          if(hm.get(k)==null)
            hm.put(k,1);
          else
            if(flag==0)
            {++row;flag=1;}
        }
      }
      for (int i=0;i<n;++i)
      {
        HashMap<Integer,Integer> hm1=new HashMap<>();
        for (int j=0;j<n;++j)
        {
          if (hm1.get(arr[j][i]) == null) {
            hm1.put(arr[j][i],1);
          }
          else
          {
            ++col;
            break;
          }
        }

      }
      System.out.println("Case #"+(t+1)+": "+sum+" "+row+" "+col);

    }


  }
}