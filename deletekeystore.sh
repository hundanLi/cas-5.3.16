#!/bin/bash
sudo keytool -delete -alias cas -keystore /etc/cas/thekeystore
sudo keytool -delete -alias cas -keystore $JAVA_HOME/jre/lib/security/cacerts
