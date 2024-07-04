
import java.util.*;
import java.io.*;

class vestigium {

    static Scanner in;
    static PrintWriter out;

    static int T, N;
    static int[][] box;
    
    public static void main(String[] args) throws IOException {
		
        in = new Scanner(new File("vestigium.in"));
        
        T = Integer.parseInt(in.nextLine());
        for(int i = 1; i <= T; i++) {

            try {

                init();
                System.out.print("Case #" + i +  ": ");
                solve();

            }catch(Exception e) {
                e.printStackTrace();
            }

        }
        in.close();
	}

    static void init() {
        N = Integer.parseInt(in.nextLine());
        box = new int[N][N];

        int row = 0;
        int col = 0;
        for(int i = 0; i < N; i++) {
            String[] split = (in.nextLine()).split(" ");
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(split[i]);
                box[row][col] = num;
                col++;
            }
            row++;
            col = 0;
        }
    }

    static String solve() {
        String result = "";

        int k = 0;
        int r = 0;
        int c = 0;

        for(int i = 0; i < N; i++) {
            k += box[i][i];
        }
        
        for(int row = 0; row < box.length; row++) {
            for(int col = 0; col < box[0].length; col++) {
                int num = box[row][col];
                boolean dupe = true;
                for(int ocol = col + 1; ocol < box.length && dupe; ocol++) {
                    if(num != box[row][ocol]) {
                        r++;
                        dupe = false;
                    }
                }
            }
        }

        for(int row = 0; row < box.length; row++) {
            for(int col = 0; col < box[0].length; col++) {
                int num = box[row][col];
                boolean dupe = true;
                for(int orow = row + 1; orow < box.length && dupe; orow++) {
                    if(num != box[orow][col]) {
                        c++;
                        dupe = false;
                    }
                }
            }
        }
        System.out.println(k + " " + r + " " + c);
        return result;
    }
}
