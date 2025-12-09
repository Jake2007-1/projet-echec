package echecs;

public class Case {
    private Piece piece;

    public Case() {
        piece = null;
    }
    public Case(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean estOccupe(){
        return piece != null;
    }

    public boolean estOccupeCouleur(Piece.Couleur couleur){
        if (!estOccupe())
            return false;
        return piece.getCouleur() == couleur;
    }

    public Piece prendrePiece(Piece nouvellePiece){
        Piece temp = piece;
        piece = nouvellePiece;
        return temp;
    }


}
