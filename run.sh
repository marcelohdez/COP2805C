#!/bin/sh
if [ "$#" != 1 ]; then
	echo "Usage: $0 <number>"
	echo "where <number> is the assignment number"
	exit 1
fi

OUTDIR=out
FILES=$(find Assignment"$1"/edu/mdc/cop2805c/assignment"$1" -name \*.java)

mkdir -p "$OUTDIR"
javac -Xlint:-options --release 8 -d "$OUTDIR" $FILES
java -cp "$OUTDIR" edu.mdc.cop2805c.assignment"$1".Main
