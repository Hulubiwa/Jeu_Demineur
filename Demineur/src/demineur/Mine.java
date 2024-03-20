/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package demineur;

/**
 *
 * @author jules
 */
public class Mine extends Case{
    
    /*
        Cette classe est une sous classe de la super classe Case
    */
    
    //code qui permet de modifier la couleur d'un texte.
    public static final String ANSI_RESET ="\u001B[0m";
    public static final String ANSI_RED ="\u001B[31m";
    
//Attributs
    
    // ne possède pas d'attribut
    
//Constructeur
    
    public Mine(Plateau pl, int l, int c) {
        super(pl, l, c); //appel du constructeur de la superclasse
    }     
//Méthodes
    
   public void ActivationCase(){
       /*
       Quand le joueur sélectionne une mine cela provoque la fin du jeu. On modifie
       la description de la mine sélectionnée par "[ m ]", puis on fais de même
       avec toutes les mines du plateau.
       */
       this.description = ("["+ANSI_RED + " m " + ANSI_RESET+"]"); 
       for(int i=0; i<getPlateau().getLigne(); i++){
           for(int j=0; j<getPlateau().getColonne(); j++){
               if(this.getPlateau().getCase(i, j) instanceof Mine){
                   // modification des desccriptions de toutes les mines du plateau
                   this.getPlateau().getCase(i, j).setDescription("["+ANSI_RED + " m " + ANSI_RESET+"]"); // cette boucle dévoile  toutes les mines dans le plateau
               }
           }
       }
       this.P.setGagne(false); // affecte le statut du joueur à perdu
       this.P.setTermine(true); // indique la fin du jeu
   } 
    
}
