import java.util.Random;

/***********************************************************
* The RandomDie class contains methods for simulating 
* a roll of fair, six-sided die numbered 1 - 6.  
* This class is used for educational purposes only.  
* 
* @author Sal LaMarca
* @version 1.0, 02/16/2012
***********************************************************/
public class RandomDie {
	
	//The seed value for the random number generator
	private static final long SEED = System.currentTimeMillis();
	//Construct a new random number generator based on the seed
	private static Random randomNumGenerator = new Random(SEED);
	//Set the number of faces on the die
	private static final int FACES_ON_DIE = 6;
	
	/***********************************************************
	* Return a random integer of 1, 2, 3, 4, 5, or 6 simulating
	* a roll of a fair, six-side die.
	* 
	* @return Return a random integer of 1, 2, 3, 4, 5, or 6.
	***********************************************************/
	public static int getRandomDieRoll(){
		return (randomNumGenerator.nextInt(FACES_ON_DIE) + 1);
	}

}
