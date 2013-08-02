#include <stdio.h>
#include <stdlib.h>
#include <execinfo.h>
#include <limits.h>
#include <time.h>

typedef struct {
	char *description;
	int (*func)(int);
} function;

int straightforward(int number) {
	int count = 0;
	while (number != 0) {
		if (number & 1)
			count ++;
		number = number >> 1;
	}
	return count;
}

int optimized1 (int number) {
	int b1, b2, b3, b4, xor1, xor2, or1, or2;
	int count = 0;

	b1 = number & 255;
	b2 = (number >> 8) & 255;
	b3 = (number >> 16) & 255;
	b4 = (number >> 24) & 255;

	xor1 = b1 ^ b2;
	xor2 = b3 ^ b4;

	or1 = b1 | b2;
	or2 = b3 | b4;

	while (or1 != 0) {
		if (or1 & 1) {
			if (xor1 & 1) 
				count++;
			else 
				count += 2;
		}
			
		or1 >>= 1;
		xor1 >>= 1;
	}

	while (or2 != 0) {
		if (or2 & 1) {
			if (xor2 & 1) 
				count ++;
			else 
				count += 2;
		}
		or2 >>= 1;
		xor2 >>= 1;
	}
	return count;
}

	
const int FUNC_COUNT = 2;
function funcs [FUNC_COUNT] = {
	{"straightforward", &straightforward},
	{"optimized1", &optimized1}
};

int main(int argc, char **args) 
{
	clock_t start, end;
	if (argc != 2) {
		printf("Usage: %s <integer>\n", args[0]);
		return -1;
	}
	int number = atoi(args[1]);
	printf("size of int is %ld\n", sizeof(int));
	printf("max int is: %d\n", INT_MAX);
	printf("size of char is %ld\n", sizeof(char));

	for (int i = 0; i < FUNC_COUNT; i++) {
 		start = clock();
		for (int j = 0; j< 20100100; j++) {
			(*funcs[i].func)(number);
		}
		printf ("population count of %d is %d [%s]\n", 		
				number, 
				(*funcs[i].func)(number),
				(funcs[i].description)
				);
		end = clock();
		printf( "Number of seconds: %f\n", (end-start)/(double)CLOCKS_PER_SEC );
	}
	
	
	
	return 0;
}

