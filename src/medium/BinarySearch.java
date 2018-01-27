package medium; /***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/index-of-first-1-in-a-sorted-array-of-0s-and-1s/0
 */
public class BinarySearch
{
   private static int binarySearch(int[] arr, int left, int right, int key){
      if(left==right){
         if(arr[left] == key)
            return left;
         else
            return -1;
      }
      if(left<right){
         int mid = (left+right)/2;
         if(arr[mid] == key){
            int smallerIdx = binarySearch(arr, left, mid-1, key);
            if(smallerIdx == -1)
               return mid;
            else
               return smallerIdx;
         }
         else //(arr[mid] < key)
            return binarySearch(arr, mid+1, right, key);
      }
      else
         return -1;
   }

   private static int getFirstOneIndex(int[] arr){
      int size = arr.length;
      if(0 == size || 0 == arr[size-1])
         return -1;
      return binarySearch(arr, 0, size-1, 1);
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         int size = in.nextInt();
         int[] input = new int[size];
         for(int i=0; i<size; ++i){
            input[i] = in.nextInt();
         }
         System.out.println(getFirstOneIndex(input));
      }
   }
}
