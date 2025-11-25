package echecs;

public class Cavalier extends Piece{
    public Cavalier(Couleur couleur) {
        super(Type.CAVALIER, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        return  (
                depart.getColonne() == arrivee.getColonne() && depart.getLigne() == arrivee.getLigne() ||
                (depart.getLigne() != arrivee.getLigne()) && (
                        depart.getColonne() + 1 == arrivee.getColonne() && depart.getLigne() + 2 == arrivee.getLigne() ||
                        depart.getColonne() + 1 == arrivee.getColonne() && depart.getLigne() - 2 == arrivee.getLigne() ||
                        depart.getColonne() - 1 == arrivee.getColonne() && depart.getLigne() + 2 == arrivee.getLigne() ||
                        depart.getColonne() - 1 == arrivee.getColonne() && depart.getLigne() - 2 == arrivee.getLigne() ||
                        depart.getColonne() + 2 == arrivee.getColonne() && depart.getLigne() + 1 == arrivee.getLigne() ||
                        depart.getColonne() + 2 == arrivee.getColonne() && depart.getLigne() - 1 == arrivee.getLigne() ||
                        depart.getColonne() - 2 == arrivee.getColonne() && depart.getLigne() + 1 == arrivee.getLigne() ||
                        depart.getColonne() - 2 == arrivee.getColonne() && depart.getLigne() - 1 == arrivee.getLigne()
                        )
                );
    }
}
