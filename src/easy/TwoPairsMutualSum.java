/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/sum-equals-to-sum/0/?ref=self
 */
class Pair{
   private int x,y;

   public Pair(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public int getX()
   {
      return x;
   }

   public int getY()
   {
      return y;
   }
}
public class TwoPairsMutualSum
{
   private static boolean pairsWithMutualSumExist(int[] arr){
//      if(arr.length < 4)
//         return false;
//      Arrays.sort(arr);
//      int lidx = 0, ridx = arr.length-1, midlidx = arr.length/2, midridx=midlidx+1;
//      while (lidx<arr.length/2 && ridx>arr.length/2+1) {
//         int lidxCopy = lidx, ridxCopy = ridx;
//         while (lidxCopy < midlidx && ridx > midridx) {
//            if (arr[lidxCopy] + arr[ridxCopy] == arr[midlidx] + arr[midridx])
//               return true;
//            else if (arr[lidxCopy] + arr[ridxCopy] < arr[midlidx] + arr[midridx])
//               --midlidx;
//            else
//               ++midridx;
//         }
//         midlidx = arr.length/2; midridx=midlidx+1; ++lidx; --ridx;
//      }
//      return false;
      int length = arr.length;
      Map<Integer, Pair> sumPairMap = new HashMap<>();
      for (int i=0; i<length-1; ++i){
         for(int j=i+1; j<length; ++j){
            int sum = arr[i]+arr[j];
            if(sumPairMap.containsKey(sum)){
               Pair prev = sumPairMap.get(sum);
               if(prev.getX() != i && prev.getX() != j && prev.getY() != i && prev.getY() != j)
                  return true;
            }
            else
               sumPairMap.put(sum, new Pair(i, j));
         }
      }
      return false;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while (tests-- > 0){
         int N = in.nextInt();
         int[] arr = new int[N];
         for(int i=0; i<N; ++i)
            arr[i] = in.nextInt();
         System.out.println(pairsWithMutualSumExist(arr)?1:0);
      }
   }
}
