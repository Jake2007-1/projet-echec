package echecs;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private Pion p1;
    private Pion p2;

    private Fou f1;
    private Fou f2;

    private Cavalier c1;
    private Cavalier c2;

    private Tour t1;
    private Tour t2;

    private Reine re1;
    private Reine re2;

    private Roi r1;
    private Roi r2;

    @BeforeEach
    void setUp() {
        p2 = new Pion(Piece.Type.PION, Piece.Couleur.NOIR);
        p1 = new Pion(Piece.Type.PION, Piece.Couleur.BLANC);

        r1 = new Roi(Piece.Type.ROI, Piece.Couleur.NOIR);
        r2 = new Roi(Piece.Type.ROI, Piece.Couleur.BLANC);

        re1 = new Reine(Piece.Type.REINE, Piece.Couleur.NOIR);
        re2 = new Reine(Piece.Type.REINE, Piece.Couleur.BLANC);

        f1 = new Fou(Piece.Type.FOU, Piece.Couleur.NOIR);
        f2 = new Fou(Piece.Type.FOU, Piece.Couleur.BLANC);

        c1 = new Cavalier(Piece.Type.CAVALIER, Piece.Couleur.NOIR);
        c2 = new Cavalier(Piece.Type.CAVALIER, Piece.Couleur.BLANC);

        t1 = new Tour(Piece.Type.TOUR, Piece.Couleur.NOIR);
        t2 = new Tour(Piece.Type.TOUR, Piece.Couleur.BLANC);
    }
    @org.junit.jupiter.api.Test
    void estValide() {
        assertTrue(p1.estValide(new Position(1,1), new Position(2,1)));
        assertTrue(p2.estValide(new Position(1,1), new Position(0,1)));
        assertFalse(p2.estValide(new Position(2,1), new Position(3,1)));
        assertFalse(p1.estValide(new Position(1,1), new Position(0,1)));

        assertTrue(c1.estValide(new Position(0,0), new Position(1,2)));
        assertTrue(c2.estValide(new Position(0,0), new Position(2,1)));
        assertFalse(c1.estValide(new Position(2,1), new Position(3,1)));
        assertFalse(c2.estValide(new Position(1,1), new Position(0,5)));

        assertTrue(f1.estValide(new Position(1,1), new Position(3,3)));
        assertTrue(f2.estValide(new Position(6,6), new Position(2,2)));
        assertFalse(f1.estValide(new Position(1,1), new Position(3,1)));
        assertFalse(f2.estValide(new Position(6,0), new Position(0,1)));

        assertTrue(t1.estValide(new Position(2,1), new Position(1,1)));
        assertTrue(t2.estValide(new Position(0,1), new Position(2,1)));
        assertFalse(t1.estValide(new Position(2,2), new Position(3,1)));
        assertFalse(t2.estValide(new Position(1,3), new Position(0,1)));

        assertTrue(r1.estValide(new Position(1,1), new Position(1,2)));
        assertTrue(r2.estValide(new Position(1,1), new Position(2,2)));
        assertFalse(r1.estValide(new Position(2,1), new Position(5,1)));
        assertFalse(r2.estValide(new Position(3,1), new Position(0,1)));

        assertTrue(re1.estValide(new Position(0,0), new Position(0,7)));
        assertTrue(re2.estValide(new Position(3,3), new Position(5,5)));
        assertFalse(re1.estValide(new Position(7,2), new Position(3,1)));
        assertFalse(re2.estValide(new Position(4,1), new Position(0,2)));
    }
}