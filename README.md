# BlackJack-Game

In this project I created a simple game, **BlackJack!**. This game was created using Java.

Both you and the House (the Casino) are dealt two cards: one is face up and the other face down. So you can see only one of the House's cards and it can see only one of yours. But both you and the House can discretely peek at your face down cards.
Each card has a score as follows:
* An Ace has a score of 1. (This differs from real Blackjack where the Ace can have a score of either 1 or 11 at the player's discretion)
* A Jack, Queen or King has a score of 10.
* All other cards have a score equal to their rank. (For example, the 4 of Hearts or the 4 of any suit have a rank of 4 and a score of 4.)
* The House will obtain additional cards until its score is 17 or more.
* You are asked if you want another card. If you answer yes, you get another face down card and you will asked again. This continues until you say "no". This ends the game.
* All cards are now turned face-up and the scores of you and the House are calculated.
* You lose if your score is more than 21 (no matter what the House's score is).
* You lose if your score is the same as the House's. You win if:
* You don't go over 21 and the House does go over 21
* Both your scores are 21 or under and your score is more than the House's.
