/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp3;

import java.io.Serializable;

/**
 ** ****************************************** */
/* Classe représentant l'information échangée */
/* ****************************************** */
public class Action implements Serializable {
        String titre;
        String societe;
        float cours;
        public Action(String intitule, String proprietaire, float cout) {
          super();
          titre = intitule;
          societe = proprietaire;
          cours = cout;
        }
        public String getString() {
                return titre;
        }
        public String getSociete() {
                return societe;
        }
        public float getCours() {
                return cours;
        }
        public void setCours(float valeur) {
                cours = valeur;
        }
}

