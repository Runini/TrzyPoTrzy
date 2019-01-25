import java.util.Random;

public class BonusGra extends TrzyPoTrzy{
	
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	
	public BonusGra() {}
	
	public void printTurn() {
		System.out.println("\t\t\t\t\tActually Turn - "+turn);
		turn++;
	}
	
	public void printScore() {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		System.out.println("Player 1: "+pkt1+" pkt.\t\t\t\t\t\t\t Player 2: "+pkt2+" pkt");
	}
	
	public void bonusMap() throws InterruptedException {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		Random rand = new Random();
		while(pkt1 < 5 && pkt2 < 5){
			if (figure1.equals("Stop")) {
				break;
			}
			Thread.sleep(1000);
			System.out.print("Three ");
				Thread.sleep(700);
			System.out.print("by ");
				Thread.sleep(700);
			System.out.println("Three ");
			botFigure = rand.nextInt(3);
			botFigure++;
			
			if (botFigure == 1) 
				figure2 = "paper";
			if (botFigure == 2)
				figure2 = "scissors";
			if (botFigure ==3)
				figure2 = "stone";
			
			Thread.sleep(700);
			System.out.println("Enemy choose: "+figure2);
			Thread.sleep(700);
			if (figure1.equals("pistol")) {
				int bullet;
				System.out.print("Reloading ");
					Thread.sleep(600);
				System.out.print("and ");
					Thread.sleep(600);
				System.out.print("Shoot! ");
					Thread.sleep(600);
					
				bullet = rand.nextInt(101);
				if (bullet <= 50) {
					System.out.println("Hit!, point win");
					pkt1++;
					Thread.sleep(1500);
					break;
				}
				else {
					System.out.println("Miss!, point lose");
					if (pkt1 != 0) {
					pkt1--;
					pkt2++;
					Thread.sleep(1500);
					break;
					}else {
						System.out.println("You are 0 points, don't losing point");
						Thread.sleep(1500);
					}
					break;
				}				
			}
			
			if(figure1.equals("paper") && figure2.equals("stone")) {
				pkt1++;
				System.out.println("You Paper Win! Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			if((figure1.equals("paper") && figure2.equals("paper")) || (figure1.equals("stone") && figure2.equals("stone")) || (figure1.equals("scissors") && figure2.equals("scissors"))) {
				System.out.println("The same figures!");
				Thread.sleep(700);
				System.out.println("Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("paper") && figure2.equals("scissors")) {
				pkt2++;
				System.out.println("You Paper Lose! Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("stone") && figure2.equals("scissors")) {
				pkt1++;
				System.out.println("You Stone Win! Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("stone") && figure2.equals("paper")) {
				pkt2++;
				System.out.println("You Stone Lose! Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("scissors") && figure2.equals("paper")) {
				pkt1++;
				System.out.println("You Scissors Win! Score : "+pkt1+" : "+pkt2 );
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("scissors") && figure2.equals("stone")) {
				pkt2++;
				System.out.println("You Scissors Lose! Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			
	}	
}
	public void readFigure() throws InterruptedException {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		do {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		System.out.println("You can choice 1 of 3 figures: scissors / paper / stone");
		System.out.println("You can choice pistol as well");
		System.out.println("It gives 50% of chance for gathering points, but if you'd be wrong then you lose point");
		Thread.sleep(800);
		figure1 = read.nextLine();
		if(!figure1.equals("paper") && !figure1.equals("stone")&&
				!figure1.equals("scissors")&& !figure1.equals("pistol")){
			if(figure1.equals("Stop")) {
				break;
			}
			System.out.println(ANSI_RED+"Wrong name, Try again: "+ANSI_RESET);
			continue;
		}
		Thread.sleep(600);
		System.out.println("You'r figure this: "+figure1);
		}
		while (!figure1.equals("paper") && !figure1.equals("stone")&&
				!figure1.equals("scissors") && !figure1.equals("pistol"));
		
	}
	}

