# Bonjour !

## Organisation du projet

Ce projet est orchestré par **Maven**, le code se trouve donc dans le dossier `src`. Vous pourrez y trouver les tests
dans le dossier `src/test` et le code source dans le dossier `src/java`.

Le code source est structuré au format MVC et la vue a été conçu à l'aide de **Swing**.

La base de données est gérée à l'aide de **SQLite** dans le dossier du même nom.

GitLab : https://gitlab.com/Hugo-Julien/machine-a-boissons-qualite-log

## Tests

Les tests unitaires et d'intégration sont réalisés à l'aide de **JUnit** et de **Mockito**.

## Guide de déploiement

Les versions de Java que nous avons utilisé sont la 16 et la 17. D'autres sont probablement compatibles, mais pour
éviter toute surprise nous vous conseillons d'utiliser celles-ci.

Pour utiliser Maven, il faut l'ajouter au projet, sur **IntelliJ** il suffit de faire :

- Clic droit sur le module du projet ;
- Cliquer sur "Add framework support..." ;
- Choisir Maven et cliquer sur "Ok".

Pour pouvoir utiliser SQLite, il faut ajouter une bibliothèque au projet pour que l'exécution se déroule correctement.
Vous pourrez la trouver ici : `SQLite/sqlite-jdbc-3.35.0.1.jar`.

# Nous espérons que notre projet vous plaira !

### Membres du projet

- Hugo JULIEN
- Mohammed RMICH
- Léo BOULANGER
- Dylan VINET

Petite musique pour être de bonne humeur : https://youtu.be/dQw4w9WgXcQ