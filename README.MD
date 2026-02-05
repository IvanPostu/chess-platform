# Chess Platform

Chess Platform - Demo

## Shell

```sh
nix-shell --run bash ./app.nix

# Create maven wrapper in scripts folder, min. required 3.6.3
mvn -N wrapper:wrapper -Dmaven=3.6.3

# Create maven parent project
mvnw archetype:generate \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.5 \
    -DgroupId=com.ipostu.chess.platform.server \
    -DartifactId=chess-platform-server \
    -Dversion=1.0-SNAPSHOT

# add <packaging>pom</packaging>
# remove <dependencies>
# remove main/test folders

cd chess-platform-server/

mvnw archetype:generate \
    -DinteractiveMode=false \
    -DgroupId=com.ipostu.chess.platform.server.entrypoint \
    -DartifactId=entrypoint

mvnw archetype:generate \
    -DinteractiveMode=false \
    -DgroupId=com.ipostu.chess.platform.server.rest \
    -DartifactId=rest

mvnw archetype:generate \
    -DinteractiveMode=false \
    -DgroupId=com.ipostu.chess.platform.server.model \
    -DartifactId=model

mvnw archetype:generate \
    -DinteractiveMode=false \
    -DgroupId=com.ipostu.chess.platform.server.persistence \
    -DartifactId=persistence
```

## References

- <https://github.com/github/gitignore/blob/main/Maven.gitignore>
