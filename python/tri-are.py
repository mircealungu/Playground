import sys
from math import sqrt

print('Hello Im a triangle calculator')

a=int(input('side A?'))
b=int(input('side B?'))
c=int(input('side C?'))

if a<0 or b<0 or c<0:
	print('This triangle does not exist')
	sys.exit()

s=(float(a+b+c))/2
area=sqrt ( s* (s-a) * (s-b) * (s-c) )

print('the area of your triangle is = '+str(area))
