package medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes/0/?ref=self
 * TODO: Revisit
 */
public class MinCostOfRopes
{
   //O(N) space, O(NlogN) time GREEDY solution
   private static int getMinCostToCombineRopes2(int[] ropeLengths){
      if(ropeLengths == null || ropeLengths.length <= 1)
         return 0;

      int totalCost = 0;
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.stream(ropeLengths).boxed().collect(Collectors.toList()));
      while (minHeap.size() != 1){
         int rope1 = minHeap.poll(), rope2 = minHeap.poll();
         int cost = rope1 + rope2;
         totalCost+=cost;
         minHeap.add(cost);
      }
      return totalCost;
   }

   private static int getPartRopeLength(int[] cumRopeLength, int start, int end){
      if(start < 0 || end >= cumRopeLength.length)
         return -1;
      return start==0?cumRopeLength[end]:cumRopeLength[end]-cumRopeLength[start-1];
   }

   //O(N^2) space, O(N^3) time DP Solution
   private static int getMinCostToCombineRopes(int[] ropeLengths){
      if(ropeLengths == null || ropeLengths.length <= 1)
         return 0;

      int numRopes = ropeLengths.length;
      int[] cumRopeLength = new int[numRopes];
      int[][] minCost = new int[numRopes][numRopes];
      cumRopeLength[0] = ropeLengths[0];

      for(int i=1; i<numRopes; ++i)
         cumRopeLength[i] = cumRopeLength[i-1] + ropeLengths[i];

      for(int i=0; i<numRopes; ++i)
         minCost[i][i] = 0;

      for (int i=numRopes-2; i>=0; --i){
         for(int j=i+1; j<numRopes; ++j){
            int minC = Integer.MAX_VALUE, currCost = 0;
            for(int k=i; k<j; ++k){
               currCost = minCost[i][k] + minCost[k+1][j] + getPartRopeLength(cumRopeLength, i, k) + getPartRopeLength(cumRopeLength, k+1, j);
               minC = (minC>currCost)?currCost:minC;
            }
            minCost[i][j] = minC;
         }
      }
      return minCost[0][numRopes-1];
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int numRopes = in.nextInt();
         int[] ropeLengths = new int[numRopes];
         for(int i=0; i< numRopes; ++i)
            ropeLengths[i] = in.nextInt();
         System.out.println(getMinCostToCombineRopes2(ropeLengths));
      }
      in.close();
   }
}
