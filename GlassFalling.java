/**
 * Glass Falling
 */
// Glass Falling uses recursion, memorization, and buttom-up
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
	//base case 
	 
      if(floors==0 || floors==1)

          return floors;

      if(sheets==1)

          return floors;



      int min= Integer.MAX_VALUE, temp;

      //two cases  a) egg  breaks b) egg will not break

      for (int i = 1; i <=floors ; i++) {

          temp = Math.max(glassFallingRecur(sheets-1,i-1), glassFallingRecur(sheets, floors-i));

          min = Math.min(temp,min);

      }

      return min + 1;

  
   
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
   public int glassFallingMemoized(int sheets, int floors) {
	    int[][] memo = new int[sheets + 1][floors];
	    for (int x = 0; x <= sheets; x++) {
	      for (int y = 0; y < floors; y++) {
	        memo[x][y] = Integer.MAX_VALUE;
	      }
	    }
	    return glassFallingMemoized(sheets, floors, memo);
	  }
  public int glassFallingMemoized(int sheets, int floors, int[][]memo ) {
	     if (1>=sheets) {
	    	 return floors;
  }
    if (1>=floors) {
    	return 1;
    }
    
   int best= floors +1 ;
   for(int a,b, x=1; x< floors; x++ ) {
	   if ((a = memo[sheets-1][floors-1])== Integer.MAX_VALUE ) {
		  a = glassFallingMemoized( sheets-1, floors-1, memo);
	   
	   }
	   if ((b=memo[sheets][floors -x]) == Integer.MAX_VALUE) {
		   b= glassFallingMemoized ( sheets, floors-x, memo);
		   
	   }
	   best= Math.min(best, Math.max(a, b));
	   
   }
    	if( floors < memo[0].length) {
    		memo[sheets][floors]=best+1;
    	}
	    	 
    
    return best + 1;
  }

  // Do not change the parameters!
 
  public int glassFallingBottomUp(int floors, int sheets) {
	    int[][] glassFloor= new int [sheets+1][floors+1]; 
	    int res;
	    int i, j, x; 
	  
	    // We need one trial for one floor and 0 trials for 0 floors 
	    for (i = 1; i <= sheets; i++) 
	    { 
	        glassFloor[i][1] = 1; 
	        glassFloor[i][0] = 0; 
	    } 
	  
	    // We always need j trials for one egg and j floors. 
	    for (j = 1; j <= floors; j++) 
	        glassFloor[1][j] = j; 
	  
	    // Fill rest of the entries in table using optimal substructure 
	     
	    for (i = 2; i <= sheets; i++) 
	    { 
	        for (j = 2; j <= floors; j++) 
	        { 
	            glassFloor[i][j] =Integer.MAX_VALUE; 
	            for (x = 1; x <= j; x++) 
	            { 
	                res = 1 + Math.max(glassFloor[i-1][x-1], glassFloor[i][j-x]); 
	                if (res < glassFloor[i][j]) 
	                    glassFloor[i][j] = res; 
	            } 
	        } 
	    } 
	  
	     
	    return glassFloor[sheets][floors]; 
	} 
    
   
  


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}


