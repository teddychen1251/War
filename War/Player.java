
public class Player{
  //Full deck sample for usage purposes
  private static String[] fullDeck = {"1dd","1ht","1cb","1cr","2dd","2ht","2cb","2cr","3dd","3ht","3cb","3cr","4dd","4ht","4cb","4cr","5dd","5ht","5cb","5cr","6dd","6ht","6cb","6cr","7dd","7ht","7cb","7cr","8dd","8ht","8cb","8cr","9dd","9ht","9cb","9cr","10dd","10ht","10cb","10cr","11dd","11ht","11cb","11cr","12dd","12ht","12cb","12cr","13dd","13ht","13cb","13cr"};
  private static String[] cpuNameAdjs = {"Insolent","Lazy","Angry","Insecure","Enraged","Hyper","Psycho","Crazy","l33t","Edible","Triggered","Bacon-flavored","Introverted","Virtual","Enigmatic","Rainbow","Evil","Gluten-free","Steamwork","Aquatic","Liberal","Republican","Extraterrestrial","Myopic","Pugnacious","Pasty-white","Dank","Overrated","Prepubescent","Politically Correct","Swole","Partially-cooked","ROFL"};
  private static String[] cpuNameNouns = {"Cracker","Boulder","Cow","Lueken","Semicolon","Barbarian","Troll","Juggernaut","Prince","Apple","Barbershop Quartet","Haxxor","Illuminati Member","Dragonfly","Vegan","Chewbacca","Darth Vader","Voldemort","Caesar Salad","Monk","Sensei","Snorlax","Disappointment","Pickle","Minotaur","Orc","Vampire","Meme","Robocyclops","Clown","Bard","Knight","Rogue","Wizard","Unicorn","Mad Scientist","Anime Hero","Hair Follicle","Barnacle Boy","Ice Climbers","Inigo Montoya","Jellyfish","Morgan Freeman","Starboy","Headless Horseman","Jack o'lantern","Hedgehog","Spongebob","Marxist","Dictator","Elvis Impersonator","Undertaker","Mark Zuckerberg","Legion of Roman Soldiers"};
  private static String[] cpuCries = {"YOLO","mynameisjeff","woot","AHHHHHH","ARGHHHH","I don't like to fight but whatever","there can only be one","apple pie","HiYaAaaaAAa","nothing","it's over 9000!!!!","eat defeat","what is life","help I'm behind on my college apps","why can't we make peace?","you have activated my trap card","get rekt m8","ooowwweeee","ah jeez"};
  private static String[] playerSounds = {"cries","yells","bellows","whines","screams","declares","shrieks","ululates","blubbers","mumbles","caterwauls","vociferates","politely says","wails","mewls","yammers"};
  private String[] deck;
  private int cards;
  private String name;

  public Player(){
    name = cpuNameAdjs[(int)(Math.random()*cpuNameAdjs.length)] + " " + cpuNameNouns[(int)(Math.random()*cpuNameNouns.length)];
    deck = new String[104];
    cards = 52;
    for(int i = 0; i < cards; i++){
      deck[i] = fullDeck[i];
    }
    shuffle();
  }
  public Player(String n){
    name = n;
    deck = new String[104];
    cards = 52;
    for(int i = 0; i < cards; i++){
      deck[i] = fullDeck[i];
    }
    shuffle();
  }

  public String getName(){
    return(name);
  }

  public void showCards(){
    for(int i = 0; i < cards; i++){
      System.out.println(deck[i]);
    }
  }

  public String returnFirstCard(){
    return(deck[0]);
  }

  public void shuffle(){
    //Fisher-Yates
    for(int i = 0; i < cards; i++){
      int rand = (int)(Math.random() * cards);
      String temp = deck[rand];
      deck[rand] = deck[i];
      deck[i] = temp;
    }
  }

  public String drawCard(String battleCry){
    String drawn = deck[0];
    for(int i = 1; i <= cards; i++){
      deck[i-1] = deck[i];
    }
    cards--;
    System.out.println(getName() + " " + playerSounds[(int)(Math.random() * playerSounds.length)] + " " + (battleCry.equals("") ? cpuCries[(int)(Math.random() * cpuCries.length)] : battleCry) + " and draws " + cardTranslate(drawn));
    return(drawn);
  }
  //breaks are needed or else it just falls through to lower statements
  public String cardTranslate(String str){
    String cardString = "";
    switch(str.substring(0,str.length()-2)){
      case "1":
        cardString = "Ace";
        break;
      case "11":
        cardString = "Jack";
        break;
      case "12":
        cardString = "Queen";
        break;
      case "13":
        cardString = "King";
        break;
      default:
        cardString = str.substring(0,str.length()-2);
    }
    switch(str.substring(str.length()-2)){
      case "ht":
        cardString = cardString + " of Hearts!";
        break;
      case "dd":
        cardString = cardString + " of Diamonds!";
        break;
      case "cb":
        cardString = cardString + " of Clubs!";
        break;
      case "cr":
        cardString = cardString + " of Clovers!";
        break;
    }
    return(cardString);
  }

}
