package medium;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/sum-of-query-ii/0/?ref=self
 */
public class SumOfQuery2
{
   private static void resolveQueries(int[] arr, int queryCount, Scanner in){
      int len = arr.length;
      long[] sums = new long[len];
      sums[0] = arr[0];

      for(int i=1; i<len; ++i)
         sums[i] = sums[i-1] + arr[i];

      while (queryCount-- > 0){
         int left = in.nextInt()-1, right = in.nextInt()-1;
         long prevSum = (left-1 < 0)?0:sums[left-1];
         System.out.print(sums[right]-prevSum + " ");
      }
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt(), queryCount;
         int[] arr = new int[size];
         for(int i=0; i< size; ++i)
            arr[i] = in.nextInt();
         queryCount = in.nextInt();
         resolveQueries(arr, queryCount, in);
         System.out.println();
      }
      in.close();
   }
}
