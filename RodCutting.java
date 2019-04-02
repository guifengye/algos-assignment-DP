
/**

 * Rod cutting problem described in Chapter 15 of textbook

 */
// rod cutting approach with recurison, memorization, and buttom up

public class RodCutting {
 // approach with memorize
	public int Memorize(int[] prices, int n) {

        int[] r = new int[n + 1];

        for (int i = 0; i < r.length; i++) {

            r[i] = -1;

        }

        return MemorizeA(prices, n, r);

    }



    private int  MemorizeA(int[] prices, int n, int[] r) {

        if (r[n] >= 0) {

            return r[n];

        }

        int max = Integer.MIN_VALUE;

        if (n == 0) {

            max = 0;

        } else {

            for (int i = 0; i < n; i++) {

                max = Math.max(max, prices[i] + MemorizeA(prices, n - i - 1, r));

            }

        }

        r[n] = max;

        return max;

    }




  // Do not change the parameters!
  // approach with recurison
	

  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
	  if(rodLength<=0 )
		  return 0;
	  int max_val = Integer.MIN_VALUE ;
	  for(int i=0; i<rodLength;i++)
		  max_val= Math.max(max_val, 
				  lengthPrices[i]+rodCuttingRecur(rodLength-i-1 ,lengthPrices));

    return max_val;

  }



  // Do not change the parameters!
// dynamic programming BottomUp

  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
	  int[]result= new int[rodLength+1];
	  result[0]=0;
	  for(int i= 1; i<= rodLength;i++) {
		  int max=-1;
		  for(int j =1 ; j < i; j++) {
			  max=Math.max(max, lengthPrices[j]+ result[i-(j+1)]);
			  result[i]= max;
		  }
		  
	  }

    return result[rodLength];

  }





  public static void main(String args[]){

      RodCutting rc = new RodCutting();



      // In your turned in copy, do not touch the below lines of code.

      // Make sure below is your only output.

      int length1 = 7;

      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};

      int length2 = 14;

      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};

      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);

      int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);

      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);

      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);

      System.out.println(maxSell1Recur + " " + maxSell1Bottom);

      System.out.println(maxSell2Recur + " " + maxSell2Bottom);

  }

}
           
