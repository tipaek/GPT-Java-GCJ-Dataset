import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_test_case = Integer.parseInt(br.readLine());
        for(int t = 1; t <= total_test_case; t++){
            String str = br.readLine();
            int array[] = new int[str.length()];
            for(int i = 0; i < array.length; i++) array[i] = Integer.parseInt(str.charAt(i)+"");
            StringBuilder st = new StringBuilder("");
            int flag=0;
            for(int i = 0; i < array.length; i++){
                if(array[i]<flag){
                    for(int j = 0; j < flag - array[i]; j++){
                        st.append(")");
                    }
                }else if(array[i]>flag){
                    for(int j = 0; j < array[i] - flag; j++){
                        st.append("(");
                    }
                }
                flag = array[i];
                st.append(array[i]);
            }
            while(flag-- >0){
                st.append(")");
            }
            System.out.println("Cae #"+t+": "+st.toString());

        }

    }
}
