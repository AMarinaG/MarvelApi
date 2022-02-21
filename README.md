# AMG - Marvel App

## Motivation

Through the marvel api I have tried to carry the best practices of google for the architecture of an Android
application

## Installation 

First of all you need create file on root project named secrets.properties and define to variables <code>MARVEL_PUBLIC_KEY</code> and <code> MARVEL_PRIVATE_KEY</code>
like this
```properties
MARVEL_PUBLIC_KEY=your_marvel_public_key
MARVEL_PRIVATE_KEY=your_marvel_private_key
``` 
And run gradle install for open on your device

```bash
./gradlew iD
```


### Used plugins

* secrets-gradle-plugin
