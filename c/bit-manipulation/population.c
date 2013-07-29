#include <stdio.h>

int main(int argc, char const *argv[])
{
	/* code */
	int i, pop = 0;
    int x = 33;
    for (i = 0; i < 32; i++) {
    	if (x & 1) pop = pop + 1;
    	x = x >> 1;
	}
	printf("%d\n", pop);
	return 0;
}

