#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	int size;
	char *static_str = "hello there";   
	char *new_str = NULL;
	char *ptr = NULL;

	printf("%s\n", static_str);  // prints "hello there"


	size = strlen(static_str);
	new_str = malloc(sizeof(char)*(size+1)); // need space for '\0'
	if(new_str == NULL) { 
		printf("malloc failed\n"); 
	}
	strncpy(new_str, static_str, 6);
	strcat(new_str, "yo");
	printf("%s\n", new_str);	// prints "hello yo"

	
	if((ptr = strstr(new_str, "yo")) != NULL) {
		printf("%s\n", ptr);	// prints "yo"
	}
	free(new_str);
}