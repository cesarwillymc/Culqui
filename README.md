# Culqui
## CESAR CANAZA

Mobile developer willing to learn old and new technologies, I like the team work and communication.
Thank you for check this project.

## USE CASE TEST

### LOGIN
Try with this data because if you try with other ***data the user no exist***.
```
{
"email": "eve.holt@reqres.in",
"password": "cityslicka"
}
```
### REGISTER
Try with this data
```
{
"email": "eve.holt@reqres.in",
"password": "Rasec.123"
}
```
If you try to use other data you will be get
```
{
"error": "Note: Only defined users succeed registration"
}
```

### PASSWORD VALIDATION
For validate the password in register needs to contain:
- 8 letter or more
- at least one letter Uppercase
- at least one special symbol
- at least one Number

## Architecture MVVM with clean

### data (Repositories - Framework)
- di: Contains the dependency injection with hilt
- settings: Contains all the settings local `(Convertes, SharedEncription)` and network `(Interceptor, Cookie, more)`
- sources: Contains all the content of each feature `For example: Auth` like `framework database or retrofit` the connection is through repository
    - di: Contains the dependency injection of the Feature like `Auth`
    - entities: Contains all the entities of the feature like `Auth`
    - mapper: Contains all the mapper of the feature
    - local: Contains the framework with the local storage
    - remote: Contains the framework to connect the data using `voley, retrofit or other`
    - repository files: Contains the interface and the implementation of the connections with the local and remote data
### domain (Model - Use Case)
- usecase:
    - entities: Contains all the entities in domain with the logic if they have
    - usecase Files:  Contains each use case of the app where we can sort, filter  and others
### presentation (ViewModel - Screen UI)
- Main Activity: Contains the main activity in jetpack compose
- Screen Directory: Contains all the resources that manage a screen like **View Model, CustomComposable, State, Screen**
- delegate: Contains Singleton classes that work when we need to share contents between ViewModel where we **delegate the action to do something** or **save something light**
### Additional comments
- ui: Package that contains all the layers like **Permission, General Composables, NavigationComponent, Theme, Services**
- util: Contains global Constants and Extension Functions
## Technology Stack
- Kotlin  Programming language
- MVVM:  Architecture design that help us to decouple our code in layers
- Retrofit:  Library that help us to consume ApiRest
- Kotlin Coroutines: Provides ways to manage threads very easily
- Flow: Library that help us to manage the asynchronous stream data
- Jetpack Compose:  Framework for UI using Kotlin where we developed the code like puzzles
- Hilt: Dependency Injection in Compile-Time
- Jetpack Navigation:  library that simplify and streamline the navigation between composables or screens
- Jacoco: Generate Files of the coverage of the unit test
- KLint: Format the code for give my quality to the project
- Detekt: Code analysis tool that help us to follow rules in the code
- Proguard R8, Encryption, Github actions,  Atomic design, Control of error, Coroutines.

## Configuration:
### Local.properties
Add  this line
```

SHARED_PREFERENCES_NAME=DBCulqui
BASE_URL=https://reqres.in/api/
DEBUG_KEY_PASSWORD=holacomoestas
```
### Gradle Java

Go to **Gradle JDK** and change to **Java17**

![Java](image/gradle_j17.png)

### DOWNLOAD APP
## Download the app by Google Drive
- [GOOGLE DRIVE](https://drive.google.com/drive/folders/1C7WVXYcDp49F8r7DEWLClsDFTvImy23_?usp=sharing)
## Download the app by artifact github
Go to [Here](https://github.com/cesarwillymc/Culqui/actions)
- ![APK](image/artifact.png)  
  Later select the first workflow and download the apk
- ![APK](image/app.png)  