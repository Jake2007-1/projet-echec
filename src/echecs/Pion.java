package echecs;

public class Pion extends Piece{
    public Pion(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return
                estSurEchiquier(arrivee) && (
                depart.getColonne() == arrivee.getColonne() &&
                (this.getCouleur() == Couleur.BLANC ? depart.getLigne() + 1 : depart.getLigne() - 1) == arrivee.getLigne());

    }
}
