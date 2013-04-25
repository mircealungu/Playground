
int f(int a)
{
	int b,c;
	b = a+11;
	c = b+22;
	return c+33;
}

int g(int a, int b) 
{
	int x, y;
	x = a * 44;
	y = b * 55;
	f(x+y);
	return x + y;
}

const int big_int = 9876;

int main(int count, char ** args) {
	return g(3, 5);
	//return 0;
}