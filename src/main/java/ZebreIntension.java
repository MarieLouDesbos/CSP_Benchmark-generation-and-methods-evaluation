import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class ZebreIntension {
	public static void main(String[] args) {
		
		// Création du modele
		Model model2 = new Model("Zebre");
		
		
		// Création des variables
		IntVar blu = model2.intVar("Blue", 1, 5);	// blu est une variable entière dont le nom est "Blue" et le domaine [1,5]
		IntVar gre = model2.intVar("Green", 1, 5); 
		IntVar ivo = model2.intVar("Ivory", 1, 5);         
		IntVar red = model2.intVar("Red", 1, 5);         
		IntVar yel = model2.intVar("Yellow", 1, 5);   
		
		IntVar eng = model2.intVar("English", 1, 5);         
		IntVar jap = model2.intVar("Japanese", 1, 5);         
		IntVar nor = model2.intVar("Norwegian", 1, 5);         
		IntVar spa = model2.intVar("Spanish", 1, 5);         
		IntVar ukr = model2.intVar("Ukrainian", 1, 5);         
		
		IntVar cof = model2.intVar("Coffee", 1, 5);         
		IntVar mil = model2.intVar("Milk", 1, 5);         
		IntVar ora = model2.intVar("Orange Juice", 1, 5);         
		IntVar tea = model2.intVar("Tea", 1, 5);         
		IntVar wat = model2.intVar("Water", 1, 5);         
		
	    IntVar dog = model2.intVar("Dog", 1, 5);         
	    IntVar fox = model2.intVar("Fox", 1, 5);         
	    IntVar hor = model2.intVar("Horse", 1, 5);         
	    IntVar sna = model2.intVar("Snail", 1, 5);         
	    IntVar zeb = model2.intVar("Zebra", 1, 5);         
	    
	    IntVar che = model2.intVar("Chesterfield", 1, 5);         
	    IntVar koo = model2.intVar("Kool", 1, 5);         
	    IntVar luc = model2.intVar("Lucky Strike", 1, 5);         
	    IntVar old = model2.intVar("Old Gold", 1, 5);         
	    IntVar par = model2.intVar("Parliament", 1, 5);
	    
	    //création des contraintes
	    /* 1 */
	    model2.allDifferent(blu, gre, ivo, red, yel).post();//OK
	    model2.allDifferent(eng, jap, nor, spa, ukr).post();
	    model2.allDifferent(cof, mil, ora, tea, wat).post();
	    model2.allDifferent(dog, fox, hor, sna, zeb).post();
	    model2.allDifferent(che, koo, luc, old, par).post();
	    
	    /* 2 */
	    model2.arithm(eng, "=", red).post();
	    
	    /* 3 */
	    model2.arithm(spa, "=", dog).post();
	    
	    /* 4 */
	    model2.arithm(cof, "=", gre).post();
	    
	    /* 5 */
	    model2.arithm(ukr, "=", tea).post();
	    
	    /* 6 */
	    model2.arithm(gre, "-", ivo, "=", 1).post();
	    
	    /* 7 */
	    model2.arithm(old, "=", sna).post();
	    
	    /* 8 */
	    model2.arithm(koo, "=", yel).post();
	    
	    /* 9 */
	    model2.arithm(mil, "=", 3).post();
	    
	    /* 10 */
	    model2.arithm(nor, "=", 1).post();
	    
	    /* 11 */
	    //abs(gre - ivo) = 1;
	    
	    //model.absolute(vabs, p).post();
	    
	    IntVar dif = model2.intVar("dif", -4, 4);
	    model2.arithm(che,"-", fox, "=", dif).post();
	    IntVar absDif = model2.intVar("absdif", 0, 4);
	    model2.absolute(absDif, dif).post();
	    model2.arithm(absDif, "=", 1).post();
	    
	
	    
	    /* 12 */
	    IntVar dif2 = model2.intVar("dif2", -4, 4);
	    model2.arithm(koo,"-", hor, "=", dif2).post();
	    IntVar absDif2 = model2.intVar("absdif2", 0, 4);
	    model2.absolute(absDif2, dif2).post();
	    model2.arithm(absDif2, "=", 1).post();
	    
	    /* 13 */
	    model2.arithm(luc, "=", ora).post(); //OK
	    
	    /* 14 */
	    model2.arithm(jap, "=", par).post(); //OK
	    
	    /* 15 */
	    IntVar dif3 = model2.intVar("dif3", -4, 4);
	    model2.arithm(nor,"-", blu, "=", dif3).post();
	    IntVar absDif3 = model2.intVar("absdif3", 0, 4);
	    model2.absolute(absDif3, dif3).post();
	    model2.arithm(absDif3, "=", 1).post();
	    
	    
	 // Affichage du réseau de contraintes créé
        System.out.println("*** Réseau Initial ***");
        System.out.println(model2);
        

        // Calcul de la première solution
        if(model2.getSolver().solve()) {
        	System.out.println("\n\n*** Première solution ***");        
        	System.out.println(model2);
        }

        
        
    	// Calcul de toutes les solutions
    	System.out.println("\n\n*** Autres solutions ***");        
        while(model2.getSolver().solve()) {    	
            System.out.println("Sol "+ model2.getSolver().getSolutionCount()+"\n"+model2);
	    }
	    
 
        
        // Affichage de l'ensemble des caractéristiques de résolution
      	System.out.println("\n\n*** Bilan ***");        
        model2.getSolver().printStatistics();
	    
	    
	}

}
