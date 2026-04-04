# LOGISTIA - Plateforme SaaS d'Optimisation Logistique

**LOGISTIA** est une solution SaaS moderne conçue pour optimiser les flux d'import/export. Le projet repose sur une architecture microservices robuste, utilisant l'intelligence artificielle pour la prédiction et l'optimisation logistique.

---

## Architecture du Projet

Le système est construit selon une architecture **Microservices** décentralisée pour garantir la scalabilité et la haute disponibilité.

* **Service Discovery :** Netflix Eureka Server (Port 8761).
* **API Gateway :** Point d'entrée unique pour le routage des requêtes.
* **Microservices Métiers :**
    * `auth-service` : Gestion de l'authentification et des utilisateurs.
    * `billing-service` : Gestion de la facturation (En cours).
    * `logistics-service` : Cœur de l'optimisation logistique (À venir).

---

## Technologies Utilisées

### Backend & Infrastructure
* **Langage :** Java 21
* **Framework :** Spring Boot 3.x & Spring Cloud
* **Gestionnaire de dépendances :** Maven
* **Base de données :** PostgreSQL (Database per Service)
* **Conteneurisation :** Docker & Docker Compose

### Intelligence Artificielle
* **Langage :** Python (Service prédictif dédié)

---

## Installation et Démarrage

### Pré-requis
* Docker & Docker Compose installés.
* JDK 21 installé.
* Maven installé.

### Lancement de l'infrastructure (Bases de données)
```bash
sudo docker-compose up -d
