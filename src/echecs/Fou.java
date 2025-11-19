package echecs;

public class Fou extends Piece{
    public Fou(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return  estSurEchiquier(arrivee) &&
                Math.pow(arrivee.getLigne() - depart.getLigne(),2) == Math.pow(arrivee.getColonne() - depart.getColonne(),2);
    }
}
