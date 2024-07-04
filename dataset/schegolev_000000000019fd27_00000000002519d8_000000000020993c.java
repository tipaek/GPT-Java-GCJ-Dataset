package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        call(T);
    }

    static void call(int T) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < T; ++i) {
            int N = Integer.parseInt(reader.readLine());
            System.out.println("Case #" + i + ": " +  task(N));
        }
    }

    static String task (int N) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int track = 0, row = 0, column = 0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            int j = 0;
            String s = reader.readLine();
            for (String str : s.split(" ")) {

                list.add(Integer.parseInt(str));
                if (i == j)
                    track += list.get(list.size() - 1);
                ++j;
            }
            arrayLists.add(list);
            list = new ArrayList<>();
        }


        for (int i = 0; i < N; ++i) {
            ArrayList<Integer> tmp = arrayLists.get(i);
            row += info(tmp, N);
        }

        for (int i = 0; i < N; ++i) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < N; ++j) {
                tmp.add(arrayLists.get(j).get(i));
            }
            column += info(tmp, N);
        }

        String s = track + " " + row + " " + column;
        return s;
    }

    static int info(ArrayList<Integer> tmp, int N) {
        for (int j = 0; j < N - 1; ++j) {
            for (int k = j + 1; k < N; ++k) {
                if (tmp.get(j) == tmp.get(k)) {
                    return 1;
                }
            }
        }
        return 0;
    }

}
