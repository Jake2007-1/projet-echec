package echecs;

public class Tour extends Piece{

    public Tour(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return  estSurEchiquier(arrivee) && (
                depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne());

    }
}
