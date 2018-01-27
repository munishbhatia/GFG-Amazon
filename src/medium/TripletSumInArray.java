package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/triplet-sum-in-array/0/?ref=self
 */
public class TripletSumInArray
{
   //O(n^2) time, O(1) space approach
   private static boolean tripletWithSumExistsNoExtraSpace(int[] arr, int expectedSum){
      Arrays.sort(arr);
      int size = arr.length;
      for(int i=0; i<size-2; ++i){
         int complement = expectedSum - arr[i];
         int lidx = i+1, ridx = size-1;
         while (lidx < ridx){
            if(arr[lidx]+arr[ridx] == complement)
               return true;
            else if(arr[lidx]+arr[ridx] < complement)
               ++lidx;
            else
               --ridx;
         }
      }
      return false;
   }

   //O(n^2) time, O(n) space approach
   private static boolean tripletWithSumExists(int[] arr, int expectedSum){
      Set<Integer> observedElems = new HashSet<>();
      int size = arr.length;

      observedElems.add(arr[0]);

      for(int i=1; i<size-1; ++i){
         for(int j=i+1; j<size; ++j){
            int complement = expectedSum - (arr[i] + arr[j]);
            if(observedElems.contains(complement))
               return true;
         }
         observedElems.add(arr[i]);
      }
      return false;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt(), expectedSum = in.nextInt();
         int[] arr = new int[size];
         for(int i=0; i<size; ++i)
            arr[i] = in.nextInt();
//         System.out.println(tripletWithSumExists(arr, expectedSum)?1:0);
         System.out.println(tripletWithSumExistsNoExtraSpace(arr, expectedSum)?1:0);
      }
   }
}
