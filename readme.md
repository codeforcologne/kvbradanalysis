# KVB Rad Analysis

Dieser Service analysiert die durch [kvbradrouting](https://github.com/codeforcologne/kvbradrouting) ermittelten Fahrradrouten durch Köln. Er holt sich die dort hinterlegten Routen, teilt sie in Unterabschnitte auf und persistiert diese in der Datenbank. Danach können diese durchgezählt werden. 

### Json Service

Es ist möglich die durch die Routing Funktion erstellten Daten im Json-Format über den REST-Endpoint /kvbradanalysis/service/json abzufragen.

### GeoJson Service

Über den REST-EndPoint /kvbradanalysis/service/geojson lassen sich alle routing-Informationen abfragen.

## Datenbank



## Test

Da zur Zeit keine Integration Test Stage zur Verfügung steht, sind alle Tests, die eineDatenbank voraussetzt als main codiert. Um eine Datenbankverbindung hierfür zur Verfügung stellen zu können, muss die Datei src/test/resources/jndi.properties.template in src/test/resources/jndi.properties kopiert und die entsprechenden Parameter für die Datenbank-Verbindung gesetzt werden.

Weiterhin muss im Test die Verbindung für die Verwendung im Test-Betrieb konfiguriert werden. Dies erfolgt durch Aufruf von 		

	JndiProperties.setUpConnectionForJndi();

Dadurch werden die connection Parameter zum Auslesen per JNDI gesetzt. Das Anfordern der Datenbankverbindung erfolgt dann innerhalb der ausführenden Klasse.