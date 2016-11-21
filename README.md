# java-iterators
koan like exercises for java.lang.Iterable and java.util.Iterator interfaces

## downloading the repository
```bash
git clone https://github.com/javakisagh/java-iterators.git
cd java-iterators
```

## running tests (and failing them)

script gradlew automatically downloads proper version of gradle and later via gradle itself the all the dependencies
so it is as simple as running:
```bash
./gradlew test
```
## inspecting test report

after executing tests one can inspect all the failing tests by opening report
```bash
build/reports/tests/test/index.html
```

## editing code in IDE

gradle provides tasks for creating an Eclipse project or an InteliJ (Idea) project (one has to just execute proper gradle task)
```bash
./gradlew eclipse
```
or 
```bash
./gradlew idea
```
importing the generated project into an IDE is described in <http://home.agh.edu.pl/~mwypych/doku.php?id=zimowy:java2016:labs:tips2#import_projektu_do_eclipse>

## order from the easiest to the hardest problem
1. MyList
2. Array2d
3. BinaryTree
