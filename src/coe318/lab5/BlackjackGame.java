package coe318.lab5;
import java.util.ArrayList;

public class BlackjackGame {

    private CardPile deck;
    private CardPile houseCards;
    private CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private UserInterface ui;

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
        
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        
        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() {
        Card c;
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        ui.display();
    }

    public void play() {
        while (!houseDone || !playerDone) {
            if (!houseDone) {
                if (score(getHouseCards()) <= 17) {  
                    getHouseCards().add(deck.removeRandom());
                    ui.display();
                    
                } else {
                    
                    houseDone = true;
                }
            }
            
            if (!playerDone) {
                
                if (ui.hitMe()) {
                    getYourCards().add(deck.removeRandom());
                    ui.display();
                    
                } else {
                    playerDone = true;
                    
                }
            }
        }
    }

    public void end() {
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }

    public int score(CardPile p) {
        ArrayList<Card> card_array = p.getCards();
        int tot_score = 0;
        int temp_rank;
        
        for(Card temp: card_array){
            
            if (temp._rank == 14){
                temp_rank = 1;
                
            } else if(temp._rank == 11 || temp._rank == 12 || temp._rank == 13){
                temp_rank = 10;
                
            } else{
                temp_rank = temp._rank;
            }

            tot_score += temp_rank;
        }
        
        return tot_score;
    }


    
    public CardPile getHouseCards() {
        return houseCards;
    }


    
    public CardPile getYourCards() {
        return yourCards;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame(new SimpleUI());
        game.start();
        game.play();
        game.end();
    }
}
