# Questions réponses

## Activité B
1. Étudiez le fichier `TextometrieOutils.kt`. Ce fichier contient un ensemble de fonctions encapsulées dans un `object`. Kotlin permet cela dans le cas où l'on souhaite utiliser une seule instance d'un objet dans un programme. Un tel objet est appelé `singleton`. Étudiez la classe de tests `TextometrieOutilsTest`. Observez comment sont appelées les fonctions de l'objet `TextometrieOutils`. Est-ce que la syntaxe vous paraît cohérente avec l'invocation d'une méthode sur un objet ? Justifiez votre réponse. \
   La syntaxe est cohérente avec la notation utilisant le point pour invoquer une méthode sur un objet donné.

2. Quelle est la complexité asymptotique de la fonction `tableauTokens` ? \
   O(n), ne représentant le nombre de caractères dans le texte.
3. Le tableau obtenu est-il trié selon l'ordre alphabétique ? \
   Non, les tokens sont ajoutés dans le tableau suivant l'ordre de leur apparition dans le texte.


## Activité D

Quelle est la complexité asymptotique de la méthode `listeTokens()` de la classe `Text` ?
On considère, pour cette évaluation de la complexité, que la comparaison de deux Tokens est une opération en temps constant.\

Dans le pire cas, le nombre de tokens est $ k = n/2 + 1 $ classé dans l'ordre alphabétique inverse. \
Exemple : "z y x w v". \
On parcourt tout le texte caractère par caractère, puis à chaque token rencontré on insère suivant l'approche du tri par insertion.

$ k(k+1)/2 + (n-k) $ => O($n^2$)


## Activité E

Quelle est la complexité de la méthode `nombreOccurrencesSansMap()` ?
...