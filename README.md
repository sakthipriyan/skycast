#skycast


##Environment tested
```
Java 1.7.0_40
Apache Maven 3.0.4
```

##Clone code
```
git clone https://github.com/spriyan/skycast.git
```

##Setup using mvn
```
cd skycast
mvn clean install
```

##How to run?
```
mvn exec:java -Dexec.mainClass=com.sakthipriyan.skycast.SkycastApp \
-Dexec.args="'1 100' '4 78 79 80 3' '8 10 13 13 100 99 98 77 81'"
```
