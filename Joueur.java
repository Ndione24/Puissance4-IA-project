package up.mi.ken;

public class Joueur {
	private static int numJoueur=1;

	public Joueur() {
		
	}

	public static int getNumJoueur() {
		return numJoueur;
	}

	public static void setNumJoueur(int numJoueur) {
		Joueur.numJoueur = numJoueur;
	}

	public static void jouerCoup(int numColonne) 
	{
		int i=6;
		while(i>=0 && !Grille.estColonnePleine(numColonne)) 
		{
			if(Grille.getGrille()[i][numColonne-1]==0) 
			{
				Grille.getGrille()[i][numColonne-1]=Joueur.getNumJoueur();
				return;
			}
			else i--;
		}
	}

	/**
	 * 
	 * @param player le numéro couraant du joueur
	 * @return le numéro du joueur suivant
	 */
	public static int joueurSuivant(int player) {
		if (Joueur.getNumJoueur() == 1)
			return 2;
		else
			return 1;
	}
}
