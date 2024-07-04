import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(buffReader.readLine());
            for(int cases = 1; cases <= num; cases++) {
                String content = buffReader.readLine();
                StringBuilder sb = new StringBuilder();
                int remove = 0;
                int i = 0;
                while(i < content.length()) {
                    int current = Character.getNumericValue(content.charAt(i));
                    int j = 0;
                    while(j < current) {
                        int index = sb.length() - 1;
                        if(index < 0 || sb.charAt(index) != ')') {
                            break;
                        } else {
                            sb.deleteCharAt(index);
                        }
                        j++;
                    }
                    int toAdd = current - remove ;
                    if(toAdd > 0) {
                        j = 0;
                        while(j < toAdd) {
                            sb.append('(');
                            j++;
                        }
                    }
                    sb.append(current);
                    j = 0;
                    while(j < current) {
                        sb.append(')');
                        j++;
                    }
        
                    i++;
                    remove = current;
                }
        
                System.out.println("Case #" + cases + ": " + sb.toString());
            }
        } catch (Exception e) {
            
        }
    }

}