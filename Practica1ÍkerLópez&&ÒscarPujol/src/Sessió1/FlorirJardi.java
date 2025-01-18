package Sessió1;

import jconsole.JConsole;
import java.awt.Color;
import java.util.Random;

public class FlorirJardi {

	enum Estat { Sembrat, Nascut, Florit }

	public static void main(String[] args) {
		JConsole console = new JConsole (160,40);

		int fila, columna, florides, contadorIntents = 30;

		String textFila, textColumna;

		textFila= "Indica quantes files té el taulell: ";
		textColumna= "Indica quantes columnes té el taulell: ";

		fila = llegirValor(3, 10, textFila, console);
		columna = llegirValor(3, 10, textColumna, console);

		Estat jardi [][] = new Estat [fila][columna];
		
		
		
		console.println("Comença el joc. Aniràs indicant les components que vols regar");
		console.println("-------------------------------------------------------------");
		
		int[] intents = new int[contadorIntents];
		
		for(int i = 0; !acabar(jardi) ; i++) {
			console.println("Indica la fila de la component a regar");
			int fila = console.readInt();
			console.println("Indica la columna de la component a regar");
			int columna = console.readInt();
				visualitza(jardi, console);
				florides = sembrarJardi(jardi);
				canviarEstat(jardi, fila, columna, console);
				regar(jardi, fila, columna, florides);
			console.println("El reg de la component("+fila+","+columna+") provoca els següents canvis al jardí");
			intents[i] = florides;
        }
		
		
		
		
		console.println("Guanyat!");
		console.println("Dades finals:");
		for(int i=0; i<intents.length; i++) {
			console.println("El reg número "+i+1+"té "+intents[i]+"flors");
		}

	}

	private static int llegirValor(int minim, int maxim, String text, JConsole console) {
		int valor;
		console.println(text);

		console.setForegroundColor(Color.GREEN);
		valor = console.readInt();
		while (valor<3 || valor>10) {
			console.setForegroundColor(Color.RED);
			console.print("El valor entrat està fora de l'interval (ha d'estar entre 3 i 10)");
			console.println();
			console.setForegroundColor(Color.GREEN);
			valor = console.readInt();
		}
		console.resetColor();
		return valor;

	}

	private static int sembrarJardi(Estat jardi[][]) {
		int valor;
		int florides = 0;

		Random aleatori = new Random ();

		for (int i = 0; i<jardi.length;i++) {
			for (int j = 0; j<jardi[0].length;j++) {
				valor = aleatori.nextInt(1,4);
				if (valor == 1) {
					jardi [i][j] = Estat.Sembrat;
				}
				else if (valor == 2) {
					jardi [i][j] = Estat.Nascut;
				}
				else if (valor == 3) {
					jardi [i][j] = Estat.Florit;
					florides++;
				}
			}
		}
		return florides;
	}

	private static void canviarEstat(Estat[][]jardi, int fila, int col, JConsole console) {
		
				if(jardi[fila][col]== Estat.Sembrat) {
					jardi [fila][col] = Estat.Nascut;
				} 
				
				else if(jardi[fila][col] == Estat.Nascut) {
					jardi [fila][col] = Estat.Florit;
				} 
				
				else if(jardi[fila][col] == Estat.Florit){
					jardi [fila][col] = Estat.Sembrat;
				}
	}


	private static boolean acabar(Estat[][]taulell) {
		for (int i = 0; i<taulell.length;i++) {
			for (int j = 0; j<taulell[0].length;j++) {
				if (taulell [i][j]!= Estat.Florit) {
					return false;
				}
			}
		} 
		return true;
	}

	private static int regar(Estat[][]taulell, int fil, int col, int florides) {
		int contadorFlorit = 0;
		
		for (int i = 0; i<taulell.length;i++) {
			for (int j = 0; j<taulell[0].length;j++) {
				if(i==fil || j == col) {
					canviarEstat(taulell, i, j, console);
				}
			}
		} 
		for (int i = 0; i<taulell.length;i++) {
			for (int j = 0; j<taulell[0].length;j++) {
				if(taulell[i][j] == Estat.Florit) {
					contadorFlorit++;
				}
			}
		}
		
		return contadorFlorit;
	}

	private static void visualitza(Estat[][] t, JConsole console) {
		for (int i = 0; i<t.length;i++) {
			for (int j = 0; j<t[0].length;j++) {

				console.print(t[i][j]+"\t");

			}
			console.println();
		}
	}


}


