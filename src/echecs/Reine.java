package echecs;

public class Reine extends Piece{
    public Reine(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return  estSurEchiquier(arrivee) && (
                depart.getColonne() == arrivee.getColonne() ||
                depart.getLigne() == arrivee.getLigne() ||
                Math.pow(arrivee.getLigne() - depart.getLigne(),2) == Math.pow(arrivee.getColonne() - depart.getColonne(),2));
    }
}
