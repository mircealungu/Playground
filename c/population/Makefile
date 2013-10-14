EDITOR=subl
PROG=population

all: O0 O1 O2 
	${EDITOR} ${PROG}O*.s ${PROG}.c

O0:
	cc -S ${PROG}.c -o ${PROG}O0.s 

O1:
	cc -S -O1 ${PROG}.c -o ${PROG}O1.s 

O2:
	cc -S -O2 ${PROG}.c -o ${PROG}O2.s 

clean:
	rm -f *.out *.s

