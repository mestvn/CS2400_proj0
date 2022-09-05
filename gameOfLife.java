import java.util.Scanner;

public class gameOfLife {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    int[][] prevArray= new int[5][5];
	    int[][] nextArray = new int[5][5];
	    System.out.println("Enter the first stage in a 5x5 line by line:");
	    for(int i=0;i<5;i++){
	      for(int j=0;j<5;j++){
	        prevArray[i][j] = scan.nextInt();
	      }
		}
	    System.out.println("\nFirst stage scanned...");
	    for(int i=0;i<5;i++){
	      for(int j=0;j<5;j++){
	        System.out.print(prevArray[i][j]+ " ");
	        if(isAlive(prevArray,i,j)){
	          nextArray[i][j] = 1;
	        }else{
	          nextArray[i][j] = 0;
	        }
	      }
	      System.out.println();
	    }
	    System.out.println("\nNext Stage:");
	    for(int i=0;i<5;i++){
	      for(int j=0;j<5;j++){
	        System.out.print(nextArray[i][j]+ " ");
	      }
	      System.out.println();
	    }
	    /*Could expand on this idea by removing the 5x5 limit 
	     * and also adding delay so that it can flicker between 
	     * stages like the actual game of life. Extra stages can be
	     * added by copying the Next Stage into the Previous Stage 
	     * and looping it.
	     */
	  }
	  
	  public static boolean isAlive(int array[][],int xPos, int yPos){
	    int count =0;
	    int minX,maxX,minY,maxY;
	    if (xPos ==0){
	      minX = 0;
	    }else{
	      minX = -1;
	    }
	    if (xPos ==4){
	      maxX = 0;
	    }else{
	      maxX = 1;
	    }
	    if (yPos ==0){
	      minY = 0;
	    }else{
	      minY = -1;
	    }
	    if (yPos ==4){
	      maxY = 0;
	    }else{
	      maxY = 1;
	    }
	    for(int i=minX;i<=maxX;i++){
	     for(int j=minY;j<=maxY;j++){
	       if(array[xPos+i][yPos+j]==1){
	         count++;
	       }
	     }
	    }
	    //System.out.print(count +" "); --> used to debug
	    if(array[xPos][yPos]==0){ //if cell is dead
	      if(count ==3){ //and there's 3 cells
	        return true;
	      }
	    }else{ //if cell is alive
	      if(count == 3 || count ==4) //and there's 2 or 3 cells (including current cell)
	        return true;
	    }
	    return false;
	  }
}

