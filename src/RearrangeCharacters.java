/***************************************************************************
 * COPYRIGHT (C) 2018, Munish Bhatia.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Munish Bhatia.
 **************************************************************************/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/rearrange-characters/0
 */

class FrequencyTableElem{
   private char value;
   private int frequency;

   public FrequencyTableElem(char value, int frequency)
   {
      this.value = value;
      this.frequency = frequency;
   }

   public char getValue()
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
}

public class RearrangeCharacters
{
   private static boolean rearrangeCharacters(String string){
      int length = string.length(), ALPHABET_SIZE = 26, currIdx = 0;
      FrequencyTableElem[] frequency = new FrequencyTableElem[ALPHABET_SIZE];
      char[] output = new char[length];

      for(int i=0; i<length; ++i){
         if(null == frequency[string.charAt(i)-'a'])
            frequency[string.charAt(i)-'a'] = new FrequencyTableElem(string.charAt(i), 1);
         else{
            int currFreq = frequency[string.charAt(i)-'a'].getFrequency();
            frequency[string.charAt(i)-'a'].setFrequency(currFreq+1);
         }
      }

      Arrays.sort(frequency, new Comparator<FrequencyTableElem>()
      {
         @Override
         public int compare(FrequencyTableElem o1, FrequencyTableElem o2)
         {
            if(null == o1 && null == o2)
               return 0;
            if(null == o1)
               return 1;
            if(null == o2)
               return -1;
            return o2.getFrequency() - o1.getFrequency();
         }
      });

      for(int i=0; i<ALPHABET_SIZE; ++i) {
         FrequencyTableElem currElem = frequency[i];
         if (null != currElem && currElem.getFrequency() != 0)
         {
            int freq = currElem.getFrequency();
            int spacing = length / currElem.getFrequency();
            if (currElem.getFrequency() > Math.ceil(length / 2.0))
               return false;
            int j = 0;
            while (currIdx<length && output[currIdx] != '\0')
               ++currIdx;
            while (freq > 0 && currIdx + j < length)
            {
               output[currIdx+j] = currElem.getValue();
               j += spacing;
               --freq;
            }
            ++currIdx;
         }
      }
//      String out = new String(output);
//      System.out.println(out);
      return true;
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int tests = in.nextInt();
      while(tests-- > 0){
         String string = in.next();
         System.out.println(rearrangeCharacters(string)?1:0);
      }
   }
}
