package Sessió1;

import jconsole.JConsole;
import java.awt.Color;
import java.util.Random;

public class FlorirJardi {

	enum Estat { Sembrat, Nascut, Florit }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JConsole console = new JConsole (160,40);

		int fila, columna, contRegs=0;
		int filaReg, columnaReg;
		int vecFlors [] = new int [contRegs];
		int florides=0, menysFlors;

		String textFila, textColumna, textRegarFila, textRegarColumna;

		textFila= "Indica quantes files té el taulell: ";
		textColumna= "Indica quantes columnes té el taulell: ";
		textRegarFila = "Indica la fila de la component a regar ";
		textRegarColumna = "Indica la columna de la component a regar ";

		fila = llegirValor(3, 10, textFila, console);
		columna = llegirValor(3, 10, textColumna, console);

		Estat jardi [][] = new Estat [fila][columna];
		
		sembrarJardi(jardi);
		for (int i = 0; i<jardi.length;i++) {
			for (int j = 0; j<jardi[0].length;j++) {
				if (jardi[i][j]== Estat.Florit) {
					florides++;
				}
			}
		}
		console.println();
		visualitza(jardi, console);
		
		console.println();
		
		console.print("Conmença el joc. Àniras indicant les components que cols regar");
		console.print("--------------------------------------------------------------");
		
		while (acabar(jardi)== false) {
		filaReg = llegirValorRegFilas(fila, textRegarFila, console);
		columnaReg = llegirValorRegColumnas(columna, textRegarColumna, console);
		regar (jardi, filaReg, columnaReg, florides, console);
		visualitza(jardi, console);
		contRegs++;
		}
		
		console.println("Guanyat!!!!!");
		console.println("Dades finals");
		
		for (int i=0,cont=1; i<vecFlors.length; i++, cont++) {
			console.print("El reg número" + cont + "té" + vecFlors[i] + "flors");
		}
			
		for (int h=0; h<vecFlors.length; h++) {
			vecFlors[0] = menysFlors;
			if (menysFlors>vecFlors[h]) {
				menysFlors = vecFlors[h];
			}
			
		}
		
		console.println("La regada que ha produït menys flors ha sigut la Nº" + menysFlors );
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
				}
			}
		}
		return jardi;
	}

	private static void canviarEstat(Estat[][]jardi, int fila, int col, JConsole console) {
		
		if (jardi[fila][col] == Estat.Sembrat) {
			jardi [fila][col] = Estat.Nascut;
		}
		
		else if (jardi[fila][col]== Estat.Nascut) {
			jardi [fila][col] = Estat.Florit;
		}
		else if (jardi[fila][col]== Estat.Florit) {
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

	private static int regar (Estat[][]taulell, int fil, int col, int florides, JConsole console) {
		
		
		console.println("El reg de la component (" + fil + "," + col + " ) provoca el següents canvis al jardí");
		
		int contF=0;
		
		for (int j =0 ;j<taulell[0].length;j++) {
				canviarEstat(taulell, fil, col, console);
			}
			
			for (int i = 0; i<taulell.length; i++) {
				canviarEstat(taulell, fil, col, console);
			}
			
			for (int filas = 0; filas<taulell.length; filas++) {
				for (int columnas =0 ;columnas<taulell[0].length;columnas++) {
					if (taulell[filas][columnas] == Estat.Florit) {
						contF ++;
					}
				}
			}
		
			return contF;
			
	}

	private static void visualitza(Estat[][] t, JConsole console) {
		
		for (int i = 0; i<t.length;i++) {
			for (int j = 0; j<t[0].length;j++) {

				console.print(t[i][j]);

			}
			console.println();
		}
	}

	private static int llegirValorRegFilas(int filas, String text, JConsole console) {
		int valor;
		console.println(text);
		console.println();
		valor = console.readInt();
		while (valor<0 || valor>filas) {
			console.setForegroundColor(Color.RED);
			console.print("El valor entrat està fora del taulell");
			console.println();
			valor = console.readInt();
		}
		console.resetColor();
		return valor;

	}
	
	private static int llegirValorRegColumnas(int columnes, String text, JConsole console) {
		int valor;
		console.println(text);
		console.println();
		valor = console.readInt();
		while (valor<0 || valor>columnes) {
			console.setForegroundColor(Color.RED);
			console.print("El valor entrat està fora del taulell");
			console.println();
			valor = console.readInt();
		}
		console.resetColor();
		return valor;
	}

}

