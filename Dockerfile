docker tag my-image:1.0.0 diop/gstudent:latestdocker tag my-image:1.0.0 diop/gstudent:latestdocker tag my-image:1.0.0 diop/gstudent:latestFROM maven:3.8.4-openjdk-17 AS build

# Assigne un répertoire de travail pour la construction
WORKDIR /app

# Copier les fichiers de configuration Maven
COPY pom.xml .

# Télécharger les dépendances sans exécuter de tests
RUN mvn dependency:go-offline

# Copier le code source
COPY src ./src

# Compiler le projet et créer le fichier JAR
RUN mvn clean package -DskipTests

# Étape 2 : Créer l'image finale
FROM openjdk:17-jdk-slim

# Assigne un répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape de construction
COPY --from=build /app/target/Gstudent-0.0.1-SNAPSHOT.jar /app/wane1.0.0.jar

# Expose le port sur lequel l'application s'exécute
EXPOSE 8089

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/wane1.0.0.jar"]