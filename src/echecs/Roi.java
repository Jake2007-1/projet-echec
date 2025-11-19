package echecs;

public class Roi extends Piece{
    public Roi(Type type, Couleur couleur) {
        super(type, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        return  estSurEchiquier(arrivee) && (
                (depart.getColonne() + 1 == arrivee.getColonne() && depart.getLigne() == arrivee.getLigne()) ||
                (depart.getColonne() - 1 == arrivee.getColonne() && depart.getLigne() == arrivee.getLigne()) ||
                (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne()) ||
                (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne()) ||
                (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() + 1 == arrivee.getColonne()) ||
                (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() - 1 == arrivee.getColonne()) ||
                (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() + 1 == arrivee.getColonne()) ||
                (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() - 1 == arrivee.getColonne()));
    }
}
