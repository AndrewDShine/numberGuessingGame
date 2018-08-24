import java.util.Scanner;
import java.util.Random;

public class GameFiles
	{
		
		//Initializes first variables
		static Scanner userInput = new Scanner(System.in);
		static Scanner userIntPut = new Scanner(System.in);
		static Random randomNumber = new Random();
		static String difficultyChoice = "error";
		static boolean repeat = true;
		static String userName = "blank";

		public static void main(String[] args)
		{
			//Asks for the user's name and stores it in a global variable
			greetUser();
			
			while (repeat)
				{
					//Asks the user for what difficulty they'd like to play at and places it in a variable
					int difficultyLevel = askDifficulty();
					//Runs the game, passing in the selected difficulty level
					runGame(difficultyLevel); 
					
					//if they'd like to play again, keeps repeat true
					repeat = askToPlayAgain();
					
				}
		}
		
		public static void greetUser()
		{
			
			
			System.out.println("Hi, user! What is your name?");
			userName = userInput.nextLine();
			if (userName.equals("Fred"))
				{
					System.out.println("I know it's you, Mr. McGuire.");
				}
			
		}
		
		public static int askDifficulty()
		{
			System.out.println("Okay, "+userName+"! What difficulty level would you like to play at? \n"
					+ "Easy: 1-10 \n"
					+ "Medium: 1-30 \n"
					+ "Hard: 1-50");
			difficultyChoice = userInput.nextLine();
			
			if (difficultyChoice.equals("Easy") || difficultyChoice.equals("easy"))
				{
					System.out.println("Easy mode selected!");
					return 10;
				}
			else if (difficultyChoice.equals("Medium") || difficultyChoice.equals("medium"))
				{
					System.out.println("Medium difficulty selected!");
					return 30;
				}
			else if (difficultyChoice.equals("Hard") || difficultyChoice.equals("hard"))
				{
					System.out.println("Hard mode engaged! Good luck!");
					return 50;
				}
			else if (difficultyChoice.equals("Debug") || difficultyChoice.equals("debug"))
				{
					System.out.println("Debug difficulty chosen");
					return 2;
				}
			else
				{
					System.out.println("ERROR: DIFFICULTY LEVEL NOT ENTERED. DIFFICULTY SET TO ULTRA MAXIMUM");
					return 9999;
				}
		}

		public static void runGame (int difficultyLevel)
		{
			int secretNumber = (randomNumber.nextInt(difficultyLevel) + 1);
			boolean userWin = false;
			int userGuess = 0;
			int timesGuessed = 0;
			
			System.out.println("Guess a number between 1 and "+difficultyLevel+"! (inclusive)");
			while (!userWin)
				{
					userGuess = userIntPut.nextInt();
					if ((userGuess < secretNumber) && (userGuess >= 1))
						{
							System.out.println("You're too low! Guess again!");
							timesGuessed = timesGuessed + 1;
						}
					else if ((userGuess > secretNumber) && (userGuess <= difficultyLevel))
						{
							System.out.println("You're too high! Try again!");
							timesGuessed = timesGuessed + 1;
						}
					else if (userGuess == secretNumber)
						{
							userWin = true;
							timesGuessed = timesGuessed + 1;
							System.out.println("You win! The number was "+secretNumber+", and you were playing on '"+difficultyChoice+"' difficulty!");
							if (timesGuessed < (difficultyLevel / 2))
								{
									System.out.println("You made "+timesGuessed+" guesses, which is a pretty good number when you're guessing out of "+difficultyLevel+"!");
								}
							else
								{
									System.out.println("You guessed "+timesGuessed+" times out of a total "+difficultyLevel+" possible numbers. I think you could do better!");
								}
						}
					else
						{
							System.out.println("Hmm. You entered something that's not a number, or a number outside of the difficulty's range. Guess again, then.");
							timesGuessed = timesGuessed + 1;
						}
				}
		}
	
		public static boolean askToPlayAgain()
		{
			System.out.println("That was fun, "+userName+"! Would you like to play again? (yes/no)");
			String userAnswer = userInput.nextLine();
			if (userAnswer.equals("Yes") || userAnswer.equals("yes"))
				{
					return true;
				}
			else if (userAnswer.equals("No") || userAnswer.equals("no"))
				{
					System.out.println("Goodbye!");
					return false;
				}
			else
				{
					System.out.println("Well if you're not going to answer me, I won't play with you anymore.");
					return false;
				}
		}
	}