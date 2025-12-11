# Mood-based Music Suggestion (Java + Plain Static Frontend)

This is a minimal prototype: a Spring Boot backend serving a plain static frontend. The frontend lets the user choose or type a mood and fetches song suggestions from the backend.

Requirements
- Java 17
- Maven

Run (PowerShell)

```powershell
# from project root (where pom.xml lives)
mvn spring-boot:run

# then open http://localhost:8080 in your browser
```

Build jar

```powershell
mvn package
java -jar target/mood-music-0.1.0.jar
```

Notes
- The backend exposes GET /api/suggest?mood=<mood>
- The static UI is at `/index.html` and calls the API above
- Moods seeded: happy, sad, relaxed, energetic
- To integrate Spotify or external APIs, I'll add OAuth and token handling as a next step (needs API keys).
