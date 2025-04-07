import java.util.Random;//to use random() function
import java.util.Scanner;

public class RPSG {//actual class(logic)
    int userScore = 0;//initialize the starting score for user
    int compScore = 0;//initialize the starting score for computer
    String[] choice = {"Rock", "Paper", "Scissors"};

    // Method to start the game
    public void startGame() {
        Random r = new Random();//to get computer choice
        Scanner sc = new Scanner(System.in);//to get the user choice
        System.out.println("Rock Paper Scissors Battle Game!");

        while (userScore < 5 && compScore < 5) {//to check the score reaches or not
            System.out.println("\nChoose:\n 0 - Rock \n 1 - Paper \n 2 - Scissors ");
            int userChoice = sc.nextInt(); // to get the user's choice

            if (userChoice < 0 || userChoice >= choice.length) {//to check the length > or = given choices
                System.out.println("Invalid choice. Please choose 0, 1, or 2");
                continue;//continue to the while-loop
            }

            int compChoice = r.nextInt(3); // Random computer choice
//printing the user and computer choices
            System.out.println("You chosen: " + choice);
            System.out.println("Computer chosen: " + choice);

            // Determine the winner and update the score
            String result = guessWinner(userChoice, compChoice);//stores the score for every possibilities

            if (result == "User") {
                userScore++;
            } else{
                compScore++;
            }

            // Display scores
            System.out.println("Score - You: " + userScore + ", Computer: " + compScore);//to display scores for every choices
        }

        // Final result to display the score
        if (userScore == 5) {
            System.out.println("\nCongratulations! You won the game!");
        } else {
            System.out.println("\nThe computer wins!");
        }
    }

    // Method to determine the winner of the round
    public String guessWinner(int userChoice, int compChoice) {//passing the player choice through parameter
        if (userChoice == compChoice) {
            System.out.println("It's a tie!");
            return " Tie ";//return stmt - int type
        } else if ((userChoice == 0 && compChoice == 2) || (userChoice == 1 && compChoice == 0) ||
                (userChoice == 2 && compChoice == 1)) {
            System.out.println("You win this round!");
            return "User";
        } else {
            System.out.println("Computer wins this round!");
            return "Computer";
        }
    }
}
