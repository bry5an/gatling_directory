#!/usr/bin/env bash
touch build.sbt
echo "enablePlugins(GatlingPlugin)" >> build.sbt
echo "" >> build.sbt
echo "scalaVersion := \"2.11.8\"" >> build.sbt
echo "" >> build.sbt
echo "scalacOptions := Seq(" >> build.sbt
echo "  \"-encoding\", \"UTF-8\", \"-target:jvm-1.8\", \"-deprecation\"," >> build.sbt
echo "  \"-feature\", \"-unchecked\", \"-language:implicitConversions\", \"-language:postfixOps\")" >> build.sbt
echo "" >> build.sbt
echo "libraryDependencies += \"io.gatling.highcharts\" % \"gatling-charts-highcharts\" % \"2.2.0\" % \"test\"" >> build.sbt
echo "libraryDependencies += \"io.gatling\"            % \"gatling-test-framework\"    % \"2.2.0\" % \"test\"" >> build.sbt

mkdir src && cd src && mkdir main && cd main && mkdir resources scala java
cd ../.. && mkdir test && cd test && mkdir resources scala java
cd .. && mkdir project && cd project && touch plugins.sbt
echo "addSbtPlugin(\"io.gatling\" % \"gatling-sbt\" % \"2.2.0\")" >> plugins.sbt
