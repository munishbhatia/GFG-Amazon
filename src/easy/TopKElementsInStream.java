/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

package easy;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://practice.geeksforgeeks.org/problems/top-k-numbers/0
 */
class HeapElement implements Comparable{
   private int value, frequency;

   public HeapElement(int value, int frequency)
   {
      this.value = value;
      this.frequency = frequency;
   }

   public int getValue()
   {
      return value;
   }

   public int getFrequency()
   {
      return frequency;
   }

   public void setFrequency(int frequency)
   {
      this.frequency = frequency;
   }

   @Override
   public int compareTo(Object o)
   {
      HeapElement object = (HeapElement)o;
      if(this.frequency == object.frequency)
         return this.value - object.value;
      else
         return object.frequency - this.frequency;
   }
}

public class TopKElementsInStream
{
   private static final int MAX_ELEM = 100;
   private static void printTopK(int[] stream, int K){
      HeapElement[] frequencyMap = new HeapElement[MAX_ELEM+1];
      NavigableSet<HeapElement> sortedSet = new TreeSet<>();

      for (int curr:stream){
         HeapElement element = frequencyMap[curr]==null?new HeapElement(curr, 1):frequencyMap[curr];
         if(frequencyMap[curr] != null) {
            sortedSet.remove(frequencyMap[curr]);
            element.setFrequency(element.getFrequency() + 1);
         }
         else
            frequencyMap[curr] = element;
         sortedSet.add(element);
         Iterator<HeapElement> listIter = sortedSet.iterator();
         int i=0;
         while (listIter.hasNext() && i++ < K){
            System.out.print(listIter.next().getValue() + " ");
         }
      }
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int N = in.nextInt(), K = in.nextInt();
         int[] arr = new int[N];
         for (int i=0; i<N; ++i)
            arr[i] = in.nextInt();
         printTopK(arr, K);
         System.out.println();
      }
   }
}
