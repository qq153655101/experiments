#!/usr/bin/env bash

RECOVERYAPI_HOME=`echo $(cd "$(dirname "$0")";pwd) | sed -e 's/\/bin//g'`
pid="$RECOVERYAPI_HOME/tmp/mes-data-api.pid"

if [ -f $pid ]; then
      TARGET_ID="$(cat "$pid")"
      if [[ $(ps -p "$TARGET_ID" -o comm=) =~ "java" ]]; then
        echo "stopping $command"
        kill "$TARGET_ID" && rm -f "$pid"
      else
        echo "no $command to stop"
      fi
else
      echo "no $command to stop"
fi
