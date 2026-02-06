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

# Run spring boot
mvnw -f ./chess-platform-server/pom.xml clean install
mvnw -f ./chess-platform-server/pom.xml -pl entrypoint spring-boot:run

# Init submodules

# Add Stockfish as module
git submodule add git@github.com:official-stockfish/Stockfish.git external/Stockfish
cd external/Stockfish
git checkout sf_18 
make help
make -j profile-build ARCH=x86-64 COMP=gcc COMPCXX=g++

# Stockfish cli
./stockfish
# set 4 threads
setoption name Threads value 8
# start new game
ucinewgame # uci Universal Chess Interface
position startpos

# I play first move
position startpos moves e2e4
go movetime 1000
# bestmove e7e5 ponder g1f3

# include all previous commands + my new move
position startpos moves e2e4 e7e5 g1f3
go movetime 1000

# game1
position startpos moves e2e4 e7e5 g1f3 b8c6 f1c4 f8c5 c2c3 g8f6 d2d3 d7d6 e1g1 c5b6 f1e1 e8g8 h2h3 a7a5 b1d2 h7h6 c4b5 c8e6 d2c4 b6c5 f3e5 d6e5 a2a4 d8e7 d1e2 f6h7 c1d2 a8d8 a1d1 e7h4 b5c6 e6c4 d3c4 b7c6 b2b4 c5e7 c4c5 d8a8 g1h2 h7f6 d1a1 f8d8 a1a2 f6h7 e1d1 h7f8 g2g3 h4f6 d1a1 f6g6 h3h4 f8h7 a1e1 g6e6 a2a3
go movetime 1000
```

## References

- <https://github.com/github/gitignore/blob/main/Maven.gitignore>
- <https://www.baeldung.com/maven-multi-module>
- <https://www.w3schools.com/git/git_submodules.asp>
- Minimal UCI viewer: <https://www.dcode.fr/uci-chess-notation>
- Powerful UCI viewer: (PGN) <https://chess-online.net/analyze>
