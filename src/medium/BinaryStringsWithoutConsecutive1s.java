package medium;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed/0/?ref=self
 */
public class BinaryStringsWithoutConsecutive1s
{
   static int MAX = 100;
   static double[] lookup = new double[MAX+1];
   static double mod = 1000000007; //Math.pow(10, 9)+7;

   private static void setupLookup(){
      lookup[0] = 1;
      lookup[1] = 2;
      lookup[2] = 3;

      for (int i=3; i<=MAX; ++i)
         lookup[i] = ((2*lookup[i-2]) + lookup[i-3])%mod;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      setupLookup();
      while (tests-- > 0){
         int N = in.nextInt();
         System.out.println((long)lookup[N]);
      }
   }
}
