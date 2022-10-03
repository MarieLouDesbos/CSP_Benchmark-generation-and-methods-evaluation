import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
//import org.chocosolver.solver.constraints.extension.Tuples;

public class Reines {
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Mauvaise utilisation");
		}
		
		int n = Integer.parseInt(args[0]);
		
		// Création du modele
		Model model = new Model("Reines");
		
		
		//Création des variables
		IntVar[] R = model.intVarArray("Reines",n,1,n); //création d'un tableau contenant n reines dont les domaines vont de 1 à n
		// par exemple R[2]=3 représente la reine de la ligne 3 et colonne 3
		
		//IntVar[] C = model.intVarArray("Colonnes",n,1,n);
		//IntVar[] diag1 = model.intVarArray("diag1",n);
		//IntVar[] diag2 = model.intVarArray("diag2",n);
		//IntVar[] diag3 = model.intVarArray("diag3",n);
		//IntVar[] diag4 = model.intVarArray("diag4",n);
		
		
		//Création des contraintes
		/* 1 : interdire que les reines soient sur la même ligne */
		//??
		
		/* 2 : interdire que les reines soient sur la même colonne */
		model.allDifferent(R).post();
		
		/* 3 : interdire que les reines soient sur la même diagonale */
		
	}

}
