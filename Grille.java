package up.mi.ken;

package ia.ndione.project;

public class Grille {
	private static char[][] grille = new char[6][7];

	
	/**
	 * Constructeur qui initialise la ligne et la colonne à 7
	 */
	public Grille() {

	}

	/**
	 * met tout à zero
	 */
	public static void initialiserGrille() {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++)
				grille[i][j] = '0';
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
	public static char[][] getGrille() {
		return grille;
	}

	/**
	 * cette méthode affiche l'etat courant de la grille
	 */
	public static void afficherGrille() {
		afficherNumColonnes();
		System.out.println();

		for (int i = 0; i < 6; i++) {
			System.out.print("+---+---+---+---+---+---+---+\n");
			System.out.print("|");

			for (int j = 0; j < 7; j++) {
				if (grille[i][j] == '0') {
					System.out.print("   " + "|");
				} else {
					System.out.print(" " + grille[i][j] + " " + "|");
				}
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
		if (!estColonnePleine(numColonne)) {
			b = true;
		}

		return b;
	}

	/**
	 * methode qui retourne true si une colonne est pleine
	 * 
	 * @param numCol
	 * @return bool
	 */
	public boolean isColFull(int numCol) {
		return true;
	}

	/**
	 * permet de savoir si une colonne est pleine ou pas
	 * 
	 * @param col le numéro de la colonne
	 * @return vraie si la colonne est pleine
	 */
	public static boolean estColonnePleine(int col) {
		return grille[0][col - 1] != '0';
	}

	/**
	 * place le pion du joueur dans la colonne donnée
	 * 
	 * @param col    le numéro de la colonne
	 * @param player le numéro du joueur
	 */
	public static void playColumn(int col, int player) {
		Joueur.setNumJoueur(player);
		Joueur.jouerCoup(col);
	}

	/**
	 * determine si la partie est remportée par un joueur
	 * 
	 * @return vrai si on a 4 pions alignés
	 */
	public static boolean aGagneJoueur() {// A faire!!!
		boolean b = false;
		return b;
	}

	/**
	 * verifie s'il ya un alignement diagonal montant de quatre pion d'un joueur
	 * 
	 * @return
	 */
	
	public static boolean diagonalGAlign(int ligne,int column, char bonHommeJoueur)
	{
		
		if((column<3)|| (ligne>3)) 
		{
			
			return false;
		}
		for(int i=0;i<4;i++,ligne++,column--) 
		{
			if(grille[ligne][column]!=bonHommeJoueur) 
			{
				
				System.out.println("in if "+grille[ligne][column]);
				System.out.println("column "+ column+ "ligne "+ligne);

				return false;
			}
		}
		return true;

	}
	
	

	/**
	 * verifie s'il ya un alignement diagonal descendant de quatre pion d'un joueur
	 * 
	 * @return
	 */
	public static boolean diagonalDAlign(int ligne,int column, char bonHommeJoueur) {
		if((column>3) || (ligne>2)) 
		{
			return false;
		}
		for(int i=0;i<4;i++,ligne++,column++) 
		{
			if(grille[ligne][column]!=bonHommeJoueur) 
			{
				return false;
			}
		}
		return true;

	}
	
	

	/**
	 * verifie s'il ya un alignement vertical de quatre pion d'un joueur
	 * 
	 * @return
	 */
	public static boolean vAlign(int ligne,int column, char bonHommeJoueur){
		if(ligne>2) 
		{
			return false;
		}
		
		for(int i=0;i<4;i++,ligne++) 
		{
			if(grille[ligne][column]!=bonHommeJoueur) 
			{
				return false;
			}
		}
		return true;
		

	}

	/**
	 * Permet de chercher 4 pions alignés dans la grille
	 * 
	 * @return vrai si on a 4 pions de même
	 
	 * 
	 */
	public static boolean hAlign(int ligne,int column, char bonHommeJoueur) {
		
		if(column>4) 
		{
			return false;
		}
		for(int i=0;i<4;i++,column++) 
		{
			if(grille[ligne][column]!=bonHommeJoueur) 
			{
				return false;
			}
		}
		
		return true;
		
	}
	
	
	
	
	/**
	 * return le numero du joueur gagnant
	 *
	 * @param numJoueur
	 * @return 0 si il n'y a pas de joueur gagnant. Return le numero du joueur gagnant au cas contraire
	 */
	
	public static int checkWinner(int ligne,int column, int numJoueur){
		char bonhommeJoueur= Joueur.playerToChar(numJoueur);
		if(vAlign(ligne, column, bonhommeJoueur) || hAlign(ligne, column, bonhommeJoueur) ||diagonalDAlign(ligne, column, bonhommeJoueur)|| diagonalGAlign(ligne, column, bonhommeJoueur) ) 
		{
			return 7;
		}
		
		
		return 0;

	}
	
}

