#!/bin/bash
domain=hundanli.com
sudo keytool -genkey -alias cas -keyalg RSA -validity 999 -keystore /etc/cas/thekeystore -ext san=dns:$domain
