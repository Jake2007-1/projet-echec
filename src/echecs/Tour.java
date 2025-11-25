package echecs;

public class Tour extends Piece{

    public Tour(Couleur couleur) {
        super(Type.TOUR, couleur);
    }

    @Override
    public boolean estValideSpecifique(Position depart, Position arrivee) {
        return  (
                depart.getColonne() == arrivee.getColonne() || depart.getLigne() == arrivee.getLigne());

    }
}
