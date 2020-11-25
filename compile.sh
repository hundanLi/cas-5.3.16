#!/bin/bash
ulimit -n 65535
rm -rf ~/.npm/_locks ~/.npm/_logs ~/.npm/_cacache
./gradlew build install --build-cache --no-daemon --stacktrace --continue --parallel -x test -x javadoc -x check -DskipNpmLint=true -DskipErrorProneCompiler=true --offline
