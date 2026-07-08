#!/bin/bash

set -e

envsubst < /init.js.template > /docker-entrypoint-initdb.d/init.js

exec docker-entrypoint.sh mongod