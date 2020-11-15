# LPPWM - JAVA - Lecteur de fichier
Lecteur de fichier réalisé en JAVA dans le cadre d'un TP à la licence professionelle Projet Web et Mobile de Sorbonne Université.

## Architecture
Une classe abstraire `FileReader` implémente l'interface `Readable`. Chaque type de fichier aura ensuite une classe abstraite qui étend `FileReader` (par exemple `TextFileReader`, `MarkdownFileReader`, etc...). Puis pour chaque type de lecture il y aura une classe qui étend la classe spécialisée par type de fichier (par exemple `TexteFileReaderReverse`).

## Fonction diff
La fonction diff retourne le résultat de la `commande` diff Unix, ou `FC` sous Windows.