#!/bin/bash

# Export the certificate into a file
keytool -export -file cas.crt -keystore /etc/cas/thekeystore -alias cas

# Import the certificate into the global keystore
keytool -import -file cas.crt -alias cas -keystore $JAVA_HOME/jre/lib/security/cacerts
