# basic-computer-games-gradle
Buildscript for the jvm games in https://github.com/coding-horror/basic-computer-games.git

## tl;dr
Run these commands on the command line

```shell
git clone https://github.com/coding-horror/basic-computer-games.git
cd basic-computer-games
git submodule add https://github.com/pcholt/basic-computer-games-gradle.git
cd basic-computer-games-gradle
./gradlew build commonDistribution
```
...and all the games will appear as `.bat` (for Windows) 
and shell script files (for Mac and Linux) 
in `build/distrib/bin`.

## More detailed instructions

Add this repository as a submodule in your basic-computer-games project. You can use gradle to build and run all the jvm based games in the project.

You will not need a gradle installation, everything is included with this repository.


- Check out https://github.com/coding-horror/basic-computer-games.git

```shell
git clone https://github.com/coding-horror/basic-computer-games.git
```

- Change to that directory

```shell
cd basic-computer-games
```
- Add this repository as a subproject

```shell
git submodule add https://github.com/pcholt/basic-computer-games-gradle.git
```
  
- Change to the subproject directory and build using gradle. 

```
cd basic-computer-games-gradle
./gradlew build commonDistribution
```
  
This should create executable `.jar` files in the directory of every game project.
This will also create a pair of directories under the basic-computer-games-gradle,
`build/distrib/bin` for the batch/shell files and `build/distrib/lib` for the compiled jar files. `lib` contains
the jar files for the games and their dependencies, and the kotlin support libraries
for games written in kotlin. `bin` contains all shell script and batch files.

```
basic-computer-games-gradle
└── build
    └── distrib
        ├── bin
        │   ├── 04_awari
        │   └── 04_awari.bat
        └── lib
            ├── build_04_awari.jar
            └── {dependencies}
```

## Notes
- This repository works as a git submodule because it relies on the parent directory to contain source files.
If you try to run it standalone it will complain of missing source directories.
