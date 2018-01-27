/***************************************************************************
 * COPYRIGHT (C) 2018, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package easy;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * TODO: Revisit
 */
public class DutchFlagPartition
{
   private static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   private static void partitionArray(int[] arr){
      int size = arr.length, lo = 0, mid = 0, high = size-1;
      while (mid<=high){
         if(arr[mid] == 0){
            swap(arr, lo, mid);
            ++lo; ++mid;
         }
         else if(arr[mid] == 2){
            swap(arr, mid, high);
            --high;
         }
         else
            ++mid;
      }
   }
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int size = in.nextInt();
         int[] arr = new int[size];
         for(int i=0; i<size; ++i)
            arr[i] = in.nextInt();
         partitionArray(arr);
         for(int elem:arr)
            System.out.print(elem + " ");
         System.out.println();
      }
   }
}
