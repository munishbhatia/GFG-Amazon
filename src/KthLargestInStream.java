/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import sun.awt.datatransfer.DataTransferer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0/?ref=self
 */
public class KthLargestInStream
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int k = in.nextInt(), size = in.nextInt();
         PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
               return o1 - o2;
            }
         });

         for(int i=0; i<size; ++i){
            int currElem = in.nextInt();
            if(minHeap.size() < k)
               minHeap.add(currElem);
            else{
               if(currElem > minHeap.peek()){
                  minHeap.poll();
                  minHeap.add(currElem);
               }
            }
            if(minHeap.size() < k)
               System.out.print(-1 + " ");
            else
               System.out.print(minHeap.peek() + " ");
         }
         System.out.println();
      }
   }
}