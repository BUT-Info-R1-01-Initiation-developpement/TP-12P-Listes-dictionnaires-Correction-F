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
...

## Activité E

Quelle est la complexité de la méthode `nombreOccurrencesSansMap()` ?
...