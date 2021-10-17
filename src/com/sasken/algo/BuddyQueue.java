package com.sasken.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class BuddyQueue {

  public static void addToMap(LinkedHashMap<Integer, LinkedList<Integer>> map, int key, int val) {
    if (!map.containsKey(key)) {
      map.put(key, new LinkedList<>(Arrays.asList(val)));
    } else {
      map.get(key).addLast(val);
    }
  }

  public static void main(String[] args) {
    LinkedHashMap<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
    Map<Integer, Integer> inpMap = new HashMap<>();
    LinkedList<Integer> result = new LinkedList<>();

    Reader rd = new Reader();
    int n = rd.nextInt();

    for (int i = 0; i < n; i++) {
      int k = rd.nextInt();
      for (int j = 0; j < k; j++) {
        inpMap.put(rd.nextInt(), i);
      }
    }

    boolean stop = false;

    while (!stop) {
      String op = rd.next();
      int val;
      switch (op) {
        case "ENQUEUE":
          val = rd.nextInt();
          addToMap(map, inpMap.get(val), val);
          break;

        case "DEQUEUE":
          result.addLast(printFirst(map));
          break;

        case "STOP":
          stop = true;
          break;

      }


    }
    // print result
    for (Integer out : result) {
      System.out.println(out);
    }

  }

  public static Integer printFirst(LinkedHashMap<Integer, LinkedList<Integer>> map) {
    Iterator<Entry<Integer, LinkedList<Integer>>> it = map.entrySet().iterator();
    if (it.hasNext()) {
      Entry<Integer, LinkedList<Integer>> entry = it.next();
      if (entry.getValue().size() > 1) {
        return entry.getValue().removeFirst();
      } else {
        int rt = entry.getValue().removeFirst();
        it.remove();
        return rt;
      }
    }

    return 0;
  }

}
