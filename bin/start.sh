#!/usr/bin/env bash

RECOVERYAPI_HOME=`echo $(cd "$(dirname "$0")";pwd) | sed -e 's/\/bin//g'`
cd ${RECOVERYAPI_HOME}/bin

LIB_DIR=`ls ${RECOVERYAPI_HOME}/lib`
CONF_DIR="$RECOVERYAPI_HOME/conf"
_CLASSPATH="$CONF_DIR $LIB_DIR"
CLASSPATH=`echo ${_CLASSPATH} | sed -e 's/ /:..\/lib\//g'`
pid="$RECOVERYAPI_HOME/tmp/mes-data-api.pid"

nohup /usr/java/jdk1.8.0_144/bin/java -server -Xmx1024m -classpath ${CLASSPATH} mainClass 1>${RECOVERYAPI_HOME}/logs/mes-data-api.out 2>${RECOVERYAPI_HOME}/logs/mes-data-api.err &
newpid="$!"
echo "$newpid" > "$pid"
