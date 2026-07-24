#!/usr/bin/env bash
# Build and run the app on Tomcat 9 at http://localhost:8081
set -e

DIR="$(cd "$(dirname "$0")" && pwd)"
export CATALINA_HOME=/opt/homebrew/opt/tomcat@9/libexec
export CATALINA_BASE="$DIR/.tomcat-runtime"

mvn -q -f "$DIR/pom.xml" package -DskipTests

mkdir -p "$CATALINA_BASE/webapps"
[ -d "$CATALINA_BASE/conf" ] || cp -RL "$CATALINA_HOME/conf" "$CATALINA_BASE/conf"
sed -i '' -E 's/port="8080"/port="8081"/' "$CATALINA_BASE/conf/server.xml"
cp "$DIR/target/gestion_g2_spring_mvc.war" "$CATALINA_BASE/webapps/ROOT.war"

echo "App: http://localhost:8081/product)"
"$CATALINA_HOME/bin/catalina.sh" run
