import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Gra {

	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";

	public static void main(String[] args) throws InterruptedException, IOException {
		boolean gameover = false;
		boolean men = false;
		boolean men2 = false;
		int menu = -1;
		Scanner odczyt = new Scanner(System.in);
		TrzyPoTrzy f = new TrzyPoTrzy();
		BonusGra g = new BonusGra();
		f.clrscr();
		System.out.println("Witaj w grze "+ANSI_YELLOW+"Papier, Kamien, Nozyce."+ANSI_RESET);
		System.out.println("Wpisz podczas gry slowo "+ANSI_RED+"'Stop'"+ANSI_RESET+" jezeli chcesz wrocic do menu.");
		Thread.sleep(500);
		while(men == false) {
		//f.clrscr();
		System.out.println("\t\t\tMenu Gry: ");
		System.out.println("\t\t\t[1]Nowa Gra ");
		System.out.println("\t\t\t[2]Wyniki ");
		System.out.println("\t\t\t[3]Kod Bonusowy ");
		System.out.println("\t\t\t[4]Wyjscie ");
		while(men2 == false) {
		try {
		//menu=odczyt.nextInt();
			menu=Integer.parseInt(odczyt.nextLine());
			System.out.println("Wybrales: "+menu);
		}catch (InputMismatchException e) {
			System.out.println("Nieprawidlowy parametr! Podaj CYFRE!:");
			
			//
		}catch (NumberFormatException e) {
			System.out.println("HALO Nieprawidlowy parametr! Podaj CYFRE!:");
			continue;
		}
		men2 = menu == -1?false:true;
		}
		  switch(menu){
			case 1: 
				f.aktualnyWynik();
				while (gameover == false){
					f.tura();
					f.podajFigure();
					f.Graj();
					f.clrscr();
					f.aktualnyWynik();
					
					if (f.pkt1 == 3 || f.pkt2 == 3 || f.figura.equals("Stop")) {
						gameover = true;
						//f.pkt1 = 0;
						//f.pkt2 = 0;
						//f.b = 1;
						
						}
					}
				
					f.wyniki();
					f.osiagniecia();
					Thread.sleep(4000);
					gameover = false;
					f.pkt1 = 0;
					f.pkt2 = 0;
					f.b = 1;
					f.clrscr();
					break;
			case 2:
				System.out.println("Twoja liczba wygranych: "+f.wygrana);
				System.out.println("Osiagniecie odblokowane: "+f.achi);
				if(f.achi >= 1)
					System.out.println("1. Osiagniecie 'Dloniom Precz' +kod - "+f.bonus);
				System.out.println("Wcisnij k, aby kontynuowac");
				
				while(gameover == false) {
				String k = g.podaj.nextLine();
				
				if (k.equals("k")) {
					gameover = true;
					
				}
					
				else
					System.out.println("Zly przycisk, sproboj jeszcze raz");
				}
				gameover = false;
				f.clrscr();
				break;
			case 3:
				g.bonusMode();
				Thread.sleep(1500);
				g.clrscr();
				if (g.bon == true) {
					System.out.println("Bonusowy tryb = walka do 5pkt + nowa figura ingerujaca w zasady");
				while (gameover == false){
					g.tura();
					g.podajFigure();
					g.bonusMapa();
					//g.clrscr();
					g.aktualnyWynik();
				if (g.pkt1 == 5 || g.pkt2 == 5 || g.figura.equals("Stop")){
					gameover = true;
					
					
				}
				}
				g.wyniki();
				Thread.sleep(2000);
				g.pkt1 = 0;
				g.pkt2 = 0;
				g.b = 1;
				gameover = false;
				g.bon = false;
				System.out.println(ANSI_RESET);
				g.clrscr();
				}
				break;
			case 4:
				System.out.println("Koniec");
				men = true;
				break;
			default:
				System.out.println("Nieprawidlowa Cyfra");
			} // end switch
		  men2 = false;
		//}catch(InputMismatchException e) {
			//System.out.println("Nieprawidlowy parametr!");
			//men = true;
			//break;
			//}
		} // end petla men
		} 
		
	}
	
