package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {




  public static void main(String[] args) throws IOException {

    try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      final int t = Integer.parseInt(bufferedReader.readLine().trim());

      for (int i = 0; i<t; i++) {

        final int n = Integer.parseInt(bufferedReader.readLine().trim());

        long trace = 0;
        Map<Integer, Set<Integer>> colsSet = new HashMap<>();
        long r = 0;
        for (int j = 0; j<n; j++) {
          final List<Integer> collect =
              Arrays.stream(bufferedReader.readLine().trim().split(" ")).map(Integer::parseInt)
                  .collect(
                      Collectors.toList());
          trace += collect.get(j);

          if (new HashSet<>(collect).size() != n ) {
            r++;
          }

          for (int k =0; k < n; k++) {
            final Set<Integer> valsOnCol =
                colsSet.containsKey(k) ? colsSet.get(k) : new HashSet<Integer>();
            valsOnCol.add(collect.get(k));
            colsSet.put(k, valsOnCol);
          }
        }
        long c = 0;
        for (Set s : colsSet.values()) {
          if (s.size() != n ) {
            c++;
          }
        }

        System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);

      }

    }

  }
}
