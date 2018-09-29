import java.util.Scanner;

class War {

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    String playerInput = "";

    System.out.println("Welcome to the Game of WAR!");
    System.out.println("Would you like to start a new game?(type yes/no)");
    playerInput = scan.nextLine().toLowerCase();

    while(!playerInput.equals("yes") && !playerInput.equals("no")){
      System.out.println("Enter a valid response please");
      playerInput = scan.nextLine().toLowerCase();
    }

    if(playerInput.equals("no")){
      System.out.println("Understandable. Have a nice day.");
    } else if(playerInput.equals("yes")){
      System.out.println("Excellent. Enter your name:");
      playerInput = scan.nextLine();
      Player cpu = new Player();
      Player you = new Player(playerInput);
      System.out.println("Your opponent is: " + cpu.getName());
      int round = 1;
      int youScore = 0;
      int cpuScore = 0;
      boolean prevTie = false;
      int tieStakes = 1;
      while(you.returnFirstCard() != null && cpu.returnFirstCard() != null){
        System.out.println("Round " + round + ": Type your battle cry!");
        playerInput = scan.nextLine(); //Can comment out this line for a quick game
        String youCard = you.drawCard(playerInput);
        String cpuCard = cpu.drawCard("");
        if(Integer.parseInt(youCard.substring(0,youCard.length()-2)) > Integer.parseInt(cpuCard.substring(0,cpuCard.length()-2))){
          youScore += tieStakes;
          System.out.println(you.getName() + " wins the round!");
          prevTie = false;
          tieStakes = 1;
        } else if(Integer.parseInt(youCard.substring(0,youCard.length()-2)) < Integer.parseInt(cpuCard.substring(0,cpuCard.length()-2))){
          cpuScore += tieStakes;
          System.out.println(cpu.getName() + " wins the round!");
          prevTie = false;
          tieStakes = 1;
        } else {
          System.out.println("It's a TIE! Next round is for double the previous points!");
          prevTie = true;
          tieStakes *= 2;
        }
        System.out.println(you.getName() + ": " + youScore);
        System.out.println(cpu.getName() + ": " + cpuScore);
        round++;
      }//account for ties
      System.out.println((youScore > cpuScore ? you.getName():cpu.getName()) + " wins!");
    }

  }

}

//Idea: cool stories to go along with battles
//Idea: deck arrays are just indices that reference the full Deck, nulls are negative
//Idea: instead of changing every element in the array by shifting, just increment index up by one(search for next non-negative)
//Idea: each player's original cards are marked to add that sweet 'hah i used your card'
//Cpu says stuff like 'hah' or 'darn'
//Every diff opponent (Chewbacca, Cow, etc) has different sounds and characteristics and their adj affects it too
//Special abilities and stuff to retain interest, maybe shuffling in game and extra strategy
//Double points for tie

//Bug: if user inputs empty, the program doesn't work FIXED with scan.nextLine()


/*
Deck generator

String deckString = "";
for(String card : new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"}){
  for(String suit : new String[]{"dd","ht","cb","cr"}){
    deckString += "\"" + card + suit + "\"" + ",";
  }
}
System.out.println(deckString);
*/

/*
Sets up a shuffling pattern
  public int[] shuffleNumbers(){
    int[] shuffledNums = new int[cards];
    //Set up the nums
    for(int i = 0; i < cards; i++){
      shuffledNums[i] = i;
    }
    //Fisher-Yates shuffle
    for(int i = 0; i < shuffledNums.length; i++){
      int rand = (int)(Math.random() * shuffledNums.length);
      int temp = shuffledNums[rand];
      shuffledNums[rand] = shuffledNums[i];
      shuffledNums[i] = temp;
    }

    return(shuffledNums);
  }
*/
