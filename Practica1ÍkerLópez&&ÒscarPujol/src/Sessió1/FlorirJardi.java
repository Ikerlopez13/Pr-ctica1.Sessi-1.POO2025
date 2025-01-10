package Sessió1;

import jconsole.JConsole;
import java.awt.Color;
import java.util.Random;

public class FlorirJardi {

	enum Estat { Sembrat, Nascut, Florit }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JConsole console = new JConsole (160,40);

		int fila, columna;

		String textFila, textColumna, textRegarFila, textRegarColumna;

		textFila= "Indica quantes files té el taulell: ";
		textColumna= "Indica quantes columnes té el taulell: ";
		textRegarFila = "Indica la fila de la component a regar ";
		textRegarColumna = "Indica la columna de la component a regar ";

		fila = llegirValor(3, 10, textFila, console);
		columna = llegirValor(3, 10, textColumna, console);

		Estat jardi [][] = new Estat [fila][columna];

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

	private static void canviarEstat(Estat[][]jardi, int fila, int col) {

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

	}

	private static void visualitza(Estat[][] t, JConsole console) {
		for (int i = 0; i<t.length;i++) {
			for (int j = 0; j<t[0].length;j++) {

				console.print(t[i][j]);

			}
			console.println();
		}
	}


}


