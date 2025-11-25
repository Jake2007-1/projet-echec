package echecs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {


        Pion pBl;
        Pion pNo;
        Reine rei;
        Roi roi;
        Cavalier cav;
        Fou fou;
        Tour tou;
        Position depart;
        Position arrivee;

        @BeforeEach
        void setUp() {
            pNo = new Pion(Piece.Couleur.NOIR);
            pBl = new Pion(Piece.Couleur.BLANC);
            cav = new Cavalier(Piece.Couleur.BLANC);
            fou = new Fou(Piece.Couleur.BLANC);
            rei = new Reine(Piece.Couleur.BLANC);
            roi = new Roi(Piece.Couleur.BLANC);
            tou = new Tour(Piece.Couleur.BLANC);
            depart = new Position(3, 3);
            arrivee = new Position(3, 3);
        }

        @Test
        void estValidePionN1() {
            depart.setLigne(1);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(3);
            assertTrue(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionN2() {
            depart.setLigne(1);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionN3() {
            depart.setLigne(1);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(3);
            assertFalse(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionN4() {
            depart.setLigne(2);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(3);
            assertFalse(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionN5() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(2);
            assertFalse(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionN6() {
            depart.setLigne(-5);
            depart.setColonne(3);
            arrivee.setLigne(-4);
            arrivee.setColonne(3);
            assertFalse(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionN7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(pNo.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB1() {
            depart.setLigne(6);
            depart.setColonne(3);
            arrivee.setLigne(5);
            arrivee.setColonne(3);
            assertTrue(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB2() {
            depart.setLigne(6);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(3);
            assertTrue(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB3() {
            depart.setLigne(6);
            depart.setColonne(3);
            arrivee.setLigne(7);
            arrivee.setColonne(3);
            assertFalse(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB4() {
            depart.setLigne(5);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertFalse(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB5() {
            depart.setLigne(5);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(2);
            assertFalse(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB6() {
            depart.setLigne(-5);
            depart.setColonne(3);
            arrivee.setLigne(-4);
            arrivee.setColonne(3);
            assertFalse(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValidePionB7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(pBl.estValide(depart, arrivee));
        }

        @Test
        void estValideFou1() {
            depart.setLigne(-5);
            depart.setColonne(3);
            arrivee.setLigne(-4);
            arrivee.setColonne(3);
            assertFalse(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou2() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(4);
            assertTrue(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou3() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(6);
            arrivee.setColonne(6);
            assertTrue(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou4() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(6);
            arrivee.setColonne(0);
            assertTrue(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou5() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(4);
            assertTrue(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou6() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(4);
            assertFalse(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(5);
            assertFalse(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideFou8() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(fou.estValide(depart, arrivee));
        }

        @Test
        void estValideCav1() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(4);
            assertFalse(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideCav2() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(1);
            assertTrue(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideCav3() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideCav4() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(1);
            arrivee.setColonne(4);
            assertTrue(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideCav5() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(5);
            assertTrue(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideCav6() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(6);
            assertFalse(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideCav7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(1);
            arrivee.setColonne(2);
            assertTrue(cav.estValide(depart, arrivee));
        }

        @Test
        void estValideRei1() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei2() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(7);
            arrivee.setColonne(7);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei3() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(6);
            arrivee.setColonne(0);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei4() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(7);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei5() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(7);
            arrivee.setColonne(3);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei6() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(3);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(7);
            arrivee.setColonne(3);
            assertTrue(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei8() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(5);
            assertFalse(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei9() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(1);
            arrivee.setColonne(6);
            assertFalse(rei.estValide(depart, arrivee));
        }

        @Test
        void estValideRei10() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(4);
            assertFalse(rei.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour1() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(3);
            assertTrue(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour2() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(3);
            assertTrue(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour3() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(0);
            assertTrue(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour4() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(4);
            assertFalse(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour5() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(4);
            assertFalse(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour6() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(1);
            arrivee.setColonne(2);
            assertFalse(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(4);
            assertFalse(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderTour8() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(4);
            assertFalse(tou.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi1() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(4);
            assertTrue(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi2() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(2);
            assertTrue(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi3() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(2);
            arrivee.setColonne(4);
            assertTrue(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi4() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(3);
            assertTrue(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi5() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(4);
            arrivee.setColonne(1);
            assertFalse(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi6() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(3);
            arrivee.setColonne(1);
            assertFalse(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi7() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(1);
            arrivee.setColonne(1);
            assertFalse(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi8() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(1);
            arrivee.setColonne(2);
            assertFalse(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi9() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(5);
            arrivee.setColonne(3);
            assertFalse(roi.estValide(depart, arrivee));
        }

        @Test
        void estValiderRoi10() {
            depart.setLigne(3);
            depart.setColonne(3);
            arrivee.setLigne(0);
            arrivee.setColonne(3);
            assertFalse(roi.estValide(depart, arrivee));
        }
    }