package coe318.lab5;

public class Card implements Comparable {

    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    int _rank, _suit;
    boolean _faceup;
    
    
    public Card(int rank, int suit, boolean faceUp) {
        _rank = rank;
        _suit = suit;
        _faceup = faceUp;
    }

    
    public boolean isFaceUp() {
        return _faceup;
    }


    public void setFaceUp(boolean faceUp) {
        _faceup = faceUp;
    }

    
    public int getRank() {
        return _rank;
    }


    public int getSuit() {
        return _suit;
    }

    

    @Override
    public boolean equals(Object ob) {
        
        if (!(ob instanceof Card)) {
            return false; 
        }
        
        Card c = (Card) ob;
        if (this._rank == c._rank && this._suit == c._suit){
            return true; //Cards are equal
            
        } else{
            return false; //Cards not equal
            
        }
    }

 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }


    @Override
    public int compareTo(Object obj) {
        return compareTo((Card) obj);
    }


    
    public int compareTo(Card c) {
        
        if (this._rank > c._rank){
            return 1; // 'This' is bigger
            
        } else if (this._rank < c._rank){
            return -1; // 'This' is smaller
            
        } else{
            
            if (this._suit > c._suit){
                return 1; // 'This' is bigger
                
            } else if (this._suit < c._suit){
                return -1; // 'This' is smaller
                
            } else{
                return 0; // Both cards are equal
            }       
        }
    }

    

    
    public String getRankString() {
        
        int temp_rank = getRank();
        String return_var;
        
        switch(temp_rank){
            case 11:
                return_var = "Jack";
                break;
                
            case 12:
                return_var = "Queen";
                break;
                
            case 13:
                return_var = "King";
                break;
                
            case 14:
                return_var = "Ace";
                break;
                   
            default:
                return_var = String.valueOf(temp_rank);     
        }
        
        return return_var; 
    }
    
    
    
    public String getSuitString() {
        
        int temp_suit = getSuit();
        String return_var = "";
        
        switch(temp_suit){
            case 0:
                return_var = "Clubs";
                break;
                
            case 1:
                return_var = "Diamonds";
                break;
                
            case 2:
                return_var = "Hearts";
                break;
                
            case 3:
                return_var = "Spades";
                break;
        }
        
        return return_var;
    }

    
    @Override
    public String toString() {
        
        boolean is_faceUp = isFaceUp();
        String return_var;
        
        if (is_faceUp == true){
            return_var = getRankString() + " of " + getSuitString();
            
        } else{
            return_var = "?";
            
        }
        
        return return_var;
    }



    
    
    public static void main(String[] args) {
        
        Card club5 = new Card(5, 0, true);
        System.out.println("club5: " + club5);
        
        Card spadeAce = new Card(14, SPADE, true);
        System.out.println("spadeAce: " + spadeAce);
        
        System.out.println("club5 compareTo spadeAce: " + club5.compareTo(spadeAce));
        
        System.out.println("club5 compareTo club5: " + club5.compareTo(club5));
        
        System.out.println("club5 equals spadeAce: " + club5.equals(spadeAce));
        
        System.out.println("club5 equals club5: " + club5.equals(club5));
    }
}
