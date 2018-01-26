/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/relative-sorting/0/?ref=self
 */
public class RelativeSorting
{
   //O(m) + O(n) extra space; O(m+n+nlogn) time => O(n) space, O(nlogn) time
   private static void sortArray(int[] primary, int[] aux){
      int idx = 0;
      List<Integer> nonCommon = new ArrayList<>();
      Map<Integer, Integer> itemCountMap = new HashMap<>();
      for(int i:aux)
         itemCountMap.put(i, 0);
      for(int i:primary){
         if(itemCountMap.containsKey(i))
            itemCountMap.replace(i, itemCountMap.get(i)+1);
         else
            nonCommon.add(i);
      }

      nonCommon.sort(null);

      for(int i:aux){
         int freq = itemCountMap.get(i);
         while (freq-- > 0)
            primary[idx++] = i;
      }
      for(Integer i:nonCommon)
         primary[idx++] = i;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int biggerArrSize = in.nextInt(), smallerArrSize = in.nextInt();
         int[] primaryArr = new int[biggerArrSize], auxArr = new int[smallerArrSize];
         for(int i=0; i<biggerArrSize; ++i)
            primaryArr[i] = in.nextInt();
         for(int i=0; i<smallerArrSize; ++i)
            auxArr[i] = in.nextInt();

         sortArray(primaryArr, auxArr);

         for(int i:primaryArr)
            System.out.print(i+" ");
         System.out.println();
      }
   }
}
