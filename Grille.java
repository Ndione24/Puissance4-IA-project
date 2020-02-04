package up.mi.ken;

public class Grille {
	private static int[][] grille =new int[7][7];

	/**
	 * Constructeur qui initialise la ligne et la colonne à 7
	 */
	public Grille() {
	
	}
	/**
	 * met tout à zero
	 */
	public static void initialiserGrille() {
		for(int i=0;i<7;i++)
			for(int j=0;j<7;j++)
				grille[i][j]=0;
	}

	private static void afficherNumColonnes() {

		for (int i = 1; i <= 7; i++) {
			System.out.print("  " + i + " ");
		}
	}

	/**
	 * méthode retournant une réf de cette grille
	 * 
	 * @return la grille
	 */
	public static int[][] getGrille() {
		return grille;
	}

	/**
	 * cette méthode affiche l'etat courant de la grille
	 */
	public static void afficherGrille() {
		afficherNumColonnes();
		System.out.println();

		for (int i = 0; i < 7; i++) {
			System.out.print("+---+---+---+---+---+---+---+\n");
			System.out.print("|");

			for (int j = 0; j < 7; j++) {
				System.out.print(" " + grille[i][j] + " " + "|");
			}
			System.out.print("\n");
		}
		System.out.print("+---+---+---+---+---+---+---+\n");
		afficherNumColonnes();
		System.out.println("\n\n");
	}

	/**
	 * Méthode nous disant si la case est pleine ou pas
	 * 
	 * @param numColonne le numero de la colonne
	 * @return un boolean indiquant si on peut continuer à jour ou pas
	 */
	public static boolean coupPossible(int numColonne) {
		boolean b = false;
		if(!estColonnePleine(numColonne)) 
		{
			b=true;
		}
		

		return b;
	}

	/**
	 * permet de savoir si une colonne est pleine ou pas
	 * @param col le numéro de la colonne
	 * @return vraie su la colonne est pleine
	 */
	public static boolean estColonnePleine(int col) {
	return grille[0][col]!=0;
	}
	
	/**
	 * place le pion du joueur dans la colonne donnée
	 * @param col le numéro de la colonne
	 * @param player le numéro du joueur
	 */
	public static void playColumn (int col , int player) {
		Joueur.setNumJoueur(player);
		Joueur.jouerCoup(col);
	}
	
	/**
	 * determine si la partie est remportée par 
	 * un joueur
	 * @return vrai si on a 4 pions alignés
	 */
	public static boolean  aGagneJoueur() 
	{//A faire!!!
		boolean b=false;
		return b;
	}
	
	/**
	 * Permet de chercher 4 pions alignés
	 * dans la grille
	 * @return vrai si on a 4 pions de même
	 * 
	 */
	public static boolean hAlign() 
	{  
		int ligne =6;
		int col=0;
		int compteur=0;
		int pion=0;
		int i=1;
		while(ligne>=0 && col<7 && !(compteur==4)) 
		{
			//si le jeu a commencé
			if(grille[ligne][col]!=0) 
			{
				pion=grille[ligne][col];
				compteur++;
				while(i<7) 
				{
					col=i;
					if(pion==grille[ligne][col]) 
					{
						compteur++;
						i++;
						if(compteur==4) 
						{
							return true;
						}
					}else 
					{ compteur=0;
					pion=grille[ligne][col];
					  i++;
					}
					//si on a parcourue toute la ligne
					if(i==6) col=0;
					
				}
			}
			if(pion!=0 && compteur==4) 
			{
				return true;
			}
			//on passe à la ligne d'en haut de la grille
			ligne--;
		}//fin while
		
		//si on a pas de pions alignés
		return false;
	}
}
