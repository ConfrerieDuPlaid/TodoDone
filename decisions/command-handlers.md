# Gestion des commandes

Problèmatique :
> Comment gérer les commandes envoyées par les utilisateurs de manière découplée ?

## Solutions possibles :
- Command Handler 
Utiliser un pattern de command handler pour gérer les commandes envoyées par les utilisateurs.
  - Avantages :
    - Découplage total entre les commandes et les actions à réaliser
    - Ajout et suppression de commandes facile -> flexibilité
    - Séparation des responsabilités forte
  - Inconvénients :
    - Lisibilité moindre et compréhension du code plus difficile
    - Objet métier affaibli et moins cohérent


- Objet Metier Fortement cohérent
Appeler des méthodes metier dans l'objet ToDoList : todolist.addTask(.), .removeTask(.), ...
    - Avantages :
        - Objet métier fortement cohérent
        - Lisibilité du code à court terme
    - Inconvénients :
        - Ajout et suppression de commandes difficile, car il faut modifier l'objet métier
        - Complexité de l'objet métier peut rapidement croite et devenir difficile à maintenir


## Décision

Nous avons choisi de mettre en place un pattern de command handler pour gérer les commandes envoyées par les utilisateurs. 
Cela permet également d'ajouter et de supprimer des commandes facilement et de garder une flexibilité dans le code.
Même si la lisibilité du code est moindre et la complexité à court terme est plus élevée, nous pensons qu'à long terme,
cette solution est plus adaptée pour la maintenabilité du code.