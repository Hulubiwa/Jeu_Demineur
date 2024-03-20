/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demineur;

/**
 *
 * @author jules
 */
public class Jeu {
    
//Attributs
    
    private int NbM; //nombre de mines
    private Plateau plateau; // Plateau du jeu
    private int nblig, nbcol;   //nombre de ligne et de colonnes
    private int dif; // difficulté du jeu
    
//Constructeur
    
    public Jeu(int lig, int col, int d){
        this.dif = d;
        this.nblig = lig;
        this.nbcol = col;
        this.NbM = (int)(lig*col*d)/10;
        // création d'une instance du type Plateau
        this.plateau = new Plateau(this, lig, col);
    }
    
//Accesseurs

    public Plateau getPlateau() {
        //renvoie le plateau du  jeu
        return plateau;
    }
    
    public int getNbCaseVide(){
        // renvoie le nombre de cases vides sur le plateau 
        return this.nbcol* this.nblig - this.NbM;
    }
    
    public int getNbMines() {
        //renvoie le nombre de mines sur le plateau
        return NbM;
    }
    
    public int getNiveau(){
        //renvoie la difficulté du jeu
        return this.dif;
    }
    
//Méthodes
    
    public void joue(){
        /*
        Cette méthode à pour rôle de s'occuper du déroulement de la partie. Elle
        récupère les coordonnées de la case sélectionnée puis elle active la case en
        faisant appel aux méthodes d'activation d'une case.
        */
        int s, u;
        String de;
        this.plateau.DevoilePlateau();
        do{
            /*
            Cette boucle a pour condition d'arrêt le fait que le jeu s'arrête
            */
            //récupération des coordonnées
            System.out.print("Choisissez une ligne : ");
            s = Lire.i();
            System.out.print("Choisissez une colonne : ");
            u = Lire.i();
            // activation de la case avec la méthode ActivationCase()
            this.plateau.getCase(s, u).ActivationCase();
            /*
            la méthode DevoilePlateau affiche le plateau avec les dernières modifications
            effectuées.
            */
            this.getPlateau().DevoilePlateau();
        }while(this.plateau.getTermine() == false && this.plateau.getNbCaseVide()>0);
        /*
        le jeu est terminé on regarde donc si le joueur a gagné ou perdu
        */
        if(this.plateau.getGagne() == true)
            System.out.println("Vous avez gagné !\n");
        else
            System.out.println("Vous avez perdu !\n");
        /*
        Dans la partie qui suit, on propose au joueur de lancer une nouvelle partie, Si
        elle est lancée, on lui demande de nouvelles dimension et un nouveau niveau.
        */
        do{
            System.out.print("Voulez-vous rejouez ? (Y/N) : ");
            de = Lire.S();
        }while(de.equals("Y") == false && de.equals("N") == false);
        if(de.equals("Y")){
            System.out.println();
            System.out.print("Veuillez Choisir votre niveau de difficulté (de 1 à 9): ");
            int d;
            do{
                d = Lire.i();
                if(d<1 || d>9)
                    System.out.print("Difficulté invalide, recommencez : ");
            }while(d<1 || d>9);
            System.out.println();
            System.out.println("Veuillez maintenant entrer les dimension de votre Plateau de jeu :");
            int l,c;
            do{
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
        else
            System.out.println("MERCI D'AVOIR JOUE");
    }
}
