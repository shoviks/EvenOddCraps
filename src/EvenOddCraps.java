/*
* EvenOddCraps.java
* Author: YourName
* Submission Date: YourSubmissionDate
*
* Purpose: Program allows user to bet chips on whether a dice lands on an odd or even number. 
* If the user wins the bet he/she is allowed the option of betting double or nothing on his original bet.  
* The game ends when the casino becomes bankrupt.  The only case when the casino goes bankrupt and the game continues is when the user wins "double or nothing" 
* so many times that the casino goes bankrupt.  The user is always presented with the option of discontinuing the game.  The program basically simulates
* a game of craps.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without written
* consent from the Department of Computer Science.
*/

import java.util.Scanner;
public class EvenOddCraps {

	/**
	 * @param args
	 */
	public static final int MIN_BET = 1;
	public static final int MAX_BET = 31250;
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// TODO Auto-generated method stub
		int casinoBankTotal = 1000000;
		int roll;
		int b = 0;
		int winnings = 0, numOfRolls = 0;
		int doubleb;
		String playing;
		String evenOrOdd = "0000";
		String doubleOrNothing = "0000";
		
		while((casinoBankTotal>0)||((doubleOrNothing.charAt(0)=='y')||(doubleOrNothing.charAt(0)=='Y')))
		{
			if (numOfRolls==0)
			{
				System.out.println("Would you like to play even/odd craps (y/n)?");/*Asks user if they want to play craps*/
				playing=keyboard.next();/*Stores user's input in variable*/
				if ((playing.charAt(0)=='y')||(playing.charAt(0)=='Y'))
				{
					
					System.out.println("How many chips would you like to bet?");/*Asks user how many chips they would like to bet*/
					b = keyboard.nextInt();/*Stores number of chips in variable*/
					doubleb=b;
					if (b<1)
					{	
						System.out.println("You must bet at least 1 chip");/*Number of chips is too low*/
						continue;
					}	
					else if (b>31250)
					{	
						System.out.println("Your bet cannot exceed 31250 chips");/*Number of chips is too high*/
						continue;
					}	
					else
					{	
						System.out.println("Bet on an even or odd roll (e/o)?");/*Asks users if they want to bet on even or odd*/
						evenOrOdd = keyboard.next();
						while ((evenOrOdd.charAt(0)!='o')&&(evenOrOdd.charAt(0)!='O')&&(evenOrOdd.charAt(0)!='e')&&(evenOrOdd.charAt(0)!='E'))
						{
							System.out.println("Bet on an even or odd roll (e/o)?");/*Asks users if they want to bet on even or odd*/
							evenOrOdd = keyboard.next();
						}
						roll = RandomDie.getRandomDieRoll();/*Stores result of dice roll in a variable*/
						System.out.println("You roll a "+ roll + ".");/*Presents which number gets rolled*/
						numOfRolls+=1;
						if (((roll%2==0)&&((evenOrOdd.charAt(0)=='e')||(evenOrOdd.charAt(0)=='E')))||((roll%2==1)&&((evenOrOdd.charAt(0)=='o')||(evenOrOdd.charAt(0)=='O'))))
						{
							casinoBankTotal-=b;
							winnings += b;
							System.out.println("Congrats! You won " + b + " chips.");/*Number of chips won*/
							if (roll%2==0)
							{
								System.out.println("Bet double or nothing on another even roll (y/n)?");/*Asks user if they want to bet double or nothing*/
								doubleOrNothing = keyboard.next();
								while (((doubleOrNothing.charAt(0)=='y')||(doubleOrNothing.charAt(0)=='Y')))
								{									
									roll = RandomDie.getRandomDieRoll();
									System.out.println("You roll a "+ roll + ".");/*Presents which number gets rolled*/
									numOfRolls+=1;
									if (roll%2==0) {
										doubleb = 2*doubleb;
										casinoBankTotal-=doubleb;
										winnings += doubleb;
										System.out.println("Congrats! You won " + b + " chips.");/*Number of chips won*/
									}
									else {
										casinoBankTotal+=b;
										winnings = 0;
										System.out.println("Sorry you lost your original bet of " + b + " chips.");/*Number of chips lost*/
										break;
									}
									System.out.println("Bet double or nothing on another even roll (y/n)?");
									doubleOrNothing = keyboard.next();/*User's choice of playing double or nothing*/
								}
								if ((doubleOrNothing.charAt(0)=='n')||(doubleOrNothing.charAt(0)=='N'))
								{
									continue;
								}
							}
							else
							{
								System.out.println("Bet double or nothing on another odd roll (y/n)?");
								doubleOrNothing = keyboard.next();
								while (((doubleOrNothing.charAt(0)=='y')||(doubleOrNothing.charAt(0)=='Y')))
								{									
									roll = RandomDie.getRandomDieRoll();/*Stores result of dice roll in variable*/
									System.out.println("You roll a "+ roll + ".");
									numOfRolls+=1;
									if (roll%2==1) {
										doubleb = 2*doubleb;
										casinoBankTotal-=doubleb;
										winnings += doubleb;
										System.out.println("Congrats! You won " + b + " chips.");/*Number of chips won*/
									}
									else {
										casinoBankTotal+=b;
										winnings = 0;
										System.out.println("Sorry you lost your original bet of " + b + " chips.");/*Number of chips lost*/
										break;
									}
									System.out.println("Bet double or nothing on another odd roll (y/n)?");/*Asks user if they want to play double or nothing*/
									doubleOrNothing = keyboard.next();
								}
								if ((doubleOrNothing.charAt(0)=='n')||(doubleOrNothing.charAt(0)=='N'))
								{
									continue;
								}
							}
						}
						
						else
						{
							casinoBankTotal+=b;
							winnings -= b;
							System.out.println("Sorry! You lost your original bet of " + b + " chips.");/*Number of chips lost*/
						}
					}
				}
				else if ((playing.charAt(0)=='n')||(playing.charAt(0)=='N'))
				{
					break;
				}
				else
				{
					continue;
				}
			}
			else
			{
				System.out.println("Would you like to continue playing (y/n)?");/*Asks user if they want to continue playing*/
				playing=keyboard.next();
				if ((playing.charAt(0)=='y')||(playing.charAt(0)=='Y'))
				{
					
					System.out.println("How many chips would you like to bet?");/*Asks user how many chips they would like to bet*/
					b = keyboard.nextInt();
					doubleb=b;
					if (b<1)
					{	
						System.out.println("You must bet at least 1 chip");/*Bet is too low*/
						continue;
					}	
					else if (b>31250)
					{	
						System.out.println("Your bet cannot exceed 31250 chips");/*Bet is too high*/
						continue;
					}	
					else
					{	
						System.out.println("Bet on an even or odd roll (e/o)?");/*Asks user if they want to bet on even or odd*/
						evenOrOdd = keyboard.next();/*User's choice of even or odd*/
						while ((evenOrOdd.charAt(0)!='e')&&(evenOrOdd.charAt(0)!='E')&&(evenOrOdd.charAt(0)!='o')&&(evenOrOdd.charAt(0)!='O'))
						{
							System.out.println("Bet on an even or odd roll (e/o)?");/*Asks user if they want to bet on even or odd*/
							evenOrOdd = keyboard.next();/*User's choice of even or Odd*/
						}
						roll = RandomDie.getRandomDieRoll();/*Stores number that resulted from dice roll in a variable*/
						System.out.println("You roll a "+ roll + ".");/*Presents number from dice roll*/
						numOfRolls+=1;
						if (((roll%2==0)&&((evenOrOdd.charAt(0)=='e')||(evenOrOdd.charAt(0)=='E')))||((roll%2==1)&&((evenOrOdd.charAt(0)=='o')||(evenOrOdd.charAt(0)=='O'))))
						{
							casinoBankTotal-=b;
							winnings += b;
							System.out.println("Congrats! You won " + b + " chips.");/*How many chips won*/
							if (roll%2==0)
							{
								System.out.println("Bet double or nothing on another even roll (y/n)?");/*Asks user if they want to play double or nothing*/
								doubleOrNothing = keyboard.next();
								while (((doubleOrNothing.charAt(0)=='y')||(doubleOrNothing.charAt(0)=='Y')))
								{									
									roll = RandomDie.getRandomDieRoll();/*Dice roll*/
									System.out.println("You roll a "+ roll + ".");/*Presents with dice roll*/
									numOfRolls+=1;
									if (roll%2==0) {
										doubleb = 2*doubleb;
										casinoBankTotal-=doubleb;
										winnings += doubleb;
										System.out.println("Congrats! You won " + b + " chips.");/*Number of chips won*/
									}
									else {
										casinoBankTotal+=b;
										winnings = 0;
										System.out.println("Sorry you lost your original bet of " + b + " chips.");/*number of chips lost*/
										break;
									}
									System.out.println("Bet double or nothing on another even roll (y/n)?");/*Asks user if they want to play double or nothing*/
									doubleOrNothing = keyboard.next();/*User's choice for double or nothing*/
								}
								if ((doubleOrNothing.charAt(0)=='n')||(doubleOrNothing.charAt(0)=='N'))
								{
									continue;
								}
							}
							else
							{
								System.out.println("Bet double or nothing on another odd roll (y/n)?");/*Asks user if they want to play double or nothing*/
								doubleOrNothing = keyboard.next();
								while (((doubleOrNothing.charAt(0)=='y')||(doubleOrNothing.charAt(0)=='Y')))
								{									
									roll = RandomDie.getRandomDieRoll();/*Dice roll*/
									System.out.println("You roll a "+ roll + ".");/*Presented with result from dice roll*/
									numOfRolls+=1;
									if (roll%2==1) {
										doubleb = 2*doubleb;
										casinoBankTotal-=doubleb;
										winnings += doubleb;
										System.out.println("Congrats! You won " + b + " chips.");/*Number of chips won*/
									}
									else {
										casinoBankTotal+=b;
										winnings = 0;
										System.out.println("Sorry you lost your original bet of " + b + " chips.");/*Number of chips lost*/
										break;
									}
									System.out.println("Bet double or nothing on another odd roll (y/n)?");/*Asks user if they want to play double or nothing*/
									doubleOrNothing = keyboard.next();/*User's choice for double or nothing*/
								}
								if ((doubleOrNothing.charAt(0)=='n')||(doubleOrNothing.charAt(0)=='N'))
								{
									continue;
								}
							}
						}
						
						else
						{
							casinoBankTotal+=b;
							winnings -= b;
							System.out.println("Sorry! You lost your original bet of " + b + " chips.");/*Number of chips lost*/
						}
					}
				}
				else if ((playing.charAt(0)=='n')||(playing.charAt(0)=='N'))
				{
					break;
				}
				else
				{
					continue;
				}
			}
		}
		
		if (casinoBankTotal<0)
			System.out.println("Congrats! Your winnings bankrupted the casino.");/*If casino is bankrupt*/
		/*end of game*/
		System.out.println("Goodbye!");
		System.out.println("\tYou rolled the die " + numOfRolls + " times.");
		System.out.println("\tYou won " + winnings + " chips.");
		System.out.printf("\tThe casino has %,d chips in its bank.\n", casinoBankTotal);
		System.out.println("Game Over!");
	}
}
