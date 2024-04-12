# Todo / Done

Application de gestion de tâches à faire en ligne de commande

## Commandes disponibles
- `todo list` : Affiche la liste des tâches à faire
- `todo add <task content>` : Ajoute une tâche à faire
- `todo done <task number>` : Marque une tâche comme faite
- `todo delete <task number>` : Supprime une tâche

## Décisions architecturales

### Stockage
Les tâches sont stockées en CSV dans un fichier sur l'ordinateur, étant donné que l'utilisateur a spécifié qu'il en avait seulement besoin sur son ordinateur et qu'il ne souhaitait pas avoir à installer de dépendances particulières.

### Commandes
Les commandes sont en premier lieu traitées par un `CommandParser` pour vérifier leur format.
Elles implémentent l'interface `Command` et sont séparées en Query et Command, les premières n'ayant pas d'effet sur le système, les secondes en ayant un.
Toutes les tâches prennent un argument, sauf `list`, qui n'en prend pas. Cependant, elle implémente également l'interface `Command` pour la rendre modulable, dans le cas où on voudrait par exemple plus tard vouloir filtrer par les tâches faites ou les tâches non faites.

### Todo list
La todo list est séparée en deux classes : `TodoList` et `Task`. 
`TodoList` contient une liste de `Task`.
`Task` contient le contenu de la tâche, sa date de création, et un booléen pour savoir si elle est faite ou non.
Une classe `TimeElapsed` calcule et peut afficher la durée écoulée depuis la création de la tâche. Cette durée n'est pas stockée.
