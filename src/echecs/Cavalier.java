package echecs;

public class Cavalier extends Piece{
    public Cavalier(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return  estSurEchiquier(arrivee) && (
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
