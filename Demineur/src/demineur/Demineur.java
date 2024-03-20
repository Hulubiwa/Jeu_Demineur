/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demineur;

/**
 *
 * @author jules
 */
public class Demineur {
    
    /*
    Cette classe sert dans le jeu de classe principale
    */

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
    
        System.out.println("Bienvenue sur le Jeu du Démineur");
        System.out.println();
        System.out.print("Veuillez Choisir votre niveau de difficulté (de 1 à 9): ");
        int d;
        do{
            /*
            Cette boucle permet de s'arrurer que le joueur entre un nivieau de difficulté
            valide
            */
            d = Lire.i();
            if(d<1 || d>9)
                // message indiquant que la difficulté est invalide
                System.out.print("Difficulté invalide, recommencez : ");
        }while(d<1 || d>9);
        System.out.println();
        System.out.println("Veuillez maintenant entrer les dimension de votre Plateau de jeu :");
        int l,c;
        //récupération des dimensions
        do{
            // On s'assure que les dimensions ne soit pas négative
            System.out.print("Nombre de ligne : ");
            l = Lire.i();
            System.out.println();
            System.out.print("Nombre de colonne : ");
            c = Lire.i();
            if(c<0 || l<0)
                System.out.println("Les dimensions ne peuvent pas être négatives, recommencez : ");
        }while(c<0 || l<0);
        Jeu jeu = new Jeu(l, c, d);
        System.out.println();
        System.out.println("Nombre de mines : "+jeu.getNbMines());
        System.out.println();
        jeu.joue();
    }
    
}
