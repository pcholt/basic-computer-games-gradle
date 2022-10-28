# basic-computer-games-gradle
Buildscript for the jvm games in @coding-horror/basic-computer-games

You can add this as a submodule in your basic-computer-games project to build the jvm based games more easily, and create a suite of executable games without effort.

- Check out https://github.com/coding-horror/basic-computer-games.git

  `git clone https://github.com/coding-horror/basic-computer-games.git`

- Change to that directory

  `cd basic-computer-games`
  
- Add this repository as a subproject

  `git submodule add https://github.com/pcholt/basic-computer-games-gradle.git`
  
- Change to that subproject directory and build using gradle. 

```
cd basic-computer-games-gradle
gradle build
```
  
This should create executable `.jar` files in the directory of every game project. For example, 

```bash
basic-computer-games
├── 04_Awari
│   └── java
│       ├── Awari.java
│       ├── AwariGame.java
│       ├── awari.jar
│       └── README.md
```
