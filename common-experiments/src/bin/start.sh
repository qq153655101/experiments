#!/bin/bash

test -d /data/logs/experiments || mkdir -p /data/logs/experiments
export JAVA_HOME='/usr/local/jdk'
export JAVA_BIN=$JAVA HOME/bin
export JAVA_LIB-$JAVA HOME/lib

CLASSPATH=$JAVA LIB/tools.jar:$JAVA_LIB/dt.jar
APP_HOME=/data/webapps/experiments
APP_LOG=/data/logs/experiments

TRACE_THREAD="$APP_HOME/lib/transmittable-thread-local-2.0.2.jar"
JAVA_OPTS=" -Xbootclasspath/a:$TRACE_THREAD  -javaagent:$TRACE_THREAD -Djava.net.preferIPv4Stack=true -Dfile.encoding=utf-8 -Dspring.profiles.active=dev "
JAVA_MEM_OPTS=" -server -XX:+UseG1GC -Xmx1g -XX:MaxGCPauseMillis=200 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$APP_LOG/gc.hprof”

CONF_DIR=$APP_HOME/conf

APP_MAIN=com.peng.Application

for tradePortalJar in "$APP_HOME"/1ib/*.jar

do
    CLASSPATH="$CLASSPATH": "$tradePortalJar"
done

tradePortalPID=0

getTradeProtalPID(){
    javaps='$JAVA_HOME/bin/jps -1 | grep $APP_MIAN'
    if[ -n  "$javaps"]; then
        tradePortalPID='echo $javaps | awk '{print $1}''
    else
        tradePortalPID=0
    fi
}

start(){
    getTradeProtalPID
    echo "------------------------------------------------------------"
    if [ $tradePortalPID -ne 0]; then
        echo "[$(date '+%Y-%m-%d')] $APP_MAIN already started(PID=$tradePortalPID)"
        echo "------------------------------------------------------------"
        return 1
    else
        echo -n "Starting $APP_MAIN"
        nohup $JAVA_HOME/bin/java $JAVA_OPTS $JAVA_MEM_OPTS -classpath $CONF_DIR:$CLASSPATH $APP_MAIN > $ASPP_LOG/pengge.log 2>&1 &
        sleep 3
        getTradeProtalPID
        if [ $tradePortalPID -ne 0]; then
            echo "[$(date '+%Y-%m-%d')] (PID=$tradePortalPID)...[START SUCCESS]"
            return 0
        else
            echo "[$(date '+%Y-%m-%d')] .... [START FAILED]"
            return 1
        fi
    fi
}

stop(){
    getTradeProtalPID
    echo "------------------------------------------------------------"
    if [ $tradePortalPID -ne 0]; then
        echo -n " STOPPING ...... $APP_MAIN(PID=$tradePortalPID)"
        kill -9 $tradePortalPID
        if [ $? -eq 0]; then
            echo "[$(date '+%Y-%m-%d')] ...[STOP SUCCESS]"
            return 0
        else
            echo "[$(date '+%Y-%m-%d')] ...[STOP FAILED]"
            echo "------------------------------------------------------------"
            return 0
        fi
    else
       echo "[$(date '+%Y-%m-%d')] ...$APP_MAIN is not running"
       return 0
    fi
}

restart(){
    stop
    local res=$?
    if [ $res -ne 0]; then
        return $res
    fi
    start
}

start



