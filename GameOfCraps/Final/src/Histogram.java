public class Histogram
{
  private int [] values;
  private int minIndex;
  private int maxIndex;
  private int maxLength;
 
  /** constructor for histogram drawing class
    * @param values: the array of integer values to draw
    * @param minIndex: the lowest index in the array for the range to draw
    * @param maxIndex: the highest index in the array for the range to draw
    * @param maxLength: the length of line to draw for the largest value
    */
 
  public Histogram(int [] values, int minIndex, int maxIndex, int maxLength)
  {
    // initialize the values of the instance variables from the constructor parameters
    this.values = new int [maxIndex + 1];   // allocate memory for a copy of the values array
    this.minIndex = minIndex;
    this.maxIndex = maxIndex;
    this.maxLength = maxLength;

    // ---------------------------------------------------------------------
    // step 6:
    // find largest number in values array for scaling length of bars
    // ---------------------------------------------------------------------
   
    int maxValue = 0;
    for(int i = 0; i <values.length; i++){
        if (i > maxValue){
            maxValue = i;
        }
     
    }
    int a = 0;
     for(int x = 0; x < values.length; x++){
        if (x == 0)
            continue;      
        int z = (values[x] * maxLength) / maxValue;
        this.values[a] = z;
        a++;
    }
 
}

 
  public void drawHor()
  {
    // ---------------------------------------------------------------------
    // step 8:
    // draw horizontal bar graph (one line per roll value)
    // ---------------------------------------------------------------------
   
 for (int B = 0; B < values.length; B++) {
	 for (int C = 1; C < values[B]; C++) {
		 System.out.print("*");
	 }
	 System.out.println(" Count "+ B + " ... " + values[B]);
 	}
  }
 
  /** draw a vertical bar graph
    */
 
  public void drawVer()
  {
   
    // ---------------------------------------------------------------------
    // step 9:
    // draw vertical bar graph (one column per roll value)
    // ---------------------------------------------------------------------
   
 for (int D = maxLength; D > 1; D--) {
	 for (int E = 0; E < values.length; E++) {
		 if (values[E] >= D)
			 System.out.print(" * ");
		 else
			 System.out.print("   ");
	 }
	 System.out.println("Count " + D);
 	}
  }
}
