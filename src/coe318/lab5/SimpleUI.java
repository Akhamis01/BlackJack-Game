package coe318.lab5;
import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);


  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }



  @Override
    public void display() {
        System.out.println("\nHouse holds: " + this.game.getHouseCards().toString());
        System.out.println("You hold: " + this.game.getYourCards().toString());
    }



  @Override
    public boolean hitMe() {
        System.out.println("Would you like another card? (y/n)");
        String user_option = user.nextLine();
        
        while(true) {
            if("y".equals(user_option) || "n".equals(user_option)){ // Checks input is 'y' or 'n'
                break;
            }
            
            System.out.println("Input must be lowercase 'y' or 'n' ");
            user_option = user.nextLine();
        }
        
        if ("y".equals(user_option)){
            return true;
            
        } else if("n".equals(user_option)){
            return false;
        }
        
        return false;
    }


    
    
  @Override
    public void gameOver() {
        System.out.println("Game Over");
        display(); // Outputs the house and user's current score
        
        int House_score = game.score(game.getHouseCards());
        int User_score = game.score(game.getYourCards());
        System.out.println("Your Score: " + User_score + ", House Score: " + House_score);
        
        if( (User_score <= 21) && (House_score > 21 || User_score > House_score) ){
            System.out.println("You Win");
            
        } else{
            System.out.println("The House Wins");
        }
       
    }

}