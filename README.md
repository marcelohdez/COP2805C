# COP2805C

My mono-repo for my COP2805C (Java 2) college class.

Created using Intellij and Gradle.

## Running

In your IDE you may run the edu.mdc.cop2805c.assignmentN.Main file directly, or
from the assignment root run the Gradle `build` task either through your IDE or
through the command e.g.:

```bash
./gradlew build --no-daemon
```

_The `--no-daemon` option can be omitted if you would like gradle to stick
around and make future builds faster._

Then the resulting jar will be in `build/libs/` which can be run like e.g.:

```bash
java -jar build/libs/Assignment1_Vehicle_Management-1.0.jar
```

## License

The code in this repository is licensed under the MIT license. For more
information please see [LICENSE] at the monorepo root.

[LICENSE]: https://github.com/marcelohdez/COP2805C/blob/master/LICENSE
