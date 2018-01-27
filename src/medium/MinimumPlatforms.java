/***************************************************************************
 * COPYRIGHT (C) 2018, Rapid7 LLC, Boston, MA, USA.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Rapid7.
 **************************************************************************/

package medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/kilobyte-uz-contest1/challenges/trains-and-platforms/problem
 * https://practice.geeksforgeeks.org/problems/minimum-platforms/0/?ref=self
 */

public class MinimumPlatforms
{
   private static int getMinNumOfPlatforms(int[] arrivals, int[] departures){
      int len = arrivals.length, availPlatforms = 0, maxPlatforms = 1, aidx = 1, didx = 0;
      Arrays.sort(arrivals);
      Arrays.sort(departures);

      while (aidx < len && didx < len){
         if(departures[didx] <= arrivals[aidx]){
            ++availPlatforms;
            ++didx;
         }
         else{
            if(availPlatforms == 0)
               ++maxPlatforms;
            else
               --availPlatforms;
            ++aidx;
         }
      }
      return maxPlatforms;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int N = in.nextInt();
      int[] arrivals = new int[N], departures = new int[N];
      for(int i=0; i<N; ++i){
         arrivals[i] = in.nextInt();
         departures[i] = in.nextInt();
      }
      System.out.println(getMinNumOfPlatforms(arrivals, departures));
   }
}
