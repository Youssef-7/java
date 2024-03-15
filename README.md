Travaux Pratiques : Structure d'Arbre Binaire avec
Singleton
Objectif :
L'objectif de ce TP est de créer une structure d'arbre binaire en utilisant une classe récursive
ArbreBinaire. L'arbre vide sera codé sous la forme d'une instance unique.
Partie 1: Définition de la Classe ArbreBinaire
1. Création de la Classe :
o Définissez une classe ArbreBinaire avec les attributs suivants :
▪ clef : un attribut de type Integer représentant la valeur du nœud.
▪ gauche et droite : des attributs de type ArbreBinaire représentant les sousarbres gauche et droit respectivement.
2. Constructeurs :
o Ajoutez un constructeur qui ne prend pas de paramètre et créé l’arbre vide avec une clef
null et des sous-arbres null.
3. Singleton pour l'Arbre Vide :
o Ajoutez un attribut statique arbreVide de type ArbreBinaire qui représente l'instance
unique de l'arbre vide en utilisant le premier constructeur
4. Getters et setters :
o Ajoutez les getters et les setters
5. Méthode creer :
o Ajoutez la méthode créer qui retourne l’arbre vide
Partie 2: Test de l'Application
1. Création de l'Arbre :
o Dans une classe principale (Main), créez une instance de ArbreBinaire représentant un
arbre binaire vide.
2. Insertion de Valeurs :
o Utilisez la méthode d'insertion pour ajouter plusieurs valeurs à l'arbre.
3. Affichage de l'Arbre :
o Utilisez la méthode d'affichage pour afficher l'arbre après l'insertion des valeurs.
Partie 3: Opérations sur l'Arbre Binaire
1. Méthode estVide : cette méthode retourne Vrai ou Faux si l’arbre est vide
2. Méthode taille : cette méthode retourne la taille de cet arbre (i.e le nombre de nœuds)
3. Méthode de Recherche :
o Ajoutez une méthode rechercher pour rechercher une valeur donnée dans l'arbre. La
méthode doit retourner true si la valeur est présente, sinon false.
