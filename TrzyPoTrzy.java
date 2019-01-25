import java.util.Scanner;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;

public class TrzyPoTrzy {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	String figure1; // player 1 figure
	String figure2; // bot figure
	public int pkt1 = 0; //player one points
	public int pkt2 = 0; // bot points
	int botFigure; //bot figure choose
	int turn = 1;  //wins counter
	int win = 0;   // number of wins
	int achi = 0; //achievment number
	String winner; //see winner
	String code;  // read code to check
	String bonus = "PINK"; //bonus code
	Boolean checkBonus = false; //if bonus code is agree, checkBonus will change to true
	
	Scanner read = new Scanner(System.in);
	public TrzyPoTrzy() {
		
	}
	public String seeFigure(){
		return figure1;
	}
	public void printTurn() { //print actually round
		System.out.println(ANSI_YELLOW+"\t\t\t\t\tActually Round: - "+ANSI_RESET+ANSI_CYAN+turn+ANSI_RESET);
		turn++;
	}
	public void printScore() {  //print actually score
		
		System.out.println(ANSI_GREEN+"Player 1: "+pkt1+" pkt."+ANSI_RESET+ANSI_RED+"\t\t\t\t\t\t\t Player 2: "+pkt2+" pkt"+ANSI_RESET);
		
	}
	public void readFigure() throws InterruptedException {  //read figure to player one
		
		do {
		System.out.println("You can choice 1 of 3 figures: scissors / paper / stone");
		Thread.sleep(800);
		figure1 = read.nextLine();
		if(!figure1.equals("paper") && !figure1.equals("stone")&&
				!figure1.equals("scissors")){
			if(figure1.equals("Stop")) {
				break;
			}
			System.out.println(ANSI_RED+"Wrong name, Try again: "+ANSI_RESET);
			continue;
		}
		Thread.sleep(600);
		System.out.println("Your figure this: "+ANSI_CYAN+figure1+ANSI_RESET);
		}
		while (!figure1.equals("paper") && !figure1.equals("stone")&&
				!figure1.equals("scissors"));
		
	}
	
	public void game() throws InterruptedException {  // game function
		Random rand = new Random();
		while(pkt1 < 3 && pkt2 < 3){ //we can play to 3 points on one player
			if (figure1.equals("Stop")) {
				break;
			}
			Thread.sleep(1000);
			System.out.print("Three ");
				Thread.sleep(700);
			System.out.print("by ");
				Thread.sleep(700);
			System.out.println("Three ");
			botFigure = rand.nextInt(3); //random bot figure
			botFigure++;
			if (botFigure == 1) 
				figure2 = "paper";
			if (botFigure == 2)
				figure2 = "scissors";
			if (botFigure ==3)
				figure2 = "stone";
			Thread.sleep(700);
			System.out.println("Enemy choose: "+ANSI_PURPLE+figure2+ANSI_RESET);
			Thread.sleep(700);
			// game conditions
			if(figure1.equals("paper") && figure2.equals("stone")) {
				pkt1++;
				System.out.println(ANSI_GREEN+"You Paper Win! "+ANSI_RESET+"Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			if((figure1.equals("paper") && figure2.equals("paper")) || (figure1.equals("stone") && figure2.equals("stone")) || (figure1.equals("scissors") && figure2.equals("scissors"))) {
				System.out.println(ANSI_BLUE+"The same figures!"+ANSI_RESET);
				Thread.sleep(700);
				System.out.println("Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("paper") && figure2.equals("scissors")) {
				pkt2++;
				System.out.println(ANSI_RED+"You Paper Lose!"+ANSI_RESET+" Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("stone") && figure2.equals("scissors")) {
				pkt1++;
				System.out.println(ANSI_GREEN+"You Stone Win!"+ANSI_RESET+" Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("stone") && figure2.equals("paper")) {
				pkt2++;
				System.out.println(ANSI_RED+"You Stone Lose!"+ANSI_RESET+" Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("scissors") && figure2.equals("paper")) {
				pkt1++;
				System.out.println(ANSI_GREEN+"You Scissors Win!"+ANSI_RESET +" Score : "+pkt1+" : "+pkt2 );
				Thread.sleep(1700);
				break;
				}
			if(figure1.equals("scissors") && figure2.equals("stone")) {
				pkt2++;
				System.out.println(ANSI_RED+"You Scissors Lose!"+ANSI_RESET+" Score : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			
	}	
}
	public void scores() {
		
		if (figure1.equals("Stop")) {
			System.out.println("The match has not been resolved - "+ANSI_RED+"End Game."+ANSI_RESET);
		}
		else {
		if (pkt1 > pkt2) { 
			winner = "Gracz 1";
			win++;
		}
		if (pkt2 > pkt1) {
			winner = "Gracz 2";
			}
		System.out.println("Winner is: "+ANSI_GREEN+winner+ANSI_RESET+" - "+ANSI_RED+"End Game."+ANSI_RESET);
		
		}
	}
	public void osiagniecia() throws InterruptedException {
		if(win == 3) {
			System.out.println(ANSI_GREEN+"Congratulations!"+ANSI_RESET+"Unlocked Achievment - 'Stop hands' ");
			System.out.println("You'r bonus code is: PINK");
			achi++;
			Thread.sleep(4000);
		}
	}
	public void bonusMode() {
		System.out.println("Please bonus code: ");
		code = read.nextLine();
		if (code.equals(bonus)) {
			System.out.println("Code Agree. Bonus launching...");
			checkBonus = true;
		}else
			System.out.println("Wrong Code!");
	}
	public void clrscr() throws InterruptedException, IOException{
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	        	Thread.sleep(300);
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        }
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
}