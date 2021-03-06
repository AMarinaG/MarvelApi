# AMG - Marvel App

## Motivation

I try to convey my vision of the new architecture recommended by Google applying the latest technologies and components


## Stack
- Architecture MVVM
- New Recommended Google Architecture
- Using Flows
- Offline mode with Room
- Hilt
- UseCases
- Pagination
- Jetpack Compose
- mock / pro flavor
- Detekt for static code report
- Added Canary Leak
- Simple Tests

### WishList / RoadMap
- Animate views
- CallAdapter for kotlin.Result<>
- Integration test
- More unit test coverage
- Test UI

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

## Mock flavor
environment used for faster developer and probably test

```shell
./gradlew installMockDebug
```

## Pro flavor
environment that used real marvelapi service

```shell
./gradlew installProDebug
```


## run detekt
```shell
./gradlew detekt
```

### Test
execute test using
```shell
./gradlew check
```

Show results on
- app/build/reports
- app/build/reports/detekt
- app/build/reports/tests


### DeepLink enabled

```shell
./adb shell am start -W -a android.intent.action.VIEW -d https://www.example.com/character/1009144 com.amarinag.marvelapi
```

### Used plugins

* secrets-gradle-plugin
