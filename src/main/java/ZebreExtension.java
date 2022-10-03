import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.constraints.extension.Tuples;


public class ZebreExtension {

	public static void main(String[] args) {
		
		// Création du modele
		Model model = new Model("Zebre");
		
		
		// Création des variables
		IntVar blu = model.intVar("Blue", 1, 5);	// blu est une variable entière dont le nom est "Blue" et le domaine [1,5]
		IntVar gre = model.intVar("Green", 1, 5); 
		IntVar ivo = model.intVar("Ivory", 1, 5);         
		IntVar red = model.intVar("Red", 1, 5);         
		IntVar yel = model.intVar("Yellow", 1, 5);   
		
		IntVar eng = model.intVar("English", 1, 5);         
		IntVar jap = model.intVar("Japanese", 1, 5);         
		IntVar nor = model.intVar("Norwegian", 1, 5);         
		IntVar spa = model.intVar("Spanish", 1, 5);         
		IntVar ukr = model.intVar("Ukrainian", 1, 5);         
		
		IntVar cof = model.intVar("Coffee", 1, 5);         
		IntVar mil = model.intVar("Milk", 1, 5);         
		IntVar ora = model.intVar("Orange Juice", 1, 5);         
		IntVar tea = model.intVar("Tea", 1, 5);         
		IntVar wat = model.intVar("Water", 1, 5);         
		
	    IntVar dog = model.intVar("Dog", 1, 5);         
	    IntVar fox = model.intVar("Fox", 1, 5);         
	    IntVar hor = model.intVar("Horse", 1, 5);         
	    IntVar sna = model.intVar("Snail", 1, 5);         
	    IntVar zeb = model.intVar("Zebra", 1, 5);         
	    
	    IntVar che = model.intVar("Chesterfield", 1, 5);         
	    IntVar koo = model.intVar("Kool", 1, 5);         
	    IntVar luc = model.intVar("Lucky Strike", 1, 5);         
	    IntVar old = model.intVar("Old Gold", 1, 5);         
	    IntVar par = model.intVar("Parliament", 1, 5);         

	    
	    // Création des contraintes
        int [][] tEq = new int[][] {{1,1},{2,2},{3,3},{4,4},{5,5}};
        Tuples tuplesAutorises = new Tuples(tEq,true);		// création de Tuples de valeurs autorisés
        Tuples tuplesInterdits = new Tuples(tEq,false);		// création de Tuples de valeurs interdits
        
 /* 1 */
        model.table(new IntVar[]{blu,gre}, tuplesInterdits).post();
        // création d'une contrainte en extension de portée <blu,gre>
        // dont les tuples autorisés/interdits sont données par tuplesInterdits
        model.table(new IntVar[]{blu,ivo}, tuplesInterdits).post();
        model.table(new IntVar[]{blu,red}, tuplesInterdits).post();
        model.table(new IntVar[]{blu,yel}, tuplesInterdits).post();
        model.table(new IntVar[]{gre,ivo}, tuplesInterdits).post();
        model.table(new IntVar[]{gre,red}, tuplesInterdits).post();
        model.table(new IntVar[]{gre,yel}, tuplesInterdits).post();
        model.table(new IntVar[]{ivo,red}, tuplesInterdits).post();
        model.table(new IntVar[]{ivo,yel}, tuplesInterdits).post();
        model.table(new IntVar[]{red,yel}, tuplesInterdits).post();

        model.table(new IntVar[]{eng,jap}, tuplesInterdits).post();
        model.table(new IntVar[]{eng,nor}, tuplesInterdits).post();
        model.table(new IntVar[]{eng,spa}, tuplesInterdits).post();
        model.table(new IntVar[]{eng,ukr}, tuplesInterdits).post();
        model.table(new IntVar[]{jap,nor}, tuplesInterdits).post();
        model.table(new IntVar[]{jap,spa}, tuplesInterdits).post();
        model.table(new IntVar[]{jap,ukr}, tuplesInterdits).post();
        model.table(new IntVar[]{nor,spa}, tuplesInterdits).post();
        model.table(new IntVar[]{nor,ukr}, tuplesInterdits).post();
        model.table(new IntVar[]{spa,ukr}, tuplesInterdits).post();

        model.table(new IntVar[]{cof,mil}, tuplesInterdits).post();
        model.table(new IntVar[]{cof,ora}, tuplesInterdits).post();
        model.table(new IntVar[]{cof,tea}, tuplesInterdits).post();
        model.table(new IntVar[]{cof,wat}, tuplesInterdits).post();
        model.table(new IntVar[]{mil,ora}, tuplesInterdits).post();
        model.table(new IntVar[]{mil,tea}, tuplesInterdits).post();
        model.table(new IntVar[]{mil,wat}, tuplesInterdits).post();
        model.table(new IntVar[]{ora,tea}, tuplesInterdits).post();
        model.table(new IntVar[]{ora,wat}, tuplesInterdits).post();
        model.table(new IntVar[]{tea,wat}, tuplesInterdits).post();

        model.table(new IntVar[]{dog,fox}, tuplesInterdits).post();
        model.table(new IntVar[]{dog,hor}, tuplesInterdits).post();
        model.table(new IntVar[]{dog,sna}, tuplesInterdits).post();
        model.table(new IntVar[]{dog,zeb}, tuplesInterdits).post();
        model.table(new IntVar[]{fox,hor}, tuplesInterdits).post();
        model.table(new IntVar[]{fox,sna}, tuplesInterdits).post();
        model.table(new IntVar[]{fox,zeb}, tuplesInterdits).post();
        model.table(new IntVar[]{hor,sna}, tuplesInterdits).post();
        model.table(new IntVar[]{hor,zeb}, tuplesInterdits).post();
        model.table(new IntVar[]{sna,zeb}, tuplesInterdits).post();

        model.table(new IntVar[]{che,koo}, tuplesInterdits).post();
        model.table(new IntVar[]{che,luc}, tuplesInterdits).post();
        model.table(new IntVar[]{che,old}, tuplesInterdits).post();
        model.table(new IntVar[]{che,par}, tuplesInterdits).post();
        model.table(new IntVar[]{koo,luc}, tuplesInterdits).post();
        model.table(new IntVar[]{koo,old}, tuplesInterdits).post();
        model.table(new IntVar[]{koo,par}, tuplesInterdits).post();
        model.table(new IntVar[]{luc,old}, tuplesInterdits).post();
        model.table(new IntVar[]{luc,par}, tuplesInterdits).post();
        model.table(new IntVar[]{old,par}, tuplesInterdits).post();

        
        /************************************************************************
         *                                                                      *
         * Compléter en ajoutant les contraintes modélisant les phrases 2 à 15  *
         *                                                                      *
         ************************************************************************/
   
 /* 2 */
        model.table(new IntVar[]{eng,red}, tuplesAutorises).post();
        
        /*model.table(new IntVar[]{eng,blu}, tuplesInterdits).post();
        model.table(new IntVar[]{eng,gre}, tuplesInterdits).post();
        model.table(new IntVar[]{eng,ivo}, tuplesInterdits).post();
        model.table(new IntVar[]{eng,yel}, tuplesInterdits).post();
        
        model.table(new IntVar[]{red,jap}, tuplesInterdits).post();
        model.table(new IntVar[]{red,nor}, tuplesInterdits).post();
        model.table(new IntVar[]{red,spa}, tuplesInterdits).post();
        model.table(new IntVar[]{red,ukr}, tuplesInterdits).post();*/
        
 /* 3 */
        model.table(new IntVar[]{dog,spa}, tuplesAutorises).post();
        
        /*model.table(new IntVar[]{spa,fox}, tuplesInterdits).post();
        model.table(new IntVar[]{spa,hor}, tuplesInterdits).post();
        model.table(new IntVar[]{spa,sna}, tuplesInterdits).post();
        model.table(new IntVar[]{spa,zeb}, tuplesInterdits).post();
        
        model.table(new IntVar[]{dog,eng}, tuplesInterdits).post();
        model.table(new IntVar[]{dog,jap}, tuplesInterdits).post();
        model.table(new IntVar[]{dog,nor}, tuplesInterdits).post();
        model.table(new IntVar[]{dog,ukr}, tuplesInterdits).post();*/
        
 /* 4 */
        model.table(new IntVar[]{cof,gre}, tuplesAutorises).post();
        
        /*model.table(new IntVar[]{cof,blu}, tuplesInterdits).post();
        model.table(new IntVar[]{cof,ivo}, tuplesInterdits).post();
        model.table(new IntVar[]{cof,red}, tuplesInterdits).post();
        model.table(new IntVar[]{cof,yel}, tuplesInterdits).post();
        
        model.table(new IntVar[]{gre,mil}, tuplesInterdits).post();
        model.table(new IntVar[]{gre,ora}, tuplesInterdits).post();
        model.table(new IntVar[]{gre,tea}, tuplesInterdits).post();
        model.table(new IntVar[]{gre,wat}, tuplesInterdits).post();*/
        
 /* 5 */
        model.table(new IntVar[]{ukr,tea}, tuplesAutorises).post();
        
        /*model.table(new IntVar[]{ukr,cof}, tuplesInterdits).post();
        model.table(new IntVar[]{ukr,mil}, tuplesInterdits).post();
        model.table(new IntVar[]{ukr,ora}, tuplesInterdits).post();
        model.table(new IntVar[]{ukr,wat}, tuplesInterdits).post();
        
        model.table(new IntVar[]{tea,eng}, tuplesInterdits).post();
        model.table(new IntVar[]{tea,jap}, tuplesInterdits).post();
        model.table(new IntVar[]{tea,nor}, tuplesInterdits).post();
        model.table(new IntVar[]{tea,spa}, tuplesInterdits).post();*/
        
 /* 6 */
        int [][] tEq2 = new int[][] {{1,2},{2,3},{3,4},{4,5}};
        Tuples tuplesAutorises2 = new Tuples(tEq2,true);		// création de Tuples de valeurs autorisés
        //Tuples tuplesInterdits2 = new Tuples(tEq2,false);
        
        model.table(new IntVar[] {ivo,gre}, tuplesAutorises2).post();
        
 /* 7 */
        model.table(new IntVar[]{old,sna}, tuplesAutorises).post();
        
 /* 8 */
        model.table(new IntVar[]{koo,yel}, tuplesAutorises).post();
        
 /* 9 */
        int [][] tEq3 = new int[][] {{3}};
        Tuples tuplesAutorises3 = new Tuples(tEq3,true);		// création de Tuples de valeurs autorisés
        //Tuples tuplesInterdits3 = new Tuples(tEq3,false);
        
        model.table(new IntVar[]{mil}, tuplesAutorises3).post();
        
/* 10 */
        int [][] tEq4 = new int[][] {{1}};
        Tuples tuplesAutorises4 = new Tuples(tEq4,true);
        
        model.table(new IntVar[]{nor}, tuplesAutorises4).post();
        
/* 11 */
        int [][] tEq5 = new int[][] {{1,2},{2,1},{2,3},{3,2},{3,4},{4,3},{4,5},{5,4}};
        Tuples tuplesAutorises5 = new Tuples(tEq5,true);
        
        model.table(new IntVar[]{che,fox}, tuplesAutorises5).post();
        
/* 12 */
        model.table(new IntVar[]{koo,hor}, tuplesAutorises5).post();
        
/* 13 */
        model.table(new IntVar[]{luc,ora}, tuplesAutorises).post();
        
/* 14 */
        model.table(new IntVar[]{jap,par}, tuplesAutorises).post();
        
/* 15 */
        model.table(new IntVar[]{nor,blu}, tuplesAutorises5).post();
        
        
        // Affichage du réseau de contraintes créé
        System.out.println("*** Réseau Initial ***");
        System.out.println(model);
        

        // Calcul de la première solution
        if(model.getSolver().solve()) {
        	System.out.println("\n\n*** Première solution ***");        
        	System.out.println(model);
        	model.getSolver().showSolutions();
        }

        
        
    	// Calcul de toutes les solutions
    	System.out.println("\n\n*** Autres solutions ***");        
        while(model.getSolver().solve()) {  	
            System.out.println("Sol "+ model.getSolver().getSolutionCount()+"\n"+model);
	    }
	    
 
        
        // Affichage de l'ensemble des caractéristiques de résolution
      	System.out.println("\n\n*** Bilan ***");        
        model.getSolver().printStatistics();

	}
}
