package up.mi.ken;

public class Test {

	public static void main(String[] args) {
		Grille.initialiserGrille();
		
		Joueur.jouerCoup(1);
		Joueur.jouerCoup(1);
		Joueur.setNumJoueur(Joueur.joueurSuivant(2));
		Joueur.jouerCoup(2);
		Joueur.jouerCoup(3);
		Joueur.jouerCoup(1);
		Joueur.jouerCoup(1);
		
		
		Grille.afficherGrille();

	}

}
