import java.util.Random;

public class BonusGra extends TrzyPoTrzy{
	
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	
	public BonusGra() {}
	
	public void tura() {
		System.out.println("\t\t\t\t\tTrwa Tura - "+b);
		b++;
	}
	
	public void aktualnyWynik() {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		System.out.println("Gracz 1: "+pkt1+" pkt.\t\t\t\t\t\t\t Gracz 2: "+pkt2+" pkt");
	}
	
	public void bonusMapa() throws InterruptedException {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		Random losuj = new Random();
		while(pkt1 < 5 && pkt2 < 5){
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
			System.out.println("Przeciwnik wybral: "+figura2);
			Thread.sleep(700);
			if (figura.equals("Pistolet")) {
				int naboj;
				System.out.print("Przeladowanie ");
				Thread.sleep(600);
				System.out.print("i ");
				Thread.sleep(600);
				System.out.print("Strzal ");
				Thread.sleep(600);
				naboj = losuj.nextInt(101);
				if (naboj <= 50) {
					System.out.println("Trafiony Zatopiony, zdobywasz pkt");
					pkt1++;
					Thread.sleep(1500);
					break;
				}
				else {
					System.out.println("Pudlo, tracisz pkt");
					if (pkt1 != 0) {
					pkt1--;
					pkt2++;
					Thread.sleep(1500);
					break;
					}else
					break;
				}				
			}
			
			if(figura.equals("Papier") && figura2.equals("Kamien")) {
				pkt1++;
				System.out.println("Wygrywasz Papierem! Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			if(figura.equals("Papier") && figura2.equals("Papier")) {
				System.out.println("TAKIE SAME FIGURY");
				Thread.sleep(700);
				System.out.println("Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Kamien") && figura2.equals("Kamien")) {
				System.out.println("TAKIE SAME FIGURY");
				Thread.sleep(700);
				System.out.println("Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Nozyce") && figura2.equals("Nozyce")) {
				System.out.println("TAKIE SAME FIGURY");
				Thread.sleep(700);
				System.out.println("Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);	
				break;
				}
			if(figura.equals("Papier") && figura2.equals("Nozyce")) {
				pkt2++;
				System.out.println("Przegrywasz Papierem! Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Kamien") && figura2.equals("Nozyce")) {
				pkt1++;
				System.out.println("Wygrywasz Kamieniem! Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Kamien") && figura2.equals("Papier")) {
				pkt2++;
				System.out.println("Przegrywasz Kamieniem! Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Nozyce") && figura2.equals("Papier")) {
				pkt1++;
				System.out.println("Wygrywasz Nozycami! Wynik : "+pkt1+" : "+pkt2 );
				Thread.sleep(1700);
				break;
				}
			if(figura.equals("Nozyce") && figura2.equals("Kamien")) {
				pkt2++;
				System.out.println("Przegrywasz Nozycami! Wynik : "+pkt1+" : "+pkt2);
				Thread.sleep(1700);
				break;
			}
			
	}	
}
	public void podajFigure() throws InterruptedException {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		do {
		System.out.println(ANSI_YELLOW+ANSI_PURPLE_BACKGROUND);
		System.out.println("Wybierz 1 z 3 figur: Nozyce / Papier / Kamien");
		System.out.println("Mozesz rowniez wybrac Pistolet");
		System.out.println("Daje on 50% szansy na zdobycie pkt, ale jak nie trafisz, to tracisz pkt");
		Thread.sleep(800);
		figura = podaj.nextLine();
		//podaj.close();
		//Thread.sleep(300);
		//System.out.println("Podales: "+figura);
		if(!figura.equals("Papier") && !figura.equals("Kamien")&&
				!figura.equals("Nozyce")&& !figura.equals("Pistolet")){
			if(figura.equals("Stop")) {
				break;
			}
			System.out.println(ANSI_RED+"Bledna Nazwa, Podaj jeszcze raz: "+ANSI_RESET);
			continue;
		}
		Thread.sleep(600);
		System.out.println("Twoja figura to: "+figura);
		}
		while (!figura.equals("Papier") && !figura.equals("Kamien")&&
				!figura.equals("Nozyce") && !figura.equals("Pistolet"));
		
	}
	}

