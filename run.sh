#!/bin/bash
if [ "$#" = 0 ]; then
	echo "Usage: $0 <number> [options]"
	echo "where <number> is the assignment number, and [options] are any options"
	echo "you would like to pass to the final executable"
	exit 1
fi

case "$1" in
"1")
	mainclass=edu.mdc.cop2805c.assignment1.app.VehicleManager
	;;
*)
	echo Invalid assignment number!
	exit 1
	;;
esac

OUTDIR=out
FILES=$(find Assignment"$1"/edu/mdc/cop2805c/assignment"$1" -type f -name \*.java)

mkdir -p "$OUTDIR"
javac -Xlint:-options --release 8 -d "$OUTDIR" $FILES
java -cp "$OUTDIR" "$mainclass" -- "${@:2}"
