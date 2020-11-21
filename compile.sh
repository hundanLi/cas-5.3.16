#!/bin/bash
#if [ `uname` = 'Linux' ] ;then
    ulimit -n 65535
    rm -rf ~/.npm/_locks ~/.npm/_logs ~/.npm/_cacache
#fi
#rm -rf ~/AppData/Roaming/npm-cache/_locks ~/AppData/Roaming/npm-cache/_logs ~/AppData/Roaming/npm-cache/_cacache
./gradlew build install --parallel -x test -x javadoc -x check --build-cache --no-daemon --stacktrace --continue #-DskipNpmLint=true
