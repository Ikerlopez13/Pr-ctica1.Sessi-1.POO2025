package sessió2;

import java.util.Random;

import Sessió1.FlorirJardi.Estat;

public class Taulell {


	private enum Estat{ Sembrat, Nascut, Florit }
	private Estat taulell [][];
	private int numFiles;
	private int numCol;
	private int flors;

	public Taulell(int fil, int col) {
		numFiles = fil;
		numCol = col;
		Estat taulell [][] = new Estat [numFiles][numCol];
		sembrarJardi();
		
	}

	private void sembrarJardi() {
			int valor;

			Random aleatori = new Random ();

			for (int i = 0; i<numFiles;i++) {
				for (int j = 0; j<numCol;j++) {
					valor = aleatori.nextInt(1,4);
					if (valor == 1) {
						taulell [i][j] = Estat.Sembrat;
					}
					else if (valor == 2) {
						taulell [i][j] = Estat.Nascut;
					}
					else if (valor == 3) {
						taulell [i][j] = Estat.Florit;
						flors++;
					}
				}
			}
		}
	
	public void visualitzar(JConsole console) {
		for (int i = 0; i<numFiles;i++) {
			for (int j = 0; j<numCol;j++) {

				console.print(taulell[i][j]);

			}
			console.println();
		}
	}
	
	public int getNumeroFiles() {return numFiles;}
	public int getNumeroCol() {return numCol;}
	public int getNumeroFlors() {return flors;}
	// Falta el get de Estat [Sembrat, nascut, florit];//
	
	 public boolean totFlorit() {
		 if (flors == numCol*numFiles) {
			 return true;
		 }
		 else {
			 return false; 
		 }
	 }
	 public void regar(int fil, int col) {
		 
	 }


	
}


