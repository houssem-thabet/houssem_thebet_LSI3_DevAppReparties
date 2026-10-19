# TP 2 - Activité 2-1 : Échange de chaînes de caractères Client/Serveur via les sockets TCP

**Matière :** Développement d'applications réparties
**Niveau :** LSI 3 - Faculté des Sciences de Sfax - 2026/2027
**Enseignante des TPs :** Zeineb DAOUD

## Objectif

Étendre l'application Client/Serveur du TP 1 (échange d'un seul octet) pour que le client puisse envoyer une opération complète (ex. `55 * 25`) et recevoir le résultat calculé par le serveur, en utilisant les flux de traitement de chaînes de caractères (`BufferedReader`, `InputStreamReader`, `PrintWriter`).

## Structure du projet

```
src/
├── clientPackage/
│   └── Client.java
└── serverPackage/
    └── Server.java
```

## Fonctionnement

**Client**
1. Se connecte au serveur sur `localhost:1234`.
2. Demande une opération à l'utilisateur (ex. `55 * 25`).
3. Valide la syntaxe avec une expression régulière (`nombre opérateur nombre`). Les chaînes comme `25 ** 55` ou `abc + 3` sont refusées et ne sont jamais envoyées.
4. Envoie au serveur, ligne par ligne : le premier opérande, l'opérateur, puis le deuxième opérande.
5. Lit et affiche le résultat reçu.

**Serveur**
1. Attend la connexion d'un client sur le port `1234`.
2. Lit les trois éléments de l'opération.
3. Calcule le résultat selon l'opérateur : `+`, `-`, `*`, `/`.
4. Renvoie le résultat au client (message d'erreur en cas de division par zéro ou d'opérateur invalide).

## Exécution

1. Lancer d'abord `Server` (classe `serverPackage.Server`).
2. Lancer ensuite `Client` (classe `clientPackage.Client`).
3. Saisir une opération, par exemple : `55 * 25`.

## Exemple

```
Je suis un client pas encore connecté...
je suis un client connecté
Entrez une opération (ex: 55 * 25) : 55 * 25
Résultat : 1375.0
```

## Environnement

- JDK >= 1.8
- IntelliJ IDEA
- Git
