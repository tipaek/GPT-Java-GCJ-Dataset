import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        String[][] mat=new String[100][100];
        List<String> col=new ArrayList<>();
        for(int i=1;i<=t;i++){
            int n=Integer.parseInt(reader.readLine());
            for(int j=0;j<n;j++){
                mat[j]=reader.readLine().trim().split(" ");
            }
            int k=0;
            int r=0;
            int c=0;
                for(int j=0;j<n;j++) {
                    k += Integer.parseInt(mat[j][j]);
                    if ((Arrays.asList(mat[j]).stream().distinct().count() - n) != 0) r++;
                    for (int p = 0; p < n; p++) {
                        col.add(mat[p][j]);
                    }
                    if ((col.stream().distinct().count() - n) != 0) c++;
                    col.clear();
                }
                System.out.println("Case #"+i+": "+k+" "+r+" "+c);
            }

        }
    }

