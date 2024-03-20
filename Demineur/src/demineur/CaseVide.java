/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demineur;

/**
 *
 * @author jules
 */
public class CaseVide extends Case{
    
    /*
        Cette classe est une sous classe de la super classe Case
    */
    
    //code qui permet de modifier la couleur d'un texte.
    public static final String ANSI_RESET ="\u001B[0m";
    public static final String ANSI_BLACK ="\u001B[30m";
    public static final String ANSI_RED ="\u001B[31m";
    public static final String ANSI_GREEN ="\u001B[32m";
    public static final String ANSI_YELLOW ="\u001B[33m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_PURPLE ="\u001B[35m";
    public static final String ANSI_CYAN ="\u001B[36m";
    public static final String ANSI_WHITE ="\u001B[37m";
    
//Attributs
    
    private Voisinage voisinage;
    
//Constructeur
    
    public CaseVide(Plateau pl, int l, int c) {
        super(pl, l, c);    //appel du constructeur de la superclasse
        this.voisinage = new Voisinage(this);   // récupère le voisinage de la case
    } 
    
//Accesseurs

    public Voisinage getVoisinage() {
        //renvoie le voisinage de la case vide (this)
        return voisinage;
    }
    
    public void setVoisinage(Voisinage voisinage){
        //modifie le voisinage de la case vide (this)
        this.voisinage = voisinage;
    } 

//Méthodes
    public void ActivationCase() {
        /*
            Le joueur a selectionné une case vide. On vérifie si le voisinage 
        de la case vides possède des mines. Si oui, alors on modifie la description
        de la case pour qu'elle affiche le nombre de mines dans son voisinage.
        Sinon on active toutes les cases de sont voisinage
        */
        int ct = this.P.getNbCaseVide();
        ct--;
        this.P.setNbCasevide(ct);
        if(this.voisinage.getNbMines()>0){
            // il y a des mines dans le voisinage de la cases
            int d = this.voisinage.getNbMines(); // nombre de mines
            String s = "";
            switch(d){
                //En fonction du nombre de mines on affecte une couleur au text
                case 1 : {
                    s = (ANSI_PURPLE+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 2 : {
                    s = (ANSI_CYAN+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 3 : {
                    s = (ANSI_GREEN+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 4 : {
                    s = (ANSI_YELLOW+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 5 : {
                    s = (ANSI_BLUE+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 6 : {
                    s = (ANSI_BLACK+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 7 : {
                    s = (ANSI_WHITE+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
                
                case 8 : {
                    s = (ANSI_RED+this.voisinage.getNbMines()+ANSI_RESET);
                }break;
            }
            setDescription("[ "+s+" ]"); // modifie la description de la case vide
        }
        else{
            // il n'y a pas de mines dans le voisinage de la case vide
            setDescription("[   ]"); //modification de la description de la case vide
            this.voisinage.ActivationVoisinage(); // activation des cases du voisinage
        }
    } 
    
}
