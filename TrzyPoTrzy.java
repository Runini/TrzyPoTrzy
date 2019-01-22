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
	
	String figura;
	String figura2;
	public int pkt1 = 0;
	public int pkt2 = 0;
	int a;
	int b = 1;  //licznik tury
	int wygrana = 0; 
	int achi = 0; //licznik osiagniec
	String winner;
	String kod;
	String bonus = "PINK"; //kod bonusowy
	Boolean bon = false;
	
	Scanner podaj = new Scanner(System.in);
	public TrzyPoTrzy() {
		
	}
	public String pokazFigura(){
		return figura;
	}
	public void tura() {
		System.out.println(ANSI_YELLOW+"\t\t\t\t\tTrwa Tura - "+ANSI_RESET+ANSI_CYAN+b+ANSI_RESET);
		b++;
	}
	public void aktualnyWynik() {
		
		System.out.println(ANSI_GREEN+"Gracz 1: "+pkt1+" pkt."+ANSI_RESET+ANSI_RED+"\t\t\t\t\t\t\t Gracz 2: "+pkt2+" pkt"+ANSI_RESET);
		
	}
	public void podajFigure() throws InterruptedException {
		
		do {
		System.out.println("Wybierz 1 z 3 figur: Nozyce / Papier / Kamien");
		Thread.sleep(800);
		figura = podaj.nextLine();
		//podaj.close();
		//Thread.sleep(300);
		//System.out.println("Podales: "+figura);
		if(!figura.equals("Papier") && !figura.equals("Kamien")&&
				!figura.equals("Nozyce")){
			if(figura.equals("Stop")) {
				break;
			}
			System.out.println(ANSI_RED+"Bledna Nazwa, Podaj jeszcze raz: "+ANSI_RESET);
			continue;
		}
		Thread.sleep(600);
		System.out.println("Twoja figura to: "+ANSI_CYAN+figura+ANSI_RESET);
		}
		while (!figura.equals("Papier") && !figura.equals("Kamien")&&
				!figura.equals("Nozyce"));
		
	}
	
	public void Graj() throws InterruptedException {
		Random losuj = new Random();
		while(pkt1 < 3 && pkt2 < 3){
			if (figura.equals("Stop")) {
				break;
			}
			Thread.sleep(1000);
			System.out.print("Trzy ");
				Thread.sleep(700);
			System.out.print("Po ");
				Thread.sleep(700);
			System.out.println("Trzy ");
			a = losuj.nextInt(3);
			a++;
			if (a == 1) 
				figura2 = "Papier";
			if (a == 2)
				figura2 = "Nozyce";
			if (a ==3)
				figura2 = "Kamien";
			Thread.sleep(700);
			System.out.println("Przeciwnik wybral: "+ANSI_PURPLE+figura2+ANSI_RESET);
			Thread.sleep(700);
			
			if(figura.equals("Papier") && figura2.equals("Kamien")) {
				pkt1++;
				System.out.println(ANSI_GREEN+"Wygrywasz Papierem! "+ANSI_RESET+"Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			if(figura.equals("Papier") && figura2.equals("Papier")) {
				System.out.println(ANSI_BLUE+"TAKIE SAME FIGURY"+ANSI_RESET);
				Thread.sleep(700);
				System.out.println("Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Kamien") && figura2.equals("Kamien")) {
				System.out.println(ANSI_BLUE+"TAKIE SAME FIGURY"+ANSI_RESET);
				Thread.sleep(700);
				System.out.println("Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Nozyce") && figura2.equals("Nozyce")) {
				System.out.println(ANSI_BLUE+"TAKIE SAME FIGURY"+ANSI_RESET);
				Thread.sleep(700);
				System.out.println("Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);	
				break;
				}
			if(figura.equals("Papier") && figura2.equals("Nozyce")) {
				pkt2++;
				System.out.println(ANSI_RED+"Przegrywasz Papierem!"+ANSI_RESET+" Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Kamien") && figura2.equals("Nozyce")) {
				pkt1++;
				System.out.println(ANSI_GREEN+"Wygrywasz Kamieniem!"+ANSI_RESET+" Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Kamien") && figura2.equals("Papier")) {
				pkt2++;
				System.out.println(ANSI_RED+"Przegrywasz Kamieniem!"+ANSI_RESET+" Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Nozyce") && figura2.equals("Papier")) {
				pkt1++;
				System.out.println(ANSI_GREEN+"Wygrywasz Nozycami!"+ANSI_RESET +"Wynik : "+pkt1+" : "+pkt2 );
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Nozyce") && figura2.equals("Kamien")) {
				pkt2++;
				System.out.println(ANSI_RED+"Przegrywasz Nozycami!"+ANSI_RESET+" Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			
	}	
}
	public void wyniki() {
		
		if (figura.equals("Stop")) {
			System.out.println("Mecz nie zostal rozstrzygniety - "+ANSI_RED+"Koniec Gry."+ANSI_RESET);
		}
		else {
		if (pkt1 > pkt2) { 
			winner = "Gracz 1";
			wygrana++;
		}
		if (pkt2 > pkt1) {
			winner = "Gracz 2";
			}
		System.out.println("Zwyciezca jest: "+ANSI_GREEN+winner+ANSI_RESET+" - "+ANSI_RED+"Koniec Gry."+ANSI_RESET);
		
		}
	}
	public void osiagniecia() throws InterruptedException {
		if(wygrana == 3) {
			System.out.println(ANSI_GREEN+"Gratulacje!"+ANSI_RESET+"Odblokowales/as osiagniecie - 'Dloniom Precz' ");
			System.out.println("Twoj kod bonusowy to: PINK");
			achi++;
			Thread.sleep(4000);
		}
	}
	public void bonusMode() {
		System.out.println("Podaj kod bonusowy: ");
		kod = podaj.nextLine();
		if (kod.equals(bonus)) {
			System.out.println("Kod prawidlowy. Uruchamian bonus...");
			bon = true;
		}else
			System.out.println("Kod Nieprawidlowy");
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