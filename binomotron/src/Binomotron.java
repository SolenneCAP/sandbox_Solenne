import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.lang.Math;
import java.util.stream.Collectors;

/**
 * Première version du binomotron.
 * <p>
 *     On tire au sort des groupes de taille 2 et on les affiche dans la sortie standard.
 * </p>
 */
public class Binomotron {

    public static HashMap<String, ArrayList<String>> tirerGroupes(ArrayList<String> promo, int nbApprenantsParGroupe)
    {
        // Variable contenant les groupes constitués
        HashMap<String, ArrayList<String>> groupes = new HashMap<String, ArrayList<String>>();
        int nbApprenantsRestants = promo.size();
        int i = 1;

        // Tant qu'il reste des apprenants dans la liste
        while (nbApprenantsRestants > 0) {
            ArrayList<String> groupeCourant = new ArrayList<String>();
            String libelleGroupe = "Groupe " + i;
            i++;

            if (nbApprenantsRestants < nbApprenantsParGroupe) {
                // Pas assez d'apprenants pour faire un groupe complet, on forme un groupe
                // avec les apprenants restants.
                groupeCourant = promo; // copie la liste 'promo'
                nbApprenantsRestants = 0;

            } else {
                // Sinon il y a assez d'apprenants dans la liste donc on fait une boucle
                // pour tirer au sort un apprenant et l'ajouter au groupe courant. Puis
                // quand le groupe courant est plein (donc en fin de boucle) on l'ajoute
                // dans la variable "groupes" qui contient les groupes constitués.

                for (int j = 1; j <= nbApprenantsParGroupe; j++) {
                    // tirage d'un apprenant aléatoire
                    int indiceAleatoire = (int) (Math.random() * (nbApprenantsRestants));

                    // Ajout de l'apprenant au groupe courant
                    groupeCourant.add(promo.get(indiceAleatoire));

                    // On supprime l'apprenant qu'on vient d'ajouter au groupe courant de la promo
                    promo.remove(indiceAleatoire);

                    // On recalcule le nombre d'apprenants restants
                    nbApprenantsRestants = promo.size();
                }
                groupes.put(libelleGroupe, groupeCourant);
            }
        }
        return groupes;
    }


    public static void main(String[] args) throws Exception
    {
        // Connexion à la base de données
        DataServices bdd = new DataServices();

        // Récupération de la promo
        ArrayList<String> promo = bdd.getAllApprenants();

        // Tirage ausort
        System.out.print("Génération des équipes...");
        HashMap<String, ArrayList<String>> groupes = tirerGroupes(promo, 2);
        System.out.println("ok!");

        // On récupère l'ensemble des noms des groupes constitués
        Set<String> nomsDesGroupes = groupes.keySet();

        // Problème : cet ensemble est de type 'Set' et un Set n'est pas ordonné.
        // Donc on le trie dans l'ordre par défaut (qui est l'ordre alphabétique)
        // et on stocke le résultat dans une liste qui, elle, est ordonnée.
        List<String> nomsOrdonnes = nomsDesGroupes.stream().sorted().collect(Collectors.toList());

        // Affichage des résultats
        System.out.println("Résultats : " + groupes.size() + " groupes constitués");
        for (String key : nomsOrdonnes) {
            System.out.println("  - Equipe \"" + key + "\" : " + groupes.get(key));
        }
    }
}
