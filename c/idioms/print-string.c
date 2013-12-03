#include <stdio.h>

int main() {
	char* lecture = "ESE";
	char* dest = "---";

	while (*lecture)
		printf("%d\n", *lecture++);
}