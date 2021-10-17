package com.sasken.algo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class CodingWeeks {


  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    Reader rd = new Reader();
    int n = rd.nextInt();
    int result = 0;

    for (int i = 0; i < n; i++) {
      int val = rd.nextInt();
      max = Math.max(val, max);
      list.add(val);
    }

    LinkedHashSet<Integer> set = new LinkedHashSet<>();

    for (int i = 0; i < list.size(); i++) {
      int val = list.get(i);

      if (set.contains(val)) {
        while (set.contains(val)) {
          Iterator<Integer> it = set.iterator();
          it.next();
          it.remove();
        }
      }
      set.add(val);

      if (set.size() == max) {
        result++;
        set.clear();
      }


    }

    System.out.println(result);

  }
}
