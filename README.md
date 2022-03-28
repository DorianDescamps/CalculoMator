# CalculoMator

Projet d'android studio afin de créer une application de calcul mental avec la possibilité d'enregistrer son résultat dans une base de données.

Il y a 3 modes de jeux :

  Classique : Le but, faire le plus de points possible le plus rapidement sans se tromper !

       - Il y a un timer de 10 secondes qui se lance au démarrage de l'activité, et on a 3 vies.
       - Quand on se trompe, on perds une vie
       - Quand on réussis le calcul, le timer est réinitialisé a 10 secondes
       - Si on se trompe 3 fois d'affilés, ou que le timer atteint 0, l'activité se ferme, et on nous propose d'enregistrer notre résultat avec un pseudo

  Chronométré : Le but, faire le plus gros score en 60 secondes !

      - Il y a un timer de 60 secondes qui se lance au démarrage de l'activité
      - Quand on se trompe on perds 1 point, si on ne se trompe pas on gagne 1 point (le résultat final peut être négatif)
      - A la fin des 60 secondes, l'activité se ferme, et on nous propose d'enregistrer notre résultat avec un pseudo

  Infini : Pas de vies, pas de timer, juste vous et le calcul !

      - Il y a un bouton fin pour arrêter l'activité, et pouvoir enregistrer son résultat
      

La base de donnés est visualisable sous forme de liste avec le mode de jeu, le pseudo et le score obtenu a la fin d'un mode de jeu, pendant 10 secondes après avoir rentré son pseudo, après ces 10 secondes, l'activité se ferme et on retourne a l'écran des modes de jeux.

L'activité crédits, est accéssible depuis l'activité des modes de jeux dans la toolbar.

  Points améliorables :

      - L'UI
      - Vraiment arrêter les activités quand on fait un retour arrière
      - Pouvoir accéder au tableau de scores sans lancer un mode de jeu
