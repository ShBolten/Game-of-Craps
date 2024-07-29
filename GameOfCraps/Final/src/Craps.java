/**

 * Craps.java       Author: Bob Wilson
 *
 * Description: generates an array of values for the sum of two dice rolls.
 * Uses the Histogram class to print histograms of the frequencies of each value.
 *
 * Modified by Ting Zhang
 *
 * CSC1106 term project
 */

import java.util.Scanner;

public class Craps
{
  private static final int MIN_ROLL = 2;        
  private static final int MAX_ROLL = 12;      
  private static final int MAX_LENGTH = 36;      
 
   /**
   * main method:
   * ask the user how many dice rolls to make during this run
   * count occurances for each value of the throw of the dice
   * and draw a horizontal and vertical histogram of the counts
   */
 
  public static void main(String[] args)
  {
    // ---------------------------------------------------------------------
    // step 1:
    // declare an int array named "counts" to count dice roll occurences
    // ignore the 0th and 1st array elements (those values can't occur)
    // ---------------------------------------------------------------------
 int[] counts = new int[MAX_ROLL + 1];

   
    // ---------------------------------------------------------------------
    // step 2:
    // initialize all of the values in the array to 0
    // ---------------------------------------------------------------------
   
 for (int i = 0; i < counts.length; i++)
          counts[i] = 0;
   
    // instantiate two dice: myDie1 and myDie2

 	Die myDie1 = new Die();
    Die myDie2 = new Die();

    // ask user for the number of rolls to make during this run

    Scanner scan = new Scanner(System.in);
    System.out.println("How many dice rolls do you want?");
    int total = scan.nextInt();
    // ---------------------------------------------------------------------
    // step 3:
    // roll the two dice and count the total of the two rolls n times
    // ---------------------------------------------------------------------
    for (int n = 1; n <= total; ++n) {
        int sum = myDie1.roll() + myDie2.roll();
        counts[sum]++;
    }
    // ---------------------------------------------------------------------
    // step 4:
    // print out the estimated probabilities of win, lose, and roll again
    // ---------------------------------------------------------------------
        int win = counts[7] + counts[11];

        int lose = counts[2] + counts[3] + counts[12];

        int rollAgain = counts[4] + counts[5] + counts[6] + counts[8] + counts[9] + counts[10];

        float probWin = (float) win / (float) total;

        float probLose = (float) lose / (float) total;

        float probRollAgain = (float) rollAgain / (float) total;

        System.out.println("Estimated probabilities of the outcome for first roll");

        System.out.println("Win:" + probWin);

        System.out.println("Lose:" + probLose);

        System.out.println("Roll Again:" + probRollAgain);
    // ---------------------------------------------------------------------
    // step 5:
    // instantiate an object of the Histogram class and
    // call its two draw methods to draw the two histograms
    // with the array to be drawn, the indices of valid data,
    // and the maximum length of the bars in the histogram
    // ---------------------------------------------------------------------
        Histogram histogram = new Histogram(counts, MIN_ROLL, MAX_ROLL, MAX_LENGTH);

        histogram.drawHor();

        histogram.drawVer();
   
   
  }
}