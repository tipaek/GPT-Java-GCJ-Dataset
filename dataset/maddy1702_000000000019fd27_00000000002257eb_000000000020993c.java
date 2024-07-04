package com.jackson;

import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
    private static int getBit(int num, int i){
        return (num>>i) & 1 ;
    }


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        PrintWriter writer =  null ;
        FileReader reader = null;
        try{
            System.out.println("Working Directory = " +  System.getProperty("user.dir"));
//            reader = new FileReader("input");
            reader = new FileReader("a-input");
//			reader = new FileReader("B-small-practice.in");
//			reader = new FileReader("B-large-practice.in");

            writer = new PrintWriter("small-out.txt", "UTF-8");
//			writer = new PrintWriter("large-out.txt", "UTF-8");
        }catch(Exception e){

        }

        Scanner input = new Scanner(reader);

        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++)
        {
            int N = input.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++){
                    matrix[i][j] = input.nextInt();
                }
            }

            String result = solveA(matrix);
            System.out.println("Case #"+ (n+1) + ": " + result) ;
            writer.println("Case #"+ (n+1) + ": " + result) ;


        }
        if(writer !=null){
            writer.close();
        }
        if(reader !=null){
            try{
                reader.close();
            }catch(Exception e){
                System.out.println(e.toString()) ;
            }
        }
        if(input !=null){
            input.close();
        }
    }

    String solveA(int[][] matrix) {
        String result = "";
        int N = matrix.length;
        int k = 0  , r = 0 , c = 0;

        for (int i = 0 ; i < N ; i++) {
            k += matrix[i][i];
            Set<Integer> sets = new HashSet<>();
            for (int j = 0 ; j < N ; j++){
                if (sets.contains(matrix[i][j])) {
                    r++;
                    break;
                }
                sets.add(matrix[i][j]);
            }
            sets.clear();
            for (int j = 0 ; j < N ; j++){
                if (sets.contains(matrix[j][i])) {
                    c++;
                    break;
                }
                sets.add(matrix[j][i]);
            }
        }
        result = String.format("%d %d %d", k, r, c);

        return result;
    }

    String GCJ2019AForegoneSolution(int N) {

        return String.valueOf(N);
    }

    static final double MAX = 1e15;
    String solve(){
        long max = (long)MAX;
        List<String> strings = new ArrayList<>(Arrays.asList("foo", "bar", "baz"));
        List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3));
        ints.add(6);
        ints.add(5);
        Collections.sort(ints, Collections.reverseOrder());

        TreeSet<Integer> sets = new TreeSet<>(Collections.reverseOrder());
        sets.add(6);
        sets.add(7);
        sets.add(4);
        sets.add(8);
        sets.add(1);

        System.out.println(sets.pollFirst()) ;
        System.out.println(sets.pollFirst()) ;



        return "" ;
    }

}