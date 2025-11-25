package echecs;

public class Echiquier implements MethodesEchiquier {
    private Case[][] echiquier;

    public Echiquier() {
        echiquier = new Case[8][8];
        initCase();
    }

    private void initCase(){
        for(int i = 0; i < 8; i++){
            for (int ii = 0; ii < 8; ii++){
                echiquier[i][ii] = new Case();
            }
        }
    }


    @Override
    public void debuter() {
        for (int i = 0; i < 8; i++) {
            echiquier[1][i].setPiece(new Pion(Piece.Couleur.NOIR));
            echiquier[6][i].setPiece(new Pion(Piece.Couleur.BLANC));
            switch (i){
                case 0:
                case 7:
                    echiquier[0][i].setPiece(new Tour(Piece.Couleur.BLANC));
                    echiquier[7][i].setPiece(new Tour(Piece.Couleur.NOIR));
                    break;
                case 1:
                case 6:
                    echiquier[0][i].setPiece(new Cavalier(Piece.Couleur.BLANC));
                    echiquier[7][i].setPiece(new Cavalier(Piece.Couleur.NOIR));
                    break;
                case 2:
                case 5:
                    echiquier[0][i].setPiece(new Fou(Piece.Couleur.BLANC));
                    echiquier[7][i].setPiece(new Fou(Piece.Couleur.NOIR));
                    break;
                case 3:
                    echiquier[0][i].setPiece(new Reine(Piece.Couleur.BLANC));
                    echiquier[7][i].setPiece(new Reine(Piece.Couleur.NOIR));
                    break;
                case 4:
                    echiquier[0][i].setPiece(new Roi(Piece.Couleur.BLANC));
                    echiquier[7][i].setPiece(new Roi(Piece.Couleur.NOIR));
                    break;
            }

        }
    }

    @Override
    public Case getCase(int ligne, int colonne) {
        return echiquier[ligne][colonne];
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee) {
        return false;
    }

    @Override
    public boolean captureParUnPionPossible(Position depart, Position arrivee) {
        return false;
    }
}
