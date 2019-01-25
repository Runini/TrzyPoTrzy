import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Gra {

	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) throws InterruptedException, IOException {
		boolean gameover = false;
		boolean men = false;   //loop variable
		boolean men2 = false;  //loop variable
		int menu = -1; // menu digit to switch
		Scanner odczyt = new Scanner(System.in);
		TrzyPoTrzy newPlayer = new TrzyPoTrzy();
		BonusGra bonusPlayer = new BonusGra();
		newPlayer.clrscr();
		System.out.println("Welcome in game "+ANSI_YELLOW+"Scissors, Paper, Stone."+ANSI_RESET);
		System.out.println("On game write "+ANSI_RED+"'Stop'"+ANSI_RESET+" if you back to menu.");
		Thread.sleep(500);
		while(men == false) {
		System.out.println("\t\t\t Game Menu: ");
		System.out.println("\t\t\t[1]New Game ");
		System.out.println("\t\t\t[2]Highscores ");
		System.out.println("\t\t\t[3]Bonus Code ");
		System.out.println("\t\t\t[4]Exit ");
		while(men2 == false) {
		try {
			menu=Integer.parseInt(odczyt.nextLine());
			System.out.println("You choose: "+menu);
		}catch (InputMismatchException e) {
			System.out.println("Wrong button! Press Number!:");
			
			//
		}catch (NumberFormatException e) {
			System.out.println("HALO Wrong button! Press Number!:");
			continue;
		}
		men2 = menu == -1;
		}
		  switch(menu){
			case 1:  // normal game
				newPlayer.printScore();
				while (gameover == false){
					newPlayer.printTurn();
					newPlayer.readFigure();
					newPlayer.game();
					newPlayer.clrscr();
					newPlayer.printScore();
					
					if (newPlayer.pkt1 == 3 || newPlayer.pkt2 == 3 || newPlayer.figure1.equals("Stop")) {
						gameover = true;				
						}
					}
				
					newPlayer.scores();
					newPlayer.osiagniecia();
					Thread.sleep(4000);
					gameover = false;
					newPlayer.pkt1 = 0;
					newPlayer.pkt2 = 0;
					newPlayer.turn = 1;
					newPlayer.clrscr();
					break;
			case 2: // scores
				System.out.println("You wins: "+newPlayer.win);
				System.out.println("Achievment unlocked: "+newPlayer.achi);
				if(newPlayer.achi >= 1)
					System.out.println("1. Achievment 'Stop hands' +code - "+newPlayer.bonus);
				System.out.println("Press k, by continue");
				
				while(gameover == false) {
				String k = bonusPlayer.read.nextLine();
				
				if (k.equals("k")) {
					gameover = true;
					
				}
					
				else
					System.out.println("Wrong button, try again");
				}
				gameover = false;
				newPlayer.clrscr();
				break;
			case 3: //bonus mode 
				bonusPlayer.bonusMode();
				Thread.sleep(1500);
				bonusPlayer.clrscr();
				if (bonusPlayer.checkBonus == true) {
					System.out.println("Bonus mode = fight to 5 points + new figure");
				while (gameover == false){
					bonusPlayer.printTurn();
					bonusPlayer.readFigure();
					bonusPlayer.bonusMap();
					bonusPlayer.printScore();
				if (bonusPlayer.pkt1 == 5 || bonusPlayer.pkt2 == 5 || bonusPlayer.figure1.equals("Stop")){
					gameover = true;
					}
				}
				bonusPlayer.scores();
				Thread.sleep(3000);
				bonusPlayer.pkt1 = 0;
				bonusPlayer.pkt2 = 0;
				bonusPlayer.turn = 1;
				gameover = false;
				bonusPlayer.checkBonus = false;
				System.out.println(ANSI_RESET);
				bonusPlayer.clrscr();
				}
				break;
			case 4: //exit
				System.out.println("End");
				men = true;
				break;
			default:
				System.out.println("Wrong Number");
			} // end switch
		  men2 = false;
		} // end loop men
		} 
		
	}
	
