# AMG - Marvel App

## Motivation

I try to convey my vision of the new architecture recommended by Google applying the latest technologies and components


## Stack
- [X] Architecture MVVM
- [X] New Recommended Google Architecture
- [X] Using Flows
- [X] Offline mode with Room
- [X] Hilt
- [X] UseCases
- [X] Pagination
- [X] Jetpack Compose
- [X] mock / pro flavor
- [X] Detekt for static code report
- [X] Added Canary Leak
- [X] Simple Tests

## WishList / RoadMap
- [ ] Animate views
- [ ] CallAdapter for kotlin.Result<>
- [ ] Integration test
- [ ] More unit test coverage
- [ ] Test UI

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

### Test

you can see a sample in "CharacterRepository" and "GetCharactersUseCase"

## Mock flavor
environment used for faster developer and probably test

```shell
./gradlew installMockDebug
```

WIP MockWebServer

## run detekt
```shell
./gradlew detekt
```

### DeepLink enabled

```shell
./adb shell am start -W -a android.intent.action.VIEW -d https://www.example.com/character/1009144 com.amarinag.marvelapi
```

### Used plugins

* secrets-gradle-plugin
