package projet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.extension.Tuples;
import org.chocosolver.solver.variables.IntVar;

//pour la partie C
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class Expe {

	private static Model lireReseau(BufferedReader in) throws Exception{
			Model model = new Model("Expe");
			int nbVariables = Integer.parseInt(in.readLine());				// le nombre de variables
			int tailleDom = Integer.parseInt(in.readLine());				// la valeur max des domaines
			IntVar []var = model.intVarArray("x",nbVariables,0,tailleDom-1); 	
			int nbConstraints = Integer.parseInt(in.readLine());			// le nombre de contraintes binaires		
			for(int k=1;k<=nbConstraints;k++) { 
				String chaine[] = in.readLine().split(";");
				IntVar portee[] = new IntVar[]{var[Integer.parseInt(chaine[0])],var[Integer.parseInt(chaine[1])]}; 
				int nbTuples = Integer.parseInt(in.readLine());				// le nombre de tuples		
				Tuples tuples = new Tuples(new int[][]{},true);
				for(int nb=1;nb<=nbTuples;nb++) { 
					chaine = in.readLine().split(";");
					int t[] = new int[]{Integer.parseInt(chaine[0]), Integer.parseInt(chaine[1])};
					tuples.add(t);
				}
				model.table(portee,tuples).post();	
			}
			in.readLine();
			return model;
	}	
		
	
	//Délimiteurs qui doivent être dans le fichier CSV partie B
		private static final String DELIMITERB = ";";
		private static final String SEPARATORB = "\n";
		    
		//En-tête de fichier
		private static final String HEADERB = "nomFichier;%";
		
		
	//Délimiteurs qui doivent être dans le fichier CSV
	private static final String DELIMITERC = ";";
	private static final String SEPARATORC = "\n";
	    
	//En-tête de fichier
	private static final String HEADERC = "nomFichier;tempsCPUMoyen";
	
			
	public static void main(String[] args) throws Exception{
		/* PARTIE 0 */
		/*
		String ficName = "bench.txt";
		int nbRes=3;
		BufferedReader readFile = new BufferedReader(new FileReader(ficName));
		for(int nb=1 ; nb<=nbRes; nb++) {
			Model model=lireReseau(readFile);
			if(model==null) {
				System.out.println("Problème de lecture de fichier !\n");
				return;
			}
			System.out.println("Réseau lu "+nb+" :\n"+model+"\n\n");
		}*/
		
		/* PARTIE A */
	
		//getSolver().solve() pour demander la résolution
		
		//Calculer pour benchInsat et benchSatisf le nb de réseaux qui ont une solution
	 /*   String ficName2 = "benchInsat.txt";
		String ficName3 = "benchSatisf.txt";
		
		BufferedReader readFile2 = new BufferedReader(new FileReader(ficName2));
		BufferedReader readFile3 = new BufferedReader(new FileReader(ficName3));
	
		int cpt2 = 0;
		int cpt3 = 0;
		int nbRes = 3;
		for(int nb=1 ; nb<=nbRes; nb++) { //Pour benchInsat
			Model model=lireReseau(readFile2);//à chaque fois qu'on fait lireReseau on change de réseau dans le fichier
			if(model==null) {
				System.out.println("Problème de lecture de fichier !\n");
				return;
			}
			if(model.getSolver().solve()) {
				cpt2++;
			}
		}
		readFile2.close();
		
		for(int nb=1 ; nb<=nbRes; nb++) { //Pour benchSatisf
			Model model=lireReseau(readFile3);
			if(model==null) {
				System.out.println("Problème de lecture de fichier !\n");
				return;
			}
			if(model.getSolver().solve()) {
				cpt3++;
			}
		}
		readFile3.close();
		
		System.out.println("Nombre de réseaux qui ont une solutions dans 'benchInsat': " + cpt2);
		System.out.println("Nombre de réseaux qui ont une solutions dans 'benchSatisf': " + cpt3);
		*/
		
		
		/* PARTIE B */
		InputStreamReader isr3 = new InputStreamReader(System.in); //Pour pouvoir utiliser l'entrée clavier
		BufferedReader in3 = new BufferedReader(isr3);
		System.out.println("Voulez vous chercher la transition de phase (1) ou calculer le temps CPU (2)?");
		String numExo = in3.readLine();
		if(Integer.parseInt(numExo) == 1) {
			// poucentage de réseaux qui ont au moins 1 solutions : je regarde dans mon réseau 1 si y a une solution puis dans mon réseaux 2 puis 3 etc et je divise par le nombre de réseaux

		
			//Récupérer tous les fichier d'un dossier
			InputStreamReader isr = new InputStreamReader(System.in); //Pour pouvoir utiliser l'entrée clavier
			BufferedReader in2 = new BufferedReader(isr);
			System.out.println("De quel dossier voulez vous évaluer les fichier ? (Densbis1, Densbis2, Densbis3, Densbis4, Densbis5)");
			String nomDir = in2.readLine();
			File dir = new File(nomDir);
			String ficCSV = "";
			if(nomDir.equals("Densbis1")) {
				ficCSV = "Dens1.csv";
			} else if (nomDir.equals("Densbis2")) {
				ficCSV = "Dens2.csv";
			} else if (nomDir.equals("Densbis3")) {
				ficCSV = "Dens3.csv";
			} else if (nomDir.equals("Densbis4")) {
				ficCSV = "Dens4.csv";
			} else if (nomDir.equals("Densbis5")) {
				ficCSV = "Dens5.csv";
			} else System.out.println("Aucun dossier de ce nom");
		
			File outFile = new File(ficCSV); //Créer le fichier CSV
			FileWriter file = null;
			try
			{
			file = new FileWriter(outFile);
			//Ajouter l'en-tête
			file.append(HEADERB);
			//Ajouter une nouvelle ligne après l'en-tête
			file.append(SEPARATORB);
        
			String[] children = dir.list(); //Récupérer la liste des fichiers du dossier
			if (children == null) {
				System.out.println("Le répertoire n'existe pas ou n'est pas un répertoire");
			} else {
				for (int i=0; i<14;i++) { //Pour chaque fichier du dossier
					System.out.println("Je suis dans le for1");
					String nomFichier = children[i]; 
					String nomFichier4 = nomDir + "/" + nomFichier;
					BufferedReader readFile4 = new BufferedReader(new FileReader(nomFichier4));

					int p = nomFichier.lastIndexOf('.');
					if (p>0) {
						nomFichier=nomFichier.substring(0,p); //récupérer le nom du fichier sans l'extension
					}
					int cptB = 0;

					
					for(int j=1; j<=50; j++) {
						//System.out.println("Je suis dans le for2");
						Model model=lireReseau(readFile4);
						if(model==null) {
							System.out.println("Problème de lecture de fichier !\n");
							return;
						}
						if(model.getSolver().solve()) { //Si le réseau a au moins 1 solution
							cptB++;
						}
					}
					float pct = ((float) cptB/50)*100;
					
					//System.out.println(tempsMoyen);
					file.write(nomFichier + "");
					file.write(DELIMITERB);
					file.write(pct + "");
					file.append(SEPARATORB);
				}
				
					
					
			}
    	      
			file.close();
			
		} //Fin du try
		catch(Exception e) {
			e.printStackTrace();
		} //Fin du catch
    		
	
	System.out.println("Terminé");
	
		}//Fin du premier if
		else if(Integer.parseInt(numExo)== 2) {
		
		
		
		/* Partie C */
		
		
		//Time-Out
		//Récupérer tous les fichier d'un dossier
		InputStreamReader isr2 = new InputStreamReader(System.in); //Pour pouvoir utiliser l'entrée clavier
		BufferedReader in2 = new BufferedReader(isr2);
		System.out.println("De quel dossier voulez vous évaluer les fichier ? (Densbis1, Densbis2, Densbis3, Densbis4, Densbis5)");
		String nomDir = in2.readLine();
		File dir = new File(nomDir);
		String ficCSV = "";
		if(nomDir.equals("Densbis1")) {
			ficCSV = "1tempsCPUbis.csv";
		} else if (nomDir.equals("Densbis2")) {
			ficCSV = "2tempsCPUbis.csv";
		} else if (nomDir.equals("Densbis3")) {
			ficCSV = "3tempsCPUbis.csv";
		} else if (nomDir.equals("Densbis4")) {
			ficCSV = "4tempsCPUbis.csv";
		} else if (nomDir.equals("Densbis5")) {
			ficCSV = "5tempsCPUbis.csv";
		} else System.out.println("Aucun dossier de ce nom");
		//System.out.println(ficCSV);
			
			File outFile = new File(ficCSV); //Créer le fichier CSV
			FileWriter file = null;
			try
			{
				file = new FileWriter(outFile);
				//Ajouter l'en-tête
				file.append(HEADERC);
				//Ajouter une nouvelle ligne après l'en-tête
				file.append(SEPARATORC);
	        
				String[] children = dir.list(); //Récupérer la liste des fichiers du dossier
				if (children == null) {
					System.out.println("Le répertoire n'existe pas ou n'est pas un répertoire");
				} else {
					for (int i=0; i<14;i++) { //Pour chaque fichier du dossier
						System.out.println("Je suis dans le for1");
						String nomFichier2 = children[i]; 
						String nomFichier3 = nomDir + "/" + nomFichier2;
						BufferedReader readFile5 = new BufferedReader(new FileReader(nomFichier3));

						int p = nomFichier2.lastIndexOf('.');
						if (p>0) {
							nomFichier2=nomFichier2.substring(0,p); //récupérer le nom du fichier sans l'extension
						}
	    			
						long tempsTotal = 0;
						
						
						for(int j=1; j<=50; j++) {
							//System.out.println("Je suis dans le for2");
							Model model=lireReseau(readFile5);
							Solver s = model.getSolver();
							s.limitTime("10m");
	    			
							//Pour donner le temps d'execution
							ThreadMXBean thread = ManagementFactory.getThreadMXBean();
							double startCPUTime = thread.getCurrentThreadCpuTime(); //en nanosecondes
	    			
							if(s.solve()){ //Lance une résolution qui s'arrête à la première solution trouvée s'il y en a une
								// donner le temps qu'il a mi à trouver la solution
								double cpuTime = thread.getCurrentThreadCpuTime() - startCPUTime;
								tempsTotal+=cpuTime;
	    	        			
							}
							else if(s.isStopCriterionMet()){ //Si la résolution a été arreté par le Time-Out
								//rajouter 2h au temps total
								tempsTotal+= 7200000000000L;
							
								//System.out.println("Le solver n'a pas trouvé une solution ou prouver qu'aucune n'existe dans le temps imparti");
							}
							else {
								//System.out.println("Le solver a prouvé que le problème n'a pas de solution");
								double cpuTime = thread.getCurrentThreadCpuTime() - startCPUTime;
								tempsTotal+=cpuTime;
							}
						}
						double tempsMoyen = (double)(tempsTotal/50);
						//System.out.println(tempsMoyen);
						file.write(nomFichier2);
						file.write(DELIMITERC);
						file.write(tempsMoyen + "");
						file.append(SEPARATORC);
					
						
						
					}
				}
	    	
	    	      
				file.close();
				
			} //Fin du try
			catch(Exception e) {
				e.printStackTrace();
			} //Fin du catch
	    		
		
		System.out.println("Terminé");
		
		}//Fin du if
		
	} //Fin du main
	
} //Fin de la classe Expe
